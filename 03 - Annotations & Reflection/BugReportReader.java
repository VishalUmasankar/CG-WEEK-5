import java.lang.reflect.Method;

public class BugReportReader {
    public static void main(String[] args) throws Exception {
        Method method = IssueTracker.class.getMethod("processData");

        if (method.isAnnotationPresent(BugReports.class)) {
            BugReport[] reports = method.getAnnotation(BugReports.class).value();
            for (BugReport report : reports) {
                System.out.println("Bug = " + report.description());
            }
        } else if (method.isAnnotationPresent(BugReport.class)) {
            BugReport report = method.getAnnotation(BugReport.class);
            System.out.println("Bug = " + report.description());
        }
    }
}
