package minicode.phone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    static String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        return letterCombinations(toIntArray(digits));
    }

    public List<String> letterCombinations(Integer[] digits) {
        return letterCombinations(Arrays.asList(digits));
    }

    public List<String> letterCombinations(List<Integer> seq) {
        result = new ArrayList<>();
        if(seq.size() > 0){
            re("", seq, 0);
        }
        return result;
    }


    private List<String> result;

    private void re(String prefix, List<Integer> seq, Integer index){
        String cChars = map[seq.get(index)];
        for (int i = 0; i < cChars.length(); i++) {
            String newPrefix = prefix + cChars.charAt(i);
            if(seq.size() > index + 1){
                re(newPrefix, seq, index + 1);
            }else{
                result.add(newPrefix);
            }
        }
    }

    //util
    private List<Integer> toIntArray(String digits){
        List<Integer> seq = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            try {
                int index = Character.getNumericValue(digits.charAt(i));
                seq.add(index);
            }catch (NumberFormatException e){

            }
        }
        return seq;
    }

}
