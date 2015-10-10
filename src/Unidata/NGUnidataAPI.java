package Unidata;

import Unidata.Dictionary.NGUDTableDefinition;
import Unidata.Kernel.NGUDTableRecord;

public interface NGUnidataAPI {

    // Dictionary
    NGUDTableDefinition addTableDefinition(String aName, String aCaption);

    // Database
    NGUDTableRecord newRecord(String aName);

}
