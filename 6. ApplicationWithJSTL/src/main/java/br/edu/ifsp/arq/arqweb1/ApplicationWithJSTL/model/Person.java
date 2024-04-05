package br.edu.ifsp.arq.arqweb1.ApplicationWithJSTL.model;

public class Person {
	private String name;
	private String CPF;
	private String email;

	public Person(String name, String CPF, String email) {
		super();
		this.name = name;
		this.CPF = CPF;
		this.email = email;
	}

	public Person() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
