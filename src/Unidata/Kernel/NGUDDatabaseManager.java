package Unidata.Kernel;

import Unidata.Dictionary.NGUDTableDefinition;
import Uniwork.Base.NGComponent;
import Uniwork.Misc.NGMisc;

import java.util.ArrayList;
import java.util.Iterator;

public class NGUDDatabaseManager extends NGComponent {

    protected NGUDDataDictionary FDataDictionary;
    protected ArrayList<NGUDTable> FTables;
    protected String FDatabasePath;

    protected String getFilename(String aName) {
        return NGMisc.combinePath(FDatabasePath, aName + ".utd");
    }

    @Override
    protected void DoInitialize() {
        super.DoInitialize();
        Iterator<NGUDTableDefinition> itr =  FDataDictionary.getTableDefinitions();
        while (itr.hasNext()) {
            NGUDTableDefinition tableDef = itr.next();
            createTable(tableDef.getName());
        }
        writeInfo(String.format("Tables[%d] created.", FTables.size()));
    }

    @Override
    protected void DoFinalize() {
        super.DoFinalize();
        Integer stored = 0;
        for (NGUDTable table : FTables) {
            if (table.Loaded()) {
                StoreTable(table);
                stored++;
            }
        }
        writeInfo(String.format("Tables[%d] stored.", stored));
    }

    protected void StoreTable(NGUDTable aTable) {
        aTable.StoreTable(getFilename(aTable.getName()));
        writeInfo(String.format("Table %s[%s] stored.", aTable.getCaption(), aTable.getName()));
    }

    protected NGUDTable createTable(String aName) {
        NGUDTableDefinition tabledef = FDataDictionary.getTableDefinition(aName);
        NGUDTable res = new NGUDTable(tabledef);
        FTables.add(res);
        writeInfo(String.format("Table %s[%s] added.", res.getCaption(), res.getName()));
        return res;
    }

    protected void LoadTable(NGUDTable aTable) {
        aTable.LoadTable(getFilename(aTable.getName()));
        writeInfo(String.format("Table %s[%s] loaded (Records %d).", aTable.getCaption(), aTable.getName(), aTable.getRecordCount()));
    }

    protected NGUDTable getTable(String aName) {
        NGUDTable res = null;
        for (NGUDTable table : FTables) {
            if (table.getName().equals(aName))
                res = table;
        }
        if (res == null)
            res = createTable(aName);
        if (!res.Loaded())
            LoadTable(res);
        return res;
    }

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

    public NGUDTableRecord newRecord(String aName) {
        NGUDTable table = getTable(aName);
        return table.newRecord();
    }

    public Iterator<NGUDTableRecord> getRecords(String aName) {
        NGUDTable table = getTable(aName);
        return table.getRecords();
    }

}
