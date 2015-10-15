package Unidata.Dictionary;

import Unidata.Kernel.NGUDTableFieldBoolean;

public class NGUDTableFieldDefinitionBoolean extends NGUDCustomTableFieldDefinition {

    public NGUDTableFieldDefinitionBoolean(Integer aIndex, String aName) {
        super(new NGUDTableFieldKindSimple(), new NGUDTableFieldTypeBoolean(), aIndex, aName);
    }

    @Override
    public Class getFieldClass() {
        return NGUDTableFieldBoolean.class;
    }

}
