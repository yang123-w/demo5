package c3;

public class Exam {
    int x=0;
     synchronized void add(){
        for(int i=0;i<10000;i++){
            x++;
        }
    }
}
