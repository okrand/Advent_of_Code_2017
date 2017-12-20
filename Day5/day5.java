import java.io.*;
import java.util.*;

public class day5
{   
	// Part 1
	public static void main(String[] args){
		String fileName = "input.dat";
		String line = null;
		int result = 0;
		int iter = 0;
		List<Integer> nums = new ArrayList<Integer>();
		try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            line = bufferedReader.readLine();
            while (line != null){
            	nums.add(Integer.parseInt(line));
            	//nums.get(index);
            	line = bufferedReader.readLine();
            }   
            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");      
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        // arrayList populated
        int arraySize = nums.size();
        while (iter >= 0 || iter < arraySize){
        	int nextMove = nums.get(iter);
        	if (nextMove >= 3)
        		nums.set(iter, nextMove-1);
        	else
        		nums.set(iter, nextMove+1);
        	iter = iter + nextMove;
        	result++;
        	System.out.println("result is " + result);
        	// The number of moves will be displayed when the program crashes due to out of bounds error
        }


	}
}