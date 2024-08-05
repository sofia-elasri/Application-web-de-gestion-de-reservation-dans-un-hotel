package org.eclipse.beans;

public class Club {
	private int clubId;
	private String clubType;
	private int capacite;
	private int nbPersonne;
	private int tarifId;
	
	public Club(int clubId, String clubType, int capacite, int nbPersonne, int tarifId) {
		super();
		this.clubId = clubId;
		this.clubType = clubType;
		this.capacite = capacite;
		this.nbPersonne = nbPersonne;
		this.tarifId = tarifId;
	}
	
	public Club(String clubType, int capacite, int nbPersonne, int tarifId) {
		super();
		this.clubType = clubType;
		this.capacite = capacite;
		this.nbPersonne = nbPersonne;
		this.tarifId = tarifId;
	}
	
	public Club() {
		super();
	}
	public int getClubId() {
		return clubId;
	}
	public void setClubId(int clubId) {
		this.clubId = clubId;
	}
	public String getClubType() {
		return clubType;
	}
	public void setClubType(String clubType) {
		this.clubType = clubType;
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
	public int getTarifId() {
		return tarifId;
	}
	public void setTarifId(int tarifId) {
		this.tarifId = tarifId;
	}
}
