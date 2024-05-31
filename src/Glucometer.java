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
