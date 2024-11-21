# OOP_Limt
## Mục lục

## Công cụ sử dụng

- [Java](https://www.java.com/en/) - Ngôn ngữ lập trình sử dụng
- [JavaFX](https://openjfx.io/) - Thư viện giao diện sử dụng
- [SQLite](https://www.sqlite.org/index.html) - Cơ sở dữ liệu sử dụng
- [JDBC](https://www.oracle.com/java/technologies/jdbc.html) - Công cụ kết nối cơ sở dữ liệu sử dụng

## Thành viên nhóm

- **Phạm Anh Tuấn** - 23020704 ([GitHub](https://github.com/Yumeio))
- **Tạ Duy Khánh** - 23020696 ([GitHub](https://github.com/khanhtaduy2k5))
- **Phan Xuân Hiếu**


### Cấu trúc thư mục
    .
    ├── .idea                       # Tệp dành cho IDE (IntelliJ IDEA)
    ├── .mvn                        # Tệp hỗ trợ Maven
    ├── public                      # Thư mục chứa các tệp tĩnh
    ├── src/main                    # Mã nguồn chính
        ├── java
            ├── com/limt
                ├── Controllers     # Thư mục chứa các controller
                ├── Lib             # Thư viện hỗ trợ
                ├── Models          # Các model
                ├── Views           # Các view
                Main.java           # Tệp chính để chạy chương trình
            module-info.java        # Thông tin module
        ├── resources
            ├── Database            # Tệp cơ sở dữ liệu SQlite và các tệp SQL
            ├── fxml                # Các tệp FXML
            ├── images              # Hình ảnh sử dụng trong chương trình
            ├── styles              # Các tệp CSS
    ├── .editorconfig               # Tệp cấu hình trình chỉnh sửa
    ├── .gitignore                  # Tệp cấu hình bỏ qua của Git
    ├── LICENSE                     # Tệp giấy phép
    ├── mvnw.cmd                    # Tệp Maven wrapper dành cho Windows
    ├── package.json                # Tệp cấu hình NPM hiển thị thông tin và dependencies của dự án
    ├── pom.xml                     # Tệp cấu hình Maven
    └── README.md                   # Tệp hướng dẫn README
