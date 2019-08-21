package core.basesyntax;

import java.util.LinkedList;

public class FindNumbers {

    /**
     * <p>Реализуйте метод getAllNumbers(String text) который принимает строку, cодержащую буквы,
     * целые числа и иные символы.</p>
     *
     * <p>Требуется: все числа, которые встречаются в строке, поместить в отдельный целочисленный
     * массив, каждый элемент этого массива умножить на 2. Метод должен возвращать этот массив.</p>
     *
     * <p>Пример: если дана строка "data 48 call 9 read13 blank0a", то в массиве должны оказаться
     * числа 96, 18, 26 и 0.</p>
     */
    public int[] getAllNumbers(String text) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isDigit(c) || c == '-') {
                builder.append(c);
            } else {
                builder.append(' ');
            }
        }
        builder.append(' ');
        LinkedList<Integer> res = new LinkedList<Integer>();
        for (int i = 0; i < builder.length();i++) {
            if (builder.charAt(i) != ' ') {
                int nextWhitespace = builder.indexOf(" ", i);
                res.add(Integer.parseInt(builder.substring(i, nextWhitespace)));
                i = nextWhitespace;
            }
        }
        int[] arr = new int[res.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = res.pop() * 2;
        }
        return arr;
    }
}
