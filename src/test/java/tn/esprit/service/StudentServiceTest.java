package tn.esprit.service;

import java.util.ArrayList;
import java.util.List;

class StudentService {

    private final List<Student> students = new ArrayList<>();

    public StudentService() {
        // Initialize with some sample data
        students.add(new Student(1, "John Doe"));
        students.add(new Student(2, "Jane Smith"));
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public String getStudentNameById(int id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .map(Student::getName)
                .findFirst()
                .orElse("Unknown");
    }

    // Inner class to represent a Student
    public static class Student {
        private final int id;
        private final String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
}