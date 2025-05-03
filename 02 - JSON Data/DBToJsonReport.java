import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.*;
import java.io.FileWriter;
import java.util.*;

public class DBToJsonReport {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_username";
        String password = "your_password";

        Connection conn = DriverManager.getConnection(url, user, password);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT employee_id, name, department, salary FROM employees");

        List<Map<String, Object>> data = new ArrayList<>();

        while (rs.next()) {
            Map<String, Object> row = new LinkedHashMap<>();
            row.put("Employee ID", rs.getInt("employee_id"));
            row.put("Name", rs.getString("name"));
            row.put("Department", rs.getString("department"));
            row.put("Salary", rs.getDouble("salary"));
            data.add(row);
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new FileWriter("employees.json"), data);

        rs.close();
        stmt.close();
        conn.close();
    }
}
