package DefiningClasses.CompanyRoster;
//Define a class Employee that holds the following information: name, salary, position, department, email and age.
//The name, salary, position and department are mandatory while the rest are optional.
//Your task is to write a program which takes N lines of information about employees from the console and calculates
//the department with the highest average salary and prints for each employee in that department his name,
//salary, email and age - sorted by salary in descending order. If an employee doesn’t have an email – in place of that
//field you should print "n/a" instead, if he doesn’t have an age – print "-1" instead. The salary should be printed to
//two decimal places after the seperator.

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Department> departmentList = new HashMap<>();
        while (n > 0) {
            String[] input = scanner.nextLine().split(" ");
            Employee current = new Employee();
            if (input.length == 6) {
                current.setName(input[0]);
                current.setSalary(Double.parseDouble(input[1]));
                current.setPosition(input[2]);
                current.setDepartment(input[3]);
                current.setEmail(input[4]);
                current.setAge(Integer.parseInt(input[5]));
            } else if (input.length == 5) {
                current.setName(input[0]);
                current.setSalary(Double.parseDouble(input[1]));
                current.setPosition(input[2]);
                current.setDepartment(input[3]);
                current.setEmail(input[4]);
            } else {
                current.setName(input[0]);
                current.setSalary(Double.parseDouble(input[1]));
                current.setPosition(input[2]);
                current.setDepartment(input[3]);
            }
            if (!departmentList.containsKey(current.getDepartment())) {
                Department newDep = new Department();
                newDep.setName(current.getDepartment());
                newDep.getEmployees().add(current);
                departmentList.put(current.getDepartment(), newDep);
            } else {
                Department existingDep = departmentList.get(current.getDepartment());
                existingDep.getEmployees().add(current);
            }
            n--;
        }
        double biggestAverageSalary = Double.MIN_VALUE;
        double total = 0;
        String depName = "";
        for (Map.Entry<String, Department> entry : departmentList.entrySet()) {
            for (int i = 0; i < entry.getValue().getEmployees().size(); i++) {
                total = total + entry.getValue().getEmployees().get(i).getSalary();
            }
            double averageSalary = total / entry.getValue().getEmployees().size();
            if (averageSalary >= biggestAverageSalary) {
                biggestAverageSalary = averageSalary;
                depName = entry.getValue().getName();
            }
            total = 0;
        }
        System.out.printf("Highest Average Salary: %s%n",depName);
        Department withBiggestAverageSalary = departmentList.get(depName);
        Comparator<Employee> salaryComparator = Comparator.comparingDouble(Employee::getSalary).reversed();
        Collections.sort(withBiggestAverageSalary.getEmployees(), salaryComparator);
        for (int i = 0; i < withBiggestAverageSalary.getEmployees().size(); i++) {
            Employee currentEmployee = withBiggestAverageSalary.getEmployees().get(i);
            System.out.println(currentEmployee.toString());
            }
        }

    }
