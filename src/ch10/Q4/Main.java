package ch10.Q4;

import java.util.*;

class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("D", "B", "C", "E", "A");

        // 사전순으로 작은 순서 (오름차순)
        // 비교기 타입 : Comparator<String> -> 인터페이스라 원래는 객체 생성 불가 -> Comparator 구현한 코드 필요
        list.sort(new Comparator<String>() { // 일반적으로 인터페이스를 new..? -> 불가 
            // Functional Interface : 인터페이스에 추상 메소드가 하나만 존재하는 경우 -> 람다식으로 구현 가능 = Comparator
            // 여기서 구현하면 가능! -> 자바가 자동으로 익명의 내부 클래스를 생성해줌
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2); // a-b가 크면 위치를 바꿈 (Unicode 기준) -> 사전순으로 작은 순서 (오름차순)
            }
        });  // Comparator를 넣어줌

        // 입력 -> 출력
        list.sort((s1, s2) -> s1.compareTo(s2)); // 람다식으로 구현 -> Comparator 인터페이스의 compare 메소드 구현

        System.out.println(list);

        // 사전순으로 큰 순서 (내림차순)
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.compareTo(s1); // b-a가 크면 위치를 바꿈 -> 사전순으로 큰 순서 (내림차순)
            }
        });

        System.out.println(list);
    }
}
