package _03_Inheritance_Exercises._05_onlineRadioDatabase;

public class InvalidSongException extends IllegalArgumentException{

    public InvalidSongException(String message) {
        super(message);
    }
}
