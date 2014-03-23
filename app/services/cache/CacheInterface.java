package services.cache;

/**
 * Created by gx on 23/03/14.
 */
public interface CacheInterface {
    Object get(String key);

    Object get(String key, Object defaultVal);

    void set(String key, Object value, int expiration);

    void set(String key, Object value);

    void remove(String key);
}
