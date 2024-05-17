public abstract class MedicalDevice {
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

    public abstract void performTest();

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
        return model + ", Manufacturer: " + manufacturer + ", Serial Number: " + serialNumber;
    }
}
