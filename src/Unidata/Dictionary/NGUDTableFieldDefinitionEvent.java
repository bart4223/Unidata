package Unidata.Dictionary;

public class NGUDTableFieldDefinitionEvent extends NGUDTableDefinitionEvent {

    protected NGUDCustomTableFieldDefinition FFieldDefintion;

    public NGUDTableFieldDefinitionEvent(NGUDTableDefinition aTableDefinition, NGUDCustomTableFieldDefinition aFieldDefiniton) {
        super(aTableDefinition);
        FFieldDefintion = aFieldDefiniton;
    }

    public NGUDCustomTableFieldDefinition getFieldDefinition() {
        return FFieldDefintion;
    }

}
