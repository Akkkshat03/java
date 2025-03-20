package Assignment_2;

import java.util.*;

// Main Class
public class Main {
    public static void main(String[] args) {
        // Q1: Longest Common Prefix
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] strs = {"flower", "flow", "flight"};
        System.out.println("Longest Common Prefix: " + lcp.findPrefix(strs));

        // Q2: Password Checker
        PasswordChecker pc = new PasswordChecker();
        System.out.println("Password Valid: " + pc.checkPassword("aA1_67"));

        // Q3: Letter Combinations of a Phone Number
        PhoneCombinations phone = new PhoneCombinations();
        System.out.println("Letter Combinations: " + phone.letterCombinations("23"));

        // Q4: String Permutations
        StringPermutations sp = new StringPermutations();
        System.out.println("Permutations of XYZ:");
        sp.generatePermutations("XYZ", "");

        // Q5: Anagram Check
        AnagramChecker ac = new AnagramChecker();
        System.out.println("Is Anagram: " + ac.isAnagram("anagram", "nagaram"));

        // Q6: Replace Profanity
        ProfanityFilter pf = new ProfanityFilter();
        String[] badWords = {"bad", "ugly", "stupid"};
        System.out.println("Filtered Text: " + pf.filterText("This is a bad and ugly comment.", badWords));

        // Q7: Unique Characters in a String
        UniqueCharacterChecker ucc = new UniqueCharacterChecker();
        System.out.println("Has Unique Characters: " + ucc.hasUniqueCharacters("abcde"));

        // Q8: Find the Longest Word
        LongestWordFinder lwf = new LongestWordFinder();
        System.out.println("Longest Word: " + lwf.findLongestWord("Innovation distinguishes between a leader and a follower."));

        // Q9: Convert Sentence to Title Case
        TitleCaseConverter tcc = new TitleCaseConverter();
        System.out.println("Title Case: " + tcc.toTitleCase("java programming is fun"));

        // Q10: Extract Domain from URL
        DomainExtractor de = new DomainExtractor();
        System.out.println("Domain: " + de.extractDomain("https://www.google.com/search?q=java"));
    }
}

// Q1: Longest Common Prefix
class LongestCommonPrefix {
    public String findPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}

// Q2: Password Checker
class PasswordChecker {
    public int checkPassword(String str) {
        if (str.length() < 4 || Character.isDigit(str.charAt(0))) return 0;
        boolean hasUpper = false, hasDigit = false;
        for (char ch : str.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpper = true;
            if (Character.isDigit(ch)) hasDigit = true;
            if (ch == ' ' || ch == '/') return 0;
        }
        return (hasUpper && hasDigit) ? 1 : 0;
    }
}

// Q3: Letter Combinations of a Phone Number
class PhoneCombinations {
    private final Map<Character, String> map = Map.of(
        '2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"
    );

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return result;
        backtrack(result, new StringBuilder(), digits, 0);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, String digits, int index) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        for (char c : map.get(digits.charAt(index)).toCharArray()) {
            current.append(c);
            backtrack(result, current, digits, index + 1);
            current.deleteCharAt(current.length() - 1);
        }
    }
}

// Q4: String Permutations
class StringPermutations {
    public void generatePermutations(String str, String result) {
        if (str.isEmpty()) {
            System.out.println(result);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            generatePermutations(str.substring(0, i) + str.substring(i + 1), result + str.charAt(i));
        }
    }
}

// Q5: Anagram Check
class AnagramChecker {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }
}

// Q6: Replace Profanity
class ProfanityFilter {
    public String filterText(String text, String[] badWords) {
        for (String word : badWords) {
            text = text.replaceAll("\\b" + word + "\\b", "***");
        }
        return text;
    }
}

// Q7: Unique Characters in a String
class UniqueCharacterChecker {
    public boolean hasUniqueCharacters(String str) {
        HashSet<Character> set = new HashSet<>();
        for (char ch : str.toCharArray()) {
            if (!set.add(ch)) return false;
        }
        return true;
    }
}

// Q8: Find the Longest Word
class LongestWordFinder {
    public String findLongestWord(String sentence) {
        String[] words = sentence.split(" ");
        String longest = "";
        for (String word : words) {
            if (word.length() > longest.length()) longest = word;
        }
        return longest;
    }
}

// Q9: Convert Sentence to Title Case
class TitleCaseConverter {
    public String toTitleCase(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder titleCase = new StringBuilder();
        for (String word : words) {
            titleCase.append(Character.toUpperCase(word.charAt(0)))
                     .append(word.substring(1)).append(" ");
        }
        return titleCase.toString().trim();
    }
}

// Q10: Extract Domain from URL
class DomainExtractor {
    public String extractDomain(String url) {
        String domain = url.replaceFirst("https?://(www\\.)?", "");
        return domain.split("/")[0];
    }
}

