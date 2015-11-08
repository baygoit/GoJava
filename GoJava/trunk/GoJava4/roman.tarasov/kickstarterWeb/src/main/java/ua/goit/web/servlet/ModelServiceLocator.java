package ua.goit.web.servlet;

import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Service;
import ua.goit.web.model.ModelService;


@Service
public class ModelServiceLocator {
	private Map<String, ModelService> services ;

	public void setServices(Map<String, ModelService> services) {
		this.services = services;
	}

	public  ModelService getService(String key) {
		return services.get(key);
	}

	public void loadService(String key, ModelService service) {
		services.put(key, service);
	}

	public  Set<String> getKeys() {
		return services.keySet();
	}
}
