public class SampleMethods {

    @LogExecutionTime
    public void methodOne() throws InterruptedException {
        Thread.sleep(1000);
    }

    @LogExecutionTime
    public void methodTwo() throws InterruptedException {
        Thread.sleep(500);
    }

    public void methodWithoutLogging() throws InterruptedException {
        Thread.sleep(200);
    }
}
