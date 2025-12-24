import java.util.Scanner;

class Week7_Array1_method{
    Scanner in = new Scanner(System.in);

    String[] name;
    StringBuilder[] str;
    double[] weight, height, bmi;
    double[] max, min, sum, avg;
    char[] size;
    int n, s = 0, m = 0, l = 0, x = 0;
    
    public static void main(String[] args) {
        Week7_Array1_method obj = new Week7_Array1_method();
        //Input 
        obj.inputSize();
        obj.createArray();
        obj.setDefault();
        obj.readData();

        //Process
        obj.allCalculate();

        //Output
        obj.printData();
        obj.printSize();
    }

    String inputUi(String UI){
        System.out.print(UI);
        return in.next();
    }
    
    //--------------------------Intput-------------------------------
    void inputSize(){
        n = Integer.parseInt(inputUi("Input Size Index: "));
    }
    
    void createArray(){
        name = new String[n];
        weight = new double[n];
        height = new double[n];
        bmi = new double[n];
        size = new char[n];
        max = new double[3];
        min = new double[3];
        sum = new double[3];
        avg = new double[3];
        str = new StringBuilder[4];
    }

    void setDefault(){
        for (int i = 0; i < 3; i++) {
            max[i] = Double.MIN_VALUE;
            min[i] = Double.MAX_VALUE;
            sum[i] = 0;
        }

        for (int i = 0; i < 4; i++) {
            str[i] = new StringBuilder();
        }
    }

    void readData(){
        for (int i = 0; i < n; i++) {
            name[i] = inputUi("Name: ");
            weight[i] = Double.parseDouble(inputUi("Weight: "));
            height[i] = Double.parseDouble(inputUi("Height: "));
        }
    }
    //---------------------Process-----------------------------------

    void allCalculate(){
        calculateBmi();
        setSize();
        findMaxMin();
        calculateSum();
        calculateAverage();
    }

    void calculateBmi(){
        for (int i = 0; i < n; i++) {
            bmi[i] = weight[i] / Math.pow(height[i] * 0.01, 2);
        }
    }

    void setSize(){
        for (int i = 0; i < n; i++) {
            if (bmi[i] < 18.6) {
                size[i] = 'S';
                s++;
                str[0].append(name[i]).append(",");
            } else if (bmi[i] < 23.0) {
                size[i] = 'M';
                m++;
                str[1].append(name[i]).append(",");
            } else if (bmi[i] <= 27.5) {
                size[i] = 'L';
                l++;
                str[2].append(name[i]).append(",");
            } else {
                size[i] = 'X';
                x++;
                str[3].append(name[i]).append(",");
            }
        }
    }

    void findMaxMin(){
        for (int i = 0; i < n; i++) {
            max[0] = Math.max(max[0], weight[i]);
            max[1] = Math.max(max[1], height[i]);
            max[2] = Math.max(max[2], bmi[i]);

            min[0] = Math.min(min[0], weight[i]);
            min[1] = Math.min(min[1], height[i]);
            min[2] = Math.min(min[2], bmi[i]);
        }
    }
    
    void calculateSum(){
        for (int i = 0; i < n; i++) {
            sum[0] += weight[i];
            sum[1] += height[i];
            sum[2] += bmi[i];
        }
    }

    void calculateAverage(){
        for (int i = 0; i < 3; i++) {
            avg[i] = sum[i] / n;
        }
    }

    //-------------------------------------------------Output----------------------------------------------------------
    void printData(){
        System.out.printf("%-10s%10s %-10s%6s %s\n", "Name", "Weight", "Height", "BMI", "SIZE");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-10s%10.2f %-10.0f%6.2f %c\n", name[i], weight[i], height[i], bmi[i], size[i]);
        }

        System.out.printf("%-10s%10.2f %-10.0f%6.2f\n", "MAX", max[0], max[1], max[2]);
        System.out.printf("%-10s%10.2f %-10.0f%6.2f\n", "MIN", min[0], min[1], min[2]);
        System.out.printf("%-10s%10.2f %-10.2f%6.2f\n", "Arerage", avg[0], avg[1], avg[2]);
    }

    void printSize(){
        for(int i = 0; i < 4; i++){
            if(str[i].length() > 0) str[i].setLength(str[i].length() - 1);
        }
        System.out.printf("%s%-7d\"%s\"\n", "S:", s, str[0].toString());
        System.out.printf("%s%-7d\"%s\"\n", "M:", m, str[1].toString());
        System.out.printf("%s%-7d\"%s\"\n", "L:", l, str[2].toString());
        System.out.printf("%s%-7d\"%s\"\n", "X:", x, str[3].toString());
    }
    
}
