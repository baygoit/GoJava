package belskii.artem.kickstarter.dao.project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProjectDaoImplFile implements ProjectDao {

	private static final String FILE_PATH = "src/main/resources/project.txt";

	@Override
	public void addProject(Project projectDetails) {
		HashMap<Long, ArrayList<String>> faq = projectDetails.getFaq();
		HashMap<Long, HashMap<Long, String>> paymentVariants = projectDetails.getPaymetVariants();
		String name = projectDetails.getName();
		Long goal = projectDetails.getGoal();
		Long balance = projectDetails.getBalance();
		String startDate = projectDetails.getStartDate();
		String endDate = projectDetails.getEndDate();
		String videoUrl = projectDetails.getVideoUrl();
		int categoryId = projectDetails.getcategoryId();
		String details = projectDetails.getDetails();
		
		StringBuilder paymentVariantsStr = new StringBuilder();
		for (long i=0; i<paymentVariants.size();i++){
			if (i>0L){
				paymentVariantsStr.append(":");
			}
			Object[] value = paymentVariants.get(i).keySet().toArray();
			paymentVariantsStr.append(value[0].toString());
			paymentVariantsStr.append(":");
			Object[] bonus = paymentVariants.get(i).values().toArray();
			paymentVariantsStr.append(bonus[0].toString());
		}
		
		StringBuilder faqStr = new StringBuilder();
		for (long i=0; i<faq.size();i++){
			if (i>0L){
				faqStr.append(":");
			}
			faqStr.append(faq.get(i).get(0));
			faqStr.append(":");
			faqStr.append(faq.get(i).get(1));
		}

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
			writer.write(faqStr.toString());
			writer.append(";");
			writer.write(paymentVariantsStr.toString());
			writer.append(";");
			writer.write(name);
			writer.append(";");
			writer.append(String.valueOf(goal));
			writer.append(";");
			writer.append(String.valueOf(balance));
			writer.append(";");
			writer.append(startDate);
			writer.append(";");
			writer.append(endDate);
			writer.append(";");
			writer.append(videoUrl);
			writer.append(";");
			writer.append(String.valueOf(categoryId));
			writer.append(";");
			writer.append(details);
			writer.append(";");
			writer.append(String.valueOf(this.getNewProjectId()));
			writer.append("\n");

			writer.close();
		} catch (IOException ex) {

			System.out.println(ex.getMessage());
		}
	}
	private Long getNewProjectId() {
		return (long) this.getProjectList().size();
	}

	@Override
	public Map<Long, Project> getProjectList() {
		HashMap<Long, Project> projectList = new HashMap<Long, Project>();
		Long projectIndex = 0L;
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
			for (String line; (line = reader.readLine()) != null;) {
				String splittedString[] = line.split(";");
				String faqStr = splittedString[0];
				String paymentVariantsStr = splittedString[1];
				String name = splittedString[2];
				Long goal = new Long(splittedString[3]);
				Long balance = new Long(splittedString[4]);
				String startDate = splittedString[5];
				String endDate = splittedString[6];
				String videoUrl = splittedString[7];
				int categoryId = new Integer(splittedString[8]);
				String details = splittedString[9];
				Long projectId = new Long(splittedString[10]);

				HashMap<Long, ArrayList<String>> faq = new HashMap<Long, ArrayList<String>>();
				String splittedFaq[] = faqStr.split(":");
				for (int i = 0, index = 0; i < splittedFaq.length; i += 2, index++) {
					ArrayList<String> questionAnswer = new ArrayList<String>();
					questionAnswer.add(splittedFaq[i]);
					questionAnswer.add(splittedFaq[i + 1]);
					faq.put(new Long(index), questionAnswer);
				}

				HashMap<Long, HashMap<Long, String>> paymentVariants = new HashMap<Long, HashMap<Long, String>>();
				String splittedPaymentVariants[] = paymentVariantsStr.split(":");
				for (int i = 0, index = 0; i < splittedPaymentVariants.length; i += 2, index++) {
					HashMap<Long, String> variant = new HashMap<Long, String>();
					variant.put(new Long(splittedPaymentVariants[i]), splittedPaymentVariants[i + 1]);
					paymentVariants.put(new Long(index), variant);
				}
				Project project = new Project(name, goal, balance, startDate, endDate, videoUrl, categoryId,
						details, faq, paymentVariants);
				project.setProjectId(projectId);
				projectList.put(projectIndex, project);
				projectIndex++;
			}
		} catch (IOException ex) {

			System.out.println(ex.getMessage());
		}
		return projectList;

	}

	@Override
	public Project getProjectDetails(int id) {
		return this.getProjectList().get(new Long(id));
	}

	@Override
	public Map<Long, Project> getProjectFromCategory(int id) {
		HashMap<Long, Project> answer = new HashMap<Long, Project>();
		Map<Long, Project> projectList = this.getProjectList();
		for ( long i=0; i<projectList.size();i++){
			if (projectList.get(i).getcategoryId() == id){
				Long index=new Long(answer.size());
				answer.put(index, projectList.get(i));
			}
		}
		return answer;
		}

	
	@Override
	public void update(Project updetedProject) {
		 Map<Long, Project> projectList=this.getProjectList();
		 projectList.put(updetedProject.getProjectId(), updetedProject);

		// clean file		 
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, false))) {
			writer.write("");
			writer.close();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		
		//write new data
		for (int i=0; i<projectList.size();i++){
			this.addProject(projectList.get(new Long(i)));
		}
		
	}
	@Override
	public void initDemoDB() {
		// TODO Auto-generated method stub
		
	}

}
