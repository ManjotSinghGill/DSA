package Arrays;

public class OneDimensionalArray {

    public void printArray(int[] arr){
        int n = arr.length;
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public void reverseArray(int[] arr){
        int start = 0;
        int end = arr.length -1;
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public int minimum(int[] arr){
        int min = arr[0];
        for(int j : arr){
            if (j < min){
                min = j;
            }
        }
        return min;
    }

    public int secondMax(int[] arr){
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int j : arr){
            if (j > max){
                secondMax = max;
                max = j;
            }else if(j > secondMax && j != max){
                secondMax = j;
            }
        }
        return secondMax;
    }

    public void moveZeroAtEnd(int[] arr){
        int i = 0;
        for(int j = 0; j < arr.length; j++){
            if (arr[j] != 0 && arr[i] ==0){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
            if (arr[i] != 0){
                i++;
            }
        }
    }

    public int[] resizeArray(int[] arr, int size){
        int[] temp = new int[size];
        for (int i = 0; i < arr.length; i++){
            temp[i] = arr[i];
        }
        arr = temp;
        return arr;
    }

    public int missingNum(int[] arr){
        int n = arr.length + 1;
        int sum = (n * (n + 1)) / 2;
        for(int j : arr){
            sum-= j;
        }
        return sum;
    }

    public boolean isPalindrome(String string){
        char[] arr = string.toCharArray();
        int start = 0;
        int end = string.length() - 1 ;
        while(start < end){
            if (arr[start] == arr[end]){
                return true;
            }
            start ++;
            end--;
        }
        return false;
    }

    public int[] removeEven(int[] arr){
        int n = arr.length;
        int oddCount = 0;
        for (int k : arr) {
            if (k % 2 != 0) {
                oddCount++;
            }
        }
        int[] result = new int[oddCount];
        int oi = 0;
        for (int j : arr) {
            if (j % 2 != 0) {
                result[oi] = j;
                oi++;
            }
        }
        return result;
    }

    public void intializeArray(){
        int[] newArray = new int[5];
        newArray[0] = 1;
        newArray[1] = 2;
        newArray[2] = 4;
        newArray[3] = 5;
        newArray[4] = 6;
    }

    public static void main(String[] args) {
        OneDimensionalArray ODA = new OneDimensionalArray();
        ODA.intializeArray();
    }
}
