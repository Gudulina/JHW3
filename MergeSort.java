class MergeSort {
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        // Создание временных массивов
        int leftАrray[] = new int[n1];
        int rightАrray[] = new int[n2];

        // Копирование данных во временные массивы
        for (int i = 0; i < n1; ++i)
            leftАrray[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            rightАrray[j] = arr[m + 1 + j];


        // Объединение временных массиовов
        
        int i = 0, j = 0; // Начальные индексы первого и второго подмассивов
        
        int k = l;
        while (i < n1 && j < n2) {
            if (leftАrray[i] <= rightАrray[j]) {
                arr[k] = leftАrray[i];
                i++;
            } else {
                arr[k] = rightАrray[j];
                j++;
            }
            k++;
        }

        // Копирование оставшихся в подмассивах элементов
        while (i < n1) {
            arr[k] = leftАrray[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = rightАrray[j];
            j++;
            k++;
        }
    }

    // Основная функция, которая сортирует с помощью слияния
    void sort(int arr[], int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2; // середина

            // Сортировка первой и второй половины
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Объединение отсортированных половин
            merge(arr, l, m, r);
        }
    }

    // Печать массива
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    
    public static void main(String args[]) {
        int arr[] = { 6, 1, 9, 3, 5, 2, 10, 4, 7, 8 };

        System.out.println("Исходный массив");
        printArray(arr);

        MergeSort data = new MergeSort();
        data.sort(arr, 0, arr.length - 1);

        System.out.println("\nОтсортированный массив");
        printArray(arr);
    }
}