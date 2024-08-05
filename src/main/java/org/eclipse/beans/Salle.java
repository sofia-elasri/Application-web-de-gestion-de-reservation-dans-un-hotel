package org.eclipse.beans;

public class Salle {
	private int salleId;
	private String salleType;
	private int capacite;
	private int nbPersonne;
	private int tarifId;
	
	public int getSalleId() {
		return salleId;
	}
	public void setSalleId(int salleId) {
		this.salleId = salleId;
	}
	public String getSalleType() {
		return salleType;
	}
	public void setSalleType(String salleType) {
		this.salleType = salleType;
	}
	public int getCapacite() {
		return capacite;
	}
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	public int getNbPersonne() {
		return nbPersonne;
	}
	public void setNbPersonne(int nbPersonne) {
		this.nbPersonne = nbPersonne;
	}
	public Salle(int salleId, String salleType, int capacite, int nbPersonne,int tarifId) {
		super();
		this.salleId = salleId;
		this.salleType = salleType;
		this.capacite = capacite;
		this.nbPersonne = nbPersonne;
		this.tarifId = tarifId;
	}
	
	public Salle(String salleType, int capacite, int nbPersonne, int tarifId) {
		super();
		this.salleType = salleType;
		this.capacite = capacite;
		this.nbPersonne = nbPersonne;
		this.tarifId = tarifId;
	}
	
	public Salle() {
		super();
	}
	public int getTarifId() {
		return tarifId;
	}
	public void setTarifId(int tarifId) {
		this.tarifId = tarifId;
	}
}
