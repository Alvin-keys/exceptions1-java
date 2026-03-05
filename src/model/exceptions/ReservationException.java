package model.exceptions;

public class ReservationException extends Exception {
	private static final long serialVersionUID = 1L;
	
	// Construtor da Exceção
	public ReservationException(String message) {
        super(message);// Passa a msg para a classe pai Exception que já tem mecanismo para armazenar e mostrar
    }
	
}
