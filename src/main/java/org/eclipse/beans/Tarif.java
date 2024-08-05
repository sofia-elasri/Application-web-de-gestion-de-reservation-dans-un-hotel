package org.eclipse.beans;

public class Tarif {
	


	private int tarifId;
	private float prix;
	private float nvPrix;
	
	
	public Tarif(int tarifId, float prix, float nvPrix) {
		super();
		this.tarifId = tarifId;
		this.prix = prix;
		this.nvPrix = nvPrix;
	}
	
	public Tarif(float prix, float nvPrix) {
		super();
		this.prix = prix;
		this.nvPrix = nvPrix;
	}

	public Tarif() {
		super();
	}


	public int getTarifId() {
		return tarifId;
	}


	public void setTarifId(int tarifId) {
		this.tarifId = tarifId;
	}


	public float getPrix() {
		return prix;
	}


	public void setPrix(float prix) {
		this.prix = prix;
	}


	public float getNvPrix() {
		return nvPrix;
	}


	public void setNvPrix(float nvPrix) {
		this.nvPrix = nvPrix;
	}
}
