package cmz.study.spring.boot.event;

import cmz.study.spring.boot.utils.SpringBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@RestController
@RequestMapping("/event")
public class EventController {
    @Autowired
    private EventService eventService;
    @RequestMapping("/test")
    public String test() {
        eventService.publishEvent();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "event.test: "+ df.format(System.currentTimeMillis());
    }
}
