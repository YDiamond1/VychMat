import java.util.ArrayList;

public class Iteration {

    private int counterIterations;
    private Matrix temp;
    private double[] X;

    public Iteration(Matrix matrix){
        temp = matrix;
        counterIterations = 0;
        X = new double[matrix.getSizeOfMatrix()];
        double[] b = matrix.getB();
        int sizeOfMatrix = matrix.getSizeOfMatrix();
        for (int i=0;i<sizeOfMatrix;i++) {
            X[i] = b[i];
        }
    }

    public Answer calculation(){

        Answer answer = new Answer();
        int sizeOfMatrix = temp.getSizeOfMatrix();
        double[] B = temp.getB();
        double[][] A = temp.getA();


        double maxEps = 0;
        do {
            double[] tempX = new double[sizeOfMatrix];
            double[] EpsArray = new double[sizeOfMatrix];
            double maxEpsLine = 0;
            for (int i=0; i<sizeOfMatrix; i++){
                tempX[i] = B[i]/A[i][i];
                for(int j=0;j<sizeOfMatrix;j++){
                    if(i!=j){
                        tempX[i]+=(-1)*A[i][j]*X[j]/A[i][i];
                    }
                }
                EpsArray[i] = Math.abs(tempX[i]-X[i]);
                maxEpsLine = Math.max(maxEpsLine, EpsArray[i]);
            }

            X = tempX.clone();
            answer.addX(X.clone());
            answer.addEps(EpsArray.clone());
            maxEps = maxEpsLine;
            ++counterIterations;

        }while (maxEps-temp.getEps()>0);
        return answer;

    }
}
