package Unidata;

import Unidata.Kernel.NGUDTableRecord;

import java.util.Iterator;

public interface NGUnidataRuntimeAPI {

    NGUDTableRecord newRecord(String aName);
    Iterator<NGUDTableRecord> getRecords(String aName);

}
