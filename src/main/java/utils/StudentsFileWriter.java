package utils;

import model.Student;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class StudentsFileWriter {


    private static final String fileName = "studentsIndex.csv";
    static final Path path = Path.of(fileName);
    static FileWriter fileWriter;

    public StudentsFileWriter(){
        writeHeader();
    }

    static {
        try {
            fileWriter = new FileWriter(path.toFile(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeHeader(){
            try {
                List<String> fileHeaders = new ArrayList<>();
                fileHeaders.add("ID");
                fileHeaders.add("First Name");
                fileHeaders.add("Last Name");
                fileHeaders.add("Email");
                fileHeaders.add("Address");
                fileHeaders.add("Phone Number");
                fileHeaders.add("model.Transcript");

                /// write tabel header
                fileWriter.write(Arrays.toString(fileHeaders.toArray()) + "\n");
                fileWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public static void writeToFile(List<Student> students){
        try{
            if (students.size() <= 0) {
                throw new IllegalArgumentException("There is no student to write in file.");
            } else {
                /// write students
                for (Student student : students) {
                    fileWriter.write(student.getID() + "," +
                                    student.getFirstName() + "," +
                                    student.getLastName() + "," +
                                    student.getEmail() + "," +
                                    student.getAddress() + "," +
                                    student.getPhoneNumber() + "," +
                                    student.getTranscript() + "\n"
                    );
                    fileWriter.flush();
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void readFile(){
        try(BufferedReader bufferReader = new BufferedReader(new FileReader(path.toFile()))){
            String line;
            String[] studentsInfo = {};
            while((line = bufferReader.readLine()) != null){
                studentsInfo = line.split(",");
            }

            for(String studentInfo : studentsInfo){
                System.out.println(studentInfo + "\t");
            }

            bufferReader.close();
            System.out.println();
        } catch(IOException e){
            e.printStackTrace();
        }
    }




}
