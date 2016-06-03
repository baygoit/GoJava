package com.kutsenko.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-06-02T03:16:10.493+0300")
@StaticMetamodel(Quote.class)
public class Quote_ {
	public static volatile SingularAttribute<Quote, Integer> id;
	public static volatile SingularAttribute<Quote, String> text;
	public static volatile SingularAttribute<Quote, String> author;
}
