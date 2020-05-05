import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
    Operatsioonid viimaste tähtedega
*/

public class CharacterOperations {
    public static ArrayList<Character> lastLetters = new ArrayList<>();
    public static HashMap<Character, Integer> unSorted = new HashMap<>();
    public static HashMap<Character, Integer> sorted = new HashMap<>();

    //Otsib välja iga sõna viimase karakteri ja lisab selle listi
    public static HashMap<Character, Integer> lastChar(String lines) {
        final ArrayList<Character> lastChar = new ArrayList<>();
        for (int i = 1; i < lines.length(); i++) {

            //Otsib tühikuid
            if (lines.charAt(i) == ' ') {
                if (lines.charAt(i - 1) == ','){ //kotrollib, kas eelmine karakter on kirjavahemärk
                }else if (lines.charAt(i - 1) == '.'){
                }else if (lines.charAt(i - 1) == ';'){
                }else if (lines.charAt(i - 1) == '!'){
                }else if (lines.charAt(i - 1) == '?'){
                }else{
                    Character current = lines.charAt(i - 1); //kui ei ole kirjavahemärk valib tühikust eelmise karakteri
                    lastChar.add(current); //lisab karakteri viimaste karakterite listi
                }
            }
        }
        //teistele fn-idele saadavaks tegemine
        lastLetters = lastChar;

        //järgmise fn-i käivitamine
        countChar(lastLetters);

        //klassi töö saatmine maini
        return sorted;
    }

    //loeb kokku, palju samasuguseid karaktereid on ja paneb karakteri koos kogusega mapi
    static void countChar(ArrayList<Character> toCount) {
        HashMap<Character, Integer> unsorted = new HashMap<>();

        //
        for (int i = 0; i < toCount.size(); i++) {
            
            Character CharToArray = toCount.get(i); //Jätab hetke karakteri mällu
            Integer totalInArray = unsorted.get(CharToArray); //Jätab hetke karakteri koguse mapis mällu

            //Kontroll
            if (unsorted.containsKey(CharToArray)) { //Kas juba on Mapis, kui on lisab endisele kogusele ühe
                Integer newTotal = unsorted.get(CharToArray);
                newTotal++;
                unsorted.put(CharToArray, newTotal);
            } else {
                totalInArray = 1;
                unsorted.put(CharToArray, totalInArray); //Kui Mapis pole ühtegi, lisab karakteri ja määrab koguseks ühe
            }
        }

        //teeb teistele fn-idele kätte saadavaks
        unSorted = unsorted;

        //kutsub järgmise fn-i
        sortChar(unsorted);
    }

    //sorteerib viimased tähed esinemis järjekorras
    static void sortChar(HashMap<Character, Integer> toSort) {
        List<Map.Entry<Character, Integer>> tempList = new LinkedList<Map.Entry<Character, Integer>>(toSort.entrySet());

        //võrdleb objekte
        Collections.sort(tempList, new Comparator<Map.Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character, Integer> obj1, Map.Entry<Character, Integer> obj2){
                return (obj2.getValue()).compareTo(obj1.getValue());
            }
        });
        HashMap<Character, Integer> temporarySorted = new LinkedHashMap<Character, Integer>();
        for (java.util.Map.Entry<Character, Integer> entry : tempList) {
            temporarySorted.put(entry.getKey(), entry.getValue()); 
        }
        
        //teeb teistele fn-idele kättesaadavaks
        sorted = temporarySorted;      
    }
}