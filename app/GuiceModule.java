import com.google.inject.AbstractModule;
import com.google.inject.Provider;
import play.mvc.Http;
import services.cache.CacheInterface;
import services.cache.PlayCache;

public class GuiceModule extends AbstractModule {

    @Override
    protected void configure() {

    bind(CacheInterface.class).to(PlayCache.class);

    // Bind Play Http.Context
    bind(Http.Context.class).toProvider(new Provider<Http.Context>() {
        @Override
        public Http.Context get() {
            return Http.Context.current();
        }
    });

    }
}

