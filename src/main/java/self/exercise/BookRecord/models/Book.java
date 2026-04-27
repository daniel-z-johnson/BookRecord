package self.exercise.BookRecord.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
// for tools
@NoArgsConstructor
public class Book {
    private int id;
    private String title;
    private String subtitle;
    private String isbn10;
    private String isbn13;
}
