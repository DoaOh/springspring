package kr.or.ddit.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;


@Aspect
public class ProfilingAspect {
	private static final Logger logger = LoggerFactory.getLogger(ProfilingAspect.class);
	
	@Pointcut("execution(* kr.or.ddit..service.*.*(..))")
	public void dummy() {}
	
	@Around("dummy()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable  {
		
		//business logic 실행전
		StopWatch stopWatch = new StopWatch();
		
		stopWatch.start();
		
		long startTime =System.currentTimeMillis();
		logger.debug("startTime {} ",startTime);
		
		logger.debug("ProfilingAspect around method before");
		
		//business logic 실행
		logger.debug("method name {} ",joinPoint.getSignature().getName());
		
		
		Object[] methodArgs= joinPoint.getArgs();
		Object returnObj= joinPoint.proceed(methodArgs);
		stopWatch.stop();
		
		long stopTime =System.currentTimeMillis();
		logger.debug("startTime {} ",stopTime);
		
		logger.debug(joinPoint.getSignature().getName()+"{} ",stopWatch.getTotalTimeSeconds()+"ms");
		logger.debug(joinPoint.getSignature().getName()+"{} ",startTime-stopTime +"ms");
		//business 로직 실행후
		
		logger.debug("ProfilingAspect around method after");
		
		return returnObj;
		
	}

}
