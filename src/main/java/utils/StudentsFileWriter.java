package utils;

import model.Student;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class StudentsFileWriter {


    private static final String fileName = "data/studentsIndex.txt";
    static final Path path = Path.of(fileName);
//    static FileWriter fileWriter;
    static BufferedWriter fileWriter;

    static {
        try {
              fileWriter = new BufferedWriter((new FileWriter((path.toFile()))));
//            fileWriter = new FileWriter(path.toFile(), true);
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(Student student){
        try{
            if (student == null) {
                throw new IllegalArgumentException("There is no student to write in file.");
            } else {
                /// write students
                    fileWriter.write(student.getID() + "," +
                                    student.getFirstName() + "," +
                                    student.getLastName() + "," +
                                    student.getEmail() + "," +
                                    student.getAddress() + "," +
                                    student.getPhoneNumber() + "," +
                                    student.getTranscript() + "\n");
                    fileWriter.flush();
                }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String getStudentFromFileByID(String ID){
        String line = "";

        try(BufferedReader bufferReader = new BufferedReader(new FileReader(path.toFile()))){
            while((line = bufferReader.readLine()) != null){
                if(line.startsWith(ID)){
                    System.out.println(line);
                    break;
                } else {
                    System.out.println("Student with ID: " + ID + " not found.");
                    break;
                }
            }
            bufferReader.close();
            System.out.println();
        } catch(IOException e){
            e.printStackTrace();
        }
        return line;
    }

    public static void readFile(){
        try(BufferedReader bufferReader = new BufferedReader(new FileReader(path.toFile()))){
            String line;
            List<String> studentsInfo = new ArrayList<>();
            while((line = bufferReader.readLine()) != null){
                studentsInfo = Arrays.stream(line.split(",")).toList();
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
