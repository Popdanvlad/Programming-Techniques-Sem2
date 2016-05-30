import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
	private int[] sir=new int[20];
	int i=0;
	public ReadFile(){
		// The name of the file to open.
        String fileName = "temp.txt";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
        	FileReader fr = new FileReader("text.txt");

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fr);

            while((line = bufferedReader.readLine()) != null) {
                sir[i]=Integer.parseInt(line);
                i++;
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
    }
	public int[] getSir() {
		return sir;
	}
	public void setSir(int[] sir) {
		this.sir = sir;
	}
}
