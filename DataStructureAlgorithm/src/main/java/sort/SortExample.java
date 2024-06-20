package sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SortExample {
    static class Student{
        int age;
        String name;

        public Student(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" + "age=" + age + ", name='" + name + '\'' + '}';
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{5, 1, 2, 7, 8, 3, 0};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));

        Student[] s = {new Student(20, "a"), new Student(19, "b")};

        System.out.println(Arrays.toString(s));

        Arrays.sort(s, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.age - o2.age;
            }
        });

        System.out.println(Arrays.toString(s));
    }
}
