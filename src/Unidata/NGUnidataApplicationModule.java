package Unidata;

import Unidata.Dictionary.NGUDTableDefinition;
import Unidata.Kernel.NGUDDataDictionary;
import Unidata.Kernel.NGUDDatabaseManager;
import Uniwork.Appl.NGNonVisualApplicationModule;
import Uniwork.Base.NGComponent;

public class NGUnidataApplicationModule extends NGNonVisualApplicationModule implements NGUnidataAPI {

    protected NGUDDataDictionary FDataDictionary;
    protected NGUDDatabaseManager FDatabaseManager;

    public NGUnidataApplicationModule(NGComponent aOwner, String aName) {
        super(aOwner, aName);
        FDataDictionary = new NGUDDataDictionary(this, "DataDictionary");
        FComponentManager.registerComponent(FDataDictionary);
        FDatabaseManager = new NGUDDatabaseManager(this, "DatabaseManager");
        FComponentManager.registerComponent(FDatabaseManager);
        FDatabaseManager.setDataDictionary(FDataDictionary);
    }

    @Override
    public NGUDTableDefinition addTableDefinition(String aName) {
        return FDataDictionary.addTableDefinition(aName);
    }

}
