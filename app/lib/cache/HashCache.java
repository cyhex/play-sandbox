package lib.cache;

import com.google.inject.Singleton;

import java.util.HashMap;
import java.util.Map;

@Singleton
public class HashCache implements CacheInterface {
    private Map<String, Object> data;

    public HashCache() {
        this.data = new HashMap<String, Object>();
    }

    public Object get(String key) {
        return data.get(key);
    }

    @Override
    public Object get(String key, Object defaultVal) {
        if (!data.containsKey(key)) {
            return defaultVal;
        } else {
            return get(key);
        }
    }

    public void set(String key, Object value, int expiration) {
        data.put(key, value);
    }

    public void set(String key, Object value) {
        data.put(key, value);
    }

    public void remove(String key) {
        data.remove(key);
    }

    public void clear() {
        data.clear();
    }
}
