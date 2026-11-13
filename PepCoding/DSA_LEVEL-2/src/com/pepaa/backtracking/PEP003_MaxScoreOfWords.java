package com.pepaa.backtracking;

public class PEP003_MaxScoreOfWords {

    public static void main(String[] args) {
        String[] words = {"dog", "cat", "dad", "good"};
        String freq = "abcdddgoo";
        int[] charValue = {1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};

        int[] freqChar = new int[charValue.length];
        for(int i=0; i<freq.length(); i++){
            freqChar[freq.charAt(i) - 'a']++;
        }

        int[] wordsValue = new int[words.length];
        for(int i=0; i<words.length; i++){
            String word = words[i];
            int wordValue = 0;
            for(int j=0; j<word.length(); j++){
                wordValue += charValue[word.charAt(j) - 'a'];
            }
            wordsValue[i] = wordValue;
            //System.out.println(wordValue);
        }

        int MaxScoreOfWords = findMaxScore(0,words, wordsValue, freqChar);
        System.out.println(MaxScoreOfWords);

    }

    private static int findMaxScore(int indx, String[] words, int[] wordsValue, int[] freqChar) {
        if(indx == words.length) return 0;

        int withoutPickWords = findMaxScore(indx+1, words, wordsValue, freqChar);
        int withPickWords = wordsValue[indx];
        if(checkWordsAvailability(words[indx], freqChar)){
            reduceFreqChar(words[indx], freqChar);
            withPickWords+= findMaxScore(indx+1, words, wordsValue, freqChar);
            restoreFreqChar(words[indx], freqChar);
        }else withPickWords -= wordsValue[indx];
        return Integer.max(withoutPickWords, withPickWords);
    }

    private static void restoreFreqChar(String word, int[] freqChar) {
        for(int i=0; i<word.length(); i++){
            freqChar[word.charAt(i) - 'a']++;
        }
    }

    private static void reduceFreqChar(String word, int[] freqChar) {
        for(int i=0; i<word.length(); i++){
            freqChar[word.charAt(i) - 'a']--;
        }
    }

    private static boolean checkWordsAvailability(String word, int[] freqChar) {
        for(int i=0; i<word.length(); i++){
            if(freqChar[word.charAt(i) - 'a'] <=0) return false;
            freqChar[word.charAt(i) - 'a']--;
        }

        for(int i=0; i<word.length(); i++){
            freqChar[word.charAt(i) - 'a']++;
        }
        return true;
    }
}
