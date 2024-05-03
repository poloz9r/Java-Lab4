class Glucometer extends MedicalDevice {
    private int glucoseLevel;

    public Glucometer(String manufacturer, String model, String serialNumber) {
        super(manufacturer, model, serialNumber);
        this.glucoseLevel = 0;
    }

    public void measureGlucoseLevel() {

        this.glucoseLevel = (int) (Math.random() * 100);
    }

    @Override
    public void performTest() {
        measureGlucoseLevel();
    }

    @Override
    public void displayTestResults() {
        System.out.println("Уровень глюкозы: " + glucoseLevel);
    }
}
