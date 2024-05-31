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

    class BloodPressureMonitor extends MedicalDevice {
        private int systolicPressure;
        private int diastolicPressure;
        private static final int NORMAL_SYSTOLIC_MIN = 90;
        private static final int NORMAL_SYSTOLIC_MAX = 120;
        private static final int NORMAL_DIASTOLIC_MIN = 60;
        private static final int NORMAL_DIASTOLIC_MAX = 80;

        public BloodPressureMonitor(String manufacturer, String model, String serialNumber) {
            super(manufacturer, model, serialNumber);
        }

        @Override
        public String getManufacturer() {
            return super.getManufacturer();
        }

        // Вместо получения напрямую, используем метод getSerialNumber()
        @Override
        public String getSerialNumber() {
            return super.getSerialNumber();
        }

        public void measureBloodPressure() {
            this.systolicPressure = 90 + (int) (Math.random() * 60); // Random systolic pressure between 90 and 150
            this.diastolicPressure = 60 + (int) (Math.random() * 40); // Random diastolic pressure between 60 and 100
            System.out.println("Систолическое давление: " + systolicPressure);
            System.out.println("Диастолическое давление: " + diastolicPressure);
        }

        @Override
        public void performTest() {
            if (!isOn()) {
                System.out.println(getModel() + " выключен. Включите устройство перед тестированием.");
                return;
            }
            measureBloodPressure();
            String verdict = (systolicPressure >= NORMAL_SYSTOLIC_MIN && systolicPressure <= NORMAL_SYSTOLIC_MAX &&
                    diastolicPressure >= NORMAL_DIASTOLIC_MIN && diastolicPressure <= NORMAL_DIASTOLIC_MAX) ?
                    "Давление в норме" : "Отклонение от нормы";
            MedicalDeviceManager.addTestResult(new TestResult(getModel(), getManufacturer(), getSerialNumber(), "Измерение давления",
                    "Систолическое: " + systolicPressure + ", Диастолическое: " + diastolicPressure, verdict));
        }

        @Override
        public void displayTestResults() {
            System.out.println("Результаты измерения давления:");
            System.out.println("Систолическое давление: " + systolicPressure);
            System.out.println("Диастолическое давление: " + diastolicPressure);
        }

    }

}
