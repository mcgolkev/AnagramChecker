package org.example;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
       Solution4();
    }


    public static void Solution4(){ // Anagram checker
        String a = "";  // is string a an anagram of string b?
        String b = "";
        String isAnagram = "Not an Anagram";  // default output - Not Anagrams

        a = "anagramrmm";  // set variables for testing
        b = "marganarmm";

        a = a.toLowerCase(Locale.ROOT);  // checker is case-insensitive, so each input is converted to lower case
        b = b.toLowerCase(Locale.ROOT);

        if(a == "" || b == "" || a == null || b == null){  // short circuit if input is empty or null
            System.out.println(isAnagram);
            return;
        }

        if(a.length() != b.length()){  // short circuit if inputs are not equal length
            System.out.println(isAnagram);
            return;
        }

        Map<String, Integer> mapB = new HashMap<String, Integer>();  // create hashmap to load string B
        for (int i = 0; i < b.length(); i++) {  // iterate through string B
            if (! mapB.containsKey(b.substring(i,i+1))){
                mapB.put((b.substring(i,i+1)), 1); // if the current char in string B is not in the hashmap, add it with a key of the char and initial value of 1
            }else {
                int numOfLetter = mapB.get(b.substring(i,i+1));  // else char is already in hashmap, therefore increment the count of that char by 1
                numOfLetter ++;
                mapB.put((b.substring(i,i+1)), numOfLetter);
            }

        }

        for (int i = 0; i < a.length(); i++) {  // iterate through string A and remove chars from the hashmap "inventory"
            String letter = a.substring(i,i+1);  // get the first char from string A to test
            if(mapB.containsKey(letter)){  // is the char in string A
                int numOfLettersLeft = mapB.get(letter);  // check to see if there is any more inventory for that char in the hashmap
                if (numOfLettersLeft == 0){  // if no more inventory for char being tested, return - Not Anagrams
                    System.out.println(isAnagram);
                    return;
                }else{
                    numOfLettersLeft --;  // if inventory of char being tested remain, decrement inventory by 1
                    mapB.put(letter,numOfLettersLeft);
                }
            }else{
                System.out.println(isAnagram);  // a char from string A does not exist in hashmap... Not Anagrams
                return;
            }

        }
        System.out.println("Anagrams"); // if we get to this line of code, strings A and B are anagrams.

    }
}