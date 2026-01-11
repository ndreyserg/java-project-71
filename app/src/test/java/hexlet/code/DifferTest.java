package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    private static String readFixture(String fileName) throws IOException {
        var path = getFixturePath(fileName);
        return Files.readString(path).trim();
    }

    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize();
    }

    @Test
    public void testJsonToStylish() throws Exception {
        var file1 = getFixturePath("file1.json").toString();
        var file2 = getFixturePath("file2.json").toString();
        var expected = readFixture("expectedStylish");
        assertEquals(expected, Differ.generate(file1, file2, "stylish"));
    }

    @Test
    public void testYmlToStylish() throws Exception {
        var file1 = getFixturePath("file1.yml").toString();
        var file2 = getFixturePath("file2.yml").toString();
        var expected = readFixture("expectedStylish");
        assertEquals(expected, Differ.generate(file1, file2, "stylish"));
    }
}
