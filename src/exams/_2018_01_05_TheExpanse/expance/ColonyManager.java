package exams._2018_01_05_TheExpanse.expance;

import exams._2018_01_05_TheExpanse.expance.colonists.Colonist;
import exams._2018_01_05_TheExpanse.expance.colonists.Soldier;
import exams._2018_01_05_TheExpanse.expance.colonists.engineers.HardwareEngineer;
import exams._2018_01_05_TheExpanse.expance.colonists.engineers.SoftwareEngineer;
import exams._2018_01_05_TheExpanse.expance.colonists.mediacs.GeneralPractitioner;
import exams._2018_01_05_TheExpanse.expance.colonists.mediacs.Surgeon;

public class ColonyManager {

    private Colony colony;

    ColonyManager(int maxFamilyCount, int maxFamilyCapacity) {
        this.colony = new Colony(maxFamilyCount, maxFamilyCapacity);
    }

    void insert(String... arguments){

        String className = arguments[1];
        String colonistId = arguments[2];
        String familyId = arguments[3];
        int talent = Integer.parseInt(arguments[4]);
        int age = Integer.parseInt(arguments[5]);

        Colonist colonist;

        try {
            switch (className) {
                case "Soldier":
                    colonist = new Soldier(colonistId, familyId, talent, age);
                    colony.addColonist(colonist);
                    return;
                case "SoftwareEngineer":
                    colonist = new SoftwareEngineer(colonistId, familyId, talent, age);
                    colony.addColonist(colonist);
                    return;
                case "HardwareEngineer":
                    colonist = new HardwareEngineer(colonistId, familyId, talent, age);
                    colony.addColonist(colonist);
                    return;
                case"Surgeon":
                    String sign = arguments[6];
                    colonist = new Surgeon(colonistId, familyId, talent, age, sign);
                    colony.addColonist(colonist);
                    return;
                case  "GeneralPractitioner":
                    String sign2 = arguments[6];
                    colonist = new GeneralPractitioner(colonistId, familyId, talent, age, sign2);
                    colony.addColonist(colonist);
            }

        }catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }
    }

    public void remove(String... arguments){

        String modificator = arguments[1];
        String familyId = arguments[2];

        switch (modificator) {
            case "family":
                colony.removeFamily(familyId);
                return;
            case "colonist":
                String colonistId = arguments[3];
                colony.removeColonist(familyId, colonistId);
        }
    }

    void grow(int years){
        this.colony.grow(years);
    }

    String potential(){
        return String.format("potential: %d",this.colony.getPotential());
    }

    String capacity(){
        return this.colony.getCapacity();
    }

    String family(String familyId){

        if(!this.colony.getFamilies().containsKey(familyId)){
            return "family does not exist";
        }

        return this.colony.getFamilies().get(familyId).toString();
    }
}
