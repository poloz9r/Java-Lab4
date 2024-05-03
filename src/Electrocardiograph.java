class Electrocardiograph extends MedicalDevice {
    private String ecgResult;

    public Electrocardiograph(String manufacturer, String model, String serialNumber) {
        super(manufacturer, model, serialNumber);
        this.ecgResult = "";
    }

    public void performECG() {

        String[] ecgResults = {"Нормальный ритм", "Аритмия", "Фибрилляция предсердий"};
        int randomIndex = (int) (Math.random() * ecgResults.length);
        this.ecgResult = ecgResults[randomIndex];
    }

    @Override
    public void performTest() {
        performECG();
    }

    @Override
    public void displayTestResults() {
        System.out.println("Результаты ЭКГ: " + ecgResult);
    }
}
