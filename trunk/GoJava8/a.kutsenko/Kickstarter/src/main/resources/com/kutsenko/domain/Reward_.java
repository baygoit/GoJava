package com.kutsenko.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-06-02T03:16:10.499+0300")
@StaticMetamodel(Reward.class)
public class Reward_ {
	public static volatile SingularAttribute<Reward, Integer> id;
	public static volatile SingularAttribute<Reward, Project> project;
	public static volatile SingularAttribute<Reward, Integer> amount;
	public static volatile SingularAttribute<Reward, String> description;
}
