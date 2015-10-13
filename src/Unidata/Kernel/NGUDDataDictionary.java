package Unidata.Kernel;

import Unidata.Dictionary.*;
import Uniwork.Base.*;
import Uniwork.Misc.NGMisc;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class NGUDDataDictionary extends NGComponent implements NGUDTableDefinitionEventListener {

    protected ArrayList<NGUDTableDefinition> FTableDefinitions;
    protected String FDatabasePath;
    protected ArrayList<NGUDDataDictionaryEventListener> FEventListeners;

    protected void LoadDictionary() {
        File directory = new File(FDatabasePath);
        for (File file : directory.listFiles()) {
            NGObjectDeserializer Deserializer = new NGObjectXMLDeserializerFile(null, NGMisc.combinePath(FDatabasePath, file.getName()));
            Deserializer.setLogManager(FLogManager);
            Deserializer.deserializeObject();
            NGUDTableSchema schema = (NGUDTableSchema)Deserializer.getTarget();
            NGUDTableDefinition tabledef = addTableDefinition(schema.getName(), schema.getCaption(), false);
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
            schema.setCaption(tableDef.getCaption());
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
        writeInfo("Data Dictionary stored.");
    }

    protected synchronized void raiseTableDefinitionAddedEvent(NGUDTableDefinition aTableDefinition) {
        NGUDTableDefinitionEvent event = new NGUDTableDefinitionEvent(aTableDefinition);
        for (NGUDDataDictionaryEventListener listener : FEventListeners) {
            listener.handleTableDefinitionAdded(event);
        }
    }

    protected synchronized void raiseTableFieldDefinitionAddedEvent(NGUDTableDefinition aTableDefinition, NGUDCustomTableFieldDefinition aFieldDefinition) {
        NGUDTableFieldDefinitionEvent event = new NGUDTableFieldDefinitionEvent(aTableDefinition, aFieldDefinition);
        for (NGUDDataDictionaryEventListener listener : FEventListeners) {
            listener.handleTableFieldDefinitionAdded(event);
        }
    }

    protected NGUDTableDefinition addTableDefinition(String aName, String aCaption, Boolean aAddPKEYDefinition) {
        NGUDTableDefinition res = new NGUDTableDefinition(aName, aCaption);
        res.addEventListener(this);
        if (aAddPKEYDefinition)
            res.addFieldDefinition(new NGUDTableFieldDefinitionPKEY());
        FTableDefinitions.add(res);
        raiseTableDefinitionAddedEvent(res);
        writeInfo(String.format("Table definition %s[%s] added.", res.getCaption(), res.getName()));
        return res;
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
        FEventListeners = new ArrayList<>();
        FDatabasePath = "";
    }

    public NGUDTableDefinition addTableDefinition(String aName, String aCaption) {
        return addTableDefinition(aName, aCaption, true);
    }

    public NGUDTableDefinition getTableDefinition(String aName) {
        for (NGUDTableDefinition tableDef : FTableDefinitions) {
            if (tableDef.getName().equals(aName))
                return tableDef;
        }
        return null;
    }

    public Iterator<NGUDTableDefinition> getTableDefinitions() {
        return FTableDefinitions.iterator();
    }

    public void setDatabasePath(String aDatabasePath) {
        FDatabasePath = aDatabasePath;
    }

    public String getDatabasePath() {
        return FDatabasePath;
    }

    public void addEventListener(NGUDDataDictionaryEventListener aListener)  {
        FEventListeners.add(aListener);
    }

    public void removeEventListener(NGUDDataDictionaryEventListener aListener)   {
        FEventListeners.remove(aListener);
    }

    @Override
    public void handleFieldDefinitionAdded(NGUDTableFieldDefinitionEvent e) {
        raiseTableFieldDefinitionAddedEvent(e.getTableDefinition(), e.getFieldDefinition());
    }

}
