public class Glucometer extends MedicalDevice {
    private static final int NORMAL_GLUCOSE_LEVEL_LOWER_BOUND = 70;
    private static final int NORMAL_GLUCOSE_LEVEL_UPPER_BOUND = 140;
    private int glucoseLevel;

    public Glucometer(String manufacturer, String model, String serialNumber) {
        super(manufacturer, model, serialNumber);
        this.glucoseLevel = 0;
    }

    public void measureGlucoseLevel() {
        this.glucoseLevel = (int) (Math.random() * 161) + 60; // Генерация случайного уровня глюкозы в диапазоне от 60 до 220
        System.out.println("Уровень глюкозы: " + glucoseLevel);
    }

    @Override
    public void performTest() {
        if (!isOn()) {
            System.out.println("Устройство не включено. Включите устройство перед выполнением теста.");
        } else {
            measureGlucoseLevel();
            printDeviationMessage();
        }
    }

    private void printDeviationMessage() {
        if (glucoseLevel < NORMAL_GLUCOSE_LEVEL_LOWER_BOUND || glucoseLevel > NORMAL_GLUCOSE_LEVEL_UPPER_BOUND) {
            System.out.println("Обнаружены отклонения от нормы в уровне глюкозы.");
        } else {
            System.out.println("Уровень глюкозы в пределах нормы.");
        }
    }

    @Override
    public void displayTestResults() {
        System.out.println("Уровень глюкозы: " + glucoseLevel);
    }

    @Override
    public String toString() {
        return "Глюкометр (Производитель: " + getManufacturer() + ", Серийный номер: " + getSerialNumber() + ")";
    }
}
