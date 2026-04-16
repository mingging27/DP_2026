package practice.ch11;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry {
    private String name;
    private List<Entry> directory = new ArrayList<>();  // 컬렉션, 자식(엔트리)를 보관할 리스트, Entry: 부모 타입 (디렉터리와 파일 모두 저장 ㄱㄴ)

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {  // 자기 자식들의 크기를 모두 더함
        int size = 0;
        for (Entry entry: directory) {  // 형식 (원소 변수: 컬렉션)
            size += entry.getSize();    // entry - 파일: 자신의 파일의 크기 반환 / 디렉터리: 이 메서드 재귀적 호출
        }
        return size;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);    // this.toString() 
        for (Entry entry: directory) {
            entry.printList(prefix + "/" + name);   // 이전 경로 + 자기 이름 -> 자식에게 전달
        }
    }

    // 디렉터리 엔트리를 디렉터리에 추가한다
    public Entry add(Entry entry) {
        directory.add(entry);
        return this;
    }
}
