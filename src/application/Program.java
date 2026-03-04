package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int roomnumber = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		sc.nextLine();
		LocalDate checkin = LocalDate.parse(sc.nextLine(),fmt);
		System.out.print("Check-out date (dd/MM/yyyy): ");
		LocalDate checkout = LocalDate.parse(sc.nextLine(),fmt);
		LocalDate now = LocalDate.now();
		
		if(!checkout.isAfter(checkin)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else if (checkin.isBefore(now) || checkout.isBefore(now)) {
			System.out.println("Error in reservation: Reservation dates for update must be future dates");
		}
		
		// A lógica ainda está na camada de aplicação. Regra de negócio não deve ficar na camada de aplicação.
		else {
			Reservation reservation = new Reservation(roomnumber, checkin, checkout);
			System.out.println("Reservation: "+ reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkin = LocalDate.parse(sc.nextLine(),fmt);//Reaproveita a mesma variável.
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkout = LocalDate.parse(sc.nextLine(),fmt);
			
			if (checkin.isBefore(now) || checkout.isBefore(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			}
			else if (!checkout.isAfter(checkin)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}
			else {
				reservation.updateDates(checkin, checkout);
				System.out.println("Reservation: "+ reservation);
			}

		}
		
		sc.close();

	}
}
