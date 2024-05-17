import java.util.Random;

class BloodPressureMonitor extends MedicalDevice {
    private int systolicPressure;
    private int diastolicPressure;

    public BloodPressureMonitor(String manufacturer, String model, String serialNumber) {
        super(manufacturer, model, serialNumber);
        this.systolicPressure = 0;
        this.diastolicPressure = 0;
    }

    public void measureBloodPressure() {
        Random random = new Random();
        this.systolicPressure = random.nextInt(40) + 90; // Давление в диапазоне от 90 до 130 мм рт.ст.
        this.diastolicPressure = random.nextInt(30) + 60; // Давление в диапазоне от 60 до 90 мм рт.ст.
        System.out.println("Измерение артериального давления...");
        System.out.println("Систолическое давление: " + systolicPressure + " мм рт.ст.");
        System.out.println("Диастолическое давление: " + diastolicPressure + " мм рт.ст.");
    }

    @Override
    public void performTest() {
        checkIfDeviceIsOn();
        measureBloodPressure();
    }

    @Override
    public void displayTestResults() {
        checkIfDeviceIsOn();
        System.out.println("Результаты измерения артериального давления:");
        System.out.println("Систолическое давление: " + systolicPressure + " мм рт.ст.");
        System.out.println("Диастолическое давление: " + diastolicPressure + " мм рт.ст.");
    }
}
