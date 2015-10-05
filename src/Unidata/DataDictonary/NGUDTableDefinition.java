package Unidata.DataDictonary;

import Uniwork.Base.NGObject;

import java.util.ArrayList;
import java.util.Iterator;

public class NGUDTableDefinition extends NGObject {

    protected ArrayList<NGUDCustomTableFieldDefinition> FFieldDefinitions;

    public NGUDTableDefinition() {
        super();
        FFieldDefinitions = new ArrayList<>();
    }

    public Iterator<NGUDCustomTableFieldDefinition> getFieldDefinitions() {
        return FFieldDefinitions.iterator();
    }

    public void addFieldDefinition(NGUDCustomTableFieldDefinition aFieldDefinition) {
        int i = 0;
        for (NGUDCustomTableFieldDefinition fieldDef : FFieldDefinitions) {
            if (fieldDef.getIndex() > aFieldDefinition.getIndex()) {
                FFieldDefinitions.add(i, aFieldDefinition);
                return;
            }
            i++;
        }
        FFieldDefinitions.add(aFieldDefinition);
    }

}
