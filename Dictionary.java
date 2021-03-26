/*
 *
 * File: Dictionary.java
 * By: Dinesh Thapa
 * Date: 19/02/2021
 *
 * Description: This program can take upto 4 input separated by spaces at a
 * time and search the keywords given by user and display the result in interface.
 *
*/

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.util.*;

public class Dictionary {
    //creating multimap interface to be implemented in class
    private static Multimap<String, DictionaryWords> dataOfDictionary = ArrayListMultimap.create();

    private static String tempKeyword;
    //enum class
    public enum DictionaryWords {
        WORD01("Arrow", "noun", "Here is one arrow: <IMG> -=>> </IMG>"),
        WORD02("Distinct", "adjective", "Familiar. Worked in Java."),
        WORD03("Distinct", "adjective", "Unique. No duplicates. Clearly different or of a different kind."),
        WORD04("Distinct", "adverb", "Uniquely. Written \"distinctly\"."),
        WORD05("Distinct", "noun", "A keyword in this assignment."),
        WORD06("Distinct", "noun", "A keyword in this assignment."),
        WORD07("Distinct", "noun", "A keyword in this assignment."),
        WORD08("Distinct", "noun", "An advanced search option."),
        WORD09("Distinct", "noun", "Distinct is a parameter in this assignment."),
        WORD10("Placeholder", "adjective", "To be updated..."),
        WORD11("Placeholder", "adjective", "To be updated..."),
        WORD12("Placeholder", "adjective", "To be updated..."),
        WORD13("Placeholder", "adjective", "To be updated..."),
        WORD14("Placeholder", "interjection", "To be updated..."),
        WORD15("Placeholder", "noun", "To be updated..."),
        WORD16("Placeholder", "noun", "To be updated..."),
        WORD17("Placeholder", "noun", "To be updated..."),
        WORD18("Placeholder", "noun", "To be updated..."),
        WORD19("Placeholder", "noun", "To be updated..."),
        WORD20("Placeholder", "verb", "To be updated..."),
        WORD21("CSC340", "adjective", "= C++ version of CSC210 + CSC220 + more."),
        WORD22("CSC340", "noun", "A CS upper division course."),
        WORD23("CSC340", "noun", "Many hours outside of class."),
        WORD24("CSC340", "noun", "Programming Methodology."),
        WORD25("CSC220", "adjective", "Ready to create complex data structures."),
        WORD26("CSC220", "verb", "To create data structures."),
        WORD27("Book", "noun", "A set of pages."),
        WORD28("Book", "noun", "A written work published in printed or electronic form."),
        WORD29("Book", "noun", "To arrange for someone to have a seat on a plane."),
        WORD30("Book", "noun", "To arrange something on a particular date."),
        WORD31("Adverb", "noun", "Adverb is a word that adds more information about place, time, manner, cause or degree to a verb, an adjective, a phrase or another adverb."),
        WORD32("Adjective", "noun", "Adjective is a word that describes a person or thing, for example big, red and clever in a big house, red wine and a clever idea."),
        WORD33("Interjection", "noun", "Interjection is a short sound, word or phrase spoken suddenly to express an emotion.Oh!, Look out! and Ow! are interjections."),
        WORD34("Noun", "noun", "Noun is a word that refers to a person, (such as Ann or doctor), a place (such as Paris or city) or a thing, a quality or an activity (such as plant, sorrow or tennis."),
        WORD35("Arrow", "noun", "Here is one arrow: <IMG> -=>> </IMG>"),
        WORD36("Arrow", "noun", "Here is one arrow: <IMG> -=>> </IMG>"),
        WORD37("Arrow", "noun", "Here is one arrow: <IMG> -=>> </IMG>"),
        WORD38("Book", "adjective", "Here is one arrow: <IMG> -=>> </IMG>"),
        WORD39("Arrow", "conjunction", "Here is one arrow: <IMG> -=>> </IMG>"),
        WORD40("Arrow", "noun", "Here is one arrow: <IMG> -=>> </IMG>"),
        WORD41("Arrow", "verb", "Here is one arrow: <IMG> -=>> </IMG>"),
        WORD42("Arrow", "adjective", "Here is one arrow: <IMG> -=>> </IMG>"),
        WORD43("Random", "adjective", "Here is one arrow: <IMG> -=>> </IMG>"),
        WORD44("Reverse", "adjective", "on back side"),
        WORD45("Reverse", "adjective", "Opposite to usual or previous arrangement"),
        WORD46("Reverse", "noun", "A dictionary program's parameter"),
        WORD47("Reverse", "noun", "Change to opposite direction"),
        WORD48("Reverse", "noun", "The opposite"),
        WORD49("Reverse", "noun", "To be updated..."),
        WORD50("Reverse", "noun", "To be updated..."),
        WORD51("Reverse", "noun", "To be updated..."),
        WORD52("Reverse", "noun", "To be updated..."),
        WORD53("Reverse", "noun", "To be updated..."),
        WORD54("Reverse", "verb", "Change something to opposite"),
        WORD55("Reverse", "verb", "Go back"),
        WORD56("Reverse", "verb", "To be updated..."),
        WORD57("Reverse", "verb", "To be updated..."),
        WORD58("Reverse", "verb", "Turn something inside out"),
        WORD59("Reverse", "verb", "To be updated..."),
        WORD60("Reverse", "verb", "To be updated..."),
        WORD61("Panic", "verb", "To be updated..."),
        WORD62("Panic", "verb", "To be updated..."),
        WORD63("Panic", "verb", "To be updated..."),
        ;

