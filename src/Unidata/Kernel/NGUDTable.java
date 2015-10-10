package Unidata.Kernel;

import Unidata.Dictionary.NGUDCustomTableFieldDefinition;
import Unidata.Dictionary.NGUDTableDefinition;
import Uniwork.Base.NGObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;

public class NGUDTable extends NGObject {

    protected String FLineSeparator;
    protected String FFieldSeparator;
    protected String FName;
    protected String FCaption;
    protected ArrayList<NGUDTableRecord> FRecords;
    protected NGUDTableDefinition FDefinition;
    protected Boolean FLoaded;

    protected void addRecord(NGUDTableRecord aRecord) {
        FRecords.add(aRecord);
    }

    public NGUDTable(NGUDTableDefinition aDefinition) {
        this(aDefinition, aDefinition.getName(), aDefinition.getCaption());
    }

    public NGUDTable(NGUDTableDefinition aDefinition, String aName, String aCaption) {
        super();
        FDefinition = aDefinition;
        FName = aName;
        FCaption = aCaption;
        FRecords = new ArrayList<>();
        FLoaded = false;
        FLineSeparator = "\n";
        FFieldSeparator = "";
    }

    public NGUDTableDefinition getDefinition() {
        return FDefinition;
    }

    public NGUDTableRecord newRecord() {
        NGUDTableRecord res = new NGUDTableRecord(FDefinition);
        addRecord(res);
        return res;
    }

    public String getName() {
        return FName;
    }

    public String getCaption() {
        return FCaption;
    }

    public Integer getRecordCount() {
        return FRecords.size();
    }

    public void LoadTable(String aFilename) {
        try {
            try {
                FileReader fileReader = new FileReader(aFilename);
                BufferedReader reader = new BufferedReader(fileReader);
                String line;
                while((line = reader.readLine()) != null) {
                    String[] strs = line.split(FFieldSeparator);
                    NGUDTableRecord record = newRecord();
                    Iterator<NGUDCustomTableFieldDefinition> itr = FDefinition.getFieldDefinitions();
                    int i = 0;
                    while (itr.hasNext()) {
                        NGUDCustomTableFieldDefinition fieldDef = itr.next();
                        record.setFieldValue(fieldDef.getName(), strs[i]);
                        i++;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                FLoaded = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void StoreTable(String aFilename) {
        try {
            FileWriter fileWriter = new FileWriter(aFilename);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            try {
                int i = 0;
                for (NGUDTableRecord record : FRecords) {
                    if (i > 0)
                        writer.write(FLineSeparator);
                    Iterator<NGUDCustomTableField> itr = record.getFields();
                    int j = 0;
                    while (itr.hasNext()) {
                        NGUDCustomTableField field = itr.next();
                        if (j > 0)
                            writer.write(FFieldSeparator);
                        writer.write(field.GetAsString());
                        j++;
                    }
                    i++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                writer.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Boolean Loaded() {
        return FLoaded;
    }

}
