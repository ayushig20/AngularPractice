public class DesignPatternPractice {

    boolean foo(char c){
         int i=0;
        System.out.print(c);
        return true;
    }
    static public final void main(String[] arg) {
        int i=012;
        System.out.println(i);
        int odd = 5/2;
        System.out.println(odd);
        Object fa= new float[5];
        int[] ca[]= {{4,5,6},{7,8,9}};
        byte b=10;
        System.out.println(m1(b,3));
    }

    static double m1(byte x,double y){
        return (long)x/y*2;
    }

}
interface i{
    void m1();

}