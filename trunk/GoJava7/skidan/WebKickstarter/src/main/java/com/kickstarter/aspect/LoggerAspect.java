package com.kickstarter.aspect;

import java.util.Arrays;
import java.util.Calendar;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;

@Aspect
public class LoggerAspect {

//	@Autowired
//	private JdbcTemplate jdbcTemplate;

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

	@Before("execution(* org.springframework.jdbc.core.JdbcTemplate.*(..))")
	public void dbQueryAdd(JoinPoint joinPoint) throws Throwable {
		Object[] objArr = joinPoint.getArgs();
		String sql = (String)objArr[0];
		System.out.println("I am an sql...........................:    " + sql);
//		int queriesOfType = jdbcTemplate.queryForObject("select count(query) from queries",
//			 Integer.class);
//		System.out.println("I am the count..............: " + queriesOfType);
//		return joinPoint.proceed();
//		if (queriesOfType == 0) {
//			jdbcTemplate.update("INSERT INTO queries (query) VALUES (?)", new Object[] { sql });
//			return joinPoint.proceed();
//		} else {
//			return joinPoint.proceed();
//		}
		
	}

	@Pointcut("within(@(@org.springframework.stereotype.Component *) *)")
	public void cutOfPoints() {

	}

//	@Pointcut("execution(* org.springframework.jdbc.core.JdbcTemplate.*(..))")
//	public void getCutOfPoints() {
//
//	}

}
