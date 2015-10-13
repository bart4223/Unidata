package Unidata.Kernel;

import Unidata.Dictionary.NGUDTableDefinitionEvent;
import Unidata.Dictionary.NGUDTableFieldDefinitionEvent;

public interface NGUDDataDictionaryEventListener {

    void handleTableDefinitionAdded(NGUDTableDefinitionEvent e);
    void handleTableFieldDefinitionAdded(NGUDTableFieldDefinitionEvent e);

}
