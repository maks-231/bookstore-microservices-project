--changeset ibodnar:insert-data-into-genres-table splitStatements:false
INSERT INTO genres (id, name)
values (1, 'Fiction'),
       (2, 'Mystery'),
       (3, 'Thriller'),
       (4, 'Romance'),
       (5, 'Science'),
       (6, 'Fantasy'),
       (7, 'Biography'),
       (8, 'Historical Fiction'),
       (9, 'Horror'),
       (10, 'Detective'),
       (11, 'Adventure');

--changeset ibodnar:insert-data splitStatements:false
INSERT INTO publishers(id, name)
values (1, 'Bloomsbury');

INSERT INTO authors(id, name, email)
values (1, 'J. K. Rowling', 'jkrowling@mail.com');

INSERT INTO books(isbn, title, publisher_id, publication_date, genre_id, description, "language", pages, price)
VALUES ('9781408855652', 'Harry Potter and the Philosopher''s Stone', 1, '2011-09-01', 6,
        'Join Harry Potter as he sets out on the magical journey of a lifetime in the first book in J.K.Rowling''s multi-award-winning series', 'EN', 352, 10);

INSERT INTO books(isbn, title, publisher_id, publication_date, genre_id, description, "language", pages, price)
VALUES ('9781408855669', 'Harry Potter and the Chamber of Secrets', 1, '2014-09-01', 6,
        'Join Harry Potter on the magical journey of a lifetime in the second book in J.K.Rowling''s multi-award-winning series', 'RU', 384, 10);

INSERT INTO books_to_authors(book_isbn, author_id)
VALUES ('9781408855652', 1),
       ('9781408855669', 1);