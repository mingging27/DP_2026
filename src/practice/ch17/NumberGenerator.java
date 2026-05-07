package practice.ch17;

import java.util.ArrayList;
import java.util.List;

// 관찰 대상
public abstract class NumberGenerator {
    // Observer를 저장한다  
    // Observer: 부모 타입 => 모든 종류의 관찰자를 저장할 수 O
    // 관찰 대상은 구체적으로 어떤 관찰자가 자기를 관찰하는지 모른다. 알 필요가 없다 => 느슨한 결합
    private List<Observer> observers = new ArrayList<>(); // Observer 리스트

    // Observer를 추가한다 
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // Observer를 제거한다 
    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    // Observer에 통지한다 
    public void notifyObservers() {
        for (Observer o: observers) {   // 확장 for문
            o.update(this); // 관찰자에게 통지
        }
    }

    // 수를 취득한다 
    public abstract int getNumber();

    // 수를 생성한다 
    public abstract void execute();
}
