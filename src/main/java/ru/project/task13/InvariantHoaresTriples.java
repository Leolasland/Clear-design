package ru.project.task13;

public class InvariantHoaresTriples {

    /**
     * {P: arr.length > 0} findMax(arr) {Q: result = max(arr)}
     * Предусловие: длина массива arr больше 0, иначе возвращается 0.
     * Команда: гарантируется отсутствие сайд эффектов.
     * Постусловие: возвращается максимальное число в массиве. Если числа равны, то возвращается первый попавшийся элемент массива.
     *
     * Доказательство инварианта.
     * 1. Инициализация:
     * До начала первой итерации цикла: i = 1 и result = arr[0] = maximum(arr[0..0])
     * Проверка инварианта: 1 <= i <= arr.length и i = 1 и result = maximum(arr[0..0])
     * Инвариант истинен в начале.
     *
     * 2. Сохранение инварианта:
     * В теле цикла: если arr[i] > result, то обновляем result и увеличиваем i на 1.
     * После выполнения: result_new = max(result_old, arr[i_old]) = maximum(arr[0..i_old]) и i_new = i_old + 1
     * Следовательно: result_new = maximum(arr[0..i_new-1])
     * Инвариант сохраняется.
     *
     * 3. Завершение:
     * Цикл завершается, когда i становится больше arr.length.
     * Значит: i = arr.length и result = maximum(arr[0..arr.length-1]) = maximum(arr)
     * На этом этапе res = n!, так как инвариант после последней итерации: i = n и res = n!
     * Следовательно, постусловие выполняется: result = max(arr)
     */
    public static int findMax(int [] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > result) {
                result = arr[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5};
        System.out.println(findMax(arr));
        arr = new int[]{5, 4, 3, 2, 1};
        System.out.println(findMax(arr));
    }
}
