package com.kutsenko.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-06-02T03:16:10.346+0300")
@StaticMetamodel(Category.class)
public class Category_ {
	public static volatile SingularAttribute<Category, Integer> id;
	public static volatile SingularAttribute<Category, String> name;
	public static volatile ListAttribute<Category, Project> projects;
}
