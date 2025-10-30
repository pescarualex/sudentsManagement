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
                " grade=" + grade + '\'' +
                " highschoolYear=" + highSchoolYear +
                '}';
    }
}
