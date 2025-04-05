package src.main.java;

import jdk.jfr.Frequency;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Four phases of text processing to do. Write a method for each one.
 *
 * public void print()  - write a method that reads the contents of a file, line by line, and creates a String object,
 * making sure all the newlines are preserved. use BufferedReader to do the reading.
 *
 * For the sake of this lab, words are not and do not have punctuation.
 *
 * public WCResult wc(String input)
 * commonly called "wc"; count the number of characters in a file, number of words, number of lines.
 * Returns an object of class WCResult (a POJO) which consists of the three longs you counted.
 *
 * public FrequencyMap wordFrequency(String input)
 * word count. words in a file, produce a map with (String word, Long numOfTimes). FrequencyMap returning a HashMap might be what you're
 * looking for here, or maybe something else.
 *
 * public FrequencyMap letterFrequency(String input)
 * letter frequency, write a program that collects the frequency of each letter within the input.
*/

public class WordForWord {

    // You'll need to setup some instance variables for the phases of processing
    // you need to do on the text in the file(s).
    // And where SHOULD those POJO classes go? Inner classes? Separate public classes?
    // The decision depends on how you envision using the methods in this class.


    public static void main(String[] args) throws IOException {

        WordForWord wfw = new WordForWord();

        wfw.loadFile("testdata1.txt");

        wfw.processAll();

       // System.out.println(wfw.toString());
        BufferedReader reader = new BufferedReader(new FileReader("testdata/testdata3.txt"));

       // String read = wfw.wc(reader).toString();
//        System.out.println("this" +wfw.letterFrequency(String.valueOf(reader)));
//        System.out.println("that" +wfw.wordFrequency(String.valueOf(reader)));


        wfw.print();
    }

    public String toString() {
       return ""; // create a brief report on what you found out about the file contents.
    }

    private void processAll() {
    }

    private void loadFile(String file) {
    }

    public void print() throws IOException {
        String line;
        BufferedReader reader = new BufferedReader(new FileReader("testdata/testdata3.txt"));
        while ((line = reader.readLine()) != null){
            letterFrequency(line);
            wordFrequency(line);
           // System.out.println(line);
        }
    }

    public <WCResult> WCResult wc(BufferedReader reader) throws IOException {
        List<Long> obj = new ArrayList<>();
        String line;
        Long countLines = 0L;
        Long countWords = 0L;
        Long countChars = 0L;
        while ((line = reader.readLine()) != null){
            countLines++;
            countWords += (long) + line.split(" ").length;
            for (String s: line.split("")){
                countChars += s.length();
            }
        }

        obj.add(countWords);
        obj.add(countLines);
        obj.add(countChars);
    return (WCResult) obj;
    }

    public HashMap wordFrequency(String input){
        HashMap<String, Long> newMap = new HashMap<>();
        String newInput = input.replaceAll("[^a-zA-z]", " ");
        String[] newArr = newInput.split(" ");
        String current="";
        Long count = 0l;
        for (int i = 0; i < newArr.length; i++) {
            for (int j = 0; j < newArr.length; j++) {
                if (newArr[j].equals(newArr[i])){
                    current = newArr[j];
                    count++;
                }
            }
            newMap.put(current, count++);
        }
        System.out.println("wordFrequency" +newMap);
        return newMap;
    }


    public HashMap letterFrequency(String input){
        String newStr = input.replace(" ", "");
        HashMap<Character, Long> newMap = new HashMap<>();
//       if (input == null || input.trim().isEmpty()) {
//        throw new IllegalArgumentException("String cannot be empty or null");
//    }
        String newInput = input.replaceAll("[^a-zA-z]", "").toLowerCase();
        for (char c : newInput.toCharArray()) {
            newMap.put(c, newMap.getOrDefault(c, 0L) + 1);
        }
         System.out.println("letterFrequency" +newMap);
        return newMap;

    }

    public double frequency(String word){
        HashMap<Character, Long> newMap = new HashMap<>();
//       if (input == null || input.trim().isEmpty()) {
//        throw new IllegalArgumentException("String cannot be empty or null");
//    }
        //double num =
        String newInput = word.replaceAll("[^a-zA-z]", "").toLowerCase();
        for (char c : newInput.toCharArray()) {
            newMap.put(c, newMap.getOrDefault(c, 0L) + 1);
        }
        System.out.println("letterFrequency" +newMap);
        return 0.0;

    }

}
