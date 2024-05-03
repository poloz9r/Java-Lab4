class Electrocardiograph extends MedicalDevice {
    private String ecgResult;

    public Electrocardiograph(String manufacturer, String model, String serialNumber) {
        super(manufacturer, model, serialNumber);
        this.ecgResult = "";
    }

    public void performECG() {
        double amplitude = Math.random() * 100;
        double rPeakInterval = Math.random() * 0.1;


        if (this.ecgResult.isEmpty()) {
            if (amplitude < 20) {
                this.ecgResult = "Аритмия";
            } else if (rPeakInterval > 0.1) {
                this.ecgResult = "Фибрилляция предсердий";
            } else {
                this.ecgResult = "Нормальный ритм";
            }
        }
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
