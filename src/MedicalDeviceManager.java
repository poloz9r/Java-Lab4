import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MedicalDeviceManager {
    private static ArrayList<MedicalDevice> medicalDevices = new ArrayList<>();
    private static ArrayList<TestResult> testResults = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static final String FILE_NAME = "test_results.txt";
    private static final String DEVICES_FILE = "devices_data.txt";

    public static void main(String[] args) {
        loadMedicalDevices();
        loadTestResults();
        displayMenu();
    }

    private static void displayMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("Меню:");
            System.out.println("1. Включить устройство");
            System.out.println("2. Выполнить тест");
            System.out.println("3. Вывести результаты теста");
            System.out.println("4. Управление устройствами");
            System.out.println("5. Вывести текущие устройства");
            System.out.println("6. Выйти");

            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

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
                    manageDevices();
                    break;
                case 5:
                    displayCurrentDevices();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Некорректный выбор.");
            }
        }
        saveTestResults();
        saveMedicalDevices();
    }

    private static void turnOnDevice() {
        System.out.println("Список доступных устройств:");
        for (int i = 0; i < medicalDevices.size(); i++) {
            System.out.println(i + ". " + medicalDevices.get(i));
        }
        System.out.println("Выберите устройство для включения:");
        int index = scanner.nextInt();
        scanner.nextLine();  // Consume newline
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
        scanner.nextLine();  // Consume newline
        if (index >= 0 && index < medicalDevices.size()) {
            medicalDevices.get(index).performTest();
        } else {
            System.out.println("Некорректный индекс.");
        }
    }

    private static void displayTestResults() {
        for (TestResult result : testResults) {
            System.out.println(result);
        }
    }

    private static void displayCurrentDevices() {
        System.out.println("Текущие устройства:");
        for (MedicalDevice device : medicalDevices) {
            System.out.println(device);
        }
    }

    public static void addTestResult(TestResult result) {
        testResults.add(result);
    }

    private static void saveTestResults() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (TestResult result : testResults) {
                writer.println(result);
            }
            System.out.println("Результаты тестов сохранены в файл: " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении результатов тестов: " + e.getMessage());
        }
    }

    private static void loadTestResults() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                testResults.add(TestResult.fromString(line));
            }
            System.out.println("Результаты тестов загружены из файла: " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Ошибка при загрузке результатов тестов: " + e.getMessage());
        }
    }

    private static void saveMedicalDevices() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(DEVICES_FILE))) {
            for (MedicalDevice device : medicalDevices) {
                writer.println(device.toFileString());
            }
            System.out.println("Данные устройств сохранены в файл: " + DEVICES_FILE);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении данных устройств: " + e.getMessage());
        }
    }

    private static void loadMedicalDevices() {
        try (BufferedReader reader = new BufferedReader(new FileReader(DEVICES_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                medicalDevices.add(MedicalDevice.fromString(line));
            }
            System.out.println("Данные устройств загружены из файла: " + DEVICES_FILE);
        } catch (IOException e) {
            System.out.println("Ошибка при загрузке данных устройств: " + e.getMessage());
        }
    }

    private static void manageDevices() {
        System.out.println("Управление устройствами:");
        System.out.println("1. Добавить устройство");
        System.out.println("2. Изменить устройство");
        System.out.println("3. Удалить устройство");
        System.out.println("4. Вернуться в главное меню");

        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (choice) {
            case 1:
                addDevice();
                break;
            case 2:
                updateDevice();
                break;
            case 3:
                deleteDevice();
                break;
            case 4:
                return;
            default:
                System.out.println("Некорректный выбор.");
        }
    }

    private static void addDevice() {
        int category;
        while (true) {
            System.out.println("Выберите тип устройства:");
            System.out.println("1. Кровяной давлениемер");
            System.out.println("2. Глюкометр");
            System.out.println("3. Электрокардиограф");
            System.out.print("Ваш выбор: ");
            try {
                category = Integer.parseInt(scanner.nextLine());
                if (category < 1 || category > 3) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите число от 1 до 3.");
            }
        }
        System.out.println("Введите производителя: ");
        String manufacturer = scanner.nextLine();

        String serialNumber;
        while (true) {
            System.out.println("Введите серийный номер: ");
            serialNumber = scanner.nextLine();
            if (serialNumber.startsWith("-")) {
                System.out.println("Ошибка: серийный номер не может быть отрицательным.");
            } else {
                break;
            }
        }

        switch (category) {
            case 1:
                medicalDevices.add(new BloodPressureMonitor(manufacturer, "Кровяной давлениемер", serialNumber));
                break;
            case 2:
                medicalDevices.add(new Glucometer(manufacturer, "Глюкометр", serialNumber));
                break;
            case 3:
                medicalDevices.add(new Electrocardiograph(manufacturer, "Электрокардиограф", serialNumber));
                break;
            default:
                System.out.println("Некорректная категория.");
        }
    }

    private static void updateDevice() {
        System.out.println("Список доступных устройств:");
        for (int i = 0; i < medicalDevices.size(); i++) {
            System.out.println(i + ". " + medicalDevices.get(i));
        }
        System.out.println("Выберите устройство для изменения:");
        int index = -1;
        while (true) {
            try {
                index = Integer.parseInt(scanner.nextLine());
                if (index < 0 || index >= medicalDevices.size()) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите корректный индекс устройства.");
            }
        }
        System.out.println("Введите нового производителя: ");
        String manufacturer = scanner.nextLine();

        String serialNumber;
        while (true) {
            System.out.println("Введите новый серийный номер: ");
            serialNumber = scanner.nextLine();
            if (serialNumber.startsWith("-")) {
                System.out.println("Ошибка: серийный номер не может быть отрицательным.");
            } else {
                break;
            }
        }

        MedicalDevice device = medicalDevices.get(index);
        device.setManufacturer(manufacturer);
        device.setSerialNumber(serialNumber);
    }

    private static void deleteDevice() {
        if (medicalDevices.isEmpty()) {
            System.out.println("Все устройства уже удалены.");
            return;
        }

        System.out.println("Список доступных устройств:");
        for (int i = 0; i < medicalDevices.size(); i++) {
            System.out.println(i + ". " + medicalDevices.get(i));
        }

        System.out.print("Выберите устройство для удаления: ");
        int index = -1;
        while (index < 0 || index >= medicalDevices.size()) {
            System.out.print("Введите номер устройства: ");
            try {
                index = Integer.parseInt(scanner.nextLine());
                if (index < 0 || index >= medicalDevices.size()) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите корректный номер устройства.");
            }
        }

        MedicalDevice removedDevice = medicalDevices.remove(index);
        System.out.println("Устройство " + removedDevice.getModel() + " удалено.");
    }


    private static void removeTestResultsForDevice(MedicalDevice device) {
        ArrayList<TestResult> resultsToRemove = new ArrayList<>();
        for (TestResult result : testResults) {
            if (result.getManufacturer().equals(device.getManufacturer()) &&
                    result.getSerialNumber().equals(device.getSerialNumber())) {
                resultsToRemove.add(result);
            }
        }
        testResults.removeAll(resultsToRemove);
    }

}

