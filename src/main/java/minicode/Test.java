package minicode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) throws Exception {
        questionOne();
        questionTwo();
    }

    public static void questionOne(){
        Solution convert = new Solution();
        Map<List<Integer>, List<String>> testData = new HashMap<>();
        testData.put(Arrays.asList(0), Arrays.asList());
        testData.put(Arrays.asList(1), Arrays.asList());
        testData.put(Arrays.asList(2), Arrays.asList("a", "b", "c"));
        testData.put(Arrays.asList(3), Arrays.asList("d", "e", "f"));
        testData.put(Arrays.asList(4), Arrays.asList("g", "h", "i"));
        testData.put(Arrays.asList(5), Arrays.asList("j", "k", "l"));
        testData.put(Arrays.asList(6), Arrays.asList("m", "n", "o"));
        testData.put(Arrays.asList(7), Arrays.asList("p", "q", "r", "s"));
        testData.put(Arrays.asList(8), Arrays.asList("t", "u", "v"));
        testData.put(Arrays.asList(9), Arrays.asList("w", "x", "y", "z"));
        //test
        testData.forEach((k,v) -> {
            List<String> result = convert.letterCombinations(k);
            Test.CheckAndPrint(k, v, result);
        });
    }

    public static void questionTwo(){
        Solution convert = new Solution();
        Map<List<Integer>, List<String>> testData = new HashMap<>();
        testData.put(Arrays.asList(2, 3),
                Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"));
        testData.put(Arrays.asList(8, 8),
                Arrays.asList("tt", "tu", "tv", "ut", "uu", "uv", "vt", "vu", "vv"));
        //test
        testData.forEach((k,v) -> {
            List<String> result = convert.letterCombinations(k);
            Test.CheckAndPrint(k, v, result);
        });
    }

    public static void CheckAndPrint(List<Integer> input,
                                     List<String> expect,
                                     List<String> actual) {
        System.out.println("Checking:" + Arrays.toString(input.toArray()));
        if(expect.equals(actual)){
            System.out.println(Arrays.toString(expect.toArray()));
        }else{
            System.out.println(Arrays.toString(expect.toArray()));
            System.out.println(Arrays.toString(actual.toArray()));
            System.out.println("Check Fail:");
        }
    }

}
