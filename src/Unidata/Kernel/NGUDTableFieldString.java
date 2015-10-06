package Unidata.Kernel;

import Unidata.Dictionary.NGUDTableFieldDefinitionString;

public class NGUDTableFieldString extends NGUDCustomTableField {

    public NGUDTableFieldString(NGUDTableFieldDefinitionString aDefinition, String aValue) {
        super(aDefinition);
        setValue(aValue);
    }

    @Override
    public void setValue(Object aValue) {
        super.setValue(aValue);
    }

    @Override
    public String getValue() {
        return (String)super.getValue();
    }

}
