package _03_Inheritance_Exercises._05_onlineRadioDatabase;

public class InvalidSongNameException extends InvalidSongException{

    public InvalidSongNameException(String message) {
        super(message);
    }
}
