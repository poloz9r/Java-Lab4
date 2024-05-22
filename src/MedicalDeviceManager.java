import java.util.ArrayList;
import java.util.Scanner;

public class MedicalDeviceManager {
    private static ArrayList<MedicalDevice> medicalDevices = new ArrayList<>();
    private static ArrayList<TestResult> testResults = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        medicalDevices.add(new BloodPressureMonitor("ЗдоровьеТех", "Кровяной давлениемер", "A17489BB"));
        medicalDevices.add(new Glucometer("ЗдравПром", "Глюкометр", "A1257TRY"));
        medicalDevices.add(new Electrocardiograph("ЗдоровьеДевелопмент", "Электрокардиограф", "B987YY"));

        displayMenu();
    }

    private static void displayMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("Меню:");
            System.out.println("1. Включить устройство");
            System.out.println("2. Выполнить тест");
            System.out.println("3. Сохранить результаты теста");
            System.out.println("4. Вывести результаты теста");
            System.out.println("5. Выйти");

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
                    saveTestResults();
                    break;
                case 4:
                    displaySavedTestResults();
                    break;
                case 5:
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
            medicalDevices.get(index).performTest();
        } else {
            System.out.println("Некорректный индекс.");
        }
    }

    private static void saveTestResults() {
        System.out.println("Список доступных устройств:");
        for (int i = 0; i < medicalDevices.size(); i++) {
            System.out.println(i + ". " + medicalDevices.get(i));
        }
        System.out.println("Выберите устройство для сохранения результатов теста:");
        int index = scanner.nextInt();
        if (index >= 0 && index < medicalDevices.size()) {
            MedicalDevice device = medicalDevices.get(index);
            TestResult result = new TestResult(device.getModel(), device.getManufacturer(), device.getSerialNumber(), device.isOn());
            testResults.add(result);
            System.out.println("Результаты теста сохранены.");
        } else {
            System.out.println("Некорректный индекс.");
        }
    }

    private static void displaySavedTestResults() {
        System.out.println("Сохраненные результаты тестов:");
        for (TestResult result : testResults) {
            result.displayTestResults();
        }
    }
}
