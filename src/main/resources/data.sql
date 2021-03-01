INSERT INTO ADDRESS
VALUES(1, '33-212', 'Kanzas', 'Kanzańska', '23/1');
INSERT INTO ADDRESS
VALUES(2, '33-211', 'Gniezno', 'Warszawska', '41');
INSERT INTO ADDRESS
VALUES(3, '33-256', 'Warszawa', 'Gniezieńska', '15d/12');

INSERT INTO PERSON
VALUES(1, 1, 'John', 'Kolewicz', '232 332 334', 'john@wp.ld');
INSERT INTO PERSON
VALUES(2, 3, 'Rick', 'Wincyj', '111 332 3267', 'rick@wp.ld');
INSERT INTO PERSON
VALUES(3, 2, 'Leon', 'Zawodowiec', '456 31 3267', 'leon@wp.ld');

INSERT INTO BOOK
VALUES(4, null, 'Zielony', 'Ellon Mask', false, CURRENT_TIMESTAMP);
INSERT INTO BOOK
VALUES(1, 1, 'Czerwony Kapturek', 'Adam Mickiewicz', false, CURRENT_TIMESTAMP);
INSERT INTO BOOK
VALUES(2, 2, 'Kapturek', 'Mickiewicz', false, CURRENT_TIMESTAMP);

INSERT INTO USER_BOOKSTORE
VALUES(1, 'quishu', '$2y$12$f73ltQwBxEpAkWJzxZ2pdOXT54ewBmqyzdc4o6P2yJtokfxqvVa1.', true, 'ROLE_USER,ROLE_ADMIN', 1);