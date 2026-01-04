import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class console_app {
    private List<Vehicle> vehicle = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void run(){
        printMenu();

        boolean is_true = true;

        while (is_true){
            int button = scanner.nextInt();
            scanner.nextLine();


            switch (button) {
                case 1: printAllVehicles();break;
                case 2: addNewCar();break;
                case 3: addNewBus();break;
                case 4: showTotalInsuranceFees();break;
                case 5: showVehiclesOlderThanN();break;
                case 6: performServiceForAll();break;
                case 7: is_true = false;System.out.println("выходим из системы ");break;
                default:
                    System.out.println("Неверный пункт меню");
            }
        }
    }

    private void printMenu() {
        System.out.println("\nFleet Management System");
        System.out.println("1. Print all vehicles");
        System.out.println("2. Add new car");
        System.out.println("3. Add new bus");
        System.out.println("4. Show total yearly insurance fees");
        System.out.println("5. Show vehicles older than N years");
        System.out.println("6. Perform service for all vehicles");
        System.out.println("7. Quit");
        System.out.print("Choose an option: ");
    }






    private void printAllVehicles() {
        if (vehicle.isEmpty()) {
            System.out.println("оно пустое ");
            return;
        }

        for (int i = 0;i <vehicle.size();i++) {
            System.out.println(vehicle.get(i));
        }
    }

    private void addNewCar() {
        System.out.print("модел : ");
        String model = scanner.nextLine();

        System.out.print("год: ");
        int year = scanner.nextInt();

        System.out.print("цена машины ");
        double basePrice = scanner.nextDouble();

        System.out.print("количество дверей ");
        int doors = scanner.nextInt();
        scanner.nextLine();

        Car car = new Car(model, year, basePrice, doors);
        vehicle.add(car);

        System.out.println("машина успешно добавлен");
    }

    private void addNewBus() {
        System.out.print("модел ");
        String model = scanner.nextLine();

        System.out.print("год : ");
        int year = scanner.nextInt();

        System.out.print("цена : ");
        double basePrice = scanner.nextDouble();

        System.out.print("скок человек вмеестит : ");
        int capacity = scanner.nextInt();
        scanner.nextLine();

        Bus bus = new Bus(model, year, basePrice, capacity);
        vehicle.add(bus);

        System.out.println("автобус успешно добавлен");
    }


    private void showTotalInsuranceFees() {
        double total = 0;

        for (Vehicle v : vehicle) {
            total += v.calculateInsuranceFee();
        }

        System.out.println("Total yearly insurance fees: " + total);
    }



    private void showVehiclesOlderThanN() {
        System.out.print("этот год : ");
        int currentYear = scanner.nextInt();

        System.out.print(" (N) год ");
        int n = scanner.nextInt();
        scanner.nextLine();

        boolean found = false;

        for (Vehicle v : vehicle) {
            if (v.getAge(currentYear) > n) {
                System.out.println(v);
                found = true;
            }
        }

        if (!found) {
            System.out.println("ни один транспорт больше " + n + " годов");
        }
    }

    private void performServiceForAll() {
        for (Vehicle v : vehicle) {
            if (v instanceof Servicable) {
                Servicable s = (Servicable) v;
                s.perform_service();
            }
        }
    }
}