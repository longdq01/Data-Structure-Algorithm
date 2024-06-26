package com.example.array;

public class AddBinary_67 {
    public String addBinary(String a, String b) {
        int n = a.length(), m = b.length();
        int i = 0;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();

        while(i < n && i < m){
            int vA = a.charAt(i) - '0';
            int vB = b.charAt(i) - '0';
            int tmp = vA + vB + carry;
            if(tmp == 2){
                tmp = 0;
                carry = 1;
            }else if(tmp == 3){
                tmp = 1;
                carry = 1;
            }else{
                carry = 0;
            }
            sb.append(tmp);
            i++;
        }

        while (i < n){
            int vA = a.charAt(i) - '0';
            int tmp = vA + carry;
            if(tmp == 2){
                tmp = 0;
                carry = 1;
            } else{
                carry = 0;
            }
            sb.append(tmp);
            i++;
        }
        while (i < m){
            int vB = b.charAt(i) - '0';
            int tmp = vB + carry;
            if(tmp == 2){
                tmp = 0;
                carry = 1;
            } else{
                carry = 0;
            }
            sb.append(tmp);
            i++;
        }
        if(carry == 1)
            sb.append(carry);
        return sb.reverse().toString();
    }
}
