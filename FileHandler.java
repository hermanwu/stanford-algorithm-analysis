import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Herman on 7/26/2015.
 */
public class FileHandler {
    public String filepath;


    public FileHandler(String filepath){
        this.filepath = filepath;
    }

    public FileReader getFileReader() throws FileNotFoundException {
        return new FileReader(this.filepath);
    }

    public int[] convertToArray(){
        List<Integer> returnList = new ArrayList<Integer>();
        try(BufferedReader br = new BufferedReader(getFileReader())){
            String line;
            while ((line = br.readLine()) != null) {
                returnList.add(Integer.parseInt(line));
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        int[] returnArray = new int[returnList.size()];
        for (int i = 0; i < returnArray.length; i++){
            returnArray[i] = returnList.get(i);
        }
        return returnArray;
    }

}
