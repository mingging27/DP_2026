package ch01.A1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookShelf implements Iterable<Book> {
    private List<Book> books;

    public BookShelf(int initialsize) {
        this.books = new ArrayList<>(initialsize);  //책장의 크기를 넘어도 자동으로 늘어나는 ArrayList 사용
    }

    public Book getBookAt(int index) {
        return books.get(index);
    }

    public void appendBook(Book book) {
        books.add(book);    //add 메서드
    }

    public int getLength() {
        return books.size();
    }

    @Override
    public Iterator<Book> iterator() {
        return new BookShelfIterator(this);
    }
}
