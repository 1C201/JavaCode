import java.util.ArrayList;

/**
 * Created by benhi on 08/02/2016.
 */
public class Student {

    private int RegNo;
    private int ExamNo;
    private String Stage;

    ArrayList<Mark> marks;


    public Student(String reg, String exam,String stage){
        RegNo = Integer.parseInt(reg);
        ExamNo = Integer.parseInt(exam);
        Stage = stage;
        marks = new ArrayList<Mark>();
    }

    public int getRegNo(){
        return RegNo;
    }

    public int getExamNo(){
        return ExamNo;
    }

    public String getStage(){
        return Stage;
    }

    public void addMark(String mod,String mark){
        Mark m = new Mark(mod,mark);
        marks.add(m);
    }

    public String toString(){
        String s = this.getRegNo()+", ";
        for(Mark x:marks){
            s+="("+x.mod+"|"+x.mark+")";
        }
        //removes the last comma
        return(s);
    }
}
