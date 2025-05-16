import java.util.List;
import java.util.ArrayList;

public class GradeBook {
   public List<Student> Students = new ArrayList<>();
           List<Assignment> Assignments = new ArrayList<>();
            List<Grade> Grades = new ArrayList<>();


    public void add_student(Student student){
        Students.add(student);

    }
    public void add_assignment(Assignment assignment){
        Assignments.add(assignment);
    }
    public void record_grade(Grade grade){
        Grades.add(grade);
    }
    public void list_students(){
        System.out.println(Students);
    }
    public void list_assignments(){
        System.out.println(Assignments);
    }
    public void list_grades(){
        System.out.println(Grades);
    }

}
