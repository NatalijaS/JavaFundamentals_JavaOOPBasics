package _03_Inheritance_Exercises._05_onlineRadioDatabase;

public class InvalidSongSecondsException extends InvalidSongLengthException{

    public InvalidSongSecondsException(String message) {
        super(message);
    }
}
