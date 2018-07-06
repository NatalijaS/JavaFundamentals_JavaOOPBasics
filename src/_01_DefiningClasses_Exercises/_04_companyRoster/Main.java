package _01_DefiningClasses_Exercises._04_companyRoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Department> departmentsEmployees = new LinkedHashMap<>();

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split(" ");
            Employee employee = new Employee(line[0], Double.parseDouble(line[1]), line[2], line[3]);
            if (line.length == 6) {
                employee.setEmail(line[4]);
                employee.setAge(Integer.parseInt(line[5]));
            } else if (line.length == 5) {
                if (ageOrEmail(line[4]).equals("email")) {
                    employee.setEmail(line[4]);
                } else {
                    employee.setAge(Integer.parseInt(line[4]));
                }
            }
            String departmentName = line[3];
            departmentsEmployees.putIfAbsent(departmentName, new Department(departmentName));
            departmentsEmployees.get(departmentName).addEmployee(employee);
        }
        Optional<String> department = departmentsEmployees
                .values()
                .stream()
                .sorted()
                .findFirst()
                .map(Department::getName);

        if (department.isPresent()) {
            System.out.println(String.format("Highest Average Salary: %s", department.get()));
            System.out.println(departmentsEmployees.get(department.get()));
        }

    }

    private static String ageOrEmail(String s) {
        String regexAge = "\\d+";
        Pattern pattern = Pattern.compile(regexAge);
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            return "age";
        } else {
            return "email";
        }
    }
}
