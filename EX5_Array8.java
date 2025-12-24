import java.util.Scanner;
class EX5_Array8 {
    Scanner in = new Scanner(System.in);
    int n;
    int[][] data;
    double[][] dataAvg;

    public  static void main(String[] args){
        EX5_Array8 obj = new EX5_Array8();

        obj.inputSize();
        obj.createArray();
        obj.randomData();
        obj.calculateAvgData();
        obj.result();
    }

    int inputUi(String UI){
        System.out.print(UI);
        return in.nextInt();
    }

    int inputSize(){ n = inputUi("N: "); return n;}

    void createArray(){
        data = new int[n][n];
        dataAvg = new double[n][n];
    }

    void randomData(){
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = (int)(Math.random() * 10 + 1);
            }
        }
    }

    void calculateAvgData(){
        int i, j;
        for ( i = 0; i < dataAvg.length; i++) {
            double sum = 0;
            for ( j = 0; j < dataAvg[i].length; j++) {
                sum += data[i][j];
            }
            dataAvg[i][i] = sum / n;
        }
    }

    void result(){
        System.out.println("\nDATA :");
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("\nDATAAVERAGE :");
        for (int i = 0; i < dataAvg.length; i++) {
            for (int j = 0; j < dataAvg[i].length; j++) {
                if (dataAvg[i][j] > 0) System.out.printf("%.1f\t", dataAvg[i][j]);
                else System.out.printf("%.0f\t", dataAvg[i][j]);
            }
            System.out.println();
        }
    }


}
