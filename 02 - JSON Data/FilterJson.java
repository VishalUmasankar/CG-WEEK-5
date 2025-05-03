import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

class Person {
    private String name;
    private int age;

    public Person() {}

    public String getName() { return name; }
    public int getAge() { return age; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
}

public class FilterJson {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        List<Person> people = mapper.readValue(
                new File("data2.json"),
                new TypeReference<List<Person>>() {}
        );

        List<Person> filtered = people.stream()
                .filter(p -> p.getAge() > 25)
                .collect(Collectors.toList());

        filtered.forEach(p -> System.out.println(p.getName() + " - " + p.getAge()));
    }
}
