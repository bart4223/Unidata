package Unidata.Kernel;

import Unidata.Dictionary.NGUDTableFieldDefinitionDateTime;

import java.util.Date;

public class NGUDTableFieldDateTime extends NGUDCustomTableField {

    public NGUDTableFieldDateTime(NGUDTableFieldDefinitionDateTime aDefinition) {
        this(aDefinition, new Date());
    }

    public NGUDTableFieldDateTime(NGUDTableFieldDefinitionDateTime aDefinition, Date aValue) {
        super(aDefinition);
        setValue(aValue);
    }

    @Override
    public void setValue(Object aValue) {
        super.setValue(aValue);
    }

    @Override
    public Date getValue() {
        return (Date)super.getValue();
    }

}
