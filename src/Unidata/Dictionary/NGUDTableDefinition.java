package Unidata.Dictionary;

import Uniwork.Base.NGObject;

import java.util.ArrayList;
import java.util.Iterator;

public class NGUDTableDefinition extends NGObject {

    protected String FName;
    protected ArrayList<NGUDCustomTableFieldDefinition> FFieldDefinitions;

    public NGUDTableDefinition(String aName) {
        super();
        FName = aName;
        FFieldDefinitions = new ArrayList<>();
    }

    public String getName() {
        return FName;
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
