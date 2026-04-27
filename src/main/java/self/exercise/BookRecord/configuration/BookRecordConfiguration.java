package self.exercise.BookRecord.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class BookRecordConfiguration {

    @Bean
    public RestClient openLibraryRestClient(
            @Value("${open-library.base-url:https://openlibrary.org/api/books}") String openLibraryBaseUrl) {
        return RestClient.builder()
                .baseUrl(openLibraryBaseUrl)
                .build();
    }
}
