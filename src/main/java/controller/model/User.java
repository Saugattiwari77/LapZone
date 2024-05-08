package controller.model;

public class User {
	private int id;
	private String fullname;
	private String phonenumber;
	private String email;
	private String username;
	private String password;
	private String dateofbirth;

	private String gender;

	public User() {
		
	}

	public User( int id, String fullname,String phonenumber, String email, String username, String password, String dateofbirth, String gender) {
		this.id = id;
		this.fullname = fullname;
		this.phonenumber = phonenumber;
		this.email = email;
		this.username = username;
		this.password = password;
		this.dateofbirth = dateofbirth;
		
		this.gender = gender;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	public String getFullName() {
		return fullname;
	}

	public void setFullName(String fullname) {
		this.fullname = fullname;
	}

	public String getPhoneNumber() {
		return phonenumber;
	}

	public void setPhoneNumber(String phonenumber2) {
		this.phonenumber = phonenumber2;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getDateOfBirth() {
		return dateofbirth;
	}

	public void setDateOfBirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	
	
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	
	/*public String toString() {
		return "User [fullname=" + fullname + ", phonenumber=" + phonenumber + ", email=" + email + ", username="
				+ username + ", password=" + password + ", dateofbirth=" + dateofbirth + ", confirmpassword="
				+ confirmpassword + ", gender=" + gender + "]";*/
	}

	
	
	
	
	
	
	
	
	
	
	
	/*@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + "]";
	}*/














