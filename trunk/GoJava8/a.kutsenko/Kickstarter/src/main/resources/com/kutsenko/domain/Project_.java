package com.kutsenko.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-06-02T03:16:10.479+0300")
@StaticMetamodel(Project.class)
public class Project_ {
	public static volatile SingularAttribute<Project, Integer> id;
	public static volatile SingularAttribute<Project, Category> category;
	public static volatile SingularAttribute<Project, String> name;
	public static volatile SingularAttribute<Project, String> description;
	public static volatile SingularAttribute<Project, Integer> requiredSum;
	public static volatile SingularAttribute<Project, Integer> gatheredBudget;
	public static volatile SingularAttribute<Project, Integer> remainingDays;
	public static volatile SingularAttribute<Project, String> history;
	public static volatile SingularAttribute<Project, String> videoUrl;
	public static volatile SetAttribute<Project, Investment> investments;
	public static volatile ListAttribute<Project, Question> questions;
	public static volatile ListAttribute<Project, Reward> rewards;
}
