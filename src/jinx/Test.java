package jinx;
public class Test {
    public static void main(String[] args) {
        int[] array = new int[]{10,15,12,9,7};
        int temp = 0;
        int sum = 0;
        for(int a:array){
            if(a>=temp)
                temp = a;
            sum+= a;
        }
        System.out.print("数组求和结果为:"+sum);
        System.out.print("数组最大元素为:"+temp);
    }
}