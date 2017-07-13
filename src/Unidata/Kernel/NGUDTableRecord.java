package Unidata.Kernel;

import Unidata.Dictionary.NGUDCustomTableFieldDefinition;
import Unidata.Dictionary.NGUDTableDefinition;
import Uniwork.Base.NGObject;
import Uniwork.Misc.NGStrings;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class NGUDTableRecord extends NGObject {

    protected NGUDTableDefinition FDefinition;
    protected CopyOnWriteArrayList<NGUDCustomTableField> FFields;

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
        FFields = new CopyOnWriteArrayList<>();
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

    public String getAsString() {
        return getAsString(true);
    }

    public String getAsString(Boolean aWithPKEY) {
        String res = "";
        for (NGUDCustomTableField field : FFields) {
            if (aWithPKEY || !(field instanceof NGUDTableFieldPKEY))
                res = NGStrings.addString(res, field.GetAsString(), ",");
        }
        return res;
    }

}
