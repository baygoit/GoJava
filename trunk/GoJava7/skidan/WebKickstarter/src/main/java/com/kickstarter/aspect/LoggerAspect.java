package com.kickstarter.aspect;

import java.util.Arrays;
import java.util.Calendar;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggerAspect {

	private static final Logger log = LoggerFactory.getLogger(LoggerAspect.class);

	@Around("cutOfPoints()")
	public Object testAspect(ProceedingJoinPoint joinPoint) {
		Object object = null;
		try {
			log.info("Started method = {} with args ={} in class = {}", joinPoint.getSignature().getName(),
					Arrays.toString(joinPoint.getArgs()), joinPoint.getTarget().getClass().getName());
			long millisStart = Calendar.getInstance().getTimeInMillis();
			object = joinPoint.proceed();
			long millisEnd = Calendar.getInstance().getTimeInMillis();
			long millisFinal = millisEnd - millisStart;
			log.info("Finished method = {} in {} milliseconds ", joinPoint.getSignature().getName(), millisFinal);
		} catch (Throwable e) {
			log.error("Error in {}", joinPoint.getTarget().getClass());
			e.printStackTrace();
		}
		return object;
	}

	@Pointcut("within(@(@org.springframework.stereotype.Component *) *)")
	public void cutOfPoints() {

	}

}
