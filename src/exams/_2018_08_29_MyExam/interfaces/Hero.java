package exams._2018_08_29_MyExam.interfaces;

public interface Hero {

    String getName();

    int getHealth();

    double getOffense();

    double getDefense();

    double getTotalPoints();

    boolean isDead();

    void attack(Hero hero);

    void receiveDamage(double amount);
}
