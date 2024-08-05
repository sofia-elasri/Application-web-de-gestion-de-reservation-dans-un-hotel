package org.eclipse.beans;

public class Piscine {
	private int piscineId;
	private String piscineType;
	private int capacite;
	private int nbPersonne;
	private int tarifId;
	
	public int getPiscineId() {
		return piscineId;
	}
	public void setPiscineId(int piscineId) {
		this.piscineId = piscineId;
	}
	public String getPiscineType() {
		return piscineType;
	}
	public void setPiscineType(String piscineType) {
		this.piscineType = piscineType;
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
	public Piscine(int piscineId, String piscineType, int capacite, int nbPersonne,int tarifId) {
		super();
		this.piscineId = piscineId;
		this.piscineType = piscineType;
		this.capacite = capacite;
		this.nbPersonne = nbPersonne;
		this.tarifId = tarifId;
	}
	
	public Piscine(String piscineType, int capacite, int nbPersonne, int tarifId) {
		super();
		this.piscineType = piscineType;
		this.capacite = capacite;
		this.nbPersonne = nbPersonne;
		this.tarifId = tarifId;
	}
	
	public Piscine() {
		super();
	}
	public int getTarifId() {
		return tarifId;
	}
	public void setTarifId(int tarifId) {
		this.tarifId = tarifId;
	}
}
