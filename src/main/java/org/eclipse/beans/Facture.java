package org.eclipse.beans;

public class Facture {
	private int bookId;
	private String nomClient;
	
	public Facture(int bookId, String nomClient) {
		super();
		this.bookId = bookId;
		this.nomClient = nomClient;
	}

	public Facture() {
		super();
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
}
