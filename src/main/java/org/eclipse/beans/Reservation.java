package org.eclipse.beans;

public class Reservation {
	public Reservation(int bookId, int chambreId, int salleId, int tableId, int terasseId, int piscineId, int clubId) {
		super();
		this.bookId = bookId;
		this.chambreId = chambreId;
		this.salleId = salleId;
		this.tableId = tableId;
		this.terasseId = terasseId;
		this.piscineId = piscineId;
		this.clubId = clubId;
	}



	private int resId;
	private int bookId;
	private int chambreId, salleId, tableId, terasseId, piscineId, clubId;
	
	
	
	public Reservation() {
		super();
	}



	public Reservation(int resId, int bookId, int chambreId, int salleId, int tableId, int terasseId, int piscineId,int clubId) {
		super();
		this.resId = resId;
		this.bookId = bookId;
		this.chambreId = chambreId;
		this.salleId = salleId;
		this.tableId = tableId;
		this.terasseId = terasseId;
		this.piscineId = piscineId;
		this.clubId = clubId;
		
	}



	public int getResId() {
		return resId;
	}



	public void setResId(int resId) {
		this.resId = resId;
	}



	public int getBookId() {
		return bookId;
	}



	public void setBookId(int bookId) {
		this.bookId = bookId;
	}



	public int getChambreId() {
		return chambreId;
	}



	public void setChambreId(int chambreId) {
		this.chambreId = chambreId;
	}



	public int getSalleId() {
		return salleId;
	}



	public void setSalleId(int salleId) {
		this.salleId = salleId;
	}



	public int getTableId() {
		return tableId;
	}



	public void setTableId(int tableId) {
		this.tableId = tableId;
	}



	public int getTerasseId() {
		return terasseId;
	}



	public void setTerasseId(int terasseId) {
		this.terasseId = terasseId;
	}



	public int getPiscineId() {
		return piscineId;
	}



	public void setPiscineId(int piscineId) {
		this.piscineId = piscineId;
	}



	public int getClubId() {
		return clubId;
	}



	public void setClubId(int clubId) {
		this.clubId = clubId;
	}



	
}
