package Unidata.Kernel;

import Unidata.Dictionary.NGUDCustomTableFieldDefinition;
import Uniwork.Base.NGObject;

public abstract class NGUDCustomTableField extends NGObject {

    protected Object FValue;
    protected NGUDCustomTableFieldDefinition FDefinition;

    public NGUDCustomTableField(NGUDCustomTableFieldDefinition aDefinition) {
        super();
        FDefinition = aDefinition;
        FValue = null;
    }

    public NGUDCustomTableFieldDefinition getDefintion() {
        return FDefinition;
    }

    public void setValue(Object aValue) {
        FValue = aValue;
    }

    public Object getValue() {
        return FValue;
    }

}
