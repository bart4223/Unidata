package Unidata.Dictionary;

public class NGUDTableFieldDefinitionString extends NGUDCustomTableFieldDefinition {

    public NGUDTableFieldDefinitionString(Integer aIndex, String aName) {
        super(new NGUDTableFieldKindSimple(), new NGUDTableFieldTypeString(), aIndex, aName);
    }

}