        private final String keyword;
        private final String partsOfSpeech;
        private final String definition;


        private DictionaryWords(String keyword, String partsOfSpeech, String definition) {
            this.keyword = keyword;
            this.partsOfSpeech = partsOfSpeech;
            this.definition = definition;
        }

        public String getKeyword() {
            return keyword;
        }

        public String getPartsOfSpeech() {
            return partsOfSpeech;
        }

        public String getDefinition() {
            return definition;
        }

        @Override
        public String toString() {
            return keyword + "[" + partsOfSpeech + "] :" + definition;
        }
    }

    //Initializing multimap
    public static void initializeDictionary() {
        for (DictionaryWords items : DictionaryWords.values()) {
            dataOfDictionary.put(items.getKeyword().toLowerCase(), items);
        }
        System.out.println("! Loading completed...\n");

    }
    //Input invalid message
    public static void parameterMessagePrint() {
        System.out.println("PARAMETER HOW-TO, please enter: \n" +
                "1. A search key -then 2. An optional part of speech -then\n" +
                "3. An optional 'distinct' -then 4. An optional 'reverse'\n");

    }

    //search in 4 input parameters
    public static Collection<DictionaryWords> search(String[] input) {
        int inputArrayLength = input.length;
        tempKeyword = input[0].toLowerCase();
        Collection<DictionaryWords> tempCollector;
        tempCollector = dataOfDictionary.get(tempKeyword);
        while (true) {
            switch (inputArrayLength) {     // switch argument as input array length.
                case 1:
                    return tempCollector;
                case 2:
                    if (input[1].toLowerCase().equals("distinct")) {
                        tempCollector = getDistinct(tempCollector);
                    } else if (input[1].toLowerCase().equals("reverse")) {
                        tempCollector = getReverse(tempCollector);
                    } else if (isPartOfSpeech(input[1])) {
                        tempCollector = getPartOfSpeech(tempCollector, input[1]);
                    } else {
                        System.out.println("<The entered 2nd parameter '" + input[1] + "' is NOT a part of speech.>");
                        System.out.println("<The entered 2nd parameter '" + input[1] + "' is NOT 'distinct'.>");
                        System.out.println("<The entered 2nd parameter '" + input[1] + "' is NOT 'reverse'.>");
                        System.out.println("<The 2nd parameter should be a part of speech or 'distinct' or 'reverse'.>");
                    }
                    inputArrayLength--;
                    continue;
                case 3:
                    if (input[2].toLowerCase().equals("reverse")) {
                        tempCollector = getReverse(dataOfDictionary.get(tempKeyword));
                    } else if (input[2].toLowerCase().equals("distinct")) {
                        tempCollector = getDistinct(tempCollector);
                    } else {
                        System.out.println("<The entered 3rd parameter '" + input[2] + "' is NOT 'distinct'.>");
                        System.out.println("<The entered 3rd parameter '" + input[2] + "' is NOT 'reverse'.>");
                        System.out.println("<The 3rd parameter should be 'distinct' or 'reverse'.>");
                        System.out.println("<The entered 3rd parameter '" + input[2] + "' was disregarded.>");
                        System.out.println("<The 3rd parameter should be a part of speech or 'distinct' or 'reverse'.>");
                    }
                    inputArrayLength--;
                    continue;
                case 4:
                    if (input[3].toLowerCase().equals("reverse")) {
                        tempCollector = getReverse(tempCollector);
                    } else {
                        System.out.println("<The entered 4th parameter '" + input[3] + "' is NOT 'reverse'.>");
                        System.out.println("<The entered 4th parameter '" + input[3] + "' was disregarded.>");
                        System.out.println("<The 4th parameter should be 'reverse'.>");
                    }
                    inputArrayLength--;
                    continue;
                default:
                    parameterMessagePrint();
                    break;
            }
            break;
        }
        return new HashSet<>();
    }

