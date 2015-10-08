package Unidata.Dictionary;

import Uniwork.Base.NGObject;

public class NGUDTableFieldSchema extends NGObject {

    protected String Name = "";
    protected Integer Index = 0;
    protected String ClassName = "";

    public NGUDTableFieldSchema() {
        super();
    }

    public void setName(String value) {
        Name = value;
    }
    public String getName() {
        return Name;
    }

    public void setIndex(Integer value) {
        Index = value;
    }
    public Integer getIndex() {
        return Index;
    }

    public void setClassName(String value) {
        ClassName = value;
    }
    public String getClassName() {
        return ClassName;
    }

}
