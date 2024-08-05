package org.eclipse.beans;

public class Table {
	private int tableId;
	private String tableType;
	private int capacite;
	private int nbPersonne;
	private int tarifId;
	
	public int getTableId() {
		return tableId;
	}
	public void setTableId(int tableId) {
		this.tableId = tableId;
	}
	public String getTableType() {
		return tableType;
	}
	public void setTableType(String tableType) {
		this.tableType = tableType;
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
	public Table(int tableId, String tableType, int capacite, int nbPersonne,int tarifId) {
		super();
		this.tableId = tableId;
		this.tableType = tableType;
		this.capacite = capacite;
		this.nbPersonne = nbPersonne;
		this.tarifId = tarifId;
	}
	
	public Table(String tableType, int capacite, int nbPersonne, int tarifId) {
		super();
		this.tableType = tableType;
		this.capacite = capacite;
		this.nbPersonne = nbPersonne;
		this.tarifId = tarifId;
	}
	
	public Table() {
		super();
	}
	public int getTarifId() {
		return tarifId;
	}
	public void setTarifId(int tarifId) {
		this.tarifId = tarifId;
	}
}
