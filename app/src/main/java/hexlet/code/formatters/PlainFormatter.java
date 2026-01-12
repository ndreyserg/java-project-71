package hexlet.code.formatters;

import hexlet.code.CompareResultItem;
import hexlet.code.Formatter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class PlainFormatter implements Formatter {
    public String format(List<CompareResultItem> data) {
        return data.stream()
                .filter(item -> !item.getType().equals(CompareResultItem.UNCHANGED_TYPE))
                .map(PlainFormatter::formatItem)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private static String formatItem(CompareResultItem item) {
        return switch (item.getType()) {
            case CompareResultItem.ADDED_TYPE -> String.format("Property '%s' was added with value: %s", item.getKey(),
                    formatItemValue(item.getValue()));
            case CompareResultItem.REMOVED_TYPE -> String.format("Property '%s' was removed", item.getKey());
            case CompareResultItem.MODIFIED_TYPE -> String.format(
                    "Property '%s' was updated. From %s to %s", item.getKey(),
                    formatItemValue(item.getOldValue()), formatItemValue(item.getValue())
            );
            default -> throw new RuntimeException("Unknown compare result type: " + item.getType());
        };
    }

    private static String formatItemValue(Object item) {
        if (item instanceof String) {
            return "'" + item + "'";
        }
        if (item instanceof Map || item instanceof List) {
            return "[complex value]";
        }
        return String.valueOf(item);
    }
}
