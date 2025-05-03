public class TestExecutionTime {

    public static void main(String[] args) throws Exception {
        SampleMethods sample = new SampleMethods();

        LogExecutionTimeAspect.logExecutionTime(sample, "methodOne");

        LogExecutionTimeAspect.logExecutionTime(sample, "methodTwo");

        sample.methodWithoutLogging();
    }
}
