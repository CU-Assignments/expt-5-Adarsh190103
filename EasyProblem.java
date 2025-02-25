import java.util.ArrayList;
import java.util.List;

public class AutoboxingSum {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);

        int sum = calculateSum(numbers);
        System.out.println("The sum of the numbers is: " + sum);

        String str = "50";
        int parsedInt = parseStringToInt(str);
        System.out.println("Parsed integer from string: " + parsedInt);
    }

    public static int calculateSum(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }

    public static int parseStringToInt(String str) {
        return Integer.parseInt(str);
    }
}
