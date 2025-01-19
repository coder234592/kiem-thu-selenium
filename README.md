kiem-thu-selenium

BIT220037- Vũ Quang Dũng

Mô tả bài tập kiểm thử Selenium:

1. Ý nghĩa và mục đích
   
Mục tiêu:

Kiểm tra các chức năng cơ bản của một ứng dụng web (đăng nhập, tìm kiếm sản phẩm, đăng xuất) được phát triển trên URL https://kiem-thu-selenium.glitch.me.

Xác minh tính đúng đắn của hệ thống qua các bài kiểm thử, đồng thời ghi nhận kết quả và báo cáo qua console.

Công cụ và Framework:

Selenium WebDriver: Tự động hóa thao tác trên trình duyệt.

TestNG: Quản lý các bài kiểm thử, ưu tiên thứ tự kiểm thử, và ghi nhận kết quả.

TestListener: Ghi lại kết quả kiểm thử thành công, thất bại hoặc bị bỏ qua.

3. Chức năng chính của mã
   
a. TestResultListener

Mục đích:

Lắng nghe và ghi nhận trạng thái của các bài kiểm thử.

Các phương thức chính:

onStart: Thông báo bắt đầu kiểm thử.

onTestSuccess: Ghi nhận kết quả bài kiểm thử thành công.

onTestFailure: Ghi lại lỗi (nếu có) trong bài kiểm thử.

onTestSkipped: Thông báo các bài kiểm thử bị bỏ qua.

onFinish: Kết thúc kiểm thử.

b. WebTest

Trình tự kiểm thử:

Thiết lập môi trường:

Cấu hình và khởi động trình duyệt Chrome.

Truy cập URL của ứng dụng web.

Kiểm thử các chức năng:

testInvalidLogin: Kiểm tra đăng nhập thất bại với tài khoản không hợp lệ.

testValidLogin: Kiểm tra đăng nhập thành công với tài khoản hợp lệ.

testSearchValidProduct: Tìm kiếm sản phẩm hợp lệ và kiểm tra kết quả hiển thị.

testSearchInvalidProduct: Tìm kiếm sản phẩm không tồn tại và kiểm tra danh sách rỗng.

testLogout: Đăng xuất và kiểm tra người dùng được chuyển về trang đăng nhập.

Kết thúc kiểm thử:

Đóng trình duyệt sau khi hoàn thành kiểm thử.

c. main Method

Mục đích:

Tập hợp các bài kiểm thử trong lớp WebTest.

Sử dụng TestNG để chạy các bài kiểm thử và áp dụng TestResultListener để ghi lại kết quả.

In báo cáo kiểm thử ra console.

5. Ưu điểm của kiểm thử này
   
Tự động hóa hoàn toàn: Mọi thao tác kiểm thử trên trình duyệt được thực hiện tự động.

Báo cáo chi tiết: Ghi nhận kết quả từng bài kiểm thử, bao gồm thông tin lỗi và trạng thái (Pass/Fail).

Dễ dàng mở rộng: Có thể thêm các bài kiểm thử khác vào lớp WebTest hoặc tích hợp với CI/CD.

7. Điểm cần cải thiện
   
Quản lý driver: Nên sử dụng thư viện như WebDriverManager để tự động tải và cấu hình trình điều khiển thay vì thiết lập thủ công qua System.setProperty.

Tái sử dụng mã: Các thao tác lặp lại (như nhập thông tin đăng nhập, xóa trường) có thể được trừu tượng hóa thành phương thức riêng.

Quản lý dữ liệu: Dữ liệu kiểm thử (tài khoản, URL, sản phẩm) nên được tách biệt khỏi mã, có thể sử dụng file cấu hình hoặc tham số hóa.

Ảnh chụp kết quả kiểm thử: ![Screenshot (31)](https://github.com/user-attachments/assets/5655bbb7-ada0-44d6-a7cc-c6dfd054fe14)


Liên kết đề bài: [https://chatgpt.com/share/67839c68-e038-800b-a627-066edcc98e4b](https://chatgpt.com/share/67845bf9-d2e0-8013-a4cd-c4bb6b792e53)
