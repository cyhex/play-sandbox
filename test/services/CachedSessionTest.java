package services;

import junit.framework.TestCase;
import play.api.mvc.RequestHeader;
import play.mvc.Http;
import lib.cache.HashCache;

import java.util.Collections;
import java.util.Map;


public class CachedSessionTest extends TestCase {

    private Http.Request req;
    private RequestHeader headers;
    private Http.Context ctx1;
    private Http.Context ctx2;
    private Long id = new Long(0);


    public void setUp(){
        Map<String, String> flashData = Collections.emptyMap();
        Map<String, String> sessionData = Collections.emptyMap();
        Map<String, Object> argsData = Collections.emptyMap();

        ctx1 = new Http.Context(id , headers , req, flashData, sessionData, argsData);
        ctx2 = new Http.Context(id , headers , req, flashData, sessionData, argsData);
    }

    public void testSet() throws Exception {
        HashCache c = new HashCache();
        CachedSession s1 = new CachedSession(ctx1, c);
        CachedSession s2 = new CachedSession(ctx2, c);
        s1.set("xxx","xxx");
        s2.set("xxx","yyy");

        assertEquals(s1.get("xxx").toString(), "xxx");
        assertEquals(s2.get("xxx").toString(), "yyy");

    }


}



