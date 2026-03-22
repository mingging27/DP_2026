package hw.ch01;

import java.util.Iterator;

public class BookShelf implements Iterable<Book> {
    private Book[] books;   //배열
    private int last = 0;

    public BookShelf(int maxsize) {
        this.books = new Book[maxsize];
    }

    public Book getBookAt(int index) {
        return books[index];    //배열의 인덱스로 리턴
    }

    public void appendBook(Book book) {
        this.books[last] = book;    //인덱스로 책 추가
        last++;
    }

    public int getLength() {
        return last;
    }

    @Override
    public Iterator<Book> iterator() {
        return new BookShelfIterator(this);
    }

    public Iterator<Book> iteratorByGenre(String genre) {
        return new GenreIterator(this, genre);
    }

    public Iterator<Book> iteratorByYear() {
        return new YearIterator(this);
    }
}