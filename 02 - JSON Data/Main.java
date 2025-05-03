import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) throws Exception {
        Car car = new Car("Toyota", "Camry", 2022);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(car);
        System.out.println(json);
    }
}
