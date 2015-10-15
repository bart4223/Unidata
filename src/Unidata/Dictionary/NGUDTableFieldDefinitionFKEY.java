package Unidata.Dictionary;

import Unidata.Kernel.NGUDTableFieldFKEY;

public class NGUDTableFieldDefinitionFKEY extends NGUDCustomTableFieldDefinition {

    public NGUDTableFieldDefinitionFKEY() {
        this(0);
    }

    public NGUDTableFieldDefinitionFKEY(Integer aIndex) {
        this(aIndex, "FKEY");
    }

    public NGUDTableFieldDefinitionFKEY(Integer aIndex, String aName) {
        super(new NGUDTableFieldKindFKEY(), new NGUDTableFieldTypeString(), aIndex, aName);
    }

    @Override
    public Class getFieldClass() {
        return NGUDTableFieldFKEY.class;
    }

}
