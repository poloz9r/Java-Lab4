import java.util.Random;

class Glucometer extends MedicalDevice {
    private static final int NORMAL_GLUCOSE_LOWER_BOUND = 70;
    private static final int NORMAL_GLUCOSE_UPPER_BOUND = 100;

    private int glucoseLevel;

    public Glucometer(String manufacturer, String model, String serialNumber) {
        super(manufacturer, model, serialNumber);
        this.glucoseLevel = 0;
    }

    public void measureGlucoseLevel() {
        Random random = new Random();
        this.glucoseLevel = random.nextInt(NORMAL_GLUCOSE_UPPER_BOUND - NORMAL_GLUCOSE_LOWER_BOUND + 1) + NORMAL_GLUCOSE_LOWER_BOUND;
        System.out.println("Уровень глюкозы: " + glucoseLevel + " мг/дл");

        if (glucoseLevel >= NORMAL_GLUCOSE_LOWER_BOUND && glucoseLevel <= NORMAL_GLUCOSE_UPPER_BOUND) {
            System.out.println("Уровень глюкозы в норме.");
        } else {
            System.out.println("Отклонение от нормы. Требуется внимание врача.");
        }
    }

    @Override
    public void performTest() {
        checkIfDeviceIsOn();
        measureGlucoseLevel();
    }

    @Override
    public void displayTestResults() {

    }
}
