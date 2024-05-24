import java.io.Serializable;

public class TestResult implements Serializable {
    private String deviceModel;
    private String manufacturer;
    private String serialNumber;
    private String testType;
    private String testResults;
    private String verdict;

    public TestResult(String deviceModel, String manufacturer, String serialNumber, String testType, String testResults, String verdict) {
        this.deviceModel = deviceModel;
        this.manufacturer = manufacturer;
        this.serialNumber = serialNumber;
        this.testType = testType;
        this.testResults = testResults;
        this.verdict = verdict;
    }

    @Override
    public String toString() {
        return "Тип устройства: " + deviceModel + ", Производитель: " + manufacturer + ", Серийный номер: " + serialNumber + ", Тип теста: " + testType + ", Результат теста: " + testResults + ", Заключение: " + verdict;
    }

    public static TestResult fromString(String str) {
        String[] parts = str.split(", ");
        String deviceModel = parts[0].split(": ")[1];
        String manufacturer = parts[1].split(": ")[1];
        String serialNumber = parts[2].split(": ")[1];
        String testType = parts[3].split(": ")[1];
        String testResults = parts[4].split(": ")[1];
        String verdict = parts[5].split(": ")[1];
        return new TestResult(deviceModel, manufacturer, serialNumber, testType, testResults, verdict);
    }
}
