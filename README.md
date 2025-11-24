Student Management System (Java)

A console-based Java application for managing student records.
The system allows adding students, listing stored students, and generating report files — all through a simple menu-driven interface.

🚀 Features

Add new student details

Generate report files

List all students

File-based storage (no database required)

Clean, modular Java code

Organized package structure

🧱 Project Structure
src/
 ├── main/           → Application entry point (MainApp.java)
 ├── model/          → Data models (e.g., Student.java)
 ├── services/       → Business logic (report generation, student management)
 └── utils/          → File handling / common utilities

storage/             → Auto-generated report files

▶️ How to Run
Compile the project
javac -d out src/**/*.java

Run the application
java -cp out main.MainApp

📦 Requirements

Java 17 or higher

VS Code / IntelliJ / any terminal

Git (optional, for version control)

📚 Future Enhancements

Add update/delete student options

Integrate database (MySQL or SQLite)

Add GUI (JavaFX)

Validation for user input

Sorting/filtering features
