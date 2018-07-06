package _01_DefiningClasses_Exercises._10_FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class Person {
   private String name;
   private String birthday;
   private List<Person> parents;
   private List<Person> children;

    Person(String name, String birthday) {
        this.setName(name);
        this.setBirthday(birthday);
        this.setParents(new ArrayList<>());
        this.setChildren(new ArrayList<>());
    }

    void changeName(String name) {
        this.setName(name);
    }

    void changeBirthday(String birthday) {
        this.setBirthday(birthday);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String getBirthday() {
        return birthday;
    }

    private void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    List<Person> getParents() {
        return parents;
    }

    private void setParents(List<Person> parents) {
        this.parents = parents;
    }

    List<Person> getChildren() {
        return children;
    }

    private void setChildren(List<Person> children) {
        this.children = children;
    }

    void addChild(Person child) {
        this.getChildren().add(child);
    }

    void addParent(Person parent) {
        this.getParents().add(parent);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(this.name).append(" ").append(this.birthday).append(System.lineSeparator());
        result.append("Parents:").append(System.lineSeparator());
        if (this.parents.size() > 0){
            for (Person parent : this.parents) {
                result.append(parent.getName()).append(" ").append(parent.getBirthday()).append(System.lineSeparator());
            }
        }
        result.append("Children:").append(System.lineSeparator());
        if (this.children.size() > 0){
            for (Person children : this.children) {
                result.append(children.getName()).append(" ").append(children.getBirthday()).append(System.lineSeparator());
            }
        }
        return result.toString();
    }
}
