package Unidata.Dictionary;

import Unidata.Kernel.NGUDTableFieldString;

public class NGUDTableFieldDefinitionString extends NGUDCustomTableFieldDefinition {

    public NGUDTableFieldDefinitionString(Integer aIndex, String aName) {
        super(new NGUDTableFieldKindSimple(), new NGUDTableFieldTypeString(), aIndex, aName);
    }

    @Override
    public Class getFieldClass() {
        return NGUDTableFieldString.class;
    }

}
