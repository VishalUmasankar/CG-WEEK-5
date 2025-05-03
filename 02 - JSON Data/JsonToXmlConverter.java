import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class JsonToXmlConverter {

    public static void main(String[] args) throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        JsonNode jsonNode = jsonMapper.readTree(new File("file.json"));

        XmlMapper xmlMapper = new XmlMapper(new XmlFactory());

        String xml = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);

        System.out.println(xml);

        xmlMapper.writeValue(new File("file.xml"), jsonNode);
    }
}
