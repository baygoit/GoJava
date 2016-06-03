package com.kutsenko.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-06-02T03:16:10.485+0300")
@StaticMetamodel(Question.class)
public class Question_ {
	public static volatile SingularAttribute<Question, Integer> id;
	public static volatile SingularAttribute<Question, Project> project;
	public static volatile SingularAttribute<Question, String> request;
	public static volatile SingularAttribute<Question, String> reply;
}
