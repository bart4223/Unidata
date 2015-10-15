package Unidata.Dictionary;

import Unidata.Kernel.NGUDTableFieldDouble;

public class NGUDTableFieldDefinitionDouble extends NGUDCustomTableFieldDefinition {

    public NGUDTableFieldDefinitionDouble(Integer aIndex, String aName) {
        super(new NGUDTableFieldKindSimple(), new NGUDTableFieldTypeDouble(), aIndex, aName);
    }

    @Override
    public Class getFieldClass() {
        return NGUDTableFieldDouble.class;
    }

}
