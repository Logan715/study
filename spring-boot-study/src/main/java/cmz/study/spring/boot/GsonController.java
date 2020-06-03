package cmz.study.spring.boot;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/gson")
public class GsonController {

    @RequestMapping("/test")
    public Map test() {
        Gson gson = new Gson();
        Map map = new HashMap<String, String>();
        map.put("a", "a");
        return map;
    }
}
