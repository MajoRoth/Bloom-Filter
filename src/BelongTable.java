import java.util.Arrays;

public class BelongTable {

    BelongTable(int m, int k){
        /*
            Constructor of table
         */

        int hash_table[] = new int[m];
        Arrays.fill(hash_table, 0);
        
        HashFunc hash_func_array[] = new HashFunc[k];
        for (int i=0; i<k; i++){
            hash_func_array[i] = new HashFunc();
    }

    public void add_element(int element){
        /*
            Add elements to the table
            set 1 where hi sends the element
         */
    }

    public boolean is_belong(int element){


    }

    private
}
