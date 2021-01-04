import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class main {
    public static void main(String args[]){
        /*
         * When running the main specify 4 arguments.
         * first argument - file path of elements to insert to the data structure.
         * second argument - file path of elements to check.txt if they are belong to the data structure.
         * third argument - m, the size of the array.
         * fourth argument - k, the number of hash functions.
         * setting the constants as in the example in the task.
         */
    	String[] input_to_insert = read_file(args[0]);
        int N = input_to_insert.length;
    	int m = Integer.parseInt(args[2]);
        int k = Integer.parseInt(args[3]);

        /*
         * creating the table and inserting the elements
         */
        BelongTable t = new BelongTable(m, k);
        for(int i=0; i<N; i++) {
        	t.add_element(input_to_insert[i]);
        	System.out.println("added " + input_to_insert[i]);
        }
        
        
        String[] input_to_check = read_file(args[1]);
        for(int j=0; j<input_to_check.length; j++) {
            System.out.println(input_to_check[j] + " belong: " + t.is_belong(input_to_check[j]));

        }
    }
        
    
    
    private static String[] read_file(String path) {
    	/*
         * receiving input from a file
         */
    	String file = "";
        try(BufferedReader in = new BufferedReader(new FileReader(path))) {
            String str;
            while ((str = in.readLine()) != null) {
            	file += str;
            }
        }
        catch (IOException e) {
            System.out.println("File Read Error");
        }
        
        /*
         * converting the comma-separated values to a String array
         */
        String[] input = file.split(",");
        return input;
    	
    }
    }
