package Unidata.Dictionary;

import Unidata.Kernel.NGUDTableFieldInteger;

public class NGUDTableFieldDefinitionInteger extends NGUDCustomTableFieldDefinition {

    public NGUDTableFieldDefinitionInteger(Integer aIndex, String aName) {
        super(new NGUDTableFieldKindSimple(), new NGUDTableFieldTypeInteger(), aIndex, aName);
    }

    @Override
    public Class getFieldClass() {
        return NGUDTableFieldInteger.class;
    }

}
