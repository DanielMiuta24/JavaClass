public class Assignment {
    String name,id;
    int max_score;

    public Assignment(String id,String name,int max_score){
        this.id=id;
        this.name= name;
        this.max_score=max_score;
    }

    public  void get_weight(){

    }
    public  void add_grade(){

    }
    @Override
    public String toString() {
        return "Assignment{name='" + name + "', id='" + id + "', maxScore=" + max_score + "}";
    }
}
