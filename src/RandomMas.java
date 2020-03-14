import java.util.Random;

public class RandomMas {
    private int sizeOfMatrix;
    private Random random;
    public RandomMas(int sizeOfMatrix) {
        this.sizeOfMatrix = sizeOfMatrix;
        this.random = new Random(System.currentTimeMillis());
    }
    public double[] getMas(){
        double[] temp = new double[sizeOfMatrix];
        for (int i = 0; i < sizeOfMatrix; i++) {
            temp[i] = random.nextDouble()*100;
        }
        return temp;
    }
    public double[][] get2DMas(){
        double[][] temp = new double[sizeOfMatrix][sizeOfMatrix];
        for (int i = 0; i < sizeOfMatrix; i++) {
            temp[i][i] = random.nextDouble()*201-100;
        }
        for (int i = 0; i < sizeOfMatrix; i++) {
            for (int j = 0; j < sizeOfMatrix; j++) {
                if(i!=j){
                    temp[i][j] = random.nextDouble()*Math.abs(temp[i][i]*2/sizeOfMatrix)-Math.abs(temp[i][i]/sizeOfMatrix);
                }
            }
        }
        return temp;
    }
}
