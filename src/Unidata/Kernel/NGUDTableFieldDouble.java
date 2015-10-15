package Unidata.Kernel;

import Unidata.Dictionary.NGUDTableFieldDefinitionDouble;

public class NGUDTableFieldDouble extends NGUDCustomTableField {

    public NGUDTableFieldDouble(NGUDTableFieldDefinitionDouble aDefinition) {
        this(aDefinition, 0.0);
    }

    public NGUDTableFieldDouble(NGUDTableFieldDefinitionDouble aDefinition, Double aValue) {
        super(aDefinition);
        setValue(aValue);
    }

    @Override
    public void setValue(Object aValue) {
        super.setValue(aValue);
    }

    @Override
    public Double getValue() {
        return (Double)super.getValue();
    }

}
