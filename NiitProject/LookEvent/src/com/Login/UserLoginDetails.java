package com.Login;

public class UserLoginDetails {
	private String FirstName;
	private String LastName;
	private String Email;
	private String Password;
	private String Confirm_Password;

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		this.FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		this.LastName = lastName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		this.Password = password;
	}

	public String getConfirm_Password() {
		return Confirm_Password;
	}

	public void setConfirm_Password(String confirm_Password) {
		this.Confirm_Password = confirm_Password;
	}

	public UserLoginDetails(String firstName, String lastName, String email, String password, String confirm_Password) {
		super();
		FirstName = firstName;
		LastName = lastName;
		Email = email;
		Password = password;
		Confirm_Password = confirm_Password;
	}

	public UserLoginDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

}
