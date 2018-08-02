package mvc.pattern;

public class LoginBean {
	private String name;
	private String password;
	
	public LoginBean(String name, String password) {
		this.name = name;
		this.password = password;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean validate() {
		if (this.password.equals("admin")) {
			return true;
		} else {
			return false;
		}
	}
}
