package idusw.springboot.lsmMall.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
class LogAspect { // @AspectJ 지원 AOP
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("execution(*  idusw.springboot.lsmMall.service.*ServiceImpl(..))")
    public void getLogging() {}

    @Before("getLogging()")
    public void loggerBefore(JoinPoint joinPoint) {
        String message = "횡단관심, 공통코드 : 보안 트랜잭션, 로깅...";
        logger.info(message);
    }
    @AfterReturning("execution(*  idusw.springboot.lsmMall.service.*ServiceImpl(..))")
    public void loggerAfterReturning(JoinPoint joinPoint) {
        String message = "트랜잭션처리";
        logger.info(message);
    }}
