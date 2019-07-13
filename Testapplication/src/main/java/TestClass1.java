
import java.util.*;

class TestClass1 {
    public static void main(String args[] ) throws Exception {

        Scanner s = new Scanner(System.in);
        String[] Arr_query = s.nextLine().split(" ");
        Integer sizeArray = Integer.parseInt(Arr_query[0]);
        Integer queries = Integer.parseInt(Arr_query[1]);

        String[] A_Array = s.nextLine().split(" ");
        String[] B_Array = s.nextLine().split(" ");

        for(int i =1; i<=queries; i++ ){
            String[] query = s.nextLine().split(" ");
            Integer _type = Integer.parseInt(query[0]);
            Integer _LTerm = Integer.parseInt(query[1]);
            Integer _RTerm = Integer.parseInt(query[2]);

            int sum = 0;
            boolean _A_Process = false ;
            boolean _B_Process = false ;

            for(int j = _LTerm-1; j< _RTerm && _RTerm <= A_Array.length && _RTerm <= B_Array.length  ; j++){


                if( _type == 1 ){
                    if(!_A_Process) {
                        sum = sum + Integer.parseInt(A_Array[j]);
                        _A_Process = true;
                    }
                    else {
                        sum = sum + Integer.parseInt(B_Array[j]);
                        _A_Process = false ;
                    }
                }else if( _type == 2){
                    if(!_B_Process) {
                        sum = sum + Integer.parseInt(B_Array[j]);
                        _B_Process = true;
                    }
                    else {
                        sum = sum + Integer.parseInt(A_Array[j]);
                        _B_Process = false ;
                    }
                }
            }
            System.out.println(sum);

        }




    }
}
