package exams._2017_08_03_PawInc.models.centers;

import exams._2017_08_03_PawInc.models.animals.Animal;

import java.util.List;
import java.util.stream.Collectors;

public class AdoptionCenter extends Center {

    public AdoptionCenter(String name) {
        super(name);
    }

    public void sendForCleansing(CleansingCenter center) {
        List<Animal> animals = super.getAnimals().stream()
                .filter(a -> !a.isCleansed())
                .collect(Collectors.toList());

        center.registerAll(animals);
        super.removeAnimals(animals);
    }

    public List<Animal> adopt() {
        List<Animal> animals = super.getAnimals().stream()
                .filter(Animal::isCleansed)
                .collect(Collectors.toList());

        super.removeAnimals(animals);
        return animals;
    }
}
