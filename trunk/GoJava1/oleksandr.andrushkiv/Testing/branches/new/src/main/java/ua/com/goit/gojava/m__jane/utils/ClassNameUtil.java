package ua.com.goit.gojava.m__jane.utils;

public final class ClassNameUtil {

	public ClassNameUtil() {
	}

	public static String getCurrentClassName() {
		try {
			throw new RuntimeException();
		} catch (RuntimeException e) {
			return e.getStackTrace()[1].getClassName();
		}
	}
}
