import java.util.ArrayList;
import java.util.List;

public class WarningSuppressor {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("Hello");
        list.add("World");

        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}
