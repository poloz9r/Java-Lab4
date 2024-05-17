abstract class MedicalDevice {
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

    public String getModel() {
        return model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public boolean isOn() {
        return isOn;
    }

    @Override
    public String toString() {
        return "Модель: " + model + ", Производитель: " + manufacturer + ", Серийный номер: " + serialNumber;
    }

    protected void checkIfDeviceIsOn() {
        if (!isOn) {
            System.out.println("Ошибка: " + model + " не включен.");
            throw new IllegalStateException(model + " не включен.");
        }
    }
}
