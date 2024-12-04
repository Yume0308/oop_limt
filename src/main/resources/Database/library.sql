use library;

create table MailServer
(
    ServerName     TEXT,
    ServerPort     INTEGER,
    Email          TEXT,
    Password       TEXT,
    Authentication TEXT,
    TLS            TEXT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table BOOK
(
    ID            INT AUTO_INCREMENT,
    ISBN          VARCHAR(13) NOT NULL UNIQUE,
    Author        VARCHAR(255) NOT NULL,
    Title         VARCHAR(255) NOT NULL,
    Category      VARCHAR(100) DEFAULT 'Unknown',
    Publisher     VARCHAR(100) DEFAULT 'Unknown',
    Quantity      INTEGER DEFAULT 0,
    ImagePath     VARCHAR(255) DEFAULT 'Unknown',
    PRIMARY KEY (ID, ISBN)
);

create table User
(
    UserID      INTEGER NOT NULL UNIQUE AUTO_INCREMENT,
    Username    VARCHAR(100) NOT NULL UNIQUE,
    Salt        VARCHAR(50) NOT NULL,
    PasswordHash VARCHAR(50) NOT NULL,
    Name        VARCHAR(255) NOT NULL,
    Email       VARCHAR(255) DEFAULT 'Unknown',
    PhoneNumber VARCHAR(15) DEFAULT 'Unknown',
    Birthday    DATE NOT NULL,
    PRIMARY KEY (UserID)
);

create table Student
(
    UserID      INTEGER NOT NULL,
    StudentID   INTEGER NOT NULL UNIQUE AUTO_INCREMENT,
    StudentName VARCHAR(255) NOT NULL,
    School      VARCHAR(255) NOT NULL,
    Email       VARCHAR(255) DEFAULT 'Unknown',
    PhoneNumber VARCHAR(255) DEFAULT 'Unknown',
    AddressLine VARCHAR(255) DEFAULT 'Unknown',
    Birthday    DATE NOT NULL,
    PRIMARY KEY (StudentID),
    FOREIGN KEY (UserID) REFERENCES User(UserID) ON UPDATE CASCADE
);

create table IssueBook
(
    IssueID     INTEGER NOT NULL UNIQUE AUTO_INCREMENT,
    BookID      INTEGER NOT NULL,
    BookISBN    VARCHAR(13) NOT NULL,
    BookTitle   VARCHAR(255) NOT NULL,
    StudentID   INTEGER NOT NULL,
    StudentName VARCHAR(255) NOT NULL,
    IssuedDate  DATE NOT NULL,
    PRIMARY KEY (IssueID),
    FOREIGN KEY (BookID, BookISBN) REFERENCES Book(ID, ISBN),
    FOREIGN KEY (StudentID) REFERENCES Student(StudentID) ON UPDATE CASCADE
);

create table ReturnBook
(
    IssueID     INTEGER NOT NULL UNIQUE AUTO_INCREMENT,
    BookID      INTEGER NOT NULL,
    BookTitle   TEXT NOT NULL,
    StudentID   INTEGER NOT NULL,
    StudentName TEXT NOT NULL,
    IssueDate   DATE NOT NULL,
    ReturnDate  DATE NOT NULL,
    Days        INTEGER NOT NULL,
);
