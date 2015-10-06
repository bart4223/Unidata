package Unidata.Kernel;

import Unidata.Dictionary.NGUDCustomTableFieldDefinition;
import Unidata.Dictionary.NGUDTableDefinition;
import Uniwork.Base.NGObject;

import java.util.ArrayList;
import java.util.Iterator;

public class NGUDTableRecord extends NGObject {

    protected NGUDTableDefinition FDefinition;
    protected ArrayList<NGUDCustomTableField> FFields;

    protected void addField(NGUDCustomTableField aField) {
        FFields.add(aField);
    }

    protected void InitFields() {
        Iterator<NGUDCustomTableFieldDefinition> itr = FDefinition.getFieldDefinitions();
        while (itr.hasNext()) {
            NGUDCustomTableFieldDefinition fieldDef = itr.next();
            try {
                NGUDCustomTableField field = (NGUDCustomTableField)fieldDef.getFieldClass().getConstructor(NGUDCustomTableFieldDefinition.class).newInstance(fieldDef);
                addField(field);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public NGUDTableRecord(NGUDTableDefinition aDefinition) {
        super();
        FDefinition = aDefinition;
        FFields = new ArrayList<>();
        InitFields();
    }

    public NGUDTableDefinition getDefinition() {
        return FDefinition;
    }

}
