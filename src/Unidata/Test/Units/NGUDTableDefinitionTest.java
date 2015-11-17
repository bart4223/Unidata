package Unidata.Test.Units;

import Unidata.Dictionary.NGUDTableDefinition;
import Unidata.Dictionary.NGUDTableFieldDefinitionPKEY;
import Uniwork.Test.NGCustomTestUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class NGUDTableDefinitionTest extends NGCustomTestUnit {

    @BeforeClass
    public static void beforeSuite() {
        StartTestSuite();
    }

    @AfterClass
    public static void afterSuite() {
        FinishTestSuite();
    }

    @Test
    public void testTableDefinition01() throws Exception {
        StartTest();
        NGUDTableDefinition table = new NGUDTableDefinition("Test", "Test");
        table.addFieldDefinition(new NGUDTableFieldDefinitionPKEY());
        assertTrue(table.getFieldDefinitionCount() == 1);
        FinishTest();
    }

}