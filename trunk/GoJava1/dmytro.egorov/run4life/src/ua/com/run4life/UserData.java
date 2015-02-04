package ua.com.run4life;

public class UserData {
	private String name;
	private String surName;
	private String email;
	private String nickName;
	private int userId;
	private String typeOfUser;
	private int age;
	private String sex;
	private PersonalPlan personalPlan;
	
	public UserData(String name, String surName, String email, 
			String nickName, int userId, String typeOfUser, int age, String sex){
		this.name = name;
		this.surName = surName;
		this.email = email;
		this.nickName = nickName;
		this.userId = userId;
		this.typeOfUser = typeOfUser;
		this.age = age;
		this.sex = sex;
	}
	
	public String getNickName() {
		return nickName;
	}
	
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getTypeOfUser() {
		return typeOfUser;
	}
	
	public void setTypeOfUser(String typeOfUser) {
		this.typeOfUser = typeOfUser;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public PersonalPlan getPersonalPlan() {
		return personalPlan;
	}
	
	public void setPersonalPlan(PersonalPlan personalPlan) {
		this.personalPlan = personalPlan;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurName() {
		return surName;
	}
	
	public void setSurName(String surName) {
		this.surName = surName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	} 

}