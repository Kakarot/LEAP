package save;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class LoadState {
static ArrayList<String> loadData = new ArrayList<String>();
		
    
    /**
	 * Load's the owner's account information
     * @throws IOException 
	 */
	static public List<String> readSave() throws IOException{

		
	BufferedReader br = new BufferedReader(new FileReader("Balance.dat"));
    try {
       
        String line = br.readLine();

        while (line != null) {
            loadData.add(line);
            line = br.readLine();
        }
      
    } finally {
        br.close();
    }
	
	return loadData;
		}//end readSave method
	
	
}
