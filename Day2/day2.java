import java.io.*;

public class day2
{   
	public static void main(String[] args){
		String fileName = "input.dat";
		String line = null;
		int result = 0;
		try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            line = bufferedReader.readLine();
            while (line != null){
	            String[] str_numbers = line.split("\\s+");
	            //result += getDifference(str_numbers); This is for part 1
	            result += getDivisible(str_numbers);
	            line = bufferedReader.readLine();
        	}
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        System.out.println("Result is " + result);
    }

    public static int getDivisible(String[] str_nums){
    	for (int i = 0; i < str_nums.length; i++){
    		for (int j = 0; j < str_nums.length; j++){
    			if (i != j){
    				if (Integer.parseInt(str_nums[i]) % Integer.parseInt(str_nums[j]) == 0)
    					return Integer.parseInt(str_nums[i]) / Integer.parseInt(str_nums[j]);
    			}
    		}
    	}
    	return -999999999;
    }

    public static int getDifference(String[] str_nums){
    	int min, max;
    	min = max = Integer.parseInt(str_nums[0]);
    	for (int i = 1; i < str_nums.length; i++){
    		if (Integer.parseInt(str_nums[i]) > max)
    			max = Integer.parseInt(str_nums[i]);
    		if (Integer.parseInt(str_nums[i]) < min)
    			min = Integer.parseInt(str_nums[i]);
    	}
    	return max - min;
    }
}