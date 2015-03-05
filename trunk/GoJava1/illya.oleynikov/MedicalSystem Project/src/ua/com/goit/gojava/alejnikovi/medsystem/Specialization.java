package ua.com.goit.gojava.alejnikovi.medsystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Specialization implements Persistable{
	
	private static Set<Specialization> specializations = new LinkedHashSet<Specialization>();
	private static final String FILENAME = "specializations.csv";
	private static AtomicInteger nextId = new AtomicInteger();
	
	private String name;
	private int id;
	
	public Specialization() {

	}
		
	public Specialization (String name){
		this.id = nextId.incrementAndGet();
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	List<Doctor> getDoctors (){
		List<Doctor> doctorsWithSpec = new ArrayList<Doctor>();
		for(Doctor doctor: MedicalSystem.getDoctors()){
			if(doctor.getSpecialization().equals(this)){
				doctorsWithSpec.add(doctor);
			}
		}
		return doctorsWithSpec;
	}
	
	private void writeToFile() throws IOException{
		PlainFileDAO.writeToFile(FILENAME, this.markupForFile());
	}
	
	public static void createNewSpecialisation(String name) throws IOException{
		Specialization newSpec = new Specialization(name);
		specializations.add(newSpec);
		newSpec.writeToFile();
	}
	
	static void readSpecializationsFromFile() throws IOException, MedicalSystemException {
		List<String> list = PlainFileDAO.readFromFile(FILENAME);
		for(String specialisation:list){
			specializations.add(new Specialization(specialisation));
		}
	}
	
	public static Set<Specialization> getSpecializations() throws IOException, MedicalSystemException {
		specializations.clear();
		readSpecializationsFromFile();
		return specializations;
	}
	
	public static void deleteSpecialisation(String name) throws IOException{
		
	}
	
	@Override
	public String markupForFile() {
		String fileString = new String();
		fileString = this.id + ", " + this.getName();
		return fileString;
	}
	
	@Override
	public Specialization createObjFromFile(String string) {
		
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Specialization other = (Specialization) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
