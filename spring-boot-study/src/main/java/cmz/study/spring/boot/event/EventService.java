package cmz.study.spring.boot.event;

import cmz.study.spring.boot.utils.SpringBeanUtil;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    @Async
    public void publishEvent() {
        SpringBeanUtil.getApplicationContext().publishEvent(new TestEvent("e"));
    }
}
