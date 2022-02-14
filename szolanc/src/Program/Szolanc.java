package Program;

import java.util.*;

/**
 * A Szóláncot megvalósító osztály
 */
public class Szolanc {
    /**
     * A bemenetet tároló tömb
     */
    public ArrayList<String> inputStrings = new ArrayList<>();
    /**
     * A kimenetet tároló tömb
     */
    private ArrayList<String> output = new ArrayList<>();

    /**
     * Ez a metódus végzi a beolvasást a bemenetről
     */
    public void Setup(){
        var scanner = new Scanner(System.in);
        inputStrings.addAll(List.of(scanner.nextLine().split(" ")));
    }

    /**
     * Ezzel a metódussal futtatható az algoritmus
     */
    public ArrayList<String> Run(){
        Collections.sort(inputStrings);
        algo(inputStrings.get(0), new ArrayList<>(inputStrings));
        if (output.isEmpty()){
            System.out.println("hiba: a megadott szavakból nem lehetséges szóláncot építeni!");
        } else {
            System.out.println(output);
        }
        return output;
    }

    /**
     *  Rekurzív algoritmus ami a láncolást valósítja meg
     * @param nextStr A következőnek kiválasztott elemet adjuk itt át
     * @param list A szűkített listát adjuk tovább a rekurzióba, amiben nem szerpel a már kiválasztott elem
     * @return 0 - ha minden elem elfogyott a listábol, 1 - ha végig értünk a listán de még maradt elem benne, ekkor a rekurzióba előtte lévő ciklus tovább folytatja a keresést.
     */
    private int algo(String nextStr, ArrayList<String> list){
        output.add(nextStr);
        list.remove(nextStr);
        for (var str : list){
            if (differenceBetweenTwoString(nextStr, str) == 1){
                if (algo(str, new ArrayList<>(list)) == 0)  return 0;
            }
        }
        if (list.isEmpty()) return 0;

        output.remove(nextStr);
        return 1;
    }

    /**
     * Két Stringet vizsgál, hogy hány karakterben térnek el egymástól
     * @param str1 az első String
     * @param str2 a második String
     * @return A visszatérések száma
     */
    public int differenceBetweenTwoString(String str1, String str2) {
        var charCount1 = new int[10000];
        var charCount2 = new int[10000];
        Arrays.fill(charCount1, 0);
        Arrays.fill(charCount2, 0);


        for (var c : str1.toCharArray())
            charCount1[c - '0']++;

        for (var c : str2.toCharArray())
            charCount2[c - '0']++;

        var count = 0;
        for (int i = 0; i < 10000; i++)
            count += (Math.min(charCount1[i], charCount2[i]));

        return str1.length() > str2.length() ? str1.length() - count : str2.length() - count;
    }

}
