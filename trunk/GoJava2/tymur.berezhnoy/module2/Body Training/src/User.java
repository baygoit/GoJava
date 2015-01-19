public class User implements Registration {

	private String loginName;
	private String password;
	
	private void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	public String getNickName() {
		return loginName;
	}

	private void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	@Override
	public void createAccount(String loginName, String password) {
		setLoginName(loginName);
		setPassword(password);
	}
}