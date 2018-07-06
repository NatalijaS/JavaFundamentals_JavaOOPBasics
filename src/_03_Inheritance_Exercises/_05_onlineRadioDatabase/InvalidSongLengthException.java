package _03_Inheritance_Exercises._05_onlineRadioDatabase;

public class InvalidSongLengthException extends InvalidSongException{
    public InvalidSongLengthException(String message) {
        super(message);
    }
}