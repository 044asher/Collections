package PracticalPart.Task7;


import java.util.Arrays;

public class Task7 {
    //Алгоритмическая сложность: O(n^2) - квадратичная сложность из-за вложенного цикла
    public static int[] bubbleSort(int[] array) {
        int n = array.length;
        long startTime = System.nanoTime();
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int j = 0; j < n - 1; j++) { // Цикл проходящий по элементам. -1 для предотвращения выхода за пределы массива
                if (array[j] > array[j + 1]) { // Меняем элементы местами
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    needIteration = true;
                }
            }
        }
        long endTime = System.nanoTime();
        System.out.println("Bubble Sort Time: " + (endTime - startTime) + " nano sec.");
        return array;
    }

    //Алгоритмическая сложность: O(n^2) - квадратичная сложность из-за вложенного цикла
    public static int[] selectionSort(int[] array) { //Неустойчивая сортировка. Одинаковые элементы могут изменить свой порядок
        long startTime = System.nanoTime();
        int n = array.length;
        for (int left = 0; left < n; left++) { //Внешний цикл который пройдет по всем элементам массива
            int minInd = left; //Считаем что минимальный элемент находится в текущей позиции left
            // Внутренний цикл, который ищет минимальный элемент среди оставшихся
            for (int i = left + 1; i < n; i++) { //left + 1, так как уже считаем что нулевой элемент минимальный, дабы убрать одну лишнюю итерацию
                if (array[i] < array[minInd]) {
                    minInd = i; //Если находим элемент меньший чем текущий "минимальный" обновляем minInd.
                }
            }
            //После внутреннего цикла меняем местами найденный минимальный элемент и элемент в текущей позиции left
            int temp = array[minInd];
            array[minInd] = array[left];
            array[left] = temp;
        }
        long endTime = System.nanoTime();
        System.out.println("Selection Sort time: " + (endTime - startTime) + " nano sec.");
        return array;
    }

    //Алгоритмическая сложность: O(n^2) - квадратичная сложность из-за вложенного цикла
    public static int[] insertionSort(int [] array){ //Устойчивая сортировка
        long startTime = System.nanoTime();
        int n = array.length;
        for (int left = 0; left < n; left++) {
            int value = array[left]; //Запоминаем значение текущего элемента массива
            int i = left - 1; //Индекс для перемещения влево и сравнения с другими элементами массива

            for (; i >= 0; i--) { //Ставим условие чтобы і со значением -1 не попало во внутренний цикл
                if(value < array[i]){//Если вытащили элемент меньше - передвигаем больший элемент дальше.
                    array[i + 1] = array[i];//сдвигаем элементы вправо
                }
                else break;//если вытащенный элемент больше - останавливаемся
            }
            array[i + 1] = value;// В освободившееся место вставляем вытащенное значение
        }
        long endTime = System.nanoTime();
        System.out.println("Insertion Sort Time: " + (endTime - startTime) + " nano sec.");
        return array;
    }

    //Алгоритмическая сложность: O(log n) - сложность алгоритма растёт логарифмически с увеличением входных данных.
    public static int[] mergeSort(int[] array) {
        if (array.length <= 1) { //обрабатываем базовый случай.
            return array;
        }

        int middle = array.length / 2; //делим массив пополам, на левый и правый
        int[] left = Arrays.copyOfRange(array, 0, middle);//создаем левую половину массива
        int[] right = Arrays.copyOfRange(array, middle, array.length);//создаем правую половину массива

        mergeSort(left);//делим еще пополам и так далее, пока не получим единичные элементы, или же наш обработанный базовый случай.
        mergeSort(right);

        merge(array, left, right);//объединяем левую и правую половины сначала для левой части которую делили, потом для правой и потом их вместе


        return array;
    }

    private static void merge(int[] array, int[] left, int[] right) {//объединяем левую и правую части
        int i = 0, j = 0, k = 0; //создаем индекс i для массива left, j для right и k для результирующего array
        while (i < left.length && j < right.length) {//итерируем пока не дойдем до конца одного из массивов
            if (left[i] <= right[j]) {//на каждом шаге сравниваем текущие элементы
                array[k++] = left[i++];//если left[i] меньше или равно за right[j], записываем left[i] в результирующий массив array
            } else {
                array[k++] = right[j++];//иначе записываем right[j] в результирующий массив array и увеличиваем k и j.
            }
        }

        //Копируем оставшиеся элементы, если таковые есть, в результирующий массив (array).
        while (i < left.length) {
            array[k++] = left[i++];
        }

        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    //Алгоритмическая сложность: О(log n) - сложность алгоритма растёт логарифмически с увеличением входных данных.
    public static int[] quickSort(int[] array){
        long quickStartTime = System.nanoTime();
        quickSort(array, 0, array.length - 1);
        long quickEndTime = System.nanoTime();
        System.out.println("Quick Sort Time: " + (quickEndTime - quickStartTime) + " nano sec.");

        return array;
    }
    private static void quickSort(int[] array, int leftBorder, int rightBorder){
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = array[(leftMarker + rightMarker) / 2];//опорный элемент, ставим его в середину
        do {
            while (array[leftMarker] < pivot) {//пока левый маркер меньше опорного элемента, идем вправо
                leftMarker++;
            }
            while (array[rightMarker] > pivot) {//пока правый маркер больше опорного элемента, идем влево
                rightMarker--;
            }
            if (leftMarker <= rightMarker) {
                if (leftMarker < rightMarker) {
                    // Если leftMarker меньше rightMarker, выполняется обмен элементами и сдвигаются leftMarker и rightMarker.
                    int temp = array[leftMarker];
                    array[leftMarker] = array[rightMarker];
                    array[rightMarker] = temp;
                }
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);//процесс повторяется до тех пор, пока leftMarker не превысит rightMarker.

        //проверяются границы подмассива, и если есть неотсортированные части, вызывается рекурсивно quickSort для обеих частей.
        if(leftMarker < rightBorder){
            quickSort(array, leftMarker, rightBorder);
        }
        if(leftBorder < rightMarker){
            quickSort(array, leftBorder, rightMarker);
        }

    }


    public static void main(String[] args) {
        int[] array = {10, 5, 6, 1, 2, 3, 4, 9, 8, 7, 2};
        System.out.println("Unsorted array: " + Arrays.toString(array) + "\n");

        int[] bubbleSortedArray = bubbleSort(Arrays.copyOf(array, array.length));
        System.out.println("Bubble Sort: " + Arrays.toString(bubbleSortedArray) + "\n");

        int[] selectionSortedArray = selectionSort(Arrays.copyOf(array, array.length));
        System.out.println("Selection Sort: " + Arrays.toString(selectionSortedArray) + "\n");

        int[] insertionSortedArray = insertionSort(Arrays.copyOf(array, array.length));
        System.out.println("Insertion Sort: " + Arrays.toString(insertionSortedArray) + "\n");


        long startTime = System.nanoTime();
        int[] mergeSortedArray = mergeSort(Arrays.copyOf(array, array.length));
        long endTime = System.nanoTime();
        System.out.println("Merge Sort Time: " + (endTime - startTime) + " nano sec.");
        System.out.println("Merge Sort: " + Arrays.toString(mergeSortedArray) + "\n");

        
        int[] quickSortedArray = quickSort(Arrays.copyOf(array, array.length));
        System.out.println("Quick Sort: " + Arrays.toString(quickSortedArray));

    }


}
