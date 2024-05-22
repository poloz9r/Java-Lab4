public class TestResult {
    private String model;
    private String manufacturer;
    private String serialNumber;
    private boolean isDeviceOn;

    public TestResult(String model, String manufacturer, String serialNumber, boolean isDeviceOn) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.serialNumber = serialNumber;
        this.isDeviceOn = isDeviceOn;
    }

    public void displayTestResults() {
        System.out.println("Результаты теста для устройства:");
        System.out.println("Модель: " + model);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Серийный номер: " + serialNumber);
        System.out.println("Статус устройства: " + (isDeviceOn ? "Включено" : "Выключено"));
    }
}
