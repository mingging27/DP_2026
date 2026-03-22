package practice.ch01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookShelf implements Iterable<Book> {
    private List<Book> books;   // ArrayList
    private int last = 0;   // 책장의 마지막 책

    public BookShelf(int initialCapacity) {
        this.books = new ArrayList<>(initialCapacity);
    }

    public Book getBookAt(int index) {
        return books.get(index);    // ArrayList의 인덱스로 리턴
    }

    public void appendBook(Book book) {
        this.books.add(book);    // ArrayList에 책 추가
    }

    public int getLength() {
        return books.size();    // ArrayList의 크기 리턴
    }

    @Override
    public Iterator<Book> iterator() {
        return new BookShelfIterator(this);
    }
}
