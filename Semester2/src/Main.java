public class Main {
    public static void main(String[] args) {

       GradeBook book1 = new GradeBook();
        Student Mario = new Student(1,"Mario");
        Assignment web_project = new Assignment("tnf03","Node Js Assignment",100);
        Grade web_score = new Grade(Mario,web_project,100);
        book1.add_student(Mario);
        book1.add_assignment(web_project);
        book1.record_grade(web_score);
        book1.list_students();
        book1.list_assignments();
        book1.list_grades();






    }



}