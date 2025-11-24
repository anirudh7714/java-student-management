package services;

import model.Student;

public abstract class ReportBase {

    protected void printLine() {
        System.out.println("-----------------------------------");
    }

    public abstract String generateReport(Student student, String grade);
}
