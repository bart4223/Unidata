package Unidata.Dictionary;

import java.util.EventObject;

public class NGUDTableDefinitionEvent extends EventObject {

    public NGUDTableDefinitionEvent(NGUDTableDefinition aTableDefinition) {
        super(aTableDefinition);
    }

    public NGUDTableDefinition getTableDefinition() {
        return (NGUDTableDefinition)source;
    }

}
