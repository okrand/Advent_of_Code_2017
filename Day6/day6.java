import java.io.*;
import java.util.*;

public class day6
{   
	public static void main(String[] args){
		String fileName = "input.dat";
		String line = null;
        int result = 0;
		try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            line = bufferedReader.readLine();

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

        // Part 1
        String[] nums_str = line.split("\\s+");
        int[] nums = new int[nums_str.length];
        for (int i = 0; i < nums_str.length; ++i){
            nums[i] = Integer.parseInt(nums_str[i]);
        } //convert string array to integer
        String inputString = line;
        List<String> check = new ArrayList<String>();
        while(check.contains(inputString) == false){
            check.add(inputString);
            result++;
            int index_max = -1;
            int max = -1;
            //Find the largest integer and its index
            for (int i = 0; i < nums.length; ++i){
                if (nums[i] > max){
                    index_max = i;
                    max = nums[i];
                }
            }
            nums[index_max] = 0;
            int index = index_max;
            while (max > 0){
                if (index == nums.length - 1)
                    index = 0;
                else
                    index += 1;
                nums[index]++;
                max--;
                System.out.println(nums[index]);
            }
            inputString = "";
            for (int i = 0; i < nums.length; ++i){
                inputString += String.valueOf(nums[i]);
            }
            System.out.println("outer loop");
        }
        System.out.println(result - check.indexOf(inputString)); 
        System.out.println(result);
	}
}
