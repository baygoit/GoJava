package ua.com.goit.gojava7.kickstarter.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Before("execution	(public * org.springframework.jdbc.core.JdbcTemplate.*(..)) and args(query,..)")
	public void logUniqueQueriesToDb(JoinPoint jp, String query) throws Throwable {
		if (!query.contains("insert ignore into query")) {
			if(writeQueryToDb(query) == 1) {
				log.trace("-----logUniqueQueriesToDb() created new record in DB: {}-----", query.toLowerCase());
			}
		}
	}		

	@Around("forCalculateTime()")
	public Object calculateTime(ProceedingJoinPoint pjp) throws Throwable {
		String methodName = pjp.getSignature().getName();
		String className = pjp.getSignature().getDeclaringType().getSimpleName();
		long start = System.currentTimeMillis();
		log.trace("-----{}.{}() is going to be called-----", className, methodName);

		Object output = pjp.proceed();
		log.trace("-----{}.{}() execution completed-----", className, methodName);

		long elapsedTime = System.currentTimeMillis() - start;
		log.trace("{}.{}() execution time: {} milliseconds", className, methodName, elapsedTime);
		return output;
	}
	
	@Pointcut("@within(org.springframework.stereotype.Repository)")
	private void forCalculateTime() {
	}
	
	private int writeQueryToDb(String text) {
		String query = "insert ignore into query (text) VALUES (?)";	
		return jdbcTemplate.update(query, new Object[] { text });
	}
}
