package hexlet.code.Formatter;

import hexlet.code.CompareResultItem;

import java.util.List;

public interface Formatter {
    String format(List<CompareResultItem> data);

    static Formatter of(String format) {
        switch (format) {
            case "stylish":
                return new StylishFormatter();
            default:
                throw new IllegalArgumentException("Unsupported format: " + format);
        }
    }

}
