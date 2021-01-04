import java.util.Arrays;

public class BelongTable {

    private byte[] hash_table;
    private HashFunc[] hash_func_array;
    private int _m;
    private int _k;

    BelongTable(int m, int k) {
        /*
            Constructor of table
         */

        hash_table = new byte[m]; // Filled with zeros automatically

        hash_func_array = new HashFunc[k];
        for (int i = 0; i < k; i++) {
            hash_func_array[i] = new HashFunc(m);
        }
        _m = m;
        _k = k;
        System.out.println("Table Created");
    }

    public void add_element(String text) {
        /*
            Add elements to the table
            set 1 where hi sends the element
         */

        for (int i = 0; i < _k; i++) {
            hash_table[hash_func_array[i].get_index_string(text)] = 1;
        }
    }

    public boolean is_belong(String text) {
        /*
            return true if the element is in the table.
            there is som probability that true will be returned
            thus the element not in the table.
            you can see the full explanation in the Appendix q1, q2.
         */
        boolean flag = true;

        for (int i = 0; i < _k && flag; i++) {
            if (hash_table[hash_func_array[i].get_index_string(text)]==0){
                flag = false;
            }
        }
        return flag;
    }

    private void print_table(){
        /*
            USE FOR DEBUG PURPOSES ONLY.
         */
        for (int i=0; i<_m; i++){
            System.out.print(hash_table[i]+ " ");
        }
        System.out.print("\n");
    }
}