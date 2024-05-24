class Electrocardiograph extends MedicalDevice {
    private String ecgResult;
    private double amplitude;
    private double rPeakInterval;
    private static final double NORMAL_AMPLITUDE_MIN = 20.0;
    private static final double NORMAL_R_PEAK_INTERVAL_MAX = 0.1;

    public Electrocardiograph(String manufacturer, String model, String serialNumber) {
        super(manufacturer, model, serialNumber);
        this.ecgResult = "";
    }

    public void performECG() {
        amplitude = Math.random() * 120; // Амплитуда в диапазоне от 0 до 120
        rPeakInterval = Math.random() * 0.2; // Интервал R-пика

        System.out.println("Амплитуда: " + amplitude);
        System.out.println("Интервал R-пика: " + rPeakInterval);

        if (this.ecgResult.isEmpty()) {
            if (amplitude < NORMAL_AMPLITUDE_MIN) {
                this.ecgResult = "Аритмия";
            } else if (rPeakInterval > NORMAL_R_PEAK_INTERVAL_MAX) {
                this.ecgResult = "Фибрилляция предсердий";
            } else {
                this.ecgResult = "Нормальный ритм";
            }
        }
    }

    @Override
    public void performTest() {
        if (!isOn()) {
            System.out.println(getModel() + " выключен. Включите устройство перед тестированием.");
            return;
        }
        performECG();
        MedicalDeviceManager.addTestResult(new TestResult(getModel(), getManufacturer(), getSerialNumber(), "Проведение ЭКГ",
                "Амплитуда: " + amplitude + ", Интервал R-пика: " + rPeakInterval, ecgResult));
    }

    @Override
    public void displayTestResults() {
        System.out.println("Результаты ЭКГ: " + ecgResult);
    }
}
