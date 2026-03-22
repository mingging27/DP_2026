package hw.ch01;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class YearIterator implements Iterator<Book> {
    private BookShelf bookShelf;
    private int index;
    private boolean [] visited; // 방문 여부를 저장하는 배열

    public YearIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = 0;
        this.visited = new boolean[bookShelf.getLength()]; // 책장의 길이만큼 방문 여부 배열 초기화
    }

    @Override
    public boolean hasNext() {
    int latest = -1;

    for (int i = 0; i < bookShelf.getLength(); i++) {
        if (!visited[i]) {
            if (latest == -1 || 
                bookShelf.getBookAt(i).getYear() > bookShelf.getBookAt(latest).getYear()) {
                latest = i;
            }
        }
    }

    if (latest == -1) return false; // 모든 책이 방문된 경우

    index = latest;
    return true;
}

    @Override
    public Book next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        
        Book book = bookShelf.getBookAt(index); // index가 가리키는 책을 반환
        visited[index] = true; // 반환한 책은 방문 표시
        
        return book; // index가 가리키는 책을 반환
    }
}
