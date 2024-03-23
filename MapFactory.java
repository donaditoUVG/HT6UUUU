import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapFactory {
    public static <K, V> Map<K, V> createMap(MapType mapType) {
        switch (mapType) {
            case HASHMAP:
                return new HashMap<>();
            case TREEMAP:
                return new TreeMap<>();
            case LINKEDHASHMAP:
                return new LinkedHashMap<>();
            default:
                throw new IllegalArgumentException("Tipo de mapa no válido");
        }
    }
}

enum MapType {
    HASHMAP,
    TREEMAP,
    LINKEDHASHMAP
}
