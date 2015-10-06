package Unidata.Kernel;

import Unidata.Dictionary.NGUDTableDefinition;
import Unidata.Dictionary.NGUDTableFieldDefinitionPKEY;
import Uniwork.Base.NGComponent;

import java.util.ArrayList;

public class NGUDDataDictionary extends NGComponent {

    public ArrayList<NGUDTableDefinition> FTableDefinitions;

    public NGUDDataDictionary(NGComponent aOwner, String aName) {
        super(aOwner, aName);
        FTableDefinitions = new ArrayList<>();
    }

    public NGUDTableDefinition addTableDefinition(String aName) {
        NGUDTableDefinition res = new NGUDTableDefinition(aName);
        res.addFieldDefinition(new NGUDTableFieldDefinitionPKEY());
        FTableDefinitions.add(res);
        writeInfo(String.format("Table definition [%s] added", res.getName()));
        return res;
    }

}
