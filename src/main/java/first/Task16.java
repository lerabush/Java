package first;

public class Task16 {
    public static void main(String[] args){
        int a = 6;
        System.out.println(a);
        System.out.println(average(a,7));
    }
    public static double average(double value,double... values) {
        double sum = value;
        if(values.length==0) return sum;
        for (double v : values) sum += v;
        return  sum /(values.length+1);
    }
}
