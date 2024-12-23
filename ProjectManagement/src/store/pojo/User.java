package store.pojo;

public class User {
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSuperCoins() {
		return superCoins;
	}
	public void setSuperCoins(String superCoins) {
		this.superCoins = superCoins;
	}
	private String emailId;
	private String password;
	private String superCoins;

}
