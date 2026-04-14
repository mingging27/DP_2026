package ch10.Q4;

import java.util.*;

class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("D", "B", "C", "E", "A");

        // 사전순으로 작은 순서 (오름차순)
        list.sort(new Comparator<String>() { // 일반적으로 인터페이스를 new..? -> 불가 
            // 여기서 구현하면 가능! -> 자바가 자동으로 익명의 내부 클래스를 생성해줌
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2); // 사전순으로 작은 순서 (오름차순)
            }
        });  // Comparator를 넣어줌
        System.out.println(list);

        // 사전순으로 큰 순서 (내림차순)
        list.sort( /* 미구현 */ );
        System.out.println(list);
    }
}
