package Unidata.Kernel;

import Unidata.Dictionary.NGUDTableFieldDefinitionBoolean;

public class NGUDTableFieldBoolean extends NGUDCustomTableField {

    public NGUDTableFieldBoolean(NGUDTableFieldDefinitionBoolean aDefinition) {
        this(aDefinition, false);
    }

    public NGUDTableFieldBoolean(NGUDTableFieldDefinitionBoolean aDefinition, Boolean aValue) {
        super(aDefinition);
        setValue(aValue);
    }

    @Override
    public void setValue(Object aValue) {
        super.setValue(aValue);
    }

    @Override
    public Boolean getValue() {
        return (Boolean)super.getValue();
    }

}
