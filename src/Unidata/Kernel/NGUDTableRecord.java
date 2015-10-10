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
                NGUDCustomTableField field = (NGUDCustomTableField)fieldDef.getFieldClass().getConstructor(fieldDef.getClass()).newInstance(fieldDef);
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

    public Iterator<NGUDCustomTableField> getFields() {
        return FFields.iterator();
    }

    public NGUDCustomTableField getField(String aName) {
        for (NGUDCustomTableField field : FFields) {
            if (field.getName().equals(aName))
                return field;
        }
        return null;
    }

    public void setFieldValue(String aName, Object aValue) {
        NGUDCustomTableField field = getField(aName);
        field.setValue(aValue);
    }

    public Object getFieldValue(String aName) {
        NGUDCustomTableField field = getField(aName);
        return field.getValue();
    }

}
