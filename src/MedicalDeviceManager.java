import java.util.ArrayList;
import java.util.Scanner;

public class MedicalDeviceManager {
    private static ArrayList<MedicalDevice> medicalDevices = new ArrayList<>();
    private static ArrayList<TestResult> testResults = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        medicalDevices.add(new BloodPressureMonitor("Manufacturer1", "Model1", "SerialNumber1"));
        medicalDevices.add(new Glucometer("Manufacturer2", "Model2", "SerialNumber2"));
        medicalDevices.add(new Electrocardiograph("Manufacturer3", "Model3", "SerialNumber3"));

        displayMenu();
    }

    private static void displayMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("Меню:");
            System.out.println("1. Включить устройство");
            System.out.println("2. Выполнить тест");
            System.out.println("3. Вывести результаты теста");
            System.out.println("4. Выйти");

            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    turnOnDevice();
                    break;
                case 2:
                    performTest();
                    break;
                case 3:
                    displayTestResults();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Некорректный выбор.");
            }
        }
    }

    private static void turnOnDevice() {
        System.out.println("Список доступных устройств:");
        for (int i = 0; i < medicalDevices.size(); i++) {
            System.out.println(i + ". " + medicalDevices.get(i));
        }
        System.out.println("Выберите устройство для включения:");
        int index = scanner.nextInt();
        if (index >= 0 && index < medicalDevices.size()) {
            medicalDevices.get(index).turnOn();
        } else {
            System.out.println("Некорректный индекс.");
        }
    }

    private static void performTest() {
        System.out.println("Список доступных устройств:");
        for (int i = 0; i < medicalDevices.size(); i++) {
            System.out.println(i + ". " + medicalDevices.get(i));
        }
        System.out.println("Выберите устройство для проведения теста:");
        int index = scanner.nextInt();
        if (index >= 0 && index < medicalDevices.size()) {
            MedicalDevice device = medicalDevices.get(index);
            device.performTest();
            testResults.add(new TestResult(device.getModel(), device.getManufacturer(), device.getSerialNumber(), device.isOn()));
        } else {
            System.out.println("Некорректный индекс.");
        }
    }

    private static void displayTestResults() {
        System.out.println("Список результатов тестов:");
        for (int i = 0; i < testResults.size(); i++) {
            System.out.println(i + ". " + testResults.get(i));
        }
    }
}
