class Glucometer extends MedicalDevice {
    private int glucoseLevel;
    private static final int NORMAL_GLUCOSE_MIN = 70;
    private static final int NORMAL_GLUCOSE_MAX = 140;

    public Glucometer(String manufacturer, String model, String serialNumber) {
        super(manufacturer, model, serialNumber);
        this.glucoseLevel = 0;
    }

    public void measureGlucoseLevel() {
        this.glucoseLevel = 50 + (int) (Math.random() * 200); // Random glucose level between 50 and 250
        System.out.println("Уровень глюкозы: " + glucoseLevel);
    }

    @Override
    public void performTest() {
        if (!isOn()) {
            System.out.println(getModel() + " выключен. Включите устройство перед тестированием.");
            return;
        }
        measureGlucoseLevel();
        String verdict = (glucoseLevel >= NORMAL_GLUCOSE_MIN && glucoseLevel <= NORMAL_GLUCOSE_MAX) ?
                "Уровень глюкозы в норме" : "Отклонение уровня глюкозы";
        MedicalDeviceManager.addTestResult(new TestResult(getModel(), getManufacturer(), getSerialNumber(), "Измерение уровня глюкозы",
                "Уровень глюкозы: " + glucoseLevel, verdict));
    }

    @Override
    public void displayTestResults() {
        System.out.println("Результаты измерения уровня глюкозы:");
        System.out.println("Уровень глюкозы: " + glucoseLevel);
    }
}
