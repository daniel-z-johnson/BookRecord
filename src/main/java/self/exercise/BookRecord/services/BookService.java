package self.exercise.BookRecord.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import self.exercise.BookRecord.mappers.BookMapper;
import self.exercise.BookRecord.models.Book;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookMapper bookMapper;

    public List<Book> getBooks() {
        return getBooks(0);
    }

    public List<Book> getBooks(int idOffSet) {
        return bookMapper.getBooks(idOffSet);
    }

    public Book insertBook(Book book) {
        Objects.requireNonNull(book, "book cannot be null");

        Book existingBook = findExistingBook(book);
        if (existingBook != null) {
            return existingBook;
        }

        bookMapper.insertBook(book);
        return book;
    }

    public Book findExistingBook(Book book) {
        if (book.getIsbn10() != null) {
            Book existing = bookMapper.findByISBN10(book.getIsbn10());
            if (existing != null) {
                return existing;
            }
        }

        if (book.getIsbn13() != null) {
            Book existing = bookMapper.findByISBN13(book.getIsbn13());
            if (existing != null) {
                return existing;
            }
        }

        return null;
    }
}
