package main;

public class WrongDayException extends Exception{
	public WrongDayException(String errorMessage) {
		super(errorMessage);
	}
}