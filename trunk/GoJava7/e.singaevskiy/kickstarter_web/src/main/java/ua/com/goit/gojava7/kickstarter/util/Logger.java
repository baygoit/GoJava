package ua.com.goit.gojava7.kickstarter.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@Aspect
public class Logger {
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(Logger.class);

	@Autowired
	private JdbcTemplate jdbcTemplateLogger;

	public void setJdbcTemplateLogger(JdbcTemplate jdbcTemplateLogger) {
		this.jdbcTemplateLogger = jdbcTemplateLogger;
	}

	private void logQueryIntoDB(String query) {
		int count = jdbcTemplateLogger.queryForObject("select count(query) from log_queries where query = ?", new Object[] { query }, Integer.class);
		if (count == 0) {
			jdbcTemplateLogger.update("INSERT into log_queries (query) VALUES (?)", new Object[] { query });
		}
	}

	@Around("execution	(public * org.springframework.jdbc.core.JdbcTemplate.*(..)) " 
			+ "and args(query,..)")
	public Object logJdbcTemplate(ProceedingJoinPoint jointPoint, String query) throws Throwable {
		if (query.contains("log_queries")) {
			return jointPoint.proceed();
		} else {
			String methodName = jointPoint.getSignature().toShortString();
			Object output = null;
			try {
				long start = System.currentTimeMillis();
				output = jointPoint.proceed();
				long elapsedTime = System.currentTimeMillis() - start;
				log.info("Method : {}\n\tQuery : {}\n\tExecution time : {} ms", methodName, query, elapsedTime);
				logQueryIntoDB(query);
			} catch (Exception e) {
				log.error("Method : {}\n\tQuery : {}", methodName, query);
				throw e;
			}
			return output;
		}
	}

	@Around("execution (public * *.*(..)) " 
			+ "and !within(ua.com.goit.gojava7.kickstarter.util..*) "
			+ "and !within(org.springframework.jdbc.core..*) ")
	public Object logSpringBeans(ProceedingJoinPoint jointPoint) throws Throwable {
		String methodName = jointPoint.getSignature().toShortString();
		long start = System.currentTimeMillis();
		Object output = jointPoint.proceed();
		long elapsedTime = System.currentTimeMillis() - start;
		log.info("Method : {}; Execution time : {} ms", methodName, elapsedTime);
		return output;
	}

}
