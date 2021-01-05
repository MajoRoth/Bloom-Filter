import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class Statistics {

    public static void main(String[] args){
        int m = 1000000, k = 13, N = 120000;
        double t = 0.2;
        System.out.println("m: " + m + " k: " + k +" N: " + N + " t: " + t);
        System.out.println("Experimental Value: "+false_positive_send_arrays(m, k, N, t));
        System.out.println("Mathematical Value: " + calculate_theoretical_value(m, k, (int)(N*(1-t))));


    }
    private static double false_positive_send_arrays(int m, int k, int N, double t){
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

        return false_positive(m, k, add, test);
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

        private static double calculate_theoretical_value(int _m, int _k, int _N){
            double m = (double)_m;
            double k = (double)_k;
            double N = (double)_N;

            double t1 = Math.pow((m-1)/m, N*k);
            double t2 = Math.pow(1-t1, k);
            return t2;
        }
}
