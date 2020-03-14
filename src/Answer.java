import java.util.ArrayList;

public class Answer {
    private ArrayList<double[]> X;
    private ArrayList<double[]> EPS;

    public Answer() {
        X = new ArrayList<double[]>();
        EPS = new ArrayList<double[]>();
    }
    public void addX(double[] p){
        X.add(p);
    }
    public void addEps(double[] p){
        EPS.add(p);
    }
    public void print(){
        int size = X.size();
        int sizeOfMatr = X.get(0).length;
        for (int i = 0; i < size; i++) {
            double[] tempX = X.get(i);
            double[] tempEPS = EPS.get(i);
            System.out.print((i+1)+": X={ ");
            for (int j = 0; j < sizeOfMatr; j++) {
                System.out.printf("%.9f ",tempX[j]);
            }
            System.out.print("} E={ ");
            for (int j = 0; j < sizeOfMatr; j++) {
                System.out.printf("%.9f ",tempEPS[j]);
            }
            System.out.println("};");
        }
    }
}
