package goit.nz.kickstartermvc.view;

import goit.nz.kickstartermvc.output.Output;

public class FAQView {

	private Output output;

	public FAQView(Output output) {
		this.output = output;
	}

	public void showMsg(String msg) {
		output.write("");
		output.write(msg);
	}

	public void update() {
		showMsg("Enter your question:");
		printOption();
	}

	private void printOption() {
		output.write("(0 - back)");
	}
}
