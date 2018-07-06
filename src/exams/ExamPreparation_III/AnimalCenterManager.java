package exams.ExamPreparation_III;

import exams.ExamPreparation_III.models.animals.Animal;
import exams.ExamPreparation_III.models.animals.Cat;
import exams.ExamPreparation_III.models.animals.Dog;
import exams.ExamPreparation_III.models.centers.AdoptionCenter;
import exams.ExamPreparation_III.models.centers.CleansingCenter;

import java.text.Collator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class AnimalCenterManager {

    private Map<String, AdoptionCenter> adoptionCenters;
    private Map<String, CleansingCenter> cleansingCenters;
    private List<Animal> cleansedAnimals;
    private List<Animal> adoptedAnimals;

    AnimalCenterManager() {
        this.adoptionCenters = new HashMap<>();
        this.cleansingCenters = new HashMap<>();
        this.cleansedAnimals = new ArrayList<>();
        this.adoptedAnimals = new ArrayList<>();
    }

    void registerCleansingCenter(String name) {
        CleansingCenter cleansingCenter = new CleansingCenter(name);
        this.cleansingCenters.put(name, cleansingCenter);
    }

    void registerAdoptionCenter(String name) {
        AdoptionCenter adoptionCenter = new AdoptionCenter(name);
        this.adoptionCenters.put(name, adoptionCenter);
    }

    void registerDog(String name, int age, int learnedCommands, String adoptionCenterName) {
        Dog dog = new Dog(name, age, adoptionCenterName, learnedCommands);
        this.adoptionCenters.get(adoptionCenterName).register(dog);
    }

    void registerCat(String name, int age, int intelligenceCoefficient, String adoptionCenterName) {
        Cat cat = new Cat(name, age, adoptionCenterName, intelligenceCoefficient);
        this.adoptionCenters.get(adoptionCenterName).register(cat);
    }

    void sendForCleansing(String adoptionCenterName, String cleansingCenterName) {
        CleansingCenter cleansingCenter = this.cleansingCenters.get(cleansingCenterName);
        this.adoptionCenters.get(adoptionCenterName).sendForCleansing(cleansingCenter);
    }


    void cleanse(String cleansingCenterName) {
        List<Animal> cleansedAnimals = this.cleansingCenters.get(cleansingCenterName).cleanse();
        for (Animal cleansedAnimal : cleansedAnimals) {
            this.adoptionCenters.get(cleansedAnimal.getAdoptionCenter()).register(cleansedAnimal);
        }

        this.cleansedAnimals.addAll(cleansedAnimals);
    }


    void adopt(String adoptionCenterName) {
        List<Animal> adoptedAnimals = this.adoptionCenters.get(adoptionCenterName).adopt();
        this.adoptedAnimals.addAll(adoptedAnimals);
    }

    void printStatistics() {

        StringBuilder sb = new StringBuilder();
        sb.append("Paw Incorporative Regular Statistics\n");
        sb.append(String.format("Adoption Centers: %d\n", this.adoptionCenters.size()));
        sb.append(String.format("Cleansing Centers: %d\n", this.cleansingCenters.size()));
        sb.append(String.format("Adopted Animals: %s\n", getSortedAnimals(this.adoptedAnimals)));
        sb.append(String.format("Cleansed Animals: %s\n", getSortedAnimals(this.cleansedAnimals)));
        sb.append(String.format("Animals Awaiting Adoption: %d\n", getAwaitingAdoptionCount()));
        sb.append(String.format("Animals Awaiting Cleansing: %d\n", getAwaitingCleansingCount()));

        System.out.println(sb.toString());
    }

    private String getSortedAnimals(List<Animal> animals) {
        if (animals.isEmpty()) {
            return "None";
        }

        List<String> sorted = animals.stream()
                .map(Animal::getName)
                .sorted(Collator.getInstance())
                .collect(Collectors.toList());

        return String.join(", ", sorted);
    }

    private int getAwaitingAdoptionCount() {
        int count = this.adoptionCenters.values().stream()
                .flatMap(c -> c.getAnimals().stream())
                .filter(Animal::isCleansed)
                .collect(Collectors.toList())
                .size();
        return count;
    }

    private int getAwaitingCleansingCount() {
        return this.cleansingCenters.values().stream()
                .flatMap(c -> c.getAnimals().stream())
                .collect(Collectors.toList())
                .size();
    }
}
