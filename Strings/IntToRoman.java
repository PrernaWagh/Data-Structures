import java.util.*;
public class IntToRoman
{
    static List<Integer> val = Arrays.asList(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1);
    static List<String> sym = Arrays.asList("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I");

    public String intToRoman(int num) {
        String result = "";
        int times = 0;
        for (int i = 0; i < val.size(); i++) {
            if (num == 0) {
                break;
            }
            times = num / val.get(i);
            while (times > 0) {
                result += sym.get(i);
                times--;
            }
            num = num % val.get(i);
        }

        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String result = null;
        int num =0;

        IntToRoman obj = new IntToRoman();
        System.out.println("Enter integer : ");
        num = sc.nextInt();
        result = obj.intToRoman(num);
        System.out.println(result);
    }
}

//output:
// Enter integer : 
// 1994
// MCMXCIV

// Enter integer : 
// 3749
// MMMDCCXLIX