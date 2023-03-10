import java.util.Random;

public class Main {
    public static int[] headLength = {50, 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000}; //Длина массива
    //Генерируем рандомный массив длинной 1000
    static Random random = new Random();
    public static int[] notSorted = random.ints(headLength[headLength.length - 1], 0, 5000).toArray();

    public static void regenerate() {
        notSorted = random.ints(headLength[headLength.length - 1], 0, 5000).toArray();
    }
    //Метод меняющий два элемента массива местами
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    //1.Сортировка вставками
    public static void insertionSort(int[] toSort){
        for (int left = 0; left < toSort.length; left++) {
            // Вытаскиваем значение элемента
            int value = toSort[left];
            // Перемещаемся по элементам, которые перед вытащенным элементом
            int i = left - 1;
            for (; i >= 0; i--) {
                // Если вытащили значение меньшее — передвигаем больший элемент дальше
                if (value < toSort[i]) {
                    toSort[i + 1] = toSort[i];
                } else {
                    // Если вытащенный элемент больше — останавливаемся
                    break;
                }
            }
            // В освободившееся место вставляем вытащенное значение
            toSort[i + 1] = value;
        }
    }
    //2.Пузырьковая сортировка
    public static void bubbleSort(int[] toSort) {
        for (int left = 0; left < toSort.length; left++) {
            int minInd = left;
            for (int i = left; i < toSort.length; i++) {
                if (toSort[i] < toSort[minInd]) {
                    minInd = i;
                }
            }
            swap(toSort, left, minInd);
        }
    }
    //3.Быстрая сортировка
    public static void quickSort(int[] toSort, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = toSort[(leftMarker + rightMarker) / 2];
        do {
            while (toSort[leftMarker] < pivot) {
                leftMarker++;
            }
            while (toSort[rightMarker] > pivot) {
                rightMarker--;
            }
            if (leftMarker <= rightMarker) {
                if (leftMarker < rightMarker) {
                    swap(toSort, leftMarker, rightMarker);
                }
                leftMarker++;
                rightMarker--;
            }
        }
        while (leftMarker <= rightMarker);
            if (leftMarker < rightBorder){
                quickSort(toSort, leftMarker, rightBorder);
            }
            if (leftBorder < rightMarker){
                quickSort(toSort, leftBorder, rightMarker);
            }
    }
    //4.Сортировка выбором
    public static void selectionSort(int[] toSort){
        for (int left = 0; left < toSort.length; left++){
            int minInd = left;
            for (int i = left; i < toSort.length; i++){
                if (toSort[i] < toSort[minInd]){
                    minInd = i;
                }
            }
            swap(toSort, left, minInd);
        }
    }
    //5.Сортировка кучей
    static void restore(int arr[], int heapSize, int iRoot)
    {
        int largest = iRoot; // Инициализируем наибольший элемент как корень
        int left = 2*iRoot + 1; // левый = 2*i + 1
        int right = 2*iRoot + 2; // правый = 2*i + 2

        // Если левый дочерний элемент больше корня
        if (left < heapSize && arr[left] > arr[largest])
            largest = left;

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (right < heapSize && arr[right] > arr[largest])
            largest = right;
        // Если самый большой элемент не корень
        if (largest != iRoot)
        {
            int swap = arr[iRoot];
            arr[iRoot] = arr[largest];
            arr[largest] = swap;

            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            restore(arr, heapSize, largest);
        }
    }
    public static void heapSort(int[] toSort) {
        int arrlen = toSort.length;

        // Построение кучи (перегруппируем массив)
        for (int i = arrlen / 2 - 1; i >= 0; i--)
            restore(toSort, arrlen, i);

        // Один за другим извлекаем элементы из кучи
        for (int i=arrlen-1; i>=0; i--)
        {
            // Перемещаем текущий корень в конец
            int temp = toSort[0];
            toSort[0] = toSort[i];
            toSort[i] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            restore(toSort, i, 0);
        }
    }
    //Реализация сортировок
    public static Object[] allSorts(int[] notSorted ){
        long[] allTimesInsertion = new long[headLength.length];
        long[] allTimesBubble = new long[headLength.length];
        long[] allTimesSelection = new long[headLength.length];
        long[] allTimesQuick = new long[headLength.length];
        long[] allTimesHeap = new long[headLength.length];

        for (int i = 0; i < headLength.length; i++) {
            //Передаём сгенерированный массив
            int[] toSortInsertion = new int[headLength[i]];
            int[] toSortBubble = new int[headLength[i]];
            int[] toSortQuick = new int[headLength[i]];
            int[] toSortSelection = new int[headLength[i]];
            int[] toSortHeap = new int[headLength[i]];

            int srcPos = headLength[headLength.length - 1] - headLength[i];
            System.arraycopy(notSorted, srcPos, toSortInsertion, 0, headLength[i]); //Массив для сортировки вставками
            System.arraycopy(notSorted, srcPos, toSortBubble, 0, headLength[i]); //Массив для сортировки пузырьком
            System.arraycopy(notSorted, srcPos, toSortQuick, 0, headLength[i]); //Массив для быстрой сортировки
            System.arraycopy(notSorted, srcPos, toSortSelection, 0, headLength[i]); //Массив для сортировки выбором
            System.arraycopy(notSorted, srcPos, toSortHeap, 0, headLength[i]); //Массив для сортировки кучей

            //1.Вызов сортировки вставками
            long startInsertion = System.nanoTime();
            insertionSort(toSortInsertion);
            long finishInsertion = System.nanoTime();
            long elapsed = finishInsertion - startInsertion;
            allTimesInsertion[i] = elapsed;

            //2.Вызов сортировки пузырьком
            long startBubble = System.nanoTime();
            bubbleSort(toSortBubble);
            long finishBubble = System.nanoTime();
            elapsed = finishBubble - startBubble;
            allTimesBubble[i] = elapsed;

            //3.Вызов быстрой сортировки
            long startQuick = System.nanoTime();
            quickSort(toSortQuick, 0, toSortQuick.length - 1);
            long finishQuick = System.nanoTime();
            elapsed = finishQuick - startQuick;
            allTimesQuick[i] = elapsed;

            //4.Вызов сортировки выбором
            long startSelection = System.nanoTime();
            selectionSort(toSortSelection);
            long finishSlow = System.nanoTime();
            elapsed = finishSlow - startSelection;
            allTimesSelection[i] = elapsed;

            //5. Вызов сортировки кучей
            long startHeap = System.nanoTime();
            heapSort(toSortHeap);
            long finishHeap = System.nanoTime();
            elapsed = finishHeap - startHeap;
            allTimesHeap[i] = elapsed;
        }
        Object[] times = {allTimesInsertion, allTimesBubble, allTimesQuick, allTimesSelection, allTimesHeap};
        new FinalMenu(headLength, allTimesInsertion, allTimesBubble, allTimesQuick, allTimesSelection, allTimesHeap);
        return times;
    }
    public static Object[] allTimes = allSorts(notSorted);

    public static void main(String[] args) {
    }
}
