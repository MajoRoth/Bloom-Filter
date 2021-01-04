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
        int N = 100000;
        int M = (int)(0.2*N);
        int m = 1000000;
        String[] add = new String[N];
        String[] test = new String[M];
        int j=9;
        for (int i=0; i<N; i++){
            add[i] = Integer.toString(j*i);
        }
        int k = N+1;
        for (int i=0; i< M; i++, k++){

            test[i] = Integer.toString(j*k);
        }

        System.out.println(false_positive(m, 13, add, test));
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
