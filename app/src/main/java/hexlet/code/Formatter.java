package hexlet.code;

import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;

import java.util.List;

public interface Formatter {
    String format(List<CompareResultItem> data);

    static Formatter of(String format) {
        return switch (format) {
            case "stylish" -> new StylishFormatter();
            case "plain" -> new PlainFormatter();
            default -> throw new IllegalArgumentException("Unsupported format: " + format);
        };
    }

}
