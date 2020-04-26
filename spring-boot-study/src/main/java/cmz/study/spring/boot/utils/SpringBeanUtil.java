package cmz.study.spring.boot.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/2/28.
 */
@Component
public class SpringBeanUtil implements ApplicationContextAware {
    private final static Logger LOG = LoggerFactory.getLogger(SpringBeanUtil.class);

    private static ApplicationContext ctx = null;


    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        SpringBeanUtil.ctx = ctx;
    }

    public static ApplicationContext getApplicationContext() {
        return ctx;
    }

    public static <T> T getBean(String bean) {
        return (T) ctx.getBean(bean);
    }

    public static <T> T getBean(Class classType) {
        return (T) ctx.getBean(classType);
    }
}
