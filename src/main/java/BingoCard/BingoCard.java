package BingoCard;

import java.util.*;

public class BingoCard {
    private final HashMap<String, int[]> columns = new HashMap<>();
    private final static HashMap<String , int[]> limits = new HashMap<>();
    private final static Random random = new Random();
    static {
        limits.put("B", new int[]{1,15});
        limits.put("I", new int[]{16,30});
        limits.put("N", new int[]{31,45});
        limits.put("G", new int[]{46,60});
        limits.put("O", new int[]{61,75});
    }

    BingoCard() {
        columns.put("B", generateRandomNumbersByColumn("B"));
        columns.put("I", generateRandomNumbersByColumn("I"));
        columns.put("N", generateRandomNumbersByColumn("N"));
        columns.put("G", generateRandomNumbersByColumn("G"));
        columns.put("O", generateRandomNumbersByColumn("O"));
    }
    private int[] generateRandomNumbersByColumn(String columnName){
        int[] numbers = new int[15];
        int[] limit = BingoCard.limits.get(columnName);
        int start = limit[0];
        int end = limit[1];
        int index = 0;
        while(start <= end) {
            numbers[index++] = start++;
        }
        int[] randomNumberArray = new int[5];
        for(int outputIndex = 0; outputIndex < randomNumberArray.length; outputIndex++){
            int chosenNumber = BingoCard.random.nextInt(index);
            randomNumberArray[outputIndex] = numbers[chosenNumber];
            numbers[chosenNumber] = numbers[index-- - 1];
        }
        return randomNumberArray;
    }
    public void displayCard() {
        System.out.println("Column B " + Arrays.toString(columns.get("B")));
        System.out.println("Column I " + Arrays.toString(columns.get("I")));
        System.out.println("Column N " + Arrays.toString(columns.get("N")));
        System.out.println("Column G " + Arrays.toString(columns.get("G")));
        System.out.println("Column O " + Arrays.toString(columns.get("O")));
    }
}
