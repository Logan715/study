package cmz.study.spring.boot.gson;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/gson")
public class GsonController {

    @Autowired
    private Gson gson;

    @RequestMapping("/test")
    public String test() {
//        Gson gson = new Gson();
        Map map = new HashMap<String, String>();
        map.put("a", "a");

        return gson.toJson(map);
    }
}
