package Unidata.Kernel;

import Unidata.Dictionary.NGUDTableFieldDefinitionInteger;

public class NGUDTableFieldInteger extends NGUDCustomTableField {

    public NGUDTableFieldInteger(NGUDTableFieldDefinitionInteger aDefinition) {
        this(aDefinition, 0);
    }

    public NGUDTableFieldInteger(NGUDTableFieldDefinitionInteger aDefinition, Integer aValue) {
        super(aDefinition);
        setValue(aValue);
    }

    @Override
    public void setValue(Object aValue) {
        super.setValue(aValue);
    }

    @Override
    public Integer getValue() {
        return (Integer)super.getValue();
    }

}
