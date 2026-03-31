package practice.ch05;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Triple {
    private static Map<String, Triple> triple = new HashMap<>();    // key: ALPHA, BETA, GAMMA / value: Triple 객체
    static {
        String[] names = {"ALPHA", "BETA", "GAMMA"};
        // names 배열의 각 요소에 대해 Triple 객체를 하나씩 생성하여 triple 맵에 저장
        Arrays.stream(names).forEach(s -> triple.put(s, new Triple(s)));
    }


    private Triple(String name) {
    }

    public static Triple getInstance(String name) {
        return triple.get(name);
    }


}
