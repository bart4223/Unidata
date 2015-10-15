package Unidata.Kernel;

import Unidata.Dictionary.NGUDTableFieldDefinitionPKEY;

import java.util.UUID;

public class NGUDTableFieldFKEY extends NGUDCustomTableField {

    public NGUDTableFieldFKEY(NGUDTableFieldDefinitionPKEY aDefinition) {
        super(aDefinition);
    }

    @Override
    public void setValue(Object aValue) {
        FValue = aValue;
    }

    @Override
    public String getValue() {
        return (String)super.getValue();
    }

}
