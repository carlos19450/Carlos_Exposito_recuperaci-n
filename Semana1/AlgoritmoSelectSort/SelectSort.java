package AlgoritmoSelectSort;

public class SelectSort {
    public static void selectionSort(int[] array){
        for (int i = 0; i < array.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < array.length; j++){
                if (array[j] < array[index]){
                    index = j;
                }
            }
            int numerMasBajo = array[index];
            array[index] = array[i];
            array[i] = numerMasBajo;
        }
    }

    public static void main(String a[]){
        int[] array = {8,7,6,5,4,3,2,1};
        System.out.println("Antes de hacer Selection Sort");
        for(int i : array){
            System.out.print(i + " ");
        }
        System.out.println();

        selectionSort(array);

        System.out.println("Despues de hacer Selection Sort");
        for(int i : array){
            System.out.print(i+" ");
        }
    }
}
