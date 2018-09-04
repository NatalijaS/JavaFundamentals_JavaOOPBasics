package exams._2016_10_07_SystemSplit;


import exams._2016_10_07_SystemSplit.models.Component;
import exams._2016_10_07_SystemSplit.models.hardware.HardwareComponent;
import exams._2016_10_07_SystemSplit.models.hardware.HeavyHardwareComponent;
import exams._2016_10_07_SystemSplit.models.hardware.PowerHardwareComponent;
import exams._2016_10_07_SystemSplit.models.software.ExpressSoftwareComponent;
import exams._2016_10_07_SystemSplit.models.software.LightSoftwareComponent;
import exams._2016_10_07_SystemSplit.models.software.SoftwareComponent;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TheSystem {

   private Map<String, HardwareComponent> hardwareComponents;
   private Map<String, HardwareComponent> dump;

    TheSystem() {
        this.hardwareComponents = new LinkedHashMap<>();
        this.dump = new LinkedHashMap<>();
    }

    void registerPowerHardware(String name, int capacity, int memory) {
        PowerHardwareComponent powerHardwareComponent = new PowerHardwareComponent(name, capacity, memory);
        this.hardwareComponents.put(name, powerHardwareComponent);
    }

    void registerHeavyHardware(String name, int capacity, int memory) {
        HeavyHardwareComponent heavyHardwareComponent = new HeavyHardwareComponent(name, capacity, memory);
        this.hardwareComponents.put(name, heavyHardwareComponent);
    }

    void registerExpressSoftware(String hardwareComponentName, String name, int capacity, int memory) {
        if (this.hardwareComponents.containsKey(hardwareComponentName)) {
            HardwareComponent hardwareComponent = this.hardwareComponents.get(hardwareComponentName);
            ExpressSoftwareComponent expressSoftwareComponent = new ExpressSoftwareComponent(name, capacity, memory);
            hardwareComponent.registerSoftwareComponent(expressSoftwareComponent);
        }
    }

    void registerLightSoftware(String hardwareComponentName, String name, int capacity, int memory) {
        if (this.hardwareComponents.containsKey(hardwareComponentName)) {
            HardwareComponent hardwareComponent = this.hardwareComponents.get(hardwareComponentName);
            LightSoftwareComponent lightSoftwareComponent = new LightSoftwareComponent(name, capacity, memory);
            hardwareComponent.registerSoftwareComponent(lightSoftwareComponent);
        }
    }

    void releaseSoftwareComponent(String hardwareComponentName, String softwareComponentName) {
        if (this.hardwareComponents.containsKey(hardwareComponentName)) {
            this.hardwareComponents.get(hardwareComponentName).releaseSoftwareComponent(softwareComponentName);
        }
    }

    void dump(String hardwareComponentName) {
        if (this.hardwareComponents.containsKey(hardwareComponentName)) {
            HardwareComponent component = this.hardwareComponents.get(hardwareComponentName);
            dump.put(hardwareComponentName, component);
            hardwareComponents.remove(hardwareComponentName);
        }
    }

    void restore(String hardwareComponentName) {
        if (this.dump.containsKey(hardwareComponentName)) {
            HardwareComponent component = dump.get(hardwareComponentName);
            this.hardwareComponents.put(hardwareComponentName, component);
            dump.remove(component);
        }
    }

    void dumpAnalyze() {
        String sb = "Dump Analysis\n" +
                String.format("exams._2018_07_08_TheWarOfTheComic.Power Hardware Components: %d\n", getDumpHardwareComponentsCount("exams._2018_07_08_TheWarOfTheComic.Power")) +
                String.format("Heavy Hardware Components: %d\n", getDumpHardwareComponentsCount("Heavy")) +
                String.format("Express Software Components: %d\n", getDumpSoftwareComponentsCount("Express")) +
                String.format("Light Software Components: %d\n", getDumpSoftwareComponentsCount("Light")) +
                String.format("Total Dumped Memory: %d\n", getTotalDumpedMemory()) +
                String.format("Total Dumped Capacity: %d", getTotalDumpedCapacity());

        System.out.println(sb);
    }

    private long getDumpSoftwareComponentsCount(String type) {
        return this.dump.values().stream()
                .flatMap(h -> h.getSoftwareComponents().values().stream().filter(s -> s.getType().equals(type)))
                .count();
    }

    private long getDumpHardwareComponentsCount(String type) {
        return this.dump.values().stream().filter(c -> c.getType().equals(type)).count();
    }

    void destroy(String hardwareComponentName) {
        this.dump.remove(hardwareComponentName);
    }

    String analyze() {
        return "System Analysis\n" +
                String.format("Hardware Components: %d\n", this.hardwareComponents.size()) +
                String.format("Software Components: %d\n", getTotalSoftwareComponentsCount()) +
                String.format("Total Operational Memory: %d / %d\n", getMemoryUsed(), getTotalMemory()) +
                String.format("Total Capacity Taken: %d / %d", getCapacityUsed(), getTotalCapacity());
    }

    public String split() {
        StringBuilder sb = new StringBuilder();

        hardwareComponents.values().stream().sorted((c1, c2) -> {
            if (c1.getType().equals("exams._2018_07_08_TheWarOfTheComic.Power")) {
                return -1;
            }
            return 1;
        }).forEach(c -> {
            sb.append(String.format("Hardware Component - %s\n", c.getName()));
            sb.append(String.format("Express Software Components - %d\n", getSoftwareComponentsCount(c, "Express")));
            sb.append(String.format("Light Software Components - %d\n", getSoftwareComponentsCount(c, "Light")));
            sb.append(String.format("Memory Usage: %d / %d\n", c.getMemoryTaken(), c.getMemory()));
            sb.append(String.format("Capacity Usage: %d / %d\n", c.getCapacityTaken(), c.getCapacity()));
            sb.append(String.format("Type: %s\n", c.getType()));
            sb.append(String.format("Software Components: %s", getSoftwareComponents(c)));

        });
        return sb.toString();
    }

    private String getSoftwareComponents(HardwareComponent component) {
        if (component.getSoftwareComponents().size() == 0) {
            return "None";
        }
        List<String> componentsNames = component.getSoftwareComponents().values().stream()
                .map(Component::getName)
                .collect(Collectors.toList());

        return String.join(", ", componentsNames);
    }

    private int getSoftwareComponentsCount(HardwareComponent component, String componentType) {
        List<SoftwareComponent> components = component.getSoftwareComponents().values().stream()
                .filter(s -> s.getType().equals(componentType))
                .collect(Collectors.toList());

        return components.size();
    }

     int getTotalSoftwareComponentsCount() {
        return this.hardwareComponents.values().stream().mapToInt(h -> h.getSoftwareComponents().size()).sum();
    }

     int getTotalMemory() {
        return this.hardwareComponents.values().stream().mapToInt(HardwareComponent::getMemory).sum();
    }

     int getTotalCapacity() {
        return this.hardwareComponents.values().stream().mapToInt(HardwareComponent::getCapacity).sum();
    }

     int getMemoryUsed() {
        return this.hardwareComponents.values().stream().mapToInt(HardwareComponent::getMemoryTaken).sum();
    }

     int getCapacityUsed() {
        return this.hardwareComponents.values().stream().mapToInt(HardwareComponent::getCapacityTaken).sum();
    }

    int getTotalDumpedMemory() {
        return this.dump.values().stream().mapToInt(HardwareComponent::getMemoryTaken).sum();
    }

     int getTotalDumpedCapacity() {
        return this.dump.values().stream().mapToInt(HardwareComponent::getCapacityTaken).sum();
    }
}
