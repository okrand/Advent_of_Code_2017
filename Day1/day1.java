import java.io.*;

public class day1
{   
	public static void main(String[] args){
		String fileName = "input.dat";
		String line = null;
		String captcha = "";
		try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            line = bufferedReader.readLine();
            while(line != null) {
                captcha += line;
                line = bufferedReader.readLine();
            }   
            // Always close files.
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
        //captcha += captcha.charAt(captcha.length() - 1); This is for the first part
        System.out.println(captcha + "\n\n");
        int result = getSum(captcha);
        System.out.println("result is " + result);
	}

	public static int getSum(String captcha){
		int result = 0;
		int num1, num2;
		// This was for the first part
		// for (int x = 1; x < captcha.length(); ++x){
		// 	num1 = Character.getNumericValue(captcha.charAt(x-1));
		// 	 num2 = Character.getNumericValue(captcha.charAt(x)); 
		// 	if (num1 == num2)
		// 		result += num1;
		// }
		
		// Second part
		int increment = captcha.length() / 2;
		for (int x = 0; x < captcha.length()/2; ++x){
			num1 = Character.getNumericValue(captcha.charAt(x));
			num2 = Character.getNumericValue(captcha.charAt(x + increment)); 
			if (num1 == num2)
				result += num1;
		}
		result *= 2;
		return result;
	}
}
