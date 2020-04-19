package cmz.study.spring.boot.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;


@Controller
@EnableScheduling
public class GreetingController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws  Exception{
        Thread.sleep(1000);
        return new Greeting("Hello, "+ HtmlUtils.htmlEscape(message.getName()) + "!");
    }

    @Scheduled(fixedRate = 1000)
    public String serverTime () throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpMessagingTemplate.convertAndSend("/topic/sysTime", df.format(System.currentTimeMillis()));
        return "sysTeme";
    }

    @Scheduled(fixedRate = 2000)
    public void serverTime2User() throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpMessagingTemplate.convertAndSendToUser("logan","/sysTime", df.format(System.currentTimeMillis()));
    }





}
