package Unidata.Kernel;

import Unidata.Dictionary.NGUDTableDefinition;
import Uniwork.Base.NGObject;

import java.util.ArrayList;

public class NGUDTable extends NGObject {

    protected ArrayList<NGUDTableRecord> FRecords;
    protected NGUDTableDefinition FDefinition;

    protected void addRecord(NGUDTableRecord aRecord) {
        FRecords.add(aRecord);
    }

    public NGUDTable(NGUDTableDefinition aDefinition) {
        super();
        FDefinition = aDefinition;
        FRecords = new ArrayList<>();
    }

    public NGUDTableDefinition getDefinition() {
        return FDefinition;
    }

    public NGUDTableRecord newRecord() {
        NGUDTableRecord res = new NGUDTableRecord(FDefinition);
        addRecord(res);
        return res;
    }

}
