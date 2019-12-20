package minicode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * for letter/digit convert
 * !! have unclear requirement for stage2
 */
public class LetterConvert {

    private Map<Integer, Set<String>> convertMap = new HashMap<>();
    private List<String> results;

    public Map<Integer, Set<String>> getConvertMap(){
        return convertMap;
    }

    public List<String> getPrint(){
        return results;
    }



    public void resolveAndPrint(Integer[] digits){
        init();
        System.out.println("Input " + toInt(Arrays.asList(digits)));
        resolve("", Arrays.asList(digits), 0, true);
        System.out.println("");
    }

    private void init(){
        results = new ArrayList<>();
        convertMap.clear();
        convertMap.put(1, Collections.emptySet());
        convertMap.put(2, new HashSet<>(Arrays.asList("A", "B", "C")));
        convertMap.put(3, new HashSet<>(Arrays.asList("D", "E", "F")));
        convertMap.put(4, new HashSet<>(Arrays.asList("G", "H", "I")));
        convertMap.put(5, new HashSet<>(Arrays.asList("J", "K", "L")));
        convertMap.put(6, new HashSet<>(Arrays.asList("M", "N", "O")));
        convertMap.put(7, new HashSet<>(Arrays.asList("P", "Q", "R", "S")));
        convertMap.put(8, new HashSet<>(Arrays.asList("T", "U", "V")));
        convertMap.put(9, new HashSet<>(Arrays.asList("W", "X", "Y", "Z")));
        convertMap.put(0, Collections.emptySet());
    }

    private void resolve(String prefix, List<Integer> digits, Integer dIndex, Boolean ifPrint){
        //combine
        Set<String> currentCombine = new HashSet<>();
        //if mapping exist?
        Integer currentDigit = digits.get(dIndex);
        //resolve first
        if(!convertMap.containsKey(currentDigit)){
            // resolve key
            List<Integer> newDigit = toDigits(currentDigit);
            resolve("", newDigit, 0, false);
        }
        //get letter
        convertMap.get(currentDigit).forEach(str->{
            currentCombine.add(prefix + str);
        });

        //if end
        Integer nextIndex = dIndex + 1;
        if(nextIndex >= digits.size()){
            //print
            if(ifPrint) {
                currentCombine.forEach(this::print);
            }
            Integer digitValue = toInt(digits);
            //save to map if not exist
            if(!convertMap.containsKey(digitValue)){
                convertMap.put(digitValue, currentCombine);
            }else{
                convertMap.get(digitValue).addAll(currentCombine);
            }
        }else{
            //go on
            currentCombine.forEach(pre->resolve(pre, digits, nextIndex, ifPrint));
        }
    }

    private Integer toInt(List<Integer> digits){
        StringBuffer val = new StringBuffer();
        digits.forEach(d->val.append(d.toString()));
        return Integer.parseInt(val.toString());
    }

    private List<Integer> toDigits(Integer integer){
        String[] nums = Integer.toString(integer).split("");
        return Arrays.asList(nums).stream()
                .map(num->Integer.parseInt(num))
                .collect(Collectors.toList());
    }

    private void print(String msg){
        System.out.print(msg + " ");
        results.add(msg);
    }

}
