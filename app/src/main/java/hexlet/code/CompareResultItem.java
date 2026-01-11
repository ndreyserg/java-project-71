package hexlet.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class CompareResultItem {

    public static final String REMOVED_TYPE = "-";
    public static final String ADDED_TYPE = "+";
    public static final String UNCHANGED_TYPE = " ";

    private String key;
    private Object value;
    private String type;

    public static CompareResultItem createRemovedItem(String key, Object value) {
        return new CompareResultItem(key, value, REMOVED_TYPE);
    }

    public static CompareResultItem createAddedItem(String key, Object value) {
        return new CompareResultItem(key, value, ADDED_TYPE);
    }

    public static CompareResultItem createUnchangedItem(String key, Object value) {
        return new CompareResultItem(key, value, UNCHANGED_TYPE);
    }
}
