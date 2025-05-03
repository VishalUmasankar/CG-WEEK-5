public class IssueTracker {

    @BugReport(description = "NullPointerException when input is null")
    @BugReport(description = "Incorrect result when data is empty")
    public void processData() {
        System.out.println("Processing data...");
    }
}
