package services;

import model.Student;
import utils.FileManager;

public class ReportGenerator extends ReportBase {

    @Override
    public String generateReport(Student s, String grade) {
        StringBuilder sb = new StringBuilder();
        sb.append("----- REPORT CARD -----\n");
        sb.append("Name: ").append(s.getName()).append("\n");
        sb.append("Roll: ").append(s.getRoll()).append("\n");
        sb.append("Marks: ").append(s.getMarks().toString()).append("\n");
        sb.append("Total: ").append(s.getTotal()).append("\n");
        sb.append(String.format("Percentage: %.2f\n", s.getPercentage()));
        sb.append("Grade: ").append(grade).append("\n");

        String report = sb.toString();
        FileManager.saveReport(s.getRoll() + "_report.txt", report);

        return report;
    }
}
