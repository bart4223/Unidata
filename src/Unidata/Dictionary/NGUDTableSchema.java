package Unidata.Dictionary;

import Uniwork.Base.NGObject;

import java.util.concurrent.CopyOnWriteArrayList;

public class NGUDTableSchema extends NGObject {

    protected String Name = "";
    protected String Caption = "";
    protected CopyOnWriteArrayList<NGUDTableFieldSchema> Fields;

    public NGUDTableSchema() {
        super();
    }

    public void setName(String value) {
        Name = value;
    }
    public String getName() {
        return Name;
    }

    public void setCaption(String value) {
        Caption = value;
    }
    public String getCaption() {
        return Caption;
    }

    public void setFields(CopyOnWriteArrayList<NGUDTableFieldSchema> value) { Fields = value;}
    public CopyOnWriteArrayList<NGUDTableFieldSchema> getFields() { return Fields; }

}