    //check boolean for part of speech
    public static boolean isPartOfSpeech(String speech) {
        boolean isSpeech = false;
        for (DictionaryWords typeOfSpeech : DictionaryWords.values()) {
            if (speech.toLowerCase().equals(typeOfSpeech.partsOfSpeech)) {
                isSpeech = true;
            }
        }
        return isSpeech;
    }

    //return list with same part of speech
    public static Collection<DictionaryWords> getPartOfSpeech(Collection<DictionaryWords> partOfSpeech, String secondParameter) {
        Collection<DictionaryWords> partOfSpeechItems = new ArrayList<>();
        for (DictionaryWords items : partOfSpeech) {
            if (items.getPartsOfSpeech().equals(secondParameter.toLowerCase())) {
                partOfSpeechItems.add(items);
            }
        }
        return partOfSpeechItems;
    }

    //return distinct item
    public static Collection<DictionaryWords> getDistinct(Collection<DictionaryWords> distinct) {
        Collection<DictionaryWords> distinctItems = new ArrayList<>();
        boolean isDistinct = true;
        for (DictionaryWords item : distinct) {
            isDistinct = true;
            for (DictionaryWords prevItems : distinctItems) {
                if (prevItems.getDefinition().equals(item.getDefinition())
                        && prevItems.getPartsOfSpeech().equals(item.getPartsOfSpeech())) {
                    isDistinct = false;
                    break;
                }
            }
            if (isDistinct)
                distinctItems.add(item);
        }
        return distinctItems;
    }

    // returns reverse items
    public static Collection<DictionaryWords> getReverse(Collection<DictionaryWords> reverse) {
        List<DictionaryWords> reverseItems = new ArrayList<>(reverse);
        Collections.reverse(reverseItems);
        return reverseItems;
    }

    //print out the results
    public static void print(Collection<DictionaryWords> results) {
        if (results.isEmpty()) {
            System.out.println("<Not Found> To be considered for the next release. Thank you.");
            System.out.println("   |");
            System.out.println("   |");
            parameterMessagePrint();
        } else {
            results.forEach(System.out::println);
        }
    }

    public static void main(String[] args) {
        int count = 1;
        System.out.println("! Loading data...");
        initializeDictionary();
        System.out.println("========DICTIONARY 340 JAVA========\n");
        System.out.println("No. of Definition: " + DictionaryWords.values().length + "\n");
        System.out.println("No. of Keyword: " + dataOfDictionary.keySet().size() + "\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Search[1]: ");
        String input = scanner.nextLine();
        //loop runs until user inputs !Q
        while (!input.equalsIgnoreCase("!Q")) {
            String[] inputArray = input.split(" ");
            if (inputArray[0].equalsIgnoreCase("!help") || inputArray[0].isEmpty()) {
                parameterMessagePrint();
            } else {
                print(Dictionary.search(inputArray));
            }
            count++;
            System.out.println("   |");
            System.out.println("   |");
            System.out.print("Search" + "[" + count + "]" + ":");
            input = scanner.nextLine();
        }
        System.out.println(" ");
        System.out.println("-----THANK YOU-----");
    }
}

