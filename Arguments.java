import java.lang.reflect.Array;
import java.util.Arrays;

public class Arguments {

    public static void main(String[] args) {

        // Try arguments in java
        System.out.println(sum(1,2));
        System.out.println(sum(1,2,3,4));
        System.out.println(sum(1,2,-2,-4,1,2,45,1));
        System.out.println(sum(1));
        System.out.println(sum(new int[]{1,2,4,32,43}));



    }

    public static int sum(int ...args){
        int sum = 0;
        for(int i=0; i<args.length; i++){
            sum+=args[i];
        }
        return  sum;
    }
}
