package _03_Inheritance_Exercises._05_onlineRadioDatabase;

public class InvalidSongMinutesException extends InvalidSongLengthException{

    public InvalidSongMinutesException(String message) {
        super(message);
    }
}
