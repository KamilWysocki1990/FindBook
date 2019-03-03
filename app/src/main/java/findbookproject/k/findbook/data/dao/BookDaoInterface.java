package findbookproject.k.findbook.data.dao;

import java.util.List;

import findbookproject.k.findbook.data.watchedBook.WatchedBook;

public interface BookDaoInterface {

    void insert(WatchedBook watchedBook);
    void delete(WatchedBook watchedBook);
    List<WatchedBook> getAllBooks();

}
