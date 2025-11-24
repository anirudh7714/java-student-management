package services;

import model.Student;

public class CalculatorImpl implements GradeCalculator {

    @Override
    public String calculateGrade(Student s) {
        double p = s.getPercentage();

        if (p >= 75) return "A";
        if (p >= 60) return "B";
        if (p >= 50) return "C";
        if (p >= 35) return "D";
        return "F";
    }
}
