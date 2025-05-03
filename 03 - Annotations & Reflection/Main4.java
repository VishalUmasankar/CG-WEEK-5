public class Main4 {

    public static void main(String[] args) throws Exception {
        ExpensiveComputation computation = new ExpensiveComputation();

        System.out.println(computation.compute(5));
        System.out.println(computation.compute(5));

        System.out.println(computation.compute(10));
    }
}
