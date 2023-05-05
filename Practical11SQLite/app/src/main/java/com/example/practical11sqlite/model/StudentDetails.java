package com.example.practical11sqlite.model;

public class StudentDetails {
    private int id, sem;

    private String name, enrolment, branch, mobile, email;

    public StudentDetails() {}

    public StudentDetails( String name, String enrolment, int sem, String branch, String mobile, String email ) {
        this.sem = sem;
        this.name = name;
        this.enrolment = enrolment;
        this.branch = branch;
        this.mobile = mobile;
        this.email = email;
    }

    public StudentDetails(int id, String name, String enrolment, int sem, String branch, String mobile, String email    ) {
        this.id = id;
        this.sem = sem;
        this.name = name;
        this.enrolment = enrolment;
        this.branch = branch;
        this.mobile = mobile;
        this.email = email;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public int getSem() {return sem;}
    public void setSem(int sem) {this.sem = sem;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getEnrolment() {return enrolment;}
    public void setEnrolment(String enrolment) {this.enrolment = enrolment;}

    public String getBranch() {return branch;}
    public void setBranch(String branch) {this.branch = branch;}

    public String getMobile() {return mobile;}
    public void setMobile(String mobile) {this.mobile = mobile;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
}
