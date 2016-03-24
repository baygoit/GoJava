package com.anmertrix;

class DaoSwitch {
	
	private static final String KICKSTARTER_MODE = "KICKSTARTER_MODE";

	private static enum DataSourceTypes {
		
		MEMORY, FILE, SQL;
		
		private static String initMode() {
			String mode = System.getenv(KICKSTARTER_MODE).toUpperCase();
			// TODO Add more info about supported modes
			// TODO Add more checks
			if (mode == null || mode.isEmpty() || !contains(mode)) {
				throw new IllegalStateException("Environment variable " + KICKSTARTER_MODE + " is not found or empty.");
			}
			System.err.println("Mode is " + mode);
			return mode;
		}
		
		public static boolean contains(String mode)
		  {
		      for(DataSourceTypes choice:values())
		           if (choice.name().equals(mode)) 
		              return true;
		      return false;
		  }
	}
	
	public static String getMode() {
		return DataSourceTypes.initMode();
	}
	
}
