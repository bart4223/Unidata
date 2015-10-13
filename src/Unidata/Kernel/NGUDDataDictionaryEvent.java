package Unidata.Kernel;

import java.util.EventObject;

public class NGUDDataDictionaryEvent extends EventObject {

    public NGUDDataDictionaryEvent(NGUDDataDictionary aDataDictionary) {
        super(aDataDictionary);
    }

    public NGUDDataDictionary getDataDictionary() {
        return (NGUDDataDictionary)source;
    }

}
