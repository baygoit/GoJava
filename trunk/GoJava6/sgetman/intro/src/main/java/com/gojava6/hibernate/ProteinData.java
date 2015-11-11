package com.gojava6.hibernate;

public class ProteinData {
	private int id;
	private User user;
	private int total;
	private int goal;
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getGoal() {
		return goal;
	}
	public void setGoal(int goal) {
		this.goal = goal;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

		@Override
		public String toString() {
				return "ProteinData{" +
								"id=" + id +
								", user=" + user +
								", total=" + total +
								", goal=" + goal +
								'}';
		}
}
