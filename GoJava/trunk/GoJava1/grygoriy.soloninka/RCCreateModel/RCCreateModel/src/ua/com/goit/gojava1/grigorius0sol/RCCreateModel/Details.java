package ua.com.goit.gojava1.grigorius0sol.RCCreateModel;

import java.util.ArrayList;
import java.util.List;

public class Details {
	
	List<String> kit = new ArrayList<String>();
	List<String> wheels = new ArrayList<String>();
	List<String> remote = new ArrayList<String>();
	List<String> engine = new ArrayList<String>();
	List<String> servo = new ArrayList<String>();
	List<String> detailsList = new ArrayList<String>();
	List<String> defaultSet = new ArrayList<String>();
	
	Details(){
		
		for (int i = 1; i <= 10; i++){
			
			kit.add("Kit HPI - " + i);
			wheels.add("Wheels HPI - " + i);
			remote.add("Remote HPI - " + i);
			engine.add("Engine HPI - " + i);
			servo.add("Servo HPI - " + i);
			defaultSet.add("HPI default - " + i);
		}
		
		detailsList.add("Kit");
		detailsList.add("Wheels");
		detailsList.add("Remote");
		detailsList.add("Engine");
		detailsList.add("Servo");
		
	}

	public List<String> getDetailsList() {
		return detailsList;
	}

	public void setDetailsList(List<String> detailsList) {
		this.detailsList = detailsList;
	}

	public List<String> getKit() {
		return kit;
	}

	public void setKit(List<String> kit) {
		this.kit = kit;
	}

	public List<String> getWheels() {
		return wheels;
	}

	public void setWheels(List<String> wheels) {
		this.wheels = wheels;
	}

	public List<String> getRemote() {
		return remote;
	}

	public void setRemote(List<String> remote) {
		this.remote = remote;
	}

	public List<String> getEngine() {
		return engine;
	}

	public void setEngine(List<String> engine) {
		this.engine = engine;
	}

	public List<String> getServo() {
		return servo;
	}

	public List<String> getDefaultSet() {
		return defaultSet;
	}

	public void setDefaultSet(List<String> defaultSet) {
		this.defaultSet = defaultSet;
	}

	public void setServo(List<String> servo) {
		this.servo = servo;
	}
}

