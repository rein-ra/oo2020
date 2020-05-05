import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
    Faili lugemine
*/

public class FileRead {
    public static String fileToString() throws Exception {

        //Avab faili
        InputStream fileInput = new FileInputStream("sampleTxt.txt");
        BufferedReader buffer = new BufferedReader(new InputStreamReader(fileInput));
        
        //Loeb read
        String line = buffer.readLine();
        StringBuilder createString = new StringBuilder();

        //Lisab iga rea lõppu "uue rea" ja järgmise rea sisu
        while(line != null){
            createString.append(line).append("\n");
            line = buffer.readLine();
        } 

        //Teeb loetud faili stringiks
        String fileOutput = createString.toString();
        buffer.close();

        //Saadab faili stringina tagasi Maini
        return fileOutput;
    }  
}