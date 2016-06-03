package com.kutsenko.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-06-02T03:16:10.472+0300")
@StaticMetamodel(Investment.class)
public class Investment_ {
	public static volatile SingularAttribute<Investment, Integer> id;
	public static volatile SingularAttribute<Investment, Project> project;
	public static volatile SingularAttribute<Investment, String> cardHolderName;
	public static volatile SingularAttribute<Investment, String> cardNumber;
	public static volatile SingularAttribute<Investment, Integer> amount;
}
