package cmz.study.spring.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * Created on 2019/04/11.
 *
 * @author Sury
 */
public class AmsServerId {

    private static class SingletonHolder {
        private static AmsServerId instance = new AmsServerId();
    }

    public static AmsServerId getInstance() {
        return SingletonHolder.instance;
    }

    private AmsServerId() {
    }

    /**
     * 获取clientId
     *
     * @return
     */
    public String getClientId() {

        return 1+"";
    }
}
