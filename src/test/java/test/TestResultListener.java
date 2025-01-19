package test;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestResultListener implements ITestListener {

    // Mở đầu kiểm thử (onStart)
    @Override
    public void onStart(org.testng.ITestContext context) {
        System.out.println("Bắt đầu kiểm thử...");
    }

    // Kết quả thành công của một test case (onTestSuccess)
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Tên Test Case: " + result.getName() + ", Kết quả: Pass, Mô tả lỗi: N/A");
    }

    // Kết quả thất bại của một test case (onTestFailure)
    @Override
    public void onTestFailure(ITestResult result) {
        String errorMessage = result.getThrowable() != null ? result.getThrowable().toString() : "Không có thông báo lỗi";
        System.out.println("Tên Test Case: " + result.getName() + ", Kết quả: Fail, Mô tả lỗi: " + errorMessage);
    }

    // Kết quả test case bị bỏ qua (onTestSkipped)
    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Tên Test Case: " + result.getName() + ", Kết quả: Skipped, Mô tả lỗi: " + result.getThrowable());
    }

    // Kết thúc kiểm thử (onFinish)
    @Override
    public void onFinish(org.testng.ITestContext context) {
        System.out.println("Kiểm thử đã hoàn tất.");
    }

    // Các phương thức còn lại không thay đổi
    @Override public void onTestStart(ITestResult result) {}
    @Override public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
}
