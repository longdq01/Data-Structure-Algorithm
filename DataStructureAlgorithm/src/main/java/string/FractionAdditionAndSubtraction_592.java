package string;

import java.util.ArrayList;
import java.util.List;

public class FractionAdditionAndSubtraction_592 {
    class Fraction{
        int numerator;
        int denominator;
        public Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }
    public String fractionAddition(String expression) {
        List<Fraction> fractions = parseExpression(expression);
        Fraction res = addUp(fractions);
        return res.numerator + "/" + res.denominator;
    }

    private List<Fraction> parseExpression(String expression){
        String[] fractions = expression.split("[+\\-]");
        int i = (expression.charAt(0) == '-') ? 1 : 0;
        int[] signs = new int[fractions.length];
        int idx = i;
        if(i == 0){
            signs[idx++] = 1;
        }
        for (int j = 0; j < expression.length(); j++) {
            char c = expression.charAt(j);
            if(c == '-')
                signs[idx++] = -1;
            else if(c == '+')
                signs[idx++] = 1;
        }
        List<Fraction> res = new ArrayList<>();
        for (int j = i; j < fractions.length; j++) {
            String[] s = fractions[j].split("/");
            int numerator = Integer.parseInt(s[0]) * signs[j];
            int denominator = Integer.parseInt(s[1]);
            res.add(new Fraction(numerator, denominator));
        }

        return res;
    }

    private Fraction addUp(List<Fraction> fractions){
        Fraction f = new Fraction(0, 1);
        for(Fraction fraction: fractions){
            f = add(f, fraction);
        }
        return f;
    }

    private Fraction add(Fraction a, Fraction b){
        int d = lcm(a.denominator, b.denominator);
        int n = a.numerator * (d / a.denominator) + b.numerator * (d / b.denominator);
        int f = gcd(n, d);
        n /= f; d /= f;
        if(d < 0){
            d *= -1;
            n *= -1;
        }
        return new Fraction(n, d);
    }

    private int lcm(int a, int b){
        return a * b / gcd(a, b);
    }

    private int gcd(int a, int b){
        if(b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        FractionAdditionAndSubtraction_592 f = new FractionAdditionAndSubtraction_592();
        System.out.println(f.fractionAddition("-1/2+1/2-1/3"));
    }
}
