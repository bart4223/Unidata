package UnidataWorkbench;

import Uniwork.Appl.NGCustomStageItem;
import Uniwork.Appl.NGVisualApplicationModule;
import Uniwork.Base.NGComponent;

public class NGUnidataWorkbenchApplicationModule extends NGVisualApplicationModule {

    protected NGUDWorkbenchManager FWorkbenchManager;

    @Override
    protected void DoBeforeInitialize() {
        super.DoBeforeInitialize();
        NGCustomStageItem item = FStageManager.addStageItem("Main", FPrimaryStage);
        item.setCaption(getDescription());
        item.setPosition(350, 200);
    }

    public NGUnidataWorkbenchApplicationModule(NGComponent aOwner, String aName) {
        super(aOwner, aName);
        FDescription = "Unidata Workbench";
        FWorkbenchManager = new NGUDWorkbenchManager(this, "WorkbenchManager");
        FComponentManager.registerComponent(FWorkbenchManager);
        FStageManager.registerItemClass("Main", "UnidataWorkbench.UI.NGUDWorkbenchMainStageItem");
    }

}
