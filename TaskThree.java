package HomeTaskThree;

import java.util.Scanner;

public class TaskThree {
    public static int []mas = new int[]{};

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount elements of array ");

        int size = scanner.nextInt();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Enter values of array element ");
            array[i] = scanner.nextInt();
        }
        System.out.print("Inserted array elements:");
        for (int i = 0; i < size; i++) {
            System.out.print(" " + array[i]);
        }
        System.out.println();

        int fives = 0;
        int min = array[0], max = array[0];
        for (int i = 0; i < size; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] == 5) {
                fives++;
            }
        }

        mas = array;
        System.out.println("Minimum number : " + min);
        System.out.println("Maximum number : " + max);
        System.out.println("Fifth : " + fives);
        quickSort ();
        System.out.println();
        for (int i=0; i<array.length; i++){
            System.out.print(array[i] + " ");
        }
    }

    public static void quickSort(){
        int startIndex = 0;
        int endIndex = mas.length - 1;
        doSort(startIndex, endIndex);
    }

    public static void doSort(int start, int end) {
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (mas[i] <= mas[cur])) {
                i++;
            }
            while (j > cur && (mas[cur] <= mas[j])) {
                j--;
            }
            if (i < j) {
                int temp = mas[i];
                mas[i] = mas[j];
                mas[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        doSort(start, cur);
        doSort(cur+1, end);
    }

}

