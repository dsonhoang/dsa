package Hw2_22001584_DoanSonHoang;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your string: ");
        String str = scanner.nextLine();
        scanner.close();

        String[] words = str.split(" ");
        SimpleArrayList<WordCount> wordList = new SimpleArrayList<>();

        for (String word : words) {;
            WordCount w = new WordCount(word);
            if (wordList.isContain(w)) {
                for (WordCount element : wordList) {
                    if (element.equals(w)) {
                        element.upCount();
                        break;
                    }
                }
                w.upCount();
            } else {
                wordList.add(w);
            }
        }

        for (WordCount wordCount : wordList) {
            System.out.println(wordCount.toString());
        }
    }
}
