import java.sql.SQLOutput;
import java.util.Scanner;
class EX5_Array7 {
    Scanner in = new Scanner(System.in);

    int m, n;
    int[][] matrixA, matrixAt;

    public static void main(){
        EX5_Array7 obj = new EX5_Array7();

        obj.inputRaw();
        obj.inputColumn();
        obj.createArray();

        obj.getMatrixRand();

        obj.result();
    }

    int inputUi(String UI){
        System.out.print(UI);
        return in.nextInt();
    }

    int inputRaw(){ m = inputUi("M: "); return m;}
    int inputColumn(){ n = inputUi("N: "); return n;}

    void createArray(){
        matrixA = new int[m][n];
        matrixAt = new int[n][m];
    }

    void getMatrixRand(){
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrixA[i][j] = (int)(Math.random() * 10 + 1);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrixAt[j][i] = matrixA[i][j];
            }
        }
    }

    void print(String name, int[][] x){
        System.out.printf("\n%s\n", name);
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                System.out.print(x[i][j] + "\t");
            }
            System.out.println();
        }
    }

    void result(){
        print("A", matrixA);
        print("At", matrixAt);
    }
}
