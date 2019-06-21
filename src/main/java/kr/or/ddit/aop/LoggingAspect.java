package kr.or.ddit.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingAspect {
	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	public void before(JoinPoint joinPoint) {
		logger.debug("LoggingAspect before mathod");
		
	}

	
	public void after(JoinPoint joinPoint) {
		logger.debug("LoggingAspect after mathod");
	
		
	}
	
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable  {
		
		//business logic 실행전
		
		logger.debug("LoggingAspect around method befor");
		//business logic 실행
		logger.debug("method name {} ", joinPoint.getSignature().getName());
		
		Object[] methodArgs= joinPoint.getArgs();
		Object returnObj= joinPoint.proceed(methodArgs);
		
		//business 로직 실행후
		logger.debug("LoggingAspect around method after");
		
		return returnObj;
		
	}
}
