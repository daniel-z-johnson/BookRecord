CREATE TABLE books (
                       id BIGSERIAL PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       subtitle VARCHAR(255),
                       isbn10 VARCHAR(10),
                       isbn13 VARCHAR(13),
                       CONSTRAINT uq_books_isbn10 UNIQUE (isbn10),
                       CONSTRAINT uq_books_isbn13 UNIQUE (isbn13)
);

CREATE TABLE authors (
                         id BIGSERIAL PRIMARY KEY,
                         url TEXT,
                         name VARCHAR(255) NOT NULL
);

CREATE TABLE contents (
                          id BIGSERIAL PRIMARY KEY,
                          book_id BIGINT NOT NULL,
                          title VARCHAR(255) NOT NULL,
                          page_number VARCHAR(50),
                          CONSTRAINT fk_contents_book
                              FOREIGN KEY (book_id) REFERENCES books(id) ON DELETE CASCADE
);

CREATE TABLE authors_books (
                               author_id BIGINT NOT NULL,
                               book_id BIGINT NOT NULL,
                               PRIMARY KEY (author_id, book_id),
                               CONSTRAINT fk_authors_books_author
                                   FOREIGN KEY (author_id) REFERENCES authors(id) ON DELETE CASCADE,
                               CONSTRAINT fk_authors_books_book
                                   FOREIGN KEY (book_id) REFERENCES books(id) ON DELETE CASCADE
);

CREATE INDEX idx_contents_book_id ON contents(book_id);
CREATE INDEX idx_authors_books_author_id ON authors_books(author_id);
CREATE INDEX idx_authors_books_book_id ON authors_books(book_id);