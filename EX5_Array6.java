import java.sql.SQLOutput;
import java.util.Scanner;
class EX5_Array6 {
    Scanner in = new Scanner(System.in);
    int n;
    int[][] array;
    public static void main(String[] args){
        EX5_Array6 obj = new EX5_Array6();

        obj.inputSize();
        obj.getMatrix();
    }

    int inputUi(String UI){
        System.out.print(UI);
        return in.nextInt();
    }

    int inputSize(){ n = inputUi("N: "); return n; }

    void createArray(){
        array = new int[n][n];
    }
    void getMatrix(){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j){
                    System.out.print(1 + "\t");
                }else {
                    System.out.print(0 + "\t");
                }
            }
            System.out.println();
        }
    }

}
