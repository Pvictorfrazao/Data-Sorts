import java.util.Arrays;

public class SortingAlgorithms {

    // Bubble Sort
    public static void bubbleSort(String[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    // Troca arr[j] e arr[j+1]
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort
    public static void quickSort(String[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(String[] arr, int low, int high) {
        // Escolha um índice aleatório como pivô
        int randomIndex = low + (int)(Math.random() * (high - low + 1));

        // Troque o pivô aleatório com o último elemento
        String temp = arr[randomIndex];
        arr[randomIndex] = arr[high];
        arr[high] = temp;

        // Defina o pivô como o último elemento
        String pivot = arr[high];
        int i = low - 1;

        // Particione o array em relação ao pivô
        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) < 0) {
                i++;
                // Troca arr[i] e arr[j]
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Coloque o pivô na posição correta
        temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        // Retorne o índice do pivô
        return i + 1;
    }

    // Shell Sort
    public static void shellSort(String[] arr) {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                String temp = arr[i];
                int j = i;
                while (j >= gap && arr[j - gap].compareTo(temp) > 0) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }
    }

    // Merge Sort
    public static void mergeSort(String[] arr) {
        if (arr.length < 2) return;
        int mid = arr.length / 2;
        String[] left = Arrays.copyOfRange(arr, 0, mid);
        String[] right = Arrays.copyOfRange(arr, mid, arr.length);

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    private static void merge(String[] arr, String[] left, String[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
}
