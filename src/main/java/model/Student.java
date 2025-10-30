package model;

import org.apache.commons.validator.routines.EmailValidator;

import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private String email;
    private int ID;
    private int phoneNumber;
    private String address;
    private List<List<Transcript>> transcript;

    public Student(){}

    public Student(String firstName,
                   String lastName,
                   String email,
                   int ID,
                   int phoneNumber,
                   String address,
                   List<List<Transcript>> transcript){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.ID = ID;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.transcript = transcript;
    }



    public boolean validateID(int ID){
        boolean isValid = false;
        if(ID < 0){
            System.out.println("Invalid ID: " + ID +
                    ". Please enter an ID grater than 0.");
        } else {
            isValid = true;
        }
        return isValid;
    }

    public boolean validateEmail(String email){
        boolean isValid = false;
        if(EmailValidator.getInstance().isValid(email)){
            isValid = true;
        }
        return isValid;
    }


    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public int getID(){
        return ID;
    }
    public void setID(int ID){
        this.ID = ID;
    }

    public int getPhoneNumber(){
        return phoneNumber;
    }
    public void setPhoneNumber(int phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }

    public List<List<Transcript>> getTranscript(){
        return transcript;
    }
    public void setTranscript(List<List<Transcript>> transcript){
        this.transcript = transcript;
    }


    @Override
    public String toString() {
        return "model.Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", ID=" + ID +
                ", phoneNumber=" + phoneNumber +
                ", address='" + address + '\'' +
                ", transcript=" + transcript +
                '}';
    }
}
