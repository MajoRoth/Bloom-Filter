import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class main {
    public static void main(String args[]){
        /*
         * setting the constants as in the example in the task
         */
    	
    	String[] input_to_insert = read_file("C:\\Users\\idoloven\\desktop\\all.txt");
        int N = input_to_insert.length;
    	int m = 32*N;
        int k = 13;
        
        /*
         * creating the table and inserting the elements
         */
        BelongTable t = new BelongTable(m, k);
        for(int i=0; i<N; i++) {
        	t.add_element(input_to_insert[i]);
        }
        
        
        String[] input_to_check = read_file("C:\\Users\\idoloven\\desktop\\evens.txt");
        for(int j=0; j<input_to_check.length; j++) {
            System.out.println(t.is_belong(input_to_check[j]));
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
