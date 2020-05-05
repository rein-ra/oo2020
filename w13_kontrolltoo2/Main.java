import java.util.HashMap;

/*
    Main meetod
*/

public class Main {
    public static void main(String[] args) throws Exception{

        //String, mis tuleb failist
        String fromFile = FileRead.fileToString();

        //Järjestatud HashMap, mis on tulemuseks
        HashMap<Character, Integer> result = CharacterOperations.lastChar(fromFile); 
        
        //Kuvab tulemuse konsooli
        System.out.println("Tekstis esineb järgmiseid karaktereid sõnade viimaste karakteritena(karakter=esinemiskogus): " +result);
    }
}