package exams._2018_07_08_TheWarOfTheComic;

import exams._2018_07_08_TheWarOfTheComic.contracts.Arena;
import exams._2018_07_08_TheWarOfTheComic.contracts.ComicCharacter;
import exams._2018_07_08_TheWarOfTheComic.contracts.Manager;
import exams._2018_07_08_TheWarOfTheComic.contracts.SuperPower;

import java.util.*;

public class WarManager implements Manager {

    private Map<String, ComicCharacter> heroes;
    private Map<String, ComicCharacter> antiHeroes;
    private Map<String, Arena> arenas;
    private Map<String, SuperPower> pool;
    private List<SuperPower> assignedSuperPowers;
    private List<String> assignedCharacters;
    private Map<String, List<ComicCharacter>> arenasFighters;
    private int heroChampionsCount;
    private int antiHeroChampionsCount;
    private int battlesCount;

    public WarManager() {
        this.heroes = new LinkedHashMap<>();
        this.antiHeroes = new LinkedHashMap<>();
        this.arenas = new LinkedHashMap<>();
        this.pool = new LinkedHashMap<>();
        this.assignedSuperPowers = new ArrayList<>();
        this.assignedCharacters = new ArrayList<>();
        this.arenasFighters = new HashMap<>();
        this.heroChampionsCount = 0;
        this.antiHeroChampionsCount = 0;
        this.battlesCount = 0;
    }

    @Override
    public String checkComicCharacter(String characterName) {
        if (!this.heroes.containsKey(characterName) && !this.antiHeroes.containsKey(characterName)) {
            return String.format("Sorry, fans! %s doesn't exist in our comics!", characterName);
        }

        ComicCharacter character = this.heroes.containsKey(characterName) ?
                this.heroes.get(characterName) : this.antiHeroes.get(characterName);
        if (character.getHealth() <= 0) {
            return String.format("%s has fallen in battle!", character);
        }

        return character.toString();
    }

    @Override
    public String addHero(ComicCharacter hero) {
        if (this.heroes.containsKey(hero.getName())) {
            this.heroes.get(hero.getName())
                    .boostCharacter(hero.getEnergy(), hero.getHealth(), hero.getIntelligence());
            return String.format("%s evolved!", hero.getName());
        }

        this.heroes.put(hero.getName(), hero);
        return String.format("%s is ready for battle!", hero.getName());
    }

    @Override
    public String addAntiHero(ComicCharacter antiHero) {
        if (this.antiHeroes.containsKey(antiHero.getName())) {
            this.antiHeroes.get(antiHero.getName())
                    .boostCharacter(antiHero.getEnergy(), antiHero.getHealth(), antiHero.getIntelligence());
            return String.format("%s is getting stronger!", antiHero.getName());
        }

        this.antiHeroes.put(antiHero.getName(), antiHero);
        return String.format("%s is ready for destruction!", antiHero.getName());
    }

    @Override
    public String addArena(Arena arena) {
        if (this.arenas.containsKey(arena.getArenaName())) {
            return "A battle is about to start there!";
        }

        this.arenas.put(arena.getArenaName(), arena);
        this.arenasFighters.put(arena.getArenaName(), new ArrayList<>());
        return String.format("%s is becoming a fighting ground!", arena.getArenaName());
    }

    @Override
    public String addHeroToArena(String arenaName, String hero) {
        if (this.assignedCharacters.contains(hero)){
            return String.format("%s is fighting!", hero);
        }
        ComicCharacter character = this.heroes.get(hero);
        if (character.getHealth() <= 0){
            return String.format("%s is dead!", hero);
        }
        Arena arena = this.arenas.get(arenaName);
        if (arena.isArenaFull()){
            return "Arena is full!";
        }
        arena.addHero(character);
        this.assignedCharacters.add(hero);
        this.arenasFighters.get(arenaName).add(character);
        return String.format("%s is fighting for your freedom in %s!", hero, arenaName);
    }

    @Override
    public String addAntiHeroToArena(String arenaName, String antiHero) {
        if (this.assignedCharacters.contains(antiHero)){
            return String.format("%s is fighting!", antiHero);
        }
        ComicCharacter character = this.antiHeroes.get(antiHero);
        if (character.getHealth() <= 0){
            return String.format("%s is dead!", antiHero);
        }
        Arena arena = this.arenas.get(arenaName);
        if (arena.isArenaFull()){
            return "Arena is full!";
        }
        arena.addAntiHero(character);
        this.assignedCharacters.add(antiHero);
        this.arenasFighters.get(arenaName).add(character);
        return String.format("%s and his colleagues are trying to take over %s!", antiHero, arenaName);
    }

    @Override
    public String loadSuperPowerToPool(SuperPower superPower) {
        if (pool.containsValue(superPower)) {
            return "This super power already exists!";
        }

        pool.put(superPower.getName(), superPower);
        return String.format("%s added to pool!", superPower.getName());
    }

    @Override
    public String assignSuperPowerToComicCharacter(String comicCharacter, String superPower) {
        SuperPower power = this.pool.get(superPower);
        if (this.assignedSuperPowers.contains(power) || power == null) {
            return String.format("%s already assigned!", superPower);
        }

        ComicCharacter character = this.heroes.getOrDefault(comicCharacter, this.antiHeroes.get(comicCharacter));
        character.addSuperPower(power);
        this.assignedSuperPowers.add(power);
        return String.format("%s has a new super power!", comicCharacter);
    }

    @Override
    public String usePowers(String characterName) {
        ComicCharacter character = this.antiHeroes.containsKey(characterName) ?
                this.antiHeroes.get(characterName) : this.antiHeroes.get(characterName);

        return character.useSuperPowers();
    }

    @Override
    public String startBattle(String arenaName) {
        Arena arena = this.arenas.get(arenaName);
        if (this.arenasFighters.get(arenaName).size() == 0){
            return "SAFE ZONE!";
        }
        if  (arena.fightHeroes()){
            this.heroChampionsCount++;
            this.arenasFighters.get(arenaName).forEach(c ->this.assignedCharacters.remove(c.getName()));
            this.arenas.remove(arenaName);
            this.arenasFighters.remove(arenaName);
            return String.format("Heroes won the battle of %s!", arenaName);
        }
        this.antiHeroChampionsCount++;
        this.arenasFighters.get(arenaName).forEach(c ->this.assignedCharacters.remove(c.getName()));
        this.arenas.remove(arenaName);
        this.arenasFighters.remove(arenaName);
        return String.format("Anti Heroes won the battle of %s!", arenaName);
    }

    @Override
    public String endWar() {
        this.battlesCount = this.heroChampionsCount + this.antiHeroChampionsCount;
        if (heroChampionsCount >= antiHeroChampionsCount) {
            return String.format("After %d battles our FRIENDLY HEROES WON!", this.battlesCount);
        } else {
            return "WE ARE DOOMED!";
        }
    }
}
