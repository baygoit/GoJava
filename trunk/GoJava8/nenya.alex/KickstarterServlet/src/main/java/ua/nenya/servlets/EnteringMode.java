package ua.nenya.servlets;

public interface EnteringMode {
	static final String ENTERING_MODE_ENV_NAME = "ENTERING_MODE";
	String switcher = System.getenv(ENTERING_MODE_ENV_NAME);
}
