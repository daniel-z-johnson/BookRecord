package self.exercise.BookRecord.configuration.openLibrary;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Book {
    private String url;
    private String key;
    private String title;
    private String subtitle;
}
