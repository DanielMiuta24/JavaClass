public class GradeCalculator {
    public static String getGradeSwitch(int score) {
        switch (score/10) {
            case 90:
                return "A";
            case 80:
                return "B";
            case 70:
                return "C";
            case 60:
                return "D";
            default:
                return "F";
        }
    }
public static void main(String[] args) {
       
        System.out.println("The grade is " + getGradeSwitch(85));
    }
}
