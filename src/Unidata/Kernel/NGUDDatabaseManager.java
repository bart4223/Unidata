package Unidata.Kernel;

import Uniwork.Base.NGComponent;

import java.util.ArrayList;

public class NGUDDatabaseManager extends NGComponent {

    protected NGUDDataDictionary FDataDictionary;
    protected ArrayList<NGUDTable> FTables;

    public NGUDDatabaseManager(NGComponent aOwner, String aName) {
        super(aOwner, aName);
        FTables = new ArrayList<>();
        FDataDictionary = null;
    }

    public void setDataDictionary(NGUDDataDictionary aDataDictionary) {
        FDataDictionary = aDataDictionary;
    }

    public NGUDDataDictionary getDataDictionary() {
        return FDataDictionary;
    }

}
