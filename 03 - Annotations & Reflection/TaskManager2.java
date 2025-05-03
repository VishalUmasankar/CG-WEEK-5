public class TaskManager2 {

    @ImportantMethod(level = "HIGH")
    public void processCriticalTask() {
        System.out.println("Processing critical task...");
    }

    @ImportantMethod(level = "LOW")
    public void processRoutineTask() {
        System.out.println("Processing routine task...");
    }

    public void processGeneralTask() {
        System.out.println("Processing general task...");
    }
}
