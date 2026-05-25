package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ClassGroup {

    private String name;
    private List<Student> students;

    public ClassGroup(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void add(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void removeByEnrollments(int x) {
        Iterator<Student> it = students.iterator();

        while (it.hasNext()) {
            Student student = it.next();

            if (student.getEnrollments() > x) {
                it.remove();
            }
        }
    }

    public List<String> namesNumberOfEnrollments(int number){
        if( number <0) throw new IllegalArgumentException(" number negative") ;
        List<String> names = students.stream().
                filter(n-> n.getEnrollments()==number).
                map(s-> s.getName().toUpperCase()).
                sorted().toList();
        return names;
    }

    public long countGrades(double value) {
        if( value <0) throw new IllegalArgumentException(" value negative") ;
        return students.stream()
                .filter(student -> student.getGrade() > value)
                .count();
    }

    public List<Student> sortByName() {
        return students.stream()
                .sorted(Comparator.comparing(Student::getName)).toList();
    }

    public List<Student> top3() {
        List<Student> stds=students.stream()
                .sorted(Comparator.comparing(Student::getGrade).reversed())
                .limit(3).toList();
     return stds;
    }



    public double avgGrade() {
        return students.stream()
                .mapToDouble(Student::getGrade)
                .average()
                .orElse(0.0);
    }

    public boolean hasLowerGrade(double value) {
        return students.stream()
                .anyMatch(student -> student.getGrade() < value);
    }

    public boolean validNumbers() {
        return students.stream()
                .allMatch(student -> student.getNumber() >= 10000
                        && student.getNumber() <= 99999);
    }

    @Override
    public String toString() {
        return "ClassGroup{" +
                "name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}

