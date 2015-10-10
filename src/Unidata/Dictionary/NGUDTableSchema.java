package Unidata.Dictionary;

import Uniwork.Base.NGObject;

import java.util.ArrayList;

public class NGUDTableSchema extends NGObject {

    protected String Name = "";
    protected String Caption = "";
    protected ArrayList<NGUDTableFieldSchema> Fields;

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

    public void setFields(ArrayList<NGUDTableFieldSchema> value) { Fields = value;}
    public ArrayList<NGUDTableFieldSchema> getFields() { return Fields; }

}
