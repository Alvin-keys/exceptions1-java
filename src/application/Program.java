package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.ReservationException;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            int roomNumber = sc.nextInt();
            sc.nextLine();

            System.out.print("Check-in date (dd/MM/yyyy): ");
            LocalDate checkin = LocalDate.parse(sc.nextLine(), fmt);

            System.out.print("Check-out date (dd/MM/yyyy): ");
            LocalDate checkout = LocalDate.parse(sc.nextLine(), fmt);

            // Validação com método estático antes de criar o objeto Reservation
            Reservation.validateDates(checkin, checkout);

            Reservation reservation = new Reservation(roomNumber, checkin, checkout);

            System.out.println();
            System.out.println("Reservation: " + reservation);
            System.out.println();

            System.out.println("Enter data to update the reservation:");

            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkin = LocalDate.parse(sc.nextLine(), fmt);

            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkout = LocalDate.parse(sc.nextLine(), fmt);

            // Atualização e validação via método de instância
            reservation.updateDates(checkin, checkout);

            System.out.println();
            System.out.println("Reservation: " + reservation);

        } catch (ReservationException e) {
        	//getMessage() retorna exatamente a mensagem que foi enviada no super(message).
            System.out.println("Error in reservation: " + e.getMessage());// 
        }

        sc.close();
    }
}

//O Program deve apenas: ler dados, criar objeto, chamar métodos, tratar erros(try-catch), mostrar resultado.
//Quem sabe se uma reserva é válida é a classe Reservation.
//Se eu não tratar a exceção no método, preciso usar 'Throws' para propagar o erro e subir ele na pilha de chamadas.
