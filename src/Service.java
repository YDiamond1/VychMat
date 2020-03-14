import java.io.*;
import java.util.Scanner;

public class Service {
    public Service() { }

    public void serve(){
        
        Scanner scr = new Scanner(System.in);

        InputMatrix input = new InputMatrix();
        Matrix matr = null;

        while (true) {
            System.out.println("Which way are using for your input?\n 1.File\n 2.Console\n 3.Exit");
            int choice = Integer.parseInt(scr.nextLine());
            try {
                if (choice == 1) {
                    System.out.println("Enter full path to the file");
                    String file = scr.nextLine();

                    input.setReader(new BufferedReader(new FileReader(file)));
                    input.setIsfile(true);
                } else if(choice == 3){
                    System.exit(0);
                }else {
                    input.setReader(new BufferedReader(new InputStreamReader(System.in)));

                }
                input.input();
                matr=input.getMatr();
                if(matr.hasDiagPredominance()){
                    matr.permutaion();
                    Iteration itera = new Iteration(matr);
                    Answer answer=itera.calculation();
                    answer.print();
                }
                else{
                    System.out.println("No diagonal predomince");
                }
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            } catch (IOException ex) {
                System.out.println("Something of Input have happened");
            } catch (InputMatrixException ex) {
                System.out.println("No enough elements. Enter a matrix again");
            } catch (NumberFormatException ex){
                System.out.println("Wrong format of data. Enter a matrix again");
            }

        }
    }
}
