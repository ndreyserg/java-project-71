package hexlet.code;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.dataformat.yaml.YAMLMapper;

import java.util.Map;

public class Parser {

    public static Map<String, Object> parse(String data, String dataType) {
        ObjectMapper mapper = switch (dataType) {
            case "json" -> new ObjectMapper();
            case "yml", "yaml" -> new YAMLMapper();
            default -> throw new IllegalArgumentException("Invalid data type: " + dataType);
        };
        return mapper.readValue(data, new TypeReference<>() {
        });
    }
}
