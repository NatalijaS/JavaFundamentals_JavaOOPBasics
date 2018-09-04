package exams._2018_07_08_TheWarOfTheComic.contracts;

public interface Arena {

    String getArenaName();

    boolean isArenaFull();

    void addHero(ComicCharacter hero);

    void addAntiHero(ComicCharacter antiHero);

    boolean fightHeroes();
}
