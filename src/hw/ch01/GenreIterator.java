package hw.ch01;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class GenreIterator implements Iterator<Book> {
    private BookShelf bookShelf;
    private String genre;
    private int index;

    // 생성자
    public GenreIterator(BookShelf bookShelf, String genre) {
        this.bookShelf = bookShelf;
        this.genre = genre;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        while (index < bookShelf.getLength()) { // 책장의 길이보다 인덱스가 작을 때
            if (bookShelf.getBookAt(index).getGenre().equals(genre)) { //Iterator가 가리키는 책의 장르가 찾는 장르와 같을 때
                return true;
            }
            index++;
        }
        return false;
    }

    @Override
    public Book next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Book book = bookShelf.getBookAt(index);
        index++;
        return book;
    }
}
