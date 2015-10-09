package Unidata.Kernel;

import Unidata.Dictionary.*;
import Uniwork.Base.*;
import Uniwork.Misc.NGMisc;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class NGUDDataDictionary extends NGComponent {

    protected ArrayList<NGUDTableDefinition> FTableDefinitions;
    protected String FDatabasePath;

    protected void LoadDictionary() {
        File directory = new File(FDatabasePath);
        for (File file : directory.listFiles()) {
            NGObjectDeserializer Deserializer = new NGObjectXMLDeserializerFile(null, NGMisc.combinePath(FDatabasePath, file.getName()));
            Deserializer.setLogManager(FLogManager);
            Deserializer.deserializeObject();
            NGUDTableSchema schema = (NGUDTableSchema)Deserializer.getTarget();
            NGUDTableDefinition tabledef = addTableDefinition(schema.getName());
            for (NGUDTableFieldSchema fieldSchema : schema.getFields()) {
                try {
                    NGUDCustomTableFieldDefinition fieldDef = (NGUDCustomTableFieldDefinition)getClass().getClassLoader().loadClass(fieldSchema.getClassName()).getConstructor(Integer.class, String.class).newInstance(fieldSchema.getIndex(), fieldSchema.getName());
                    tabledef.addFieldDefinition(fieldDef);
                } catch (Exception e) {
                    writeError(e.getMessage());
                }
            }
        }
        writeInfo("Data Dictionary loaded.");
    }

    protected void SaveDictionary() {
        for (NGUDTableDefinition tableDef : FTableDefinitions) {
            NGUDTableSchema schema = new NGUDTableSchema();
            schema.setName(tableDef.getName());
            schema.setFields(new ArrayList<NGUDTableFieldSchema>());
            ArrayList<NGUDTableFieldSchema> fieldSchemas = schema.getFields();
            Iterator<NGUDCustomTableFieldDefinition> itr = tableDef.getFieldDefinitions();
            while (itr.hasNext()) {
                NGUDCustomTableFieldDefinition fieldDef = itr.next();
                NGUDTableFieldSchema fieldSchema = new NGUDTableFieldSchema();
                fieldSchema.setName(fieldDef.getName());
                fieldSchema.setIndex(fieldDef.getIndex());
                fieldSchema.setClassName(fieldDef.getClass().getName());
                fieldSchemas.add(fieldSchema);
            }
            NGObjectXMLSerializer ser = new NGObjectXMLSerializerFile(schema, null, NGMisc.combinePath(FDatabasePath, tableDef.getName() + ".uts"));
            ser.setLogManager(FLogManager);
            ser.serializeObject();
        }
        writeInfo("Data Dictionary saved.");
    }

    @Override
    protected void DoBeforeInitialize() {
        super.DoBeforeInitialize();
        LoadDictionary();
    }

    @Override
    protected void DoBeforeFinalize() {
        super.DoBeforeFinalize();
        SaveDictionary();
    }

    public NGUDDataDictionary(NGComponent aOwner, String aName) {
        super(aOwner, aName);
        FTableDefinitions = new ArrayList<>();
        FDatabasePath = "";
    }

    public NGUDTableDefinition addTableDefinition(String aName) {
        NGUDTableDefinition res = new NGUDTableDefinition(aName);
        res.addFieldDefinition(new NGUDTableFieldDefinitionPKEY());
        FTableDefinitions.add(res);
        writeInfo(String.format("Table definition [%s] added.", res.getName()));
        return res;
    }

    public void setDatabasePath(String aDatabasePath) {
        FDatabasePath = aDatabasePath;
    }

    public String getDatabasePath() {
        return FDatabasePath;
    }

}
