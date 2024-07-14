package stack_queue;

import java.util.Map;
import java.util.TreeMap;

public class NumberOfAtoms_726 {
    int curIdx = 0;
    int n;
    String formula;

    public String countOfAtoms(String formula) {
        this.formula = formula;
        this.n = formula.length();
        TreeMap<String, Integer> atoms = countOfAtoms();
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : atoms.entrySet()) {
            result.append(entry.getKey());
            int freq = entry.getValue();
            if(freq != 1){
                result.append(freq);
            }
        }
        return result.toString();
    }

    public TreeMap<String, Integer> countOfAtoms(){
        TreeMap<String, Integer> atoms = new TreeMap<>();
        StringBuilder sb = new StringBuilder();
        String freq = "-1";
        while(curIdx < n){
            char c = formula.charAt(curIdx);
            if(Character.isLowerCase(c)){
                sb.append(c);
            }else if(Character.isDigit(c)){
                if(freq.equals("-1")){
                    freq = String.valueOf(c - '0');
                }else{
                    freq += String.valueOf(c - '0');
                }
            } else{
                if(!sb.isEmpty()){
                    String s = sb.toString();
                    atoms.put(s, atoms.getOrDefault(s, 0) + (freq.equals("-1") ? 1 : Integer.parseInt(freq)));
                    sb = new StringBuilder();
                    freq = "-1";
                }

                if(c == '('){
                    curIdx++;
                    TreeMap<String, Integer> subAtoms = countOfAtoms();
                    for (Map.Entry<String, Integer> entry : subAtoms.entrySet()) {
                        atoms.put(entry.getKey(), atoms.getOrDefault(entry.getKey(), 0) + entry.getValue());
                    }
                }else if(c == ')'){
                    curIdx++;
                    freq = "-1";
                    while(curIdx < n && Character.isDigit(formula.charAt(curIdx))){
                        if(freq.equals("-1")){
                            freq = String.valueOf(formula.charAt(curIdx) - '0');
                        }else{
                            freq += String.valueOf(formula.charAt(curIdx) - '0');
                        }
                        curIdx++;
                    }
                    curIdx--;
                    for (Map.Entry<String, Integer> entry : atoms.entrySet()) {
                        entry.setValue(entry.getValue() * (freq.equals("-1") ? 1 : Integer.parseInt(freq)));
                    }
                    return atoms;
                }else if(Character.isUpperCase(c)){
                    sb.append(c);
                }
            }
            curIdx++;
        }
        if(!sb.isEmpty()){
            String s = sb.toString();
            atoms.put(s, atoms.getOrDefault(s, 0) + (freq.equals("-1") ? 1 : Integer.parseInt(freq)));
        }
        return atoms;
    }

    public static void main(String[] args) {
        NumberOfAtoms_726 numberOfAtoms726 = new NumberOfAtoms_726();
        System.out.println(numberOfAtoms726.countOfAtoms("(NB3)33"));
    }
}
