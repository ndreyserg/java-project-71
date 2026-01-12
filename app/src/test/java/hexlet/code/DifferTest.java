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
        var expected = readFixture("expected.stylish");
        assertEquals(expected, Differ.generate(file1, file2, "stylish"));
    }

    @Test
    public void testYmlToStylish() throws Exception {
        var file1 = getFixturePath("file1.yml").toString();
        var file2 = getFixturePath("file2.yml").toString();
        var expected = readFixture("expected.stylish");
        assertEquals(expected, Differ.generate(file1, file2, "stylish"));
    }

    @Test
    public void testJsonToPlain() throws Exception {
        var file1 = getFixturePath("file1.json").toString();
        var file2 = getFixturePath("file2.json").toString();
        var expected = readFixture("expected.plain");
        assertEquals(expected, Differ.generate(file1, file2, "plain"));
    }

    @Test
    public void testYmlToPlain() throws Exception {
        var file1 = getFixturePath("file1.yml").toString();
        var file2 = getFixturePath("file2.yml").toString();
        var expected = readFixture("expected.plain");
        assertEquals(expected, Differ.generate(file1, file2, "plain"));
    }

    @Test
    public void testJsonToJson() throws Exception {
        var file1 = getFixturePath("file1.json").toString();
        var file2 = getFixturePath("file2.json").toString();
        var expected = readFixture("expected.json");
        assertEquals(expected, Differ.generate(file1, file2, "json"));
    }

    @Test
    public void testYmlToJson() throws Exception {
        var file1 = getFixturePath("file1.yml").toString();
        var file2 = getFixturePath("file2.yml").toString();
        var expected = readFixture("expected.json");
        assertEquals(expected, Differ.generate(file1, file2, "json"));
    }

    @Test
    public void testJsonToDefault() throws Exception {
        var file1 = getFixturePath("file1.json").toString();
        var file2 = getFixturePath("file2.json").toString();
        var expected = readFixture("expected.stylish");
        assertEquals(expected, Differ.generate(file1, file2));
    }

    @Test
    public void testYmlToDefault() throws Exception {
        var file1 = getFixturePath("file1.yml").toString();
        var file2 = getFixturePath("file2.yml").toString();
        var expected = readFixture("expected.stylish");
        assertEquals(expected, Differ.generate(file1, file2));
    }
}
