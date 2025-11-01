package model;

import java.util.List;

public class Transcript {
    private String course;
    private double grade;
    private int highSchoolYear;

    public Transcript(){}

    public Transcript(String course, double grade, int highSchoolYear){
        this.course = course;
        this.grade = grade;
        this.highSchoolYear = highSchoolYear;
    }

    public double getAverageGrade(Student student){
        double average = 0;
        List<List<Transcript>> transcript = student.getTranscript();
        for(List<Transcript> transcriptList : transcript){
            System.out.println(":::::::::Entered in first loop");
            System.out.println(":::::::::" + transcriptList.toString());
            for(Transcript courseTranscript : transcriptList){
                System.out.println(":::::::::Entered in second loop");
                System.out.println(":::::::::" + courseTranscript.toString());
                average += courseTranscript.getGrade();
                average /= transcriptList.size();
            }
        }
        return average;
    }

    public String getCourse(){
        return course;
    }
    public void setCourse(String course){
        this.course = course;
    }

    public double getGrade(){
        return grade;
    }
    public void setGrade(double grade){
        this.grade = grade;
    }

    public int getHighschoolYear(){
        return highSchoolYear;
    }
    public void setHighschoolYear(int highschoolYear){
        this.highSchoolYear = highschoolYear;
    }


    @Override
    public String toString() {
        return "Transcript{" +
                "course='" + course + '\'' +
                "grade=" + grade + '\'' +
                "highschoolYear=" + highSchoolYear +
                '}';
    }
}
