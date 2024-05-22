import java.util.Random;

public class BloodPressureMonitor extends MedicalDevice {
    private static final int NORMAL_SYSTOLIC_PRESSURE_LOWER_BOUND = 90;
    private static final int NORMAL_SYSTOLIC_PRESSURE_UPPER_BOUND = 130;
    private static final int NORMAL_DIASTOLIC_PRESSURE_LOWER_BOUND = 60;
    private static final int NORMAL_DIASTOLIC_PRESSURE_UPPER_BOUND = 90;

    private int systolicPressure;
    private int diastolicPressure;

    public BloodPressureMonitor(String manufacturer, String model, String serialNumber) {
        super(manufacturer, model, serialNumber);
    }

    public void measureBloodPressure() {
        Random random = new Random();
        this.systolicPressure = random.nextInt(NORMAL_SYSTOLIC_PRESSURE_UPPER_BOUND - NORMAL_SYSTOLIC_PRESSURE_LOWER_BOUND + 1) + NORMAL_SYSTOLIC_PRESSURE_LOWER_BOUND;
        this.diastolicPressure = random.nextInt(NORMAL_DIASTOLIC_PRESSURE_UPPER_BOUND - NORMAL_DIASTOLIC_PRESSURE_LOWER_BOUND + 1) + NORMAL_DIASTOLIC_PRESSURE_LOWER_BOUND;
        System.out.println("Измерение артериального давления...");
        System.out.println("Систолическое давление: " + systolicPressure + " мм рт.ст.");
        System.out.println("Диастолическое давление: " + diastolicPressure + " мм рт.ст.");
    }

    @Override
    public void performTest() {
        if (!isOn()) {
            System.out.println("Устройство не включено. Включите устройство перед выполнением теста.");
        } else {
            measureBloodPressure();
            printDeviationMessage();
        }
    }

    private void printDeviationMessage() {
        if (systolicPressure < NORMAL_SYSTOLIC_PRESSURE_LOWER_BOUND || systolicPressure > NORMAL_SYSTOLIC_PRESSURE_UPPER_BOUND ||
                diastolicPressure < NORMAL_DIASTOLIC_PRESSURE_LOWER_BOUND || diastolicPressure > NORMAL_DIASTOLIC_PRESSURE_UPPER_BOUND) {
            System.out.println("Обнаружены отклонения от нормы в артериальном давлении.");
        } else {
            System.out.println("Артериальное давление находится в пределах нормы.");
        }
    }

    @Override
    public void displayTestResults() {
        System.out.println("Систолическое давление: " + systolicPressure + " мм рт.ст.");
        System.out.println("Диастолическое давление: " + diastolicPressure + " мм рт.ст.");
    }
}
