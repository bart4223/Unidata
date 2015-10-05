package Unidata.DataDictonary;

public class NGUGTableFieldPKEY extends NGUDCustomTableFieldDefinition {

    public NGUGTableFieldPKEY() {
        this(0);
    }

    public NGUGTableFieldPKEY(Integer aIndex) {
        this(aIndex, "PKEY");
    }

    public NGUGTableFieldPKEY(Integer aIndex, String aName) {
        super(new NGUDTableFieldKindPKEY(), new NGUDTableFieldTypeString(), aIndex, aName);
    }

}
