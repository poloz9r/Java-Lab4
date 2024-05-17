public class Electrocardiograph extends MedicalDevice {
    private String ecgResult;

    public Electrocardiograph(String manufacturer, String model, String serialNumber) {
        super(manufacturer, model, serialNumber);
    }

    public void performECG() {
        double amplitude = Math.random() * 100;
        double rPeakInterval = Math.random() * 0.1;
        System.out.println("Амплитуда: " + amplitude);
        System.out.println("Интервал R-пика: " + rPeakInterval);

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
        if (!isOn()) {
            System.out.println("Устройство не включено. Включите устройство перед выполнением теста.");
        } else {
            performECG();
            System.out.println("Результаты ЭКГ: " + ecgResult);
        }
    }
}
