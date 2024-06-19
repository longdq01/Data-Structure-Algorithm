package recursion;

public class ReformatPhoneNumber_1694 {
    public String reformatNumber(String number) {
        number = number.replaceAll("[ -]", "");
        return groupNumber(number);
    }

    private String groupNumber(String number){
        int n = number.length();
        if(n == 2 || n == 3){
            return number;
        }
        if(n == 4)
            return number.substring(0, 2) + "-" + number.substring(2);

        return number.substring(0, 3) + "-" + groupNumber(number.substring(3));
    }

    public static void main(String[] args) {
        ReformatPhoneNumber_1694 r = new ReformatPhoneNumber_1694();
        String s = r.reformatNumber("123 4-567");
        System.out.println(s);
    }
}
