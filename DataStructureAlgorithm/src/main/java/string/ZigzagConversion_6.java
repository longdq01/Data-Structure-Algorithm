package string;

public class ZigzagConversion_6 {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;

        StringBuilder sb = new StringBuilder();
        for(int row = 0; row < numRows; row++){
            int spacing = (numRows - row - 1) + (numRows - row - 2);
            boolean f = true;
            int idx = row;
            while(idx < s.length()){
                sb.append(s.charAt(idx));
                if(row == 0 || row == numRows - 1){
                    idx += (numRows - 1) + (numRows - 2) + 1;
                }else{
                    if(f)
                        idx += (spacing + 1);
                    else{
                        idx += (row * 2);
                    }
                    f = !f;
                }
            }
        }
        return sb.toString();
    }

    /*
    P     I    N
    A   L S  I G
    Y A   H R
    P     I

    P   A   H   N
    A P L S I I G
    Y   I   R

     */
    public static void main(String[] args) {
        ZigzagConversion_6 z = new ZigzagConversion_6();
        System.out.println(z.convert("A", 1));

        // "PAHNAPLSIIGYIR"
        //  PAHNAPLSIIGYYIIRR
    }
}
