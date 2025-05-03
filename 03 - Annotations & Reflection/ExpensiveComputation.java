import java.lang.reflect.Method;

public class ExpensiveComputation {

    private CacheHandler cacheHandler = new CacheHandler();

    @CacheResult
    public int computeExpensiveValue(int input) {
        try {
            System.out.println("Computing result for input: " + input);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return input * 2;
    }

    public int compute(int input) throws Exception {
        Method method = this.getClass().getMethod("computeExpensiveValue", int.class);
        return (int) cacheHandler.invokeWithCache(this, method, new Object[]{input});
    }
}
