package ua.com.goit.gojava7.kickstarter.aspect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Aspect
public class LoggingAspect {

	@Autowired
	protected BasicDataSource basicDataSource;

	private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

	public void writeQueryToDb(String text) {
		String query = "insert ignore into query (text) VALUES (\"" + text + "\")";
		log.trace("<void> writeQueryToDb({})...", query);
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query)) {
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Pointcut("within( ua.com.goit.gojava7.kickstarter.dao..*)")
	private void forCalculateTime() {
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
}
