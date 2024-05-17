import java.util.Random;

class Electrocardiograph extends MedicalDevice {
    private static final double NORMAL_AMPLITUDE_LOWER_BOUND = 5.0;
    private static final double NORMAL_AMPLITUDE_UPPER_BOUND = 25.0;
    private static final double NORMAL_R_PEAK_INTERVAL_LOWER_BOUND = 0.05;
    private static final double NORMAL_R_PEAK_INTERVAL_UPPER_BOUND = 0.1;

    private String ecgResult;

    public Electrocardiograph(String manufacturer, String model, String serialNumber) {
        super(manufacturer, model, serialNumber);
        this.ecgResult = "";
    }

    public void performECG() {
        Random random = new Random();
        double amplitude = random.nextDouble() * (NORMAL_AMPLITUDE_UPPER_BOUND - NORMAL_AMPLITUDE_LOWER_BOUND) + NORMAL_AMPLITUDE_LOWER_BOUND;
        double rPeakInterval = random.nextDouble() * (NORMAL_R_PEAK_INTERVAL_UPPER_BOUND - NORMAL_R_PEAK_INTERVAL_LOWER_BOUND) + NORMAL_R_PEAK_INTERVAL_LOWER_BOUND;
        System.out.println("Амплитуда: " + amplitude + " мВ");
        System.out.println("Интервал R-пика: " + rPeakInterval + " с");

        if (amplitude >= NORMAL_AMPLITUDE_LOWER_BOUND && amplitude <= NORMAL_AMPLITUDE_UPPER_BOUND &&
                rPeakInterval >= NORMAL_R_PEAK_INTERVAL_LOWER_BOUND && rPeakInterval <= NORMAL_R_PEAK_INTERVAL_UPPER_BOUND) {
            this.ecgResult = "Нормальный ритм";
            System.out.println("ЭКГ: Нормальный ритм.");
        } else {
            this.ecgResult = "Отклонение от нормы. Требуется внимание врача.";
            System.out.println("Отклонение от нормы для ЭКГ: Требуется внимание врача.");
        }
    }

    @Override
    public void performTest() {
        if (!isOn()) {
            System.out.println("Устройство не включено. Включите устройство.");
            return;
        }
        performECG();
    }

    @Override
    public void displayTestResults() {
        System.out.println("Результаты ЭКГ: " + ecgResult);
    }
}

