package lib.cache;

import com.google.inject.Inject;
import play.libs.F;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.SimpleResult;

/**
 * Cache another action.
 */
public class CachedAction extends Action<CachedResult> {

    private CacheInterface cache;

    @Inject
    public CachedAction(CacheInterface cache) {
        this.cache = cache;
    }

    public F.Promise<SimpleResult> call(Http.Context ctx) {
        try {
            final String key = configuration.key();
            final Integer duration = configuration.duration();
            SimpleResult result = (SimpleResult) cache.get(key);
            F.Promise<SimpleResult> promise;
            if(result == null) {
                promise = delegate.call(ctx);
                promise.onRedeem(new F.Callback<SimpleResult>() {
                    @Override
                    public void invoke(SimpleResult simpleResult) throws Throwable {
                        cache.set(key, simpleResult, duration);
                    }
                });
            } else {
                promise = F.Promise.pure(result);
            }
            return promise;
        } catch(RuntimeException e) {
            throw e;
        } catch(Throwable t) {
            throw new RuntimeException(t);
        }
    }

}