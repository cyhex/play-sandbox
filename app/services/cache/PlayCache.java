package services.cache;


import com.google.inject.Singleton;
import play.cache.Cache;

@Singleton
public class PlayCache implements CacheInterface {

    /**
     * Retrieves an object by key.
     *
     * @return object
     */
    @Override
    public Object get(String key) {
        return Cache.get(key);
    }

    @Override
    public Object get(String key, Object defaultVal) {
        Object o = Cache.get(key);
        if (o == null) {
            return defaultVal;
        } else {
            return o;
        }
    }

    /**
     * Sets a value with expiration.
     *
     * @param expiration expiration in seconds
     */
    @Override
    public void set(String key, Object value, int expiration) {
        Cache.set(key, value, expiration);
    }

    /**
     * Sets a value without expiration.
     */
    @Override
    public void set(String key, Object value) {
        Cache.set(key, value);
    }

    @Override
    public void remove(String key) {
        Cache.remove(key);
    }
}