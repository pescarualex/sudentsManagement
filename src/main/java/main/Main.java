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
    static Transcript transcript;

    public static void main(String[] args) {
        printInfo();
        scanner.close();
    }


    private static void printInfo(){
        int choise;
        scanner = new Scanner(System.in);
        System.out.println("Welcome to StudentIndex page!\n\n" +
                "1. Add student \n" +
                "2. Search student by ID \n" +
                "3. View student transcript \n" +
                "4. Get average grade by student ID \n" +
                "0. Exit\n");
        choise = scanner.nextInt();

        switch(choise){
            case 1:
                addStudent();
                break;
            case 2:
                getStudentInfoByID();
                break;
            case 3:
                viewStudentTranscript();
                break;
            case 4:
                getStrudentAverageGradeByID();
            case 0:
                System.exit(0);
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

        for(Student student1 : students){
            StudentsFileWriter.writeToFile(student1);
        }

        System.out.println("Student \"" + student.getID() + " " +
                student.getFirstName() + " " +
                student.getLastName() + "\" added successfully.");
        System.out.println("The student transcript is set automatically for the moment.");
        printInfo();
    };

    public static void getStudentInfoByID(){
        scanner = new Scanner(System.in);
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        StudentsFileWriter.getStudentFromFileByID(id);
        printInfo();
    }

    public static void getStrudentAverageGradeByID(){
        double average = 0;
        double sum = 0;
        scanner = new Scanner(System.in);
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        String studentFromFileByID = StudentsFileWriter.getStudentFromFileByID(id);
        String[] studentString = studentFromFileByID.split(",");

        Student student = new Student();
        student.setID(Integer.parseInt(studentString[0]));
        student.setFirstName(studentString[1]);
        student.setLastName(studentString[2]);
        student.setEmail(studentString[3]);
        student.setAddress(studentString[4]);
        student.setPhoneNumber(Integer.parseInt(studentString[5]));

        List<List<Transcript>> transcript = new ArrayList<>();
        List<Transcript> year9 = new ArrayList<>();
        List<Transcript> year10 = new ArrayList<>();
        List<Transcript> year11 = new ArrayList<>();
        List<Transcript> year12 = new ArrayList<>();

        Transcript trancriptYear9Course1 = new Transcript();
        trancriptYear9Course1.setCourse(String.valueOf(studentString[6].substring(21, 28)));
        trancriptYear9Course1.setGrade(Double.parseDouble(studentString[6].substring(35, 38)));
        trancriptYear9Course1.setHighschoolYear(Integer.parseInt(studentString[6].substring(54, 55)));
        year9.add(trancriptYear9Course1);

        Transcript trancriptYear9Course2 = new Transcript();
        trancriptYear9Course2.setCourse(String.valueOf(studentString[7].substring(20, 24)));
        trancriptYear9Course2.setGrade(Double.parseDouble(studentString[7].substring(31, 34)));
        trancriptYear9Course2.setHighschoolYear(Integer.parseInt(studentString[7].substring(50, 51)));
        year9.add(trancriptYear9Course2);

        Transcript trancriptYear9Course3 = new Transcript();
        trancriptYear9Course3.setCourse(String.valueOf(studentString[8].substring(20, 28)));
        trancriptYear9Course3.setGrade(Double.parseDouble(studentString[8].substring(34, 37)));
        trancriptYear9Course3.setHighschoolYear(Integer.parseInt(studentString[8].substring(53, 54)));
        year9.add(trancriptYear9Course3);

        Transcript trancriptYear10Course1 = new Transcript();
        trancriptYear10Course1.setCourse(String.valueOf(studentString[9].substring(21, 28)));
        trancriptYear10Course1.setGrade(Double.parseDouble(studentString[9].substring(35, 38)));
        trancriptYear10Course1.setHighschoolYear(Integer.parseInt(studentString[9].substring(54, 55)));
        year10.add(trancriptYear10Course1);

        Transcript trancriptYear10Course2 = new Transcript();
        trancriptYear10Course2.setCourse(String.valueOf(studentString[10].substring(20, 24)));
        trancriptYear10Course2.setGrade(Double.parseDouble(studentString[10].substring(31, 34)));
        trancriptYear10Course2.setHighschoolYear(Integer.parseInt(studentString[10].substring(50, 51)));
        year10.add(trancriptYear10Course2);

        Transcript trancriptYear10Course3 = new Transcript();
        trancriptYear10Course3.setCourse(String.valueOf(studentString[11].substring(20, 28)));
        trancriptYear10Course3.setGrade(Double.parseDouble(studentString[11].substring(34, 37)));
        trancriptYear10Course3.setHighschoolYear(Integer.parseInt(studentString[11].substring(53, 54)));
        year10.add(trancriptYear10Course3);


        Transcript trancriptYear11Course1 = new Transcript();
        trancriptYear11Course1.setCourse(String.valueOf(studentString[12].substring(21, 28)));
        trancriptYear11Course1.setGrade(Double.parseDouble(studentString[12].substring(35, 38)));
        trancriptYear11Course1.setHighschoolYear(Integer.parseInt(studentString[12].substring(54, 55)));
        year11.add(trancriptYear11Course1);

        Transcript trancriptYear11Course2 = new Transcript();
        trancriptYear11Course2.setCourse(String.valueOf(studentString[13].substring(20, 24)));
        trancriptYear11Course2.setGrade(Double.parseDouble(studentString[13].substring(31, 34)));
        trancriptYear11Course2.setHighschoolYear(Integer.parseInt(studentString[13].substring(50, 51)));
        year11.add(trancriptYear11Course2);

        Transcript trancriptYear11Course3 = new Transcript();
        trancriptYear11Course3.setCourse(String.valueOf(studentString[14].substring(20, 28)));
        trancriptYear11Course3.setGrade(Double.parseDouble(studentString[14].substring(34, 37)));
        trancriptYear11Course3.setHighschoolYear(Integer.parseInt(studentString[14].substring(53, 54)));
        year11.add(trancriptYear11Course3);


        Transcript trancriptYear12Course1 = new Transcript();
        trancriptYear12Course1.setCourse(String.valueOf(studentString[15].substring(21, 28)));
        trancriptYear12Course1.setGrade(Double.parseDouble(studentString[15].substring(35, 38)));
        trancriptYear12Course1.setHighschoolYear(Integer.parseInt(studentString[15].substring(55, 56)));
        year12.add(trancriptYear12Course1);

        Transcript trancriptYear12Course2 = new Transcript();
        trancriptYear12Course2.setCourse(String.valueOf(studentString[16].substring(20, 24)));
        trancriptYear12Course2.setGrade(Double.parseDouble(studentString[16].substring(31, 34)));
        trancriptYear12Course2.setHighschoolYear(Integer.parseInt(studentString[16].substring(51, 52)));
        year12.add(trancriptYear12Course2);

        Transcript trancriptYear12Course3 = new Transcript();
        trancriptYear12Course3.setCourse(String.valueOf(studentString[17].substring(20, 28)));
        trancriptYear12Course3.setGrade(Double.parseDouble(studentString[17].substring(34, 37)));
        trancriptYear12Course3.setHighschoolYear(Integer.parseInt(studentString[17].substring(54, 55)));
        year12.add(trancriptYear12Course3);

        transcript.add(year9);
        transcript.add(year10);
        transcript.add(year11);
        transcript.add(year12);

        student.setTranscript(transcript);

        int i = 1;

        List<List<Transcript>> transcript1 = student.getTranscript();
        for(List<Transcript> transcript2 : transcript1){
            for (Transcript transcript3 : transcript2) {
                sum += transcript3.getGrade();
                i++;
                average = sum / i;
            }
        }

        System.out.printf("Average grade for student with ID " + id + " is %.2f", average);

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
