package exams.exam_05_Jan_2018;

import exams.exam_05_Jan_2018.colonists.Colonist;
import exams.exam_05_Jan_2018.colonists.Soldier;
import exams.exam_05_Jan_2018.colonists.engineers.HardwareEngineer;
import exams.exam_05_Jan_2018.colonists.engineers.SoftwareEngineer;
import exams.exam_05_Jan_2018.colonists.mediacs.GeneralPractitioner;
import exams.exam_05_Jan_2018.colonists.mediacs.Surgeon;

public class ColonyManager {
    private int maxFamilyCount;
    private int maxFamilyCapacity;
    private Colony colony;

    public ColonyManager(int maxFamilyCount, int maxFamilyCapacity) {
        this.maxFamilyCount = maxFamilyCount;
        this.maxFamilyCapacity = maxFamilyCapacity;
        this.colony = new Colony(maxFamilyCount, maxFamilyCapacity);
    }

    public void insert(String className, String colonistId, String familyId, int talent, int age){
        if(maxFamilyCapacity == 0){
            return;
        }
        if(!this.colony.getFamilies().containsKey(familyId)){
            if(this.colony.getFamilies().size() == maxFamilyCount){
                throw  new IllegalStateException("colony is full");
            }
            this.colony.getFamilies().put(familyId, new Family(familyId));
        }

        if(this.colony.getFamilies().get(familyId).getColonists().size() == maxFamilyCapacity){
            throw  new IllegalStateException("family is full");
        }

        Colonist colonist;
        switch (className){
            case "SoftwareEngineer":
                colonist = new SoftwareEngineer(colonistId, familyId, talent, age);
                break;
            case "HardwareEngineer":
                colonist = new HardwareEngineer(colonistId, familyId, talent, age);
                break;
            default:
                colonist = new Soldier(colonistId, familyId, talent, age);
                break;
        }
        this.colony.addColonist(colonist);

    }
    public void insert( String className,  String colonistId,  String familyId, int talent,  int age, String sign){
        if(!sign.equals("caring") && !sign.equals("careless") && !sign.equals("precise") && !sign.equals("butcher")){
            return;
        }
        if(maxFamilyCount == 0){
            return;
        }
        if(!this.colony.getFamilies().containsKey(familyId)){
            if(this.colony.getFamilies().size() == maxFamilyCount){
                throw  new IllegalStateException("colony is full");
            }
            this.colony.getFamilies().put(familyId, new Family(familyId));
        }
        if(this.colony.getFamilies().get(familyId).getColonists().size() == maxFamilyCapacity){
            throw  new IllegalStateException("family is full");
        }

        Colonist colonist;
        switch (className){
            case "Surgeon":
                colonist = new Surgeon(colonistId, familyId, talent, age, sign);
                break;
                default:
                    colonist = new GeneralPractitioner(colonistId, familyId, talent, age, sign);
                    break;
        }

        this.colony.addColonist(colonist);
    }

    public void remove(String modificator, String familyId){
        this.colony.removeFamily(familyId);
    }

    public void remove(String modificator, String familyId, String colonistId){
        this.colony.removeColonist(familyId, colonistId);
        if(this.colony.getFamilies().get(familyId).getColonists().isEmpty()){
            this.colony.removeFamily(familyId);
        }
    }

    public void grow(int years){
        this.colony.grow(years);
    }

    public String potential(){
        return String.format("potential: %d",this.colony.getPotential());
    }

    public String capacity(){
        return this.colony.getCapacity();
    }

    public String family(String familyId){
        if(!this.colony.getFamilies().containsKey(familyId)){
            return "family does not exist";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(familyId).append(":\n");
        this.colony.getFamilies().values()
                .forEach(f -> f.getColonists()
                        .forEach(c -> sb.append(String.format("-%s: %d\n", c.getId(), c.getPotential()))));
        return sb.toString();
    }
}
