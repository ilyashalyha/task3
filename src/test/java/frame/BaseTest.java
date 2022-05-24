package frame;

import org.testng.annotations.Test;

public abstract class BaseTest extends BaseEntity{

    public abstract void runTest();

    @Test
    public void xTest() {
        Class<? extends BaseTest> currentClass = this.getClass();
        runTest();
    }
}
