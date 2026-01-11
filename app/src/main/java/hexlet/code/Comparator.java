package hexlet.code;

import java.util.Objects;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.ArrayList;


public final class Comparator {

    public static List<CompareResultItem> compare(Map<String, Object> map1, Map<String, Object> map2) {
        var keys = new TreeSet<>(map1.keySet());
        keys.addAll(map2.keySet());

        var result = new ArrayList<CompareResultItem>();

        for (String key : keys) {
            if (map1.containsKey(key) && !map2.containsKey(key)) {
                result.add(CompareResultItem.createRemovedItem(key, map1.get(key)));
                continue;
            }

            if (map2.containsKey(key) && !map1.containsKey(key)) {
                result.add(CompareResultItem.createAddedItem(key, map2.get(key)));
                continue;
            }

            if (Objects.equals(map1.get(key), map2.get(key))) {
                result.add(CompareResultItem.createUnchangedItem(key, map1.get(key)));
                continue;
            }
            result.add(CompareResultItem.createModifiedItem(key, map2.get(key), map1.get(key)));
        }
        return result;
    }
}
