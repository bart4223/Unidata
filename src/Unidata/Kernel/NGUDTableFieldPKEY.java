package Unidata.Kernel;

import Unidata.Dictionary.NGUDTableFieldDefinitionPKEY;

import java.util.UUID;

public class NGUDTableFieldPKEY extends NGUDCustomTableField {

    public NGUDTableFieldPKEY(NGUDTableFieldDefinitionPKEY aDefinition) {
        super(aDefinition);
        FValue = UUID.randomUUID().toString();
    }

    @Override
    public void setValue(Object aValue) {
    }

    @Override
    public String getValue() {
        return (String)super.getValue();
    }

}
