import cmz.study.spring.boot.TestController;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

public class Test {
    public static void main(String[] srgs) {
        String path = System.getProperty("user.dir");
        System.out.println(path);
         ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"service.xml"});
        TestController cmz = context.getBean("cmz", TestController.class);

        System.out.println(cmz.test());
    }
}
