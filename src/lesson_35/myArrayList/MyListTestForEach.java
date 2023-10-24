package lesson_35.myArrayList;

public class MyListTestForEach {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.addAll(10, -45, 24, 0, 128, 15);
        for (Integer val: list){
            System.out.print(val + ", ");
        }
        System.out.println();
    }
}