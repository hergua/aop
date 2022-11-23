package xin.opstime.aop.scheduled;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * Created on 2022/11/22
 *
 * @author hergua
 */
@Component
@Slf4j
public class EventTask {

    @Scheduled(cron = "*/5 * * * * ? ")
    public void task(){
        ((EventTask)AopContext.currentProxy()).hello(Collections.singletonList("2"));
    }


    public void hello(List<String> l){
        log.info("hello");
        l.forEach(log::info);
    }

}
