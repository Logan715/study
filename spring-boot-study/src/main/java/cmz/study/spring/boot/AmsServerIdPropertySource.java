package cmz.study.spring.boot;

import org.springframework.core.env.PropertySource;

/**
 * Created on 2018/4/11.
 *
 * @author Sury
 */
public class AmsServerIdPropertySource extends PropertySource<AmsServerId> {
    /**
     * Name of the random {@link PropertySource}.
     */
    public static final String DEFAULT_AMS_SERVER_ID = "amsServerId";

    private static final String PREFIX = "amsServerId.";

    public AmsServerIdPropertySource(String name) {
        super(name, AmsServerId.getInstance());
    }

    public AmsServerIdPropertySource() {
        this(DEFAULT_AMS_SERVER_ID);
    }

    @Override
    public Object getProperty(String name) {
        System.out.println("name:" +name);
        if (!name.startsWith(PREFIX)) {
            return null;
        }
        // ams.server.host.registry
        return getSource().getClientId();
    }
}
