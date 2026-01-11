package hexlet.code.Formatter;

import hexlet.code.CompareResultItem;

import java.util.List;
import java.util.StringJoiner;

public final class StylishFormatter implements Formatter {
    @Override
    public String format(List<CompareResultItem> data) {
        var result = new StringJoiner(System.lineSeparator());
        result.add("{");
        for (var item : data) {
            var operation = getOperationLabel(item.getType());
            result.add(String.format("  %s %s: %s", operation, item.getKey(), item.getValue()));
        }
        result.add("}");
        return result.toString();
    }

    private String getOperationLabel(String operation) {
        return switch (operation) {
            case CompareResultItem.ADDED_TYPE -> "+";
            case CompareResultItem.REMOVED_TYPE -> "-";
            case CompareResultItem.UNCHANGED_TYPE -> " ";
            default -> "";
        };
    }
}
