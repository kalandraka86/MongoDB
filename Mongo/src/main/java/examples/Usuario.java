package examples;

import java.io.Serializable;

public class Usuario implements Serializable {

	private String name, passwd;

	public Usuario(String name, String passwd) {
		super();
		this.name = name;
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@Override
	public String toString() {
		return "Usuario [name=" + name + ", passwd=" + passwd + "]";
	}

}
