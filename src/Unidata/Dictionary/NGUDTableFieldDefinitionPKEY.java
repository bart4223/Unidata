package Unidata.Dictionary;

public class NGUDTableFieldDefinitionPKEY extends NGUDCustomTableFieldDefinition {

    public NGUDTableFieldDefinitionPKEY() {
        this(0);
    }

    public NGUDTableFieldDefinitionPKEY(Integer aIndex) {
        this(aIndex, "PKEY");
    }

    public NGUDTableFieldDefinitionPKEY(Integer aIndex, String aName) {
        super(new NGUDTableFieldKindPKEY(), new NGUDTableFieldTypeString(), aIndex, aName);
    }

}
