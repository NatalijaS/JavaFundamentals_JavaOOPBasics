package _03_Inheritance_Exercises._05_onlineRadioDatabase;

public class InvalidArtistNameException extends InvalidSongException{

    public InvalidArtistNameException(String message) {
        super(message);
    }
}
