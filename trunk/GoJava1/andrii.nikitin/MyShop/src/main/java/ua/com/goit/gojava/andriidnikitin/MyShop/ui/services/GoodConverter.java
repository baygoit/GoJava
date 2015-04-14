package ua.com.goit.gojava.andriidnikitin.MyShop.ui.services;

import javax.faces.bean.RequestScoped;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.Good;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.service.BusinessServiceHandler;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.util.MyShopException;

@Component
@RequestScoped
@FacesConverter("goodConverter")
public class GoodConverter extends AbstractConverter<Good> {
	
	@Autowired 	
	private BusinessServiceHandler businessService;

	@Override
	protected Integer getId(Good object) {
		return object.getId();
	}

	@Override
	protected Good getById(Integer id) {
		try {
			return businessService.getGoodById(id);
		} catch (MyShopException e) {
			getLog().error(e);
			return null;
		}
	}

	@Override
	protected String getConverterClass() {
		return getClass().toString();
	}
	
}
