package services;

import com.google.inject.Inject;
import play.mvc.Http;
import services.cache.CacheInterface;

import java.util.UUID;

/**
 * manages user bound cache
 * emulates server side sessions
 */
public class CachedSession {

    private static final String UUID_COOKIE = "uuidSession";

    private Http.Context ctx;
    private CacheInterface cache;

    @Inject
    public CachedSession(Http.Context ctx, CacheInterface cache) {
        this.ctx = ctx;
        this.cache = cache;
    }

    /**
     * Set user bound cache
     *
     * @param key
     * @param object
     * @param ttl
     */
    public void set(String key, Object object, int ttl) {
        cache.set(buildKey(key), object, ttl);
    }

    public void set(String key, Object object) {
        cache.set(buildKey(key), object);
    }


    /**
     * Get user bound cache, return defaultVal if key not found
     *
     * @param key
     * @param defaultVal
     * @return Object
     */
    public Object get(String key, Object defaultVal) {

        Object o = cache.get(buildKey(key));
        if (o == null) {
            return defaultVal;
        } else {
            return o;
        }
    }

    public Object get(String key) {
        return cache.get(buildKey(key));
    }


    private String buildKey(String key) {
        Http.Session session = ctx.session();

        String uuid = session.get(UUID_COOKIE);
        if (uuid == null) {
            uuid = UUID.randomUUID().toString();
            session.put(UUID_COOKIE, uuid);
        }
        return uuid + key;
    }

}
