package ua.com.goit.gojava.andriidnikitin;

public enum SolubleProblem {
	LINEAR_PROGRAM {
		public String toString(){
			return "Linear Program";
		}
	},
	TRANSPORTATION_PROBLEM {
		public String toString(){
			return "Transportation Problem";
		}
	};
	
	public String descriptionString(){
		return "This method is called" + this.toString();
	}
		
	public String resultString(){
		return "This is result of solving" + toString();
	}	
}