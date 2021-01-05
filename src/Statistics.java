import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class Statistics {

    public static void main(String[] args){
        /*
        String[] add = {"banana", "apple", "strawberry", "kiwi", "watermelon", "melon", "orange"};
        String[] test = {"cow", "sheep", "chicken"};
        */
        false_positive_send_arrays(1000000, 13, 120000, 0.2);


    }
    private static void false_positive_send_arrays(int m, int k, int N, double t){
        /*
        m - size of table
        k - number of hash functions
        N - size of all elements generated
        t - ratio of elements that will be send to test 0<test<1
         */

        String[] add = new String[(int)(N*(1-t))];
        String[] test = new String[(int)(N*t)];
        int j=9;
        for (int i=0; i<N*(1-t); i++){
            add[i] = Integer.toString(j*i);
        }
        int b = (int)(N*(1-t)+1);
        for (int i=0; i< N*t; i++, b++){
            test[i] = Integer.toString(j*b);
        }

        System.out.println(false_positive(m, k, add, test));


    }

    private static double false_positive(int m, int k, String[] add, String[] test){
        /*
            m - size of the table
            k - the number of hash functions
            add - strings to add
            test - string to test
            note it is critical that add-test=phi.
            return: the ratio of false_positive to all strings tested
         */
        BelongTable t = new BelongTable(m, k);
        for(int i=0; i<add.length; i++) {
            t.add_element(add[i]);
        }

        int counter = 0;
        for(int i=0; i<test.length; i++) {
            if (t.is_belong(test[i])) {
                counter++;
            }
        }
        return ((double)counter)/test.length;
        }
}
