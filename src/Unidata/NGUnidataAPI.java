package Unidata;

import Unidata.Dictionary.NGUDTableDefinition;
import Unidata.Kernel.NGUDTableRecord;

import java.util.Iterator;

public interface NGUnidataAPI {

    // Dictionary
    NGUDTableDefinition addTableDefinition(String aName, String aCaption);

    // Database
    NGUDTableRecord newRecord(String aName);
    Iterator<NGUDTableRecord> getRecords(String aName);

}
