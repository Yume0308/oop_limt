create table MailServer
(
    ServerName     TEXT,
    ServerPort     INTEGER,
    Email          TEXT,
    Password       TEXT,
    Authentication TEXT,
    TLS            TEXT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table Book
(
    ID            TEXT NOT NULL UNIQUE,
    ISBN          TEXT NOT NULL UNIQUE,
    Title         TEXT NOT NULL,
    Author        TEXT NOT NULL,
    Category      TEXT DEFAULT 'Unknown',
    Publisher     TEXT DEFAULT 'Unknown',
    Quantity      INTEGER DEFAULT 0,
    Remaining     INTEGER DEFAULT 0,
    ImagePath     VARCHAR(255) DEFAULT 'Unknown',
    PRIMARY KEY (ID, ISBN)
);

create table User
(
    UserID      INTEGER NOT NULL UNIQUE,
    Username    TEXT NOT NULL UNIQUE,
    Salt        TEXT NOT NULL,
    PasswordHash TEXT NOT NULL,
    Name        TEXT NOT NULL,
    Email       TEXT DEFAULT '',
    PhoneNumber TEXT DEFAULT '',
    Birthday    DATE NOT NULL ,
    PRIMARY KEY (UserID AUTOINCREMENT)
);

create table Student
(
    UserID      INTEGER NOT NULL UNIQUE,
    StudentID   TEXT NOT NULL UNIQUE,
    StudentName TEXT NOT NULL,
    School      TEXT NOT NULL,
    Email       TEXT DEFAULT 'Unknown',
    PhoneNumber TEXT DEFAULT 'Unknown',
    AddressLine TEXT DEFAULT 'Unknown',
    Birthday    DATE NOT NULL,
    PRIMARY KEY (StudentID),
    FOREIGN KEY (UserID) REFERENCES User(UserID) ON UPDATE CASCADE
);

create table IssueBook
(
    IssueID     INTEGER NOT NULL UNIQUE,
    BookID      TEXT NOT NULL,
    BookISBN    TEXT NOT NULL,
    BookTitle   TEXT NOT NULL,
    StudentID   TEXT NOT NULL,
    StudentName TEXT NOT NULL,
    IssuedDate  Text NOT NULL,
    ReturnDate  Text NOT NULL,
    Days        INTEGER NOT NULL,
    PRIMARY KEY (IssueID AUTOINCREMENT ),
    FOREIGN KEY (BookID, BookISBN, BookTitle) REFERENCES Book(ID, ISBN, Title),
    FOREIGN KEY (StudentID, StudentName) REFERENCES Student(StudentID, StudentName) ON UPDATE CASCADE
);

create table ReturnBook
(
    IssueID     INTEGER NOT NULL UNIQUE,
    BookID      TEXT NOT NULL,
    BookTitle   TEXT NOT NULL,
    StudentID   TEXT NOT NULL,
    StudentName TEXT NOT NULL,
    IssueDate   DATE NOT NULL,
    ReturnDate  DATE NOT NULL,
    FOREIGN KEY (IssueID) REFERENCES IssueBook(IssueID) ON UPDATE CASCADE
);
