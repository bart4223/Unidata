package UnidataWorkbench.UI;

import Uniwork.Appl.NGCustomStageItem;
import Uniwork.Appl.NGStageManager;
import javafx.stage.Stage;

public class NGUDWorkbenchMainStageItem extends NGCustomStageItem {

    public NGUDWorkbenchMainStageItem(NGStageManager aStageManager, String aName, Stage aStage) {
        super(aStageManager, aName, aStage);
        FFXMLName = "NGUDWorkbenchMainStage.fxml";
        FWidth = 200;
        FHeight = 800;
        FOnlyCaption = true;
    }

}
