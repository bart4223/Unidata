package UnidataWorkbench;

import Unidata.Dictionary.NGUDTableDefinitionEvent;
import Unidata.Dictionary.NGUDTableFieldDefinitionEvent;
import Unidata.Kernel.NGUDDataDictionaryEventListener;
import Unidata.NGUnidataAPI;
import Unigraph.NGUnigraph2DAPI;
import Unigraph.Objects.NGUGTableDiagramObject;
import Unigraph.Visuals.NGUG2DDiagramLayer;
import Unigraph.Visuals.NGUG2DTableDiagramObjectLayout;
import Uniwork.Appl.NGApplication;
import Uniwork.Base.NGComponent;
import javafx.scene.paint.Color;

public class NGUDWorkbenchManager extends NGComponent implements NGUDDataDictionaryEventListener {

    protected NGUnidataAPI FUDAPI;
    protected NGUnigraph2DAPI FUGAPI;
    protected NGUG2DDiagramLayer FLayerTable;

    @Override
    protected void DoInitialize() {
        super.DoInitialize();
        FUDAPI = (NGUnidataAPI) NGApplication.Application.ResolveObject(NGUnidataAPI.class);
        FUDAPI.addDataDictionaryEventListener(this);
        FUGAPI = (NGUnigraph2DAPI)NGApplication.Application.ResolveObject(NGUnigraph2DAPI.class);
    }

    @Override
    protected void DoAfterInitialize() {
        super.DoAfterInitialize();
        if (FUGAPI != null) {
            FLayerTable = FUGAPI.addLayer("Table", 0, 1.0);
        }
    }

    public NGUDWorkbenchManager(NGComponent aOwner, String aName) {
        super(aOwner, aName);
        FUGAPI = null;
    }

    @Override
    public void handleTableDefinitionAdded(NGUDTableDefinitionEvent e) {
        if (FUGAPI != null) {
            NGUGTableDiagramObject table = FUGAPI.addTable(e.getTableDefinition().getName(), e.getTableDefinition());
            NGUG2DTableDiagramObjectLayout tableLayout = FUGAPI.addTableLayout(table, FLayerTable, 120, 180);
            tableLayout.setObjectColor(Color.LIGHTGREEN);
            tableLayout.setPosition(100.0, 130.0);
            FUGAPI.Refresh();
        }
    }

    @Override
    public void handleTableFieldDefinitionAdded(NGUDTableFieldDefinitionEvent e) {
        if (FUGAPI != null) {
            //FUGAPI.
        }
    }

}
