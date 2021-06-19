package main;

public class WrongSchoolHourException extends Exception{
  public WrongSchoolHourException(String errorMessage){
    super(errorMessage);
  }
}