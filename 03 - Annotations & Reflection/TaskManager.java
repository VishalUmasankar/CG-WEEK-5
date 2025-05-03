public class TaskManager {

    @TaskInfo(priority = "High", assignedTo = "Ruchi")
    public void completePaymentTask() {
        System.out.println("Payment task completed.");
    }
}
