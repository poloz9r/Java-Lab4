import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MedicalDeviceManager {
    private static ArrayList<MedicalDevice> medicalDevices = new ArrayList<>();
    private static ArrayList<TestResult> testResults = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static final String FILE_NAME = "test_results.ser";

    public static void main(String[] args) {
        medicalDevices.add(new BloodPressureMonitor("ЗдоровьеТех", "Кровяной давлениемер", "A17489BB"));
        medicalDevices.add(new Glucometer("ЗдравПром", "Глюкометр", "A1257TRY"));
        medicalDevices.add(new Electrocardiograph("ЗдоровьеДевелопмент", "Электрокардиограф", "B987YY"));

        loadTestResults();  // Загружаем результаты тестов из файла

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
        saveTestResults();  // Сохраняем результаты тестов перед завершением программы
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

    private static void displayTestResults() {
        System.out.println("Список доступных устройств:");
        for (int i = 0; i < medicalDevices.size(); i++) {
            System.out.println(i + ". " + medicalDevices.get(i));
        }
        System.out.println("Выберите устройство для вывода результатов теста:");
        int index = scanner.nextInt();
        if (index >= 0 && index < medicalDevices.size()) {
            medicalDevices.get(index).displayTestResults();
        } else {
            System.out.println("Некорректный индекс.");
        }
    }

    private static void saveTestResults() {
        try {
            FileOutputStream fileOut = new FileOutputStream(FILE_NAME);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(testResults);
            objectOut.close();
            fileOut.close();
            System.out.println("Результаты тестов сохранены в файл: " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении результатов тестов: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private static void loadTestResults() {
        try {
            FileInputStream fileIn = new FileInputStream(FILE_NAME);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            testResults = (ArrayList<TestResult>) objectIn.readObject();
            objectIn.close();
            fileIn.close();
            System.out.println("Результаты тестов загружены из файла: " + FILE_NAME);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке результатов тестов: " + e.getMessage());
        }
    }
}

