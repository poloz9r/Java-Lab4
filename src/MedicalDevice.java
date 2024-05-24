import java.io.Serializable;

public abstract class MedicalDevice implements Serializable {
    private String manufacturer;
    private String model;
    private String serialNumber;
    private boolean isOn;

    public MedicalDevice(String manufacturer, String model, String serialNumber) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.serialNumber = serialNumber;
        this.isOn = false;
    }

    public void turnOn() {
        isOn = true;
        System.out.println(model + " включен.");
    }

    public void turnOff() {
        isOn = false;
        System.out.println(model + " выключен.");
    }

    public void calibrate() {
        System.out.println("Калибровка " + model);
    }

    public abstract void performTest();

    public abstract void displayTestResults();

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public boolean isOn() {
        return isOn;
    }

    @Override
    public String toString() {
        return "Устройство: " + model + ", Производитель: " + manufacturer + ", Серийный номер: " + serialNumber;
    }

    public String toFileString() {
        return model + ", " + manufacturer + ", " + serialNumber;
    }

    public static MedicalDevice fromString(String str) {
        String[] parts = str.split(", ");
        String model = parts[0];
        String manufacturer = parts[1];
        String serialNumber = parts[2];

        switch (model) {
            case "Кровяной давлениемер":
                return new BloodPressureMonitor(manufacturer, model, serialNumber);
            case "Глюкометр":
                return new Glucometer(manufacturer, model, serialNumber);
            case "Электрокардиограф":
                return new Electrocardiograph(manufacturer, model, serialNumber);
            default:
                throw new IllegalArgumentException("Неизвестный тип устройства: " + model);
        }
    }
}
