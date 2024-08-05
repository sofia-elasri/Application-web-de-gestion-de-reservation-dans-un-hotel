package org.eclipse.beans;

public class Chambre {
	private int chambreId;
	private String chambreType;
	private int capacite;
	private int nbPersonne;
	private int tarifId;
	
	public int getChambreId() {
		return chambreId;
	}
	public void setChambreId(int chambreId) {
		this.chambreId = chambreId;
	}
	public String getChambreType() {
		return chambreType;
	}
	public void setChambreType(String chambreType) {
		this.chambreType = chambreType;
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
	public Chambre(int chambreId, String chambreType, int capacite, int nbPersonne,int tarifId) {
		super();
		this.chambreId = chambreId;
		this.chambreType = chambreType;
		this.capacite = capacite;
		this.nbPersonne = nbPersonne;
		this.tarifId = tarifId;
	}
	
	public Chambre(String chambreType, int capacite, int nbPersonne, int tarifId) {
		super();
		this.chambreType = chambreType;
		this.capacite = capacite;
		this.nbPersonne = nbPersonne;
		this.tarifId = tarifId;
	}
	
	public Chambre() {
		super();
	}
	public int getTarifId() {
		return tarifId;
	}
	public void setTarifId(int tarifId) {
		this.tarifId = tarifId;
	}
}
