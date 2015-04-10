package ua.com.goit.gojava.POM.dataModel.common;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public interface FinancialDocument {

	long getId();

	String getDocType();

}
