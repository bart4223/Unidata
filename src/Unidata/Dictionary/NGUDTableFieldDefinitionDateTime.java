package Unidata.Dictionary;

import Unidata.Kernel.NGUDTableFieldDateTime;

public class NGUDTableFieldDefinitionDateTime extends NGUDCustomTableFieldDefinition {

    public NGUDTableFieldDefinitionDateTime(Integer aIndex, String aName) {
        super(new NGUDTableFieldKindSimple(), new NGUDTableFieldTypeDateTime(), aIndex, aName);
    }

    @Override
    public Class getFieldClass() {
        return NGUDTableFieldDateTime.class;
    }

}
