
import java.util.ArrayList;

public class Matrix {
    private int sizeOfMatrix;
    private double[][] A;

    private double[] B;

    public void setEps(double eps) {
        this.eps = eps;
    }

    private double eps;

    private ArrayList<ArrayList<Integer>> DiagonalElements;



    public Matrix(double[][] p) {
        sizeOfMatrix = p.length;
        this.A = p;
        defineX();
    }
    private void defineX(){

        DiagonalElements = new ArrayList<>();
        for (int i = 0; i < sizeOfMatrix; i++) {
            DiagonalElements.add(new ArrayList<Integer>());
        }
    }
    public Matrix(int n) {
        this.sizeOfMatrix = n;
        defineX();
    }

    public double[] getB() {
        return B;
    }

    public void setB(double[] b) {
        B = b;
    }

    public double[][] getA() {
        return A;
    }



    public double getEps() {
        return eps;
    }

    public ArrayList<ArrayList<Integer>> getDiagonalElements() {
        return DiagonalElements;
    }

    public void permutaion(){
        double[][] temp = new double[sizeOfMatrix][sizeOfMatrix];
        for (int i = 0; i <temp.length ; i++) {
            temp[i] = null;
        }
        for (int i = 0; i < sizeOfMatrix; i++) {
            ArrayList<Integer> arrayList = DiagonalElements.get(i);
            for (int j = 0; j < arrayList.size(); j++) {
                int position = arrayList.get(j);
                if(temp[position] == null)
                    temp[position] = A[i];
            }

        }
        A = temp;
    }

    public boolean hasDiagPredominance(){

        for (int i = 0; i < sizeOfMatrix; i++) {
            double sum = Math.abs(A[i][0]);
            double max = Math.abs(A[i][0]);
            ArrayList<Integer> diagonalLine = DiagonalElements.get(i);
            diagonalLine.add(0);

            for (int j = 1; j < sizeOfMatrix; j++) {
                sum+=Math.abs(A[i][j]);
                if(max < Math.abs(A[i][j])){
                    max = Math.abs(A[i][j]);
                    diagonalLine.removeAll(diagonalLine.subList(0,diagonalLine.size()));
                    diagonalLine.add(j);
                }
                else if(max == Math.abs(A[i][j])){
                    diagonalLine.add(j);
                }
            }
            sum-=max;
            if(max<=sum){
                return false;
            }

        }

        DiagonalElements.sort((a,b)->{return a.size()-b.size();});
        if(DiagonalElements.get(0).size()!=1){
            return false;
        }

        int counter = 0;
        boolean[] isBe = new boolean[sizeOfMatrix];
        for (boolean value:isBe) {
            value = false;
        }
        for (int i = 0; i <sizeOfMatrix; i++) {
            ArrayList<Integer> arrayList = DiagonalElements.get(i);
            for (int j = 0; j < arrayList.size(); j++) {
                if(!isBe[arrayList.get(j)]){
                    isBe[arrayList.get(j)] = true;
                    counter++;
                }
            }
        }
        return counter==sizeOfMatrix;
    }


    public int getSizeOfMatrix() {
        return sizeOfMatrix;
    }
}
