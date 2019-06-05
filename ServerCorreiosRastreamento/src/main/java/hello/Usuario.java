package hello;

public class Usuario {
	@Override
	public String toString() {
		return "Usuario [email=" + email + ", password=" + password+ "]";
	}
	private String email;
	private String password;

	
	
public Usuario(String nome, String email, String password) {
	this.email = email;
	this.password = password;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}

