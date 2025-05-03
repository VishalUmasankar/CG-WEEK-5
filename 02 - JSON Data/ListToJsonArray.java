import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

public class ListToJsonArray {
    public static void main(String[] args) throws Exception {
        List<Student2> students = Arrays.asList(
                new Student2("Ruchi", 20),
                new Student2("Yash", 22)
        );

        ObjectMapper mapper = new ObjectMapper();
        String jsonArray = mapper.writeValueAsString(students);
        System.out.println(jsonArray);
    }
}
