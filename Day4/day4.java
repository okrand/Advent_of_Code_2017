import java.io.*;
import java.util.*;

public class day4
{   
	// Part 1
	public static void main(String[] args){
		String fileName = "input.dat";
		String line = null;
		int numlines = 0;
		int result = 0;
		try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            line = bufferedReader.readLine();
            while (line != null){
            	String[] words = line.split("\\s+");
            	List<String> match = new ArrayList<String>();
            	//System.out.println("The phrase size is " + words.length);
            	for (int i = 0; i < words.length; ++i){
            		//System.out.println("The word is " + words[i]);
            		words[i] = getSorted(words[i]);
            		if (match.contains(words[i]) == false){
            			match.add(words[i]);
            			//System.out.println("Not in match, match size is " + match.size());
            			
            		}
            		else{
            			//System.out.println("Found match");
            			result++;
            			break;
            		}
            	}
            	match.clear();
            	numlines++;
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
        System.out.println(numlines - result);
	}

	//Part 2
	public static String getSorted(String inputString){
		// convert input string to char array
        char tempArray[] = inputString.toCharArray();
         
        // sort tempArray
        Arrays.sort(tempArray);
         
        // return new sorted string
        return new String(tempArray);
	}
}