package org.eclipse.beans;

public class Client {
	protected int id;
	protected String nom;
	protected String prenom;
	protected String email;
	protected String passwd;
	
	public Client() {
	}
	
	public Client(String nom, String prenom, String email, String passwd) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.passwd = passwd;
	}

	public Client(int id, String nom,String prenom, String email, String passwd) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.passwd = passwd;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
}
