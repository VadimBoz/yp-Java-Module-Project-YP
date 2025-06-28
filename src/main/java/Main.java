import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Racing racing = new Racing(3);

        String nameCar;
        String speedCar;
        int speed;
        for (int i = 1; i <= 3; i++) {

            while (true) {
                System.out.println("Введите наименование автомобиля №" + i);
                try {
                    nameCar = validateName(scanner.nextLine());
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            while (true) {
                System.out.println("Введите скорость автомобиля №" + i);
                try {
                    speed = validateSpeed(scanner.nextLine());
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            racing.addCar(new Car(nameCar, speed));
        }
        racing.startRace();
        racing.printWinner();
    }


    private static int validateSpeed(String input) {
        if (input == null || input.trim().isEmpty()) throw new IllegalArgumentException("Скорость не может быть пустой");
        if (input.trim().charAt(0) == '-') throw new IllegalArgumentException("Скорость не может быть отрицательной");
        boolean isNumber = input.trim().matches("\\d+");
        if (!isNumber) throw new IllegalArgumentException("Скорость должна быть целым числом");
        int speed = Integer.parseInt(input.trim());
        if (speed == 0) throw new IllegalArgumentException("Скорость не может быть 0 км/ч");
        if (speed > 250) throw new IllegalArgumentException("Скорость не может быть больше 250 км/ч");
        return speed;
    }


    private static String validateName(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Наименование не может быть пустым");
        }
        return input.trim();
    }

}