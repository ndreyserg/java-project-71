package hexlet.code.formatters;

import hexlet.code.CompareResultItem;
import hexlet.code.Formatter;

import java.util.List;
import java.util.StringJoiner;

public final class StylishFormatter implements Formatter {

    private static final String ROW_TEMPLATE = "  %s %s: %s";
    @Override
    public String format(List<CompareResultItem> data) {
        var result = new StringJoiner(System.lineSeparator());
        result.add("{");
        for (var item : data) {
            if (item.getType().equals(CompareResultItem.MODIFIED_TYPE)) {
                result.add(String.format(ROW_TEMPLATE, '-', item.getKey(), item.getOldValue()));
                result.add(String.format(ROW_TEMPLATE, '+', item.getKey(), item.getValue()));
            } else {
                result.add(
                    String.format(ROW_TEMPLATE, getOperationLabel(item.getType()), item.getKey(), item.getValue())
                );
            }
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
