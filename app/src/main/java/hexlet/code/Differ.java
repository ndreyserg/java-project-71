package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import tools.jackson.databind.ObjectMapper;
import tools.jackson.core.type.TypeReference;

public class Differ {
    public static String generate(String filepath1, String filepath2) throws IOException {
        var fileContent1 = getFileContent(filepath1);
        var fileContent2 = getFileContent(filepath2);

        var map1 = getContentMap(fileContent1);
        var map2 = getContentMap(fileContent2);

        System.out.println(map1);
        System.out.println(map2);
        return "";
    }

    private static String getFileContent(String filepath) throws IOException {
        Path path = Paths.get(filepath).toAbsolutePath().normalize();

        if (!Files.exists(path)) {
            throw new IllegalArgumentException("File '" + path + "' does not exist");
        }
        return Files.readString(path);
    }

    private static Map<String, Object> getContentMap(String content) throws IOException {
        var mapper = new ObjectMapper();
        return mapper.readValue(content, new TypeReference<>() {});
    }
}
