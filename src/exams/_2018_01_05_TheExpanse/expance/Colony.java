package exams._2018_01_05_TheExpanse.expance;

import exams._2018_01_05_TheExpanse.expance.colonists.Colonist;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public  class Colony {

    private int maxFamilyCount; //number of families that can inhabit a colony simultaneously
    private int maxFamilyCapacity; //total colonists that can be in a single family
    private Map<String, Family> families;

    public Colony(int maxFamilyCount, int maxFamilyCapacity) {
        this.maxFamilyCount = maxFamilyCount;
        this.maxFamilyCapacity = maxFamilyCapacity;
        this.families = new LinkedHashMap<>();
    }

    public int getMaxFamilyCount() {
        return maxFamilyCount;
    }

    public int getMaxFamilyCapacity() {
        return maxFamilyCapacity;
    }

    public List<Colonist> getColonistsByFamilyId(String familyId) {
        return this.families.get(familyId).getColonists();
    }

    public Map<String, Family> getFamilies() {
        return families;
    }

    public void addColonist(Colonist colonist) {
        String familyId = colonist.getFamilyId();
        Family family = this.families.get(familyId);

        if (family == null) {
            if (this.maxFamilyCount <= this.families.size()) {
                throw new IllegalArgumentException("colony is full");
            }
            family = new Family(familyId);
        }
        if (family.getColonists().size() == this.maxFamilyCapacity) {
            throw new IllegalArgumentException("family is full");
        }

        family.addColonist(colonist);
        this.families.put(familyId, family);
    }

    public void removeColonist(String familyId, String memberId) {
        Family family = this.families.get(familyId);

        if (family != null) {
            family.removeColonist(memberId);
            if (family.getColonists().isEmpty()) {
                this.removeFamily(familyId);
            }
        }
    }

    public void removeFamily(String id) {
        this.families.remove(id);
    }

    public void grow(int years) {
        this.families.values().forEach(f -> f.getColonists().forEach(c -> c.grow(years)));
    }

    public int getPotential() {
        return this.families.values().stream().mapToInt(Family::getPotentialsSum).sum();
    }

    public String getCapacity() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("families: %d/%d\n", this.getFamilies().size(),  this.getMaxFamilyCount()));
        this.families.values().stream().sorted(Comparator.comparing(Family::getId))
                .forEach(f -> sb.append(String.format("-%s: ", f.getId())).append(f.getColonists().size()).append("/")
                .append(this.getMaxFamilyCapacity()).append(System.lineSeparator()));

        return sb.toString().trim();
    }
}
