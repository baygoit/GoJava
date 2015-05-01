package kickstarter;

public class Citation {
	String[] citation;

	Citation(Repository repository) {
		this.citation = repository.citation;
	}
}
