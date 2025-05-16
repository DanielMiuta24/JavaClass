public class Grade {
    Student student;
    Assignment assignment;
     int score;

    public Grade(Student student, Assignment assignment, int score){
        this.student = student;
        this.assignment = assignment;
        this.score = score;
    }

    private void get_percentage(){

    }
    @Override
    public String toString() {
        return "Grade{student=" + student.name + ", assignment=" + assignment.name + ", score=" + score + "}";
    }
}
