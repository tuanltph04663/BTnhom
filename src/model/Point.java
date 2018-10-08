package model;

public class Point {

    private String studentCode;
    private String fullName;
    private double english;
    private double informatics;
    private double physicalEducation;

    public Point() {
    }

    public Point(String studentCode, String fullName, double english, double informatics, double physicalEducation) {
        this.studentCode = studentCode;
        this.fullName = fullName;
        this.english = english;
        this.informatics = informatics;
        this.physicalEducation = physicalEducation;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getEnglish() {
        return english;
    }

    public void setEnglish(double english) {
        this.english = english;
    }

    public double getInformatics() {
        return informatics;
    }

    public void setInformatics(double informatics) {
        this.informatics = informatics;
    }

    public double getPhysicalEducation() {
        return physicalEducation;
    }

    public void setPhysicalEducation(double physicalEducation) {
        this.physicalEducation = physicalEducation;
    }

    public double getAverage() {
        return (this.english + this.informatics + this.physicalEducation) / 3;
    }

    @Override
    public String toString() {
        return "Point{" + "studentCode=" + studentCode + ", fullName=" + fullName + ", english=" + english + ", informatics=" + informatics + ", physicalEducation=" + physicalEducation + '}';
    }
}
