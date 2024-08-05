package org.eclipse.beans;

public class Terasse {
	private int terasseId;
	private String terasseType;
	private int capacite;
	private int nbPersonne;
	private int tarifId;
	
	public int getTerasseId() {
		return terasseId;
	}
	public void setTerasseId(int terasseId) {
		this.terasseId = terasseId;
	}
	public String getTerasseType() {
		return terasseType;
	}
	public void setTerasseType(String terasseType) {
		this.terasseType = terasseType;
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
	public Terasse(int terasseId, String terasseType, int capacite, int nbPersonne, int tarifId) {
		super();
		this.terasseId = terasseId;
		this.terasseType = terasseType;
		this.capacite = capacite;
		this.nbPersonne = nbPersonne;
		this.tarifId = tarifId;
	}
	
	public Terasse(String terasseType, int capacite, int nbPersonne, int tarifId) {
		super();
		this.terasseType = terasseType;
		this.capacite = capacite;
		this.nbPersonne = nbPersonne;
		this.tarifId = tarifId;
	}
	
	public Terasse() {
		super();
	}
	public int getTarifId() {
		return tarifId;
	}
	public void setTarifId(int tarifId) {
		this.tarifId = tarifId;
	}
}
