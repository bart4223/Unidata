package Unidata;

import Unidata.Dictionary.NGUDTableDefinition;
import Unidata.Kernel.NGUDDataDictionaryEventListener;

public interface NGUnidataAPI {

    void addDataDictionaryEventListener(NGUDDataDictionaryEventListener aEventListener);
    void removeDataDictionaryEventListener(NGUDDataDictionaryEventListener aEventListener);
    NGUDTableDefinition addTableDefinition(String aName, String aCaption);

}
