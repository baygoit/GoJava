package goit.nz.kickstartermvc.view;

import java.util.Map;

import goit.nz.kickstartermvc.output.Output;

public class PaymentView {
	
	private Output output;
	
	public PaymentView(Output output) {
		this.output = output;
	}
	
	public void showMsg(String msg) {
		output.write("");
		output.write(msg);
	}
	
	public void update(Map<String, String> paymentData, String prompt) {
		output.write("");
		for (Map.Entry<String, String> row : paymentData.entrySet()) {
			output.write(String.format("%s: %s", row.getKey(), row.getValue()));
		}
		showMsg(prompt);
		printOption();
	}
	
	private void printOption() {
		output.write("(0 - back)");
	}

}
