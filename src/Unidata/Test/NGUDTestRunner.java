package Unidata.Test;

import Unidata.Test.Units.NGUDAllTestUnits;
import Uniwork.Test.NGCustomTestRunner;

public class NGUDTestRunner extends NGCustomTestRunner {

    public NGUDTestRunner(Class aTestClass) {
        super(aTestClass);
    }

    public static void main(String[] args) {
        TestRunner = new NGUDTestRunner(NGUDAllTestUnits.class);
        TestRunner.InitTests();
        TestRunner.RunTests();
    }

}
