# OOP_Limt
## Mục lục

# OOP_Limt

**OOP_Limt** là một ứng dụng quản lý thư viện được phát triển bằng JavaFX. Ứng dụng cung cấp các tính năng quản lý thư viện một cách hiệu quả và trực quan, hỗ trợ quản lý sách, người dùng, và các giao dịch mượn/trả sách. Đây là công cụ lý tưởng dành cho các thư viện vừa và nhỏ cũng như các cá nhân muốn tổ chức quản lý sách của mình một cách chuyên nghiệp.

---

## Tính năng chính

### Các tính năng nổi bật của **OOP_Limt**:
- **Quản lý sách**:
    - Thêm, sửa, xóa thông tin sách.
    - Quản lý thông tin chi tiết như tiêu đề, tác giả, thể loại, ISBN.
    - Theo dõi số lượng sách có sẵn trong thư viện.

- **Quản lý người dùng**:
    - Lưu trữ thông tin người dùng như tên, số điện thoại, email.
    - Phân quyền người dùng: Thủ thư và độc giả.

- **Quản lý giao dịch mượn/trả sách**:
    - Ghi nhận lịch sử mượn và trả sách.
    - Theo dõi thời hạn mượn sách và nhắc nhở khi đến hạn trả.

- **Tìm kiếm và lọc**:
    - Hỗ trợ tìm kiếm sách và người dùng nhanh chóng theo nhiều tiêu chí.
    - Lọc danh sách theo các thuộc tính như thể loại, trạng thái, hoặc tên tác giả.

- **Báo cáo và thống kê**:
    - Thống kê số lượng sách mượn/trả.
    - Báo cáo người dùng mượn nhiều sách nhất.
    - Theo dõi sách được mượn nhiều nhất.

- **Giao diện thân thiện và trực quan**:
    - Thiết kế đẹp mắt, dễ sử dụng, phù hợp cho người dùng không chuyên.

---

## Cài đặt và sử dụng
### Yêu cầu hệ thống
- **Hệ điều hành**: Windows, macOS, hoặc Linux.
- **Java Runtime Environment (JRE)**: Phiên bản 11 hoặc mới hơn.
- **JavaFX SDK**: Đã được tích hợp vào dự án.

### Hướng dẫn cài đặt

1. **Clone source code**:
   ```bash
   git clone https://github.com/<username>/OOP_Limt.git
   cd OOP_Limt
2. **Chạy ứng dụng bằng Maven**:
   ```bash
   Sao chép mã
   mvn clean javafx:run
3. **Xuất tệp JAR và chạy**:

    ```bash
    Sao chép mã
    mvn clean package
    java -jar target/OOP_Limt-1.0.jar

## Công cụ sử dụng

- [Java](https://www.java.com/en/) - Ngôn ngữ lập trình sử dụng
- [JavaFX](https://openjfx.io/) - Thư viện giao diện sử dụng
- [SQLite](https://www.sqlite.org/index.html) - Cơ sở dữ liệu sử dụng
- [JDBC](https://www.oracle.com/java/technologies/jdbc.html) - Công cụ kết nối cơ sở dữ liệu sử dụng


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

## Thành viên nhóm

- **Phạm Anh Tuấn** - 23020704 ([GitHub](https://github.com/Yumeio))
- **Tạ Duy Khánh** - 23020677 ([GitHub](https://github.com/khanhtaduy2k5))
- **Phan Xuân Hiếu** - 23020665 ([GitHub](https://github.com/mrshallow2k5)))
