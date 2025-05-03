import java.util.HashMap;
import java.util.Map;

public class Cache {
    private Map<String, Object> cacheMap = new HashMap<>();

    public Object getFromCache(String key) {
        return cacheMap.get(key);
    }

    public void putInCache(String key, Object value) {
        cacheMap.put(key, value);
    }

    public boolean containsKey(String key) {
        return cacheMap.containsKey(key);
    }
}
