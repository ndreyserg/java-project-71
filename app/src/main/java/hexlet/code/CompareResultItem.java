package hexlet.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class CompareResultItem {

    public static final String REMOVED_TYPE = "removed";
    public static final String ADDED_TYPE = "added";
    public static final String UNCHANGED_TYPE = "unchanged";
    public static final String MODIFIED_TYPE = "modified";

    private String type;
    private String key;
    private Object value;
    private Object oldValue;

    public static CompareResultItem createRemovedItem(String key, Object value) {
        return new CompareResultItem(REMOVED_TYPE, key, value, null);
    }

    public static CompareResultItem createAddedItem(String key, Object value) {
        return new CompareResultItem(ADDED_TYPE, key, value, null);
    }

    public static CompareResultItem createUnchangedItem(String key, Object value) {
        return new CompareResultItem(UNCHANGED_TYPE, key, value, null);
    }

    public static CompareResultItem createModifiedItem(String key, Object value, Object oldValue) {
        return new CompareResultItem(MODIFIED_TYPE, key, value, oldValue);
    }
}
