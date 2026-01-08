package hexlet.code;

import tools.jackson.core.JacksonException;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class Differ {
    public static String generate(String filepath1, String filepath2) throws Exception {
        var fileContent1 = getFileContent(filepath1);
        var fileContent2 = getFileContent(filepath2);

        var map1 = getContentMap(fileContent1);
        var map2 = getContentMap(fileContent2);
        var compareResult = Comparator.compare(map1, map2);
        return format(compareResult);
    }

    private static String format(List<CompareResultItem> contents) {
        var result = new StringJoiner(System.lineSeparator());
        result.add("{");
        for (var item : contents) {
            result.add("  " + item.toString());
        }
        result.add("}");
        return result.toString();
    }

    private static String getFileContent(String filepath) throws IOException, IllegalArgumentException {
        Path path = Paths.get(filepath).toAbsolutePath().normalize();

        if (!Files.exists(path)) {
            throw new IllegalArgumentException("File '" + path + "' does not exist");
        }
        return Files.readString(path);
    }

    private static Map<String, Object> getContentMap(String content) throws JacksonException {
        var mapper = new ObjectMapper();
        return mapper.readValue(content, new TypeReference<>() {
        });
    }
}
