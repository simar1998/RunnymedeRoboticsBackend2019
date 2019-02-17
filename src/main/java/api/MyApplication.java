package api;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * This Class defines the base URI for all resource URIs.
 */
@ApplicationPath("/")
/**
 * The java class declares root resource and provider classes
 */
public class MyApplication extends Application {
    /**
     * The method returns a non-empty collection with classes, that must be included in the published JAX-RS application
     * @return
     */
    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add(BasicAPI.class);
        return h;
    }
}