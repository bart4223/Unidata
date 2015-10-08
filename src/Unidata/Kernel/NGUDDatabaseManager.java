package Unidata.Kernel;

import Uniwork.Base.NGComponent;

import java.util.ArrayList;

public class NGUDDatabaseManager extends NGComponent {

    protected NGUDDataDictionary FDataDictionary;
    protected ArrayList<NGUDTable> FTables;
    protected String FDatabasePath;

    public NGUDDatabaseManager(NGComponent aOwner, String aName) {
        super(aOwner, aName);
        FTables = new ArrayList<>();
        FDataDictionary = null;
        FDatabasePath = "";
    }

    public void setDatabasePath(String aDatabasePath) {
        FDatabasePath = aDatabasePath;
    }

    public String getDatabasePath() {
        return FDatabasePath;
    }

    public void setDataDictionary(NGUDDataDictionary aDataDictionary) {
        FDataDictionary = aDataDictionary;
    }

    public NGUDDataDictionary getDataDictionary() {
        return FDataDictionary;
    }

}
