package services.cache;

import junit.framework.TestCase;

/**
 * Created by gx on 23/03/14.
 */
public class HashCacheTest extends TestCase {

    HashCache c ;

    @Override
    protected void setUp() throws Exception {
        c = new HashCache();
    }

    @Override
    protected void tearDown() throws Exception {
        c.clear();
    }

    public void testGet() throws Exception {
        c.set("xxx", "xxx");
        assertEquals(c.get("xxx"), "xxx");
    }

    public void testGetNotFound() throws Exception {
        assertEquals(c.get("ggggg", "xxx"), "xxx");
    }

    public void testRemove() throws Exception {
        c.set("xxx", "xxx");
        c.remove("xxx");
        assertEquals(c.get("xxx", null), null);
    }
}
