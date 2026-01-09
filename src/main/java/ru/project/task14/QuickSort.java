package ru.project.task14;

import java.util.Arrays;

public class QuickSort {

    /**
     * {P: arr.length > 0} quickSort(arr) {Q: sorted(arr)}
     * Предусловие: массив не пустой.
     * Команда: гарантируется отсутствие сайд эффектов.
     * Постусловие: возвращается отсортированный в порядке возрастания исходный массив.
     */
    public static void quickSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        quickSort(array, 0, array.length - 1);
    }

    /**
     * {P: 0 ≤ low ≤ high < arr.length} quickSort(arr, low, high) {Q: sorted(arr, low, high)}
     * Предусловие: low больше чем high.
     * Команда: гарантируется отсутствие сайд эффектов.
     * Постусловие: подмассив[low, high] отсортирован в порядке возрастания, остальные элементы не изменены.
     *
     * Процесс:
     * Вызов partition с предусловием low < high, который возвращает опорный элемент.
     * Далее идут рекурсивный вызовы для верхней и нижней частей массива по pivot. Из-за свойств partition объединение дает отсортированный массив.
     */
    private static void quickSort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot = partition(array, low, high);

        quickSort(array, low, pivot - 1);
        quickSort(array, pivot + 1, high);
    }

    /**
     * {P: 0 ≤ low ≤ high < arr.length} partition(arr, low, high) {Q: low <= i <= high
     * и все слева от i < array[i], все справа от i ≥ array[i] и pivot = i}
     * Предусловие: low больше чем high.
     * Команда: гарантируется отсутствие сайд эффектов.
     * Постусловие: подмассив[low, high] отсортирован в порядке возрастания, остальные элементы не изменены.
     *
     * Инвариант цикла I: Все элементы от low до i-1 меньше pivotValue и от i до j-1 больше или равны pivotValue, pivotValue = array[high].
     *
     * Инициализация:
     * В начале i == j == low, а pivotValue = array[middle]. Инвариант выполняется, т.к. [low, i-1] = [low, low-1] и
     * [i, j-1] = [low, low-1] - пустые, а pivotValue = array[high].
     *
     * Процесс:
     * Если array[j] < pivotValue: перемещаем его в начальную часть, увеличиваем значение i, а если array[j] >= pivotValue, то только увеличиваем значение j.
     *
     * Завершение:
     * Цикл завершается, когда j == high.
     * Все элементы от low до i < array[i], т.к. array[i]==pivotValue.
     * Все элементы от i до high >= array[i], т.к. array[high]==array[i+1]
     *
     * Получается, что partition действительно разделяет массив на две части относительно опрного элемента, где
     * элементы слева от i < array[i], а справа от i >= array[i], т.е. массив частично отсортирован.
     */
    private static int partition(int[] array, int low, int high) {
        int middle = low + (high - low) / 2;
        int pivotValue = array[middle];

        int tmp = array[middle];
        array[middle] = array[high];
        array[high] = tmp;

        int i = low;
        for (int j = low; j < high; j++) {
            if (array[j] < pivotValue) {
                tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
            }
        }

        tmp = array[i];
        array[i] = array[high];
        array[high] = tmp;

        return i;
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3, -6, 0, 78, 17, 30};
        System.out.println("Исходный массив: " + Arrays.toString(array));
        quickSort(array);
        System.out.println("Отсортированный массив: " + Arrays.toString(array));

        array = new int[]{};
        quickSort(array);
        System.out.println("Пустой массив: " + Arrays.toString(array));

        array = new int[]{1};
        quickSort(array);
        System.out.println("Массив из одного элемента: " + Arrays.toString(array));

        array = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println("Исходный обратно отсортированный массив: " + Arrays.toString(array));
        quickSort(array);
        System.out.println("Обратно отсортированный массив: " + Arrays.toString(array));
    }
}
