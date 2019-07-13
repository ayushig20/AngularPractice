/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/
//import for Scanner and other utility classes
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        Integer testCases = Integer.parseInt(s.nextLine());
         boolean hori = Boolean.FALSE;
        boolean verti = Boolean.FALSE;
        for(int i = 1; i <= testCases && testCases<=500; i++ ){
            Integer cases = Integer.parseInt(s.nextLine());

            String[] horArr = new String[cases];
            for(int j = 0  ; j < cases; j++){
                horArr[j] = s.nextLine();
            }

            for(int j = 0 ; j < horArr.length; j++ ) {
                if(horArr[j].equals(horArr[horArr.length-j-1])){
                    hori = Boolean.TRUE;
                    continue;
                }else {
                    hori = Boolean.FALSE;
                    break;
                }
            }

            for(int j = 0 ; j < horArr.length; j++ ) {
                StringBuilder sb = new StringBuilder(horArr[j]);
                if(horArr[j].equals(sb.reverse().toString())){
                    verti = Boolean.TRUE;
                    continue;
                }else{
                    verti = Boolean.FALSE;
                    break;
                }
            }

            if(hori && verti){
                System.out.println("BOTH");
            }else if( hori ){
                System.out.println("HORIZONTAL");
            }else if( verti ){
                System.out.println("VERTICAL");
            }else {
                System.out.println("NO");
            }
        }

     }
}
