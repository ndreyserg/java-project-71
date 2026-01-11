package hexlet.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class CompareResultItem {
    private String key;
    private Object value;
    private String type;

    public static CompareResultItem createRemovedItem(String key, Object value) {
        return new CompareResultItem(key, value, "-");
    }

    public static CompareResultItem createAddedItem(String key, Object value) {
        return new CompareResultItem(key, value, "+");
    }

    public static CompareResultItem createUnchangedItem(String key, Object value) {
        return new CompareResultItem(key, value, " ");
    }

    @Override
    public String toString() {
        return this.type + " " + this.key + ": " + this.value;
    }
}
