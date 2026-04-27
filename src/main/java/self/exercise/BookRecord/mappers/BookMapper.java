package self.exercise.BookRecord.mappers;

import org.apache.ibatis.annotations.*;
import self.exercise.BookRecord.models.Book;

import java.util.List;

@Mapper
public interface BookMapper {

    @Results(id = "bookResultMap", value = {
        @Result(property = "id",       column = "id"),
        @Result(property = "title",    column = "title"),
        @Result(property = "subtitle", column = "subtitle"),
        @Result(property = "isbn10",   column = "isbn10"),
        @Result(property = "isbn13",   column = "isbn13")
    })
    @Select("SELECT id, title, subtitle, isbn10, isbn13 FROM books WHERE id >= #{idOffSet} LIMIT 20")
    List<Book> getBooks(int idOffSet);

    @Insert("INSERT INTO books (title, subtitle, isbn10, isbn13) VALUES (#{title}, #{subtitle}, #{isbn10}, #{isbn13})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertBook(Book book);

    @ResultMap("bookResultMap")
    @Select("SELECT id, title, subtitle, isbn10, isbn13 FROM books WHERE isbn10 = #{isbn10}")
    Book findByISBN10(String isbn10);

    @ResultMap("bookResultMap")
    @Select("SELECT id, title, subtitle, isbn10, isbn13 FROM books WHERE isbn13 = #{isbn13}")
    Book findByISBN13(String isbn13);
}
