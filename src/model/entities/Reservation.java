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
		return ChronoUnit.DAYS.between(checkin,checkout); //mais seguro que Period.
	}
	
	public String updateDates(LocalDate checkin, LocalDate checkout) {
		//Lógica de Negócio veio para classe Reservation!	
		//Interação com tela(ex: print) é responsabilidade da view, da aplicação, do program.
		//Não print aqui na classe de domínio, lance uma exceção.
		
		LocalDate now = LocalDate.now();
		if (checkin.isBefore(now) || checkout.isBefore(now)) {
			throw new ReservationException(
                "Reservation dates must be future dates");
		}
		if (!checkout.isAfter(checkin)) {
			throw new ReservationException(
                "Check-out date must be after check-in date");
		}
		
		this.checkin = checkin;
		this.checkout = checkout;
		return null;//Se retornar 'null' não houve erro.
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
