package Unidata.Dictionary;

import Uniwork.Base.NGObject;

public abstract class NGUDCustomTableFieldDefinition extends NGObject {

    protected Integer FIndex;
    protected String FName;
    protected NGUDCustomTableFieldType FType;
    protected NGUDCustomTableFieldKind FKind;

    public NGUDCustomTableFieldDefinition(NGUDCustomTableFieldKind aKind, NGUDCustomTableFieldType aType, Integer aIndex, String aName) {
        super();
        FIndex = aIndex;
        FName = aName;
        FType = aType;
        FKind = aKind;
    }

    public Integer getIndex() {
        return FIndex;
    }

    public NGUDCustomTableFieldKind getKind() {
        return FKind;
    }

    public NGUDCustomTableFieldType getType() {
        return FType;
    }

    public String getName() {
        return FName;
    }

}
