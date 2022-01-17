package exercise_tasks;

import java.util.Scanner;

public class E11_ArrayManipulator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = getArrayOfNumbers(scanner.nextLine().split("\\s+"));
        String command = scanner.nextLine();

        int count = 0;
        String type = null;

        while (!command.equals("end")) {
            String[] commandArguments = command.split("\\s+");

            if (commandArguments[0].equals("first") || commandArguments[0].equals("last")) {
                count = Integer.parseInt(commandArguments[1]);
                type = commandArguments[2];
            }

            switch (commandArguments[0]) {
                case "exchange":
                    int index = Integer.parseInt(commandArguments[1]);
                    if (index < 0 || index >= numbers.length) {
                        System.out.println("Invalid index");
                    } else {
                        numbers = exchangeArrayElements(numbers, index);
                    }
                    break;
                case "max":
                    String evenOrOdd = commandArguments[1];
                    int maxIndex = evenOrOdd.equals("even") ? getMaxEvenElementIndex(numbers) : getMaxOddElementIndex(numbers);
                    System.out.println(maxIndex == -1 ? "No matches" : maxIndex);
                    break;
                case "min":
                    String oddOrEven = commandArguments[1];
                    int minIndex = oddOrEven.equals("even") ? getMinEvenElementIndex(numbers) : getMinOddElementIndex(numbers);
                    System.out.println(minIndex == -1 ? "No matches" : minIndex);
                    break;
                case "first":
                    int[] result;
                    if (count > numbers.length) {
                        System.out.println("Invalid count");
                    } else {
                        result = type.equals("even") ? getFirstCountOfEven(numbers, count) : getFirstCountOfOdd(numbers, count);
                        printArray(result);
                    }
                    break;
                case "last":
                    int[] res;
                    if (count > numbers.length) {
                        System.out.println("Invalid count");
                    } else {
                        res = type.equals("even") ? getLastCountOfEven(numbers, count) : getLastCountOfOdd(numbers, count);
                        printArray(res);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        printArray(numbers);
    }

    static int[] exchangeArrayElements(int[] array, int index) {
        int[] newArray = new int[array.length];
        int k = 0;
        for (int i = index + 1; i < array.length; i++) {
            newArray[k] = array[i];
            k++;
        }
        for (int i = 0; i <= index; i++) {
            newArray[k] = array[i];
            k++;
        }
        array = newArray;
        return array;
    }

    static int getMaxEvenElementIndex(int[] array) {
        int maxElement = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < array.length; i++) {
            int currentElement = array[i];
            if (currentElement % 2 == 0 && currentElement >= maxElement) {
                maxElement = currentElement;
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    static int getMaxOddElementIndex(int[] array) {
        int maxElement = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < array.length; i++) {
            int currentElement = array[i];
            if (currentElement % 2 != 0 && currentElement >= maxElement) {
                maxElement = currentElement;
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    static int getMinEvenElementIndex(int[] array) {
        int minElement = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < array.length; i++) {
            int currentElement = array[i];
            if (currentElement % 2 == 0 && currentElement <= minElement) {
                minElement = currentElement;
                minIndex = i;
            }
        }
        return minIndex;
    }

    static int getMinOddElementIndex(int[] array) {
        int minElement = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < array.length; i++) {
            int currentElement = array[i];
            if (currentElement % 2 != 0 && currentElement <= minElement) {
                minElement = currentElement;
                minIndex = i;
            }
        }
        return minIndex;
    }

    static int[] getFirstCountOfEven(int[] array, int count) {
        int evenCount = 0;
        for (int j : array) {
            if (j % 2 == 0) {
                evenCount++;
            }
        }
        int[] result = fillArrayElementsWithNegativeNumber(new int[count]);
        int countCheck = 0;
        for (int element : array) {
            if (element % 2 == 0) {
                result[countCheck] = element;
                countCheck++;
                if (countCheck == count) {
                    break;
                }
            }
        }
        return result;
    }

    static int[] getFirstCountOfOdd(int[] array, int count) {
        int[] result = fillArrayElementsWithNegativeNumber(new int[count]);
        int countCheck = 0;

        for (int element : array) {
            if (element % 2 != 0) {
                result[countCheck] = element;
                countCheck++;
                if (countCheck == count) {
                    break;
                }
            }
        }
        return result;
    }

    static int[] getLastCountOfEven(int[] array, int count) {
        int[] result = fillArrayElementsWithNegativeNumber(new int[count]);
        int countCheck = 0;

        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] % 2 == 0) {
                result[result.length - count - i] = array[i];
                countCheck++;
                if (countCheck == count) {
                    break;
                }
            }
        }
        return result;
    }

    static int[] getLastCountOfOdd(int[] array, int count) {
        int[] result = fillArrayElementsWithNegativeNumber(new int[count]);
        int countCheck = 0;

        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] % 2 != 0) {
                result[result.length - count - i] = array[i];
                countCheck++;
                if (countCheck == count) {
                    break;
                }
            }
        }
        return result;
    }

    static void printArray(int[] array) {
        if (array[0] == -1) {
            System.out.println("[]");
        } else {
            System.out.print("[");
            for (int i = 0; i < array.length; i++) {
                if (array[i] != -1) {
                    System.out.print(array[i]);
                }
                if (i == array.length - 1) {
                    break;
                }
                if (array[i + 1] == -1) {
                    continue;
                }
                System.out.print(", ");
            }
            System.out.println("]");
        }
    }

    static int[] getArrayOfNumbers(String[] numbers) {
        int[] arrayOfNumbers = new int[numbers.length];
        for (int i = 0; i < arrayOfNumbers.length; i++) {
            arrayOfNumbers[i] = Integer.parseInt(numbers[i]);
        }
        return arrayOfNumbers;
    }

    static int[] fillArrayElementsWithNegativeNumber(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = -1;
        }
        return array;
    }
}