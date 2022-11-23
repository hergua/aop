package xin.opstime.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;

/**
 * Created on 2022/11/22
 *
 * @author hergua
 */
@Component
@Aspect
@Slf4j
public class TaskAspect {

    @Pointcut("execution(* xin.opstime.aop.scheduled.EventTask.hello(..))")
    public void interceptor(){}

    @Around("interceptor()")
    public Object handler(ProceedingJoinPoint point) throws Throwable {
        log.info("----进入切面---");
        log.info(Arrays.toString(point.getArgs()));
        return point.proceed();
    }

}
