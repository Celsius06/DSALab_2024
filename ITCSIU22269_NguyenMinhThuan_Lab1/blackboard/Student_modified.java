package blackboard;

public class Student_modified {
    private String fname, lname;
    private int grade;
    
    public Student_modified(String fname, String lname, int grade) {
        this.fname = fname;
        this.lname = lname;
        this.grade = grade;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public int getGrade() {
        return grade;
    }

    public String toString() {
        return fname + " " + lname + "\t" + grade;
    }
}


