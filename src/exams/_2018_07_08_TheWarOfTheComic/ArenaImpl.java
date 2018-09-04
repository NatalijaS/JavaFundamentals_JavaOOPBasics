package exams._2018_07_08_TheWarOfTheComic;

import exams._2018_07_08_TheWarOfTheComic.contracts.Arena;
import exams._2018_07_08_TheWarOfTheComic.contracts.ComicCharacter;

import java.util.*;

public class ArenaImpl implements Arena {

    private String arenaName;
    private List<ComicCharacter> heroes;
    private List<ComicCharacter> antiHeroes;
    private int capacity;

    public ArenaImpl(String arenaName, int capacity) {
        this.arenaName = arenaName;
        this.capacity = capacity;
        this.heroes = new ArrayList<>();
        this.antiHeroes = new ArrayList<>();
    }

    @Override
    public String getArenaName() {
        return this.arenaName;
    }

    @Override
    public boolean isArenaFull() {
        return this.heroes.size() + this.antiHeroes.size() >= this.capacity;
    }

    @Override
    public void addHero(ComicCharacter hero) {
        this.heroes.add(hero);
    }

    @Override
    public void addAntiHero(ComicCharacter antiHero) {
        this.antiHeroes.add(antiHero);
    }

    @Override
    public boolean fightHeroes() {
        boolean heroesAttackFirst = this.heroes.size() < this.antiHeroes.size();
        while (this.heroes.size() > 0 && this.antiHeroes.size() > 0) {
            if (heroesAttackFirst) {
                if (fight(this.heroes, this.antiHeroes)) break;
            } else {
                if (fight(this.antiHeroes, this.heroes)) break;
            }
        }
        return this.heroes.size() != 0;
    }

    private boolean fight(List<ComicCharacter> first, List<ComicCharacter> second) {
        for (int i = 0; i < this.heroes.size() && i < this.antiHeroes.size(); i++) {
            second.get(i).takeDamage(first.get(i).attack());
        }
        second.removeIf(h -> h.getHealth() <= 0);
        if (second.size() == 0) {
            return true;
        }
        for (int i = 0; i < this.heroes.size() && i < this.antiHeroes.size(); i++) {
            first.get(i).takeDamage(second.get(i).attack());
        }
        first.removeIf(h -> h.getHealth() <= 0);
        return first.size() == 0;
    }
}
