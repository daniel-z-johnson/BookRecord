CREATE TABLE books (
                       id INTEGER PRIMARY KEY AUTOINCREMENT,
                       title TEXT NOT NULL,
                       subtitle TEXT,
                       isbn10 TEXT,
                       isbn13 TEXT,
                       CONSTRAINT uq_books_isbn10 UNIQUE (isbn10),
                       CONSTRAINT uq_books_isbn13 UNIQUE (isbn13)
);

CREATE TABLE authors (
                         id INTEGER PRIMARY KEY AUTOINCREMENT,
                         url TEXT,
                         name TEXT NOT NULL
);

CREATE TABLE contents (
                          id INTEGER PRIMARY KEY AUTOINCREMENT,
                          book_id INTEGER NOT NULL,
                          title TEXT NOT NULL,
                          page_number TEXT,
                          CONSTRAINT fk_contents_book
                              FOREIGN KEY (book_id) REFERENCES books(id) ON DELETE CASCADE
);

CREATE TABLE authors_books (
                               author_id INTEGER NOT NULL,
                               book_id INTEGER NOT NULL,
                               PRIMARY KEY (author_id, book_id),
                               CONSTRAINT fk_authors_books_author
                                   FOREIGN KEY (author_id) REFERENCES authors(id) ON DELETE CASCADE,
                               CONSTRAINT fk_authors_books_book
                                   FOREIGN KEY (book_id) REFERENCES books(id) ON DELETE CASCADE
);

CREATE INDEX idx_contents_book_id ON contents(book_id);
CREATE INDEX idx_authors_books_author_id ON authors_books(author_id);
CREATE INDEX idx_authors_books_book_id ON authors_books(book_id);
CREATE INDEX idx_authors_url ON authors(url);