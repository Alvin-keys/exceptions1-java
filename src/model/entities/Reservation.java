package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Reservation {
	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private Integer roomNumber;
	private LocalDate checkin;
	private LocalDate checkout;
	
	
	public Reservation() {	
	}
	
	public Reservation(Integer roomNumber, LocalDate checkin, LocalDate checkout) {
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckin() {
		return checkin;
	}

	public LocalDate getCheckout() {
		return checkout;
	}
	
	public Long duration() {	
		return ChronoUnit.DAYS.between(checkin,checkout); //mais seguro que Period
	}
	
	public void updateDates(LocalDate checkin, LocalDate checkout) {
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	@Override
	public String toString() {
		return  "Room "
				+roomNumber
				+", "
				+"check-in: "
				+checkin.format(fmt)//Mostrando objeto DateTime no formato String.
				+", "
				+"check-out: "
				+checkout.format(fmt)
				+", "
				+duration()
				+" nights";
				
	}
	
	
	
	
	
	
	
	
	
	
	

}
