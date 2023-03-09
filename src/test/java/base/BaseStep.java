package base;

import Resources.TestData;
import Resources.Utilities;
import context.TestContext;

public class BaseStep {
    protected TestData _testData;
    public Utilities _utilities;

    public BaseStep() {

        _testData = new TestData();
        _utilities = new Utilities();
    }
}
