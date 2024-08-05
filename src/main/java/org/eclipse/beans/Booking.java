package org.eclipse.beans;

import java.sql.Date;

public class Booking {
	private int bookId;
	private Date dateDebut;
	private Date dateFin;
	private int ClientId;
	private int nbChild;
	private int nbAdult;
	private float cout;
	
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public int getClientId() {
		return ClientId;
	}

	public void setClientId(int clientId) {
		ClientId = clientId;
	}

	public int getNbChild() {
		return nbChild;
	}

	public void setNbChild(int nbChild) {
		this.nbChild = nbChild;
	}

	public int getNbAdult() {
		return nbAdult;
	}

	public void setNbAdult(int nbAdult) {
		this.nbAdult = nbAdult;
	}

	public float getCout() {
		return cout;
	}

	public void setCout(float cout) {
		this.cout = cout;
	}

	
	public Booking() {
		super();
	}

	public Booking(int bookId, Date dateDebut, Date dateFin, int clientId, int nbChild, int nbAdult, float cout) {
		super();
		this.bookId = bookId;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		ClientId = clientId;
		this.nbChild = nbChild;
		this.nbAdult = nbAdult;
		this.cout = cout;
	}
}
