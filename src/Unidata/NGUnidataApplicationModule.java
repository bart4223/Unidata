package Unidata;

import Unidata.Dictionary.NGUDTableDefinition;
import Unidata.Kernel.NGUDDataDictionary;
import Unidata.Kernel.NGUDDataDictionaryEventListener;
import Unidata.Kernel.NGUDDatabaseManager;
import Unidata.Kernel.NGUDTableRecord;
import Uniwork.Appl.NGNonVisualApplicationModule;
import Uniwork.Base.NGComponent;
import Uniwork.Misc.NGMisc;

import java.util.Iterator;

public class NGUnidataApplicationModule extends NGNonVisualApplicationModule implements NGUnidataAPI {

    protected NGUDDataDictionary FDataDictionary;
    protected NGUDDatabaseManager FDatabaseManager;

    @Override
    protected void DoBeforeInitialize() {
        super.DoBeforeInitialize();
        FDataDictionary.setDatabasePath(NGMisc.combinePath(getConfigurationProperty("DatabasePath"), "schema"));
        FDatabaseManager.setDatabasePath(NGMisc.combinePath(getConfigurationProperty("DatabasePath"), "data"));
    }

    public NGUnidataApplicationModule(NGComponent aOwner, String aName) {
        super(aOwner, aName);
        FDescription = "Unidata Database";
        FDataDictionary = new NGUDDataDictionary(this, "DataDictionary");
        FComponentManager.registerComponent(FDataDictionary);
        FDatabaseManager = new NGUDDatabaseManager(this, "DatabaseManager");
        FComponentManager.registerComponent(FDatabaseManager);
        FDatabaseManager.setDataDictionary(FDataDictionary);
    }

    @Override
    public void addDataDictionaryEventListener(NGUDDataDictionaryEventListener aEventListener) {
        FDataDictionary.addEventListener(aEventListener);
    }

    @Override
    public void removeDataDictionaryEventListener(NGUDDataDictionaryEventListener aEventListener) {
        FDataDictionary.removeEventListener(aEventListener);
    }

    @Override
    public NGUDTableDefinition addTableDefinition(String aName, String aCaption) {
        return FDataDictionary.addTableDefinition(aName, aCaption);
    }

    @Override
    public NGUDTableRecord newRecord(String aName) {
        return FDatabaseManager.newRecord(aName);
    }

    @Override
    public Iterator<NGUDTableRecord> getRecords(String aName) {
        return FDatabaseManager.getRecords(aName);
    }

}
