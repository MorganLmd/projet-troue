INSERT INTO USER(ADDRESS, CITY, CREDIT_CARD_DATE, CREDIT_CARD_NUMBER, CREDIT_CARD_SECURITY_CODE, EMAIL, FIRST_NAME, LAST_NAME, PASSWORD, PHONE_NUMBER, POSTAL_CODE, USER_ROLE)
VALUES('1 rue Nationale', 'Lille', '2021-03-01', '9876543210', '156', 'jean.dupont@gmail.com', 'Jean', 'Dupont', '1234', '0354698521', '59000', 'USER');
INSERT INTO USER(ADDRESS, CITY, CREDIT_CARD_DATE, CREDIT_CARD_NUMBER, CREDIT_CARD_SECURITY_CODE, EMAIL, FIRST_NAME, LAST_NAME, PASSWORD, PHONE_NUMBER, POSTAL_CODE, USER_ROLE)
VALUES('12 rue de la clef', 'Lille', '2021-05-09', '9876543210', '987', 'lise.durant@gmail.com', 'Lise', 'Durant', 'password', '0365987541', '59000', 'USER');
INSERT INTO USER(EMAIL, FIRST_NAME, LAST_NAME, PASSWORD, USER_ROLE)
VALUES('admin@projettroue.com', 'Morgan', 'Lombard', 'admin', 'ADMIN');

INSERT INTO BOOK(AUTHOR, BOOK_FORMAT, DESCRIPTION, ISBN, PUBLICATION_DATE, PUBLISHER, TITLE)
VALUES('Howard Phillips Lovecraft', 'ebook', 'From the Inside Flap of black magic unearthed unspeakable horrors in a quiet town near Providence, Rhode Island. Evil spirits are being resurrected from beyond the grave, a supernatural force so twisted that it kills without offering the mercy of death!', '978-0345354907', '1987-07-02', 'Penguin Books', 'The Case Of Charles Dexter Ward');
INSERT INTO BOOK(AUTHOR, BOOK_FORMAT, DESCRIPTION, ISBN, PUBLICATION_DATE, PUBLISHER, TITLE)
VALUES('Howard Phillips Lovecraft', 'ebook', 'Long acknowledged as a master of nightmarish visions, H. P. Lovecraft established the genuineness and dignity of his own pioneering fiction in 1931 with his quintessential work of supernatural horror, At the Mountains of Madness. The deliberately told and increasingly chilling recollection of an Antarctic expedition’s uncanny discoveries–and their encounter with untold menace in the ruins of a lost civilization–is a milestone of macabre literature.', '978-0812974416', '1981-05-09', 'Modern Library', 'At the Mountains of Madnes');
INSERT INTO BOOK(AUTHOR, BOOK_FORMAT, DESCRIPTION, ISBN, PUBLICATION_DATE, PUBLISHER, TITLE)
VALUES('Frank Herbert', 'ebook', 'Set on the desert planet Arrakis, Dune is the story of the boy Paul Atreides, heir to a noble family tasked with ruling an inhospitable world where the only thing of value is the “spice” melange, a drug capable of extending life and enhancing consciousness. Coveted across the known universe, melange is a prize worth killing for...', '978-0441172719', '1990-09-01', 'Ace', 'Dune');

INSERT INTO BOOK_OWNER(ID_BOOK, ID_USER)
VALUES(1, 1);
INSERT INTO BOOK_OWNER(ID_BOOK, ID_USER)
VALUES(1, 2);
INSERT INTO BOOK_OWNER(ID_BOOK, ID_USER)
VALUES(2, 1);
INSERT INTO BOOK_OWNER(ID_BOOK, ID_USER)
VALUES(2, 2);
INSERT INTO BOOK_OWNER(ID_BOOK, ID_USER)
VALUES(3, 2);