package model;

import java.util.List;

public class Student {
    private String name;
    private String roll;
    private List<Integer> marks; // exactly 3 subjects

    public Student(String name, String roll, List<Integer> marks) {
        this.name = name;
        this.roll = roll;
        this.marks = marks;
    }

    public String getName() { return name; }
    public String getRoll() { return roll; }
    public List<Integer> getMarks() { return marks; }

    public int getTotal() {
        int sum = 0;
        for (int m : marks) sum += m;
        return sum;
    }

    public double getPercentage() {
        return getTotal() / 3.0; // 3 subjects
    }
}
