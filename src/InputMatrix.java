
import java.io.BufferedReader;
import java.io.IOException;



public class InputMatrix {

    private int sizeOfMatrix;
    private BufferedReader reader;
    private Matrix matr;
    private boolean isfile = false;

    public void setIsfile(boolean isfile) {
        this.isfile = isfile;
    }

    public void input() throws IOException, InputMatrixException, NumberFormatException {
        if(!isfile) {
            System.out.println("Choice variant of input\n 1.Random numbers\n 2.Your numbers");

            int choice = Integer.parseInt(reader.readLine().replace("\n", "").replace(" ", ""));
            if (choice == 1) {
                inputR();
            }
            else{
                inputY();
            }
        }else{
            inputY();
        }
    }

    private void inputR() throws NumberFormatException, IOException {

        System.out.println("Enter size of matrix");
        int size = Integer.parseInt(reader.readLine().replace("\n", "").replace(" ", ""));
        RandomMas randomMas = new RandomMas(size);
        double[][] A = randomMas.get2DMas();
        double[] B = randomMas.getMas();
        matr = new Matrix(A);
        matr.setB(B);
        print(A, "A");
        print(B, "B");
        System.out.println("Enter EPS");
        matr.setEps(Double.parseDouble(reader.readLine().replace(" ", "").replace("\n", "")));
    }

    public void inputY() throws IOException, NumberFormatException, InputMatrixException {

        if(!isfile)System.out.println("Enter size of matrix");
        String size = reader.readLine().replace(" ","").replace("\n", "");
        sizeOfMatrix = Integer.parseInt(size);
        if (!isfile)System.out.println("Enter your matr");
        matr = getMatrix();
        if (!isfile)System.out.println("Enter your free matrix elements");
        matr.setB(getB());
        if (!isfile) System.out.println("Enter your eps");
        matr.setEps(Double.parseDouble(reader.readLine()));
        if(isfile){
            print(matr.getA(), "A");
            print(matr.getB(), "B");
        }
    }

    public int getSizeOfMatrix() {
        return sizeOfMatrix;
    }

    public void setSizeOfMatrix(int sizeOfMatrix) {
        this.sizeOfMatrix = sizeOfMatrix;
    }

    public InputMatrix() { }



    private double[] getB()throws InputMatrixException, IOException{
        double[] B = new double[sizeOfMatrix];
        String[] line = getMas();
        int j = 0;
        for (String value:line){
            B[j] = Double.parseDouble(value);
            j++;
        }
        return B;
    }

    public Matrix getMatrix() throws IOException, InputMatrixException, NumberFormatException{
        double[][] temp = new double[sizeOfMatrix][sizeOfMatrix];
        for (int i =0 ; i < sizeOfMatrix; i++){
                String[] line = getMas();
                int j=0;
                for (String value : line) {
                    temp[i][j] = Double.parseDouble(value);
                    j++;
                }
        }
        return new Matrix(temp);
    }
    private String[] getMas() throws InputMatrixException, IOException{
        String[] line = reader.readLine().split(" ");
        if(line.length!= sizeOfMatrix){
            throw new InputMatrixException("wrong number of elements");
        }
        return line;
    }

    public BufferedReader getReader() {
        return reader;
    }

    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }

    public Matrix getMatr() {
        return matr;
    }
    void print(double[] p, String name){
        System.out.print(name+" {");
        for (double value:p
        ) {
            System.out.print(value+ " ");
        }
        System.out.println("}");
    }
    void print(double[][] p, String name){
        System.out.print(name+" ={");
        for (double[] value:p
             ) {
            print(value,"");
        }
        System.out.println("}");
    }
}
