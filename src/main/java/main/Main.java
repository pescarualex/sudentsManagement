package main;

import model.Student;
import model.Transcript;
import utils.StudentsFileWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner;
    static List<Student> students = new ArrayList<>();
    static StudentsFileWriter studentsFileWriter = new StudentsFileWriter();

    public static void main(String[] args) {
        printInfo();
        scanner.close();
    }


    private static void printInfo(){
        int choise;
        scanner = new Scanner(System.in);
        System.out.println("Welcome to StudentIndex page!\n\n" +
                "1. Add student \n" +
                "2. View student transcript \n" +
                "3. View student info \n");
        choise = scanner.nextInt();

        switch(choise){
            case 1:
                addStudent();
                break;
            case 2:
                viewStudentTranscript();
                break;
            case 3:
                viewStudentsInfo();
                break;
            default:
                System.out.println("Invalid choise. Please try again.");
                printInfo();
        }

    }


    public static void addStudent(){
        Student student = new Student();
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        if(student.validateID(id)){
            student.setID(id);
        }
        scanner.nextLine();

        System.out.print("Enter student first name: ");
        student.setFirstName(scanner.nextLine());
        System.out.print("Enter student last name: ");
        student.setLastName(scanner.nextLine());

        System.out.print("Enter student email: ");
        String email = scanner.nextLine();
        if(student.validateEmail(email)){
            student.setEmail(email);
        }

        System.out.print("Enter student address: ");
        student.setAddress(scanner.nextLine());
        System.out.print("Enter student phone number: ");
        student.setPhoneNumber(scanner.nextInt());
        student.setTranscript(studentTranscript());

        students.add(student);

        StudentsFileWriter.writeToFile(students);

        System.out.println("model.Student \"" + student.getID() + " " +
                student.getFirstName() + " " +
                student.getLastName() + "\" added successfully.");
        System.out.println("The student transcript is set automatically for the moment.");
        printInfo();

    };

    public static void viewStudentsInfo(){
        StudentsFileWriter.readFile();
        printInfo();
    }


    public static void viewStudentTranscript(){
        List<List<Transcript>> transcripts = studentTranscript();
        for(List<Transcript> highschool : transcripts){
            for(Transcript transcript : highschool){
                System.out.println(transcript + "\n");
            }
        }
    }

    public static List<List<Transcript>> studentTranscript(){
        List<List<Transcript>> highschool = new ArrayList<>();
        List<Transcript> year9 = new ArrayList<>();
        year9.add(new Transcript("English", 7, 9));
        year9.add(new Transcript("Math", 8, 9));
        year9.add(new Transcript("History", 9, 9));

        List<Transcript> year10 = new ArrayList<>();
        year10.add(new Transcript("English", 9, 10));
        year10.add(new Transcript("Math", 6, 10));
        year10.add(new Transcript("History", 8, 10));

        List<Transcript> year11 = new ArrayList<>();
        year11.add(new Transcript("English", 6, 11));
        year11.add(new Transcript("Math", 8, 11));
        year11.add(new Transcript("History", 7, 11));

        List<Transcript> year12 = new ArrayList<>();
        year12.add(new Transcript("English", 10, 12));
        year12.add(new Transcript("Math", 10, 12));
        year12.add(new Transcript("History", 10, 12));

        highschool.add(year9);
        highschool.add(year10);
        highschool.add(year11);
        highschool.add(year12);

        return highschool;
    }



}
