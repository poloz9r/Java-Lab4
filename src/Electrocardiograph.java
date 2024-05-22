public class Electrocardiograph extends MedicalDevice {
    private String ecgResult;
    private double amplitude;
    private double rPeakInterval;

    public Electrocardiograph(String manufacturer, String model, String serialNumber) {
        super(manufacturer, model, serialNumber);
        this.ecgResult = "";
    }

    public void performECG() {
        this.amplitude = Math.random() * 100;
        this.rPeakInterval = Math.random() * 0.2;
        System.out.println("Амплитуда: " + amplitude);
        System.out.println("Интервал R-пика: " + rPeakInterval);

        if (amplitude < 20) {
            ecgResult = "Аритмия";
        } else if (rPeakInterval > 0.1) {
            ecgResult = "Фибрилляция предсердий";
        } else {
            ecgResult = "Нормальный ритм";
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

    @Override
    public void displayTestResults() {
        System.out.println("Результаты ЭКГ: " + ecgResult);
    }

    @Override
    public String toString() {
        return "Электрокардиограф (Производитель: " + getManufacturer() + ", Серийный номер: " + getSerialNumber() + ")";
    }
}
