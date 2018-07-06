package exams.exam_05_Jan_2018;

import exams.exam_05_Jan_2018.colonists.Colonist;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public  class Colony {
    private int maxFamilyCount; //number of families that can inhabit a colony simultaneously
    private int maxFamilyCapacity; //total colonists that can be in a single family
    private Map<String, Family> families;

    public Colony(int maxFamilyCount, int maxFamilyCapacity) {
        this.setMaxFamilyCount(maxFamilyCount);
        this.setMaxFamilyCapacity(maxFamilyCapacity);
        this.families = new LinkedHashMap<>();
    }

    public int getMaxFamilyCount() {
        return maxFamilyCount;
    }

    private void setMaxFamilyCount(int maxFamilyCount) {
        this.maxFamilyCount = maxFamilyCount;
    }

    public int getMaxFamilyCapacity() {
        return maxFamilyCapacity;
    }

    private void setMaxFamilyCapacity(int maxFamilyCapacity) {
        this.maxFamilyCapacity = maxFamilyCapacity;
    }

    public List<Colonist> getColonistsByFamilyId(String familyId) {
        return this.families.get(familyId).getColonists();
    }

    public Map<String, Family> getFamilies() {
        return families;
    }

    public void setFamilies(Map<String, Family> families) {
        this.families = families;
    }

    public void addColonist(Colonist colonist) {
        String familyId = colonist.getFamilyId();
        this.families.get(familyId).addColonist(colonist);
    }

    public void removeColonist(String familyId, String memberId) {
        this.families.get(familyId).removeColonist(memberId);
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
                .append(this.getMaxFamilyCapacity()).append("\n"));
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Colony{" +
                "maxFamilyCount=" + maxFamilyCount +
                ", maxFamilyCapacity=" + maxFamilyCapacity +
                ", families=" + families +
                '}';
    }
}
