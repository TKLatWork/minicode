package minicode;

import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) throws Exception {
        LetterConvert convert = new LetterConvert();

        Integer[] digits = new Integer[]{9};
        convert.resolveAndPrint(digits);
        Test.Check(convert.getPrint(), Arrays.asList("W", "X", "Y", "Z"));

        digits = new Integer[]{2, 3};
        convert.resolveAndPrint(digits);
        Test.Check(convert.getPrint(), Arrays.asList("AD", "AE", "AF", "BD", "BE", "BF", "CD", "CE", "CF"));

        digits = new Integer[]{23};
        convert.resolveAndPrint(digits);
        Test.Check(convert.getPrint(), Arrays.asList("AD", "AE", "AF", "BD", "BE", "BF", "CD", "CE", "CF"));

        digits = new Integer[]{56};
        convert.resolveAndPrint(digits);
        System.out.println(convert.getPrint());
    }

    public static void Check(List<String> src, List<String> match) throws Exception {
        if(src.size() != match.size() || !src.containsAll(match)){
            System.out.println(src);
            System.out.println(match);
            throw new Exception("Check fail");
        }
    }

}
