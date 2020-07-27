package cmz.study.spring.boot;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@Data
public class TestController {
    @Value("${cmz.test}")
    public String port;

    @RequestMapping("/test")
    public String test() {
        return port;
    }

}
