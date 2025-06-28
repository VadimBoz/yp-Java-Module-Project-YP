
import java.util.ArrayList;

public class Racing {
    private final ArrayList<Car> cars = new ArrayList<>();
    private Car winner;
    private double lengthPathWinner = 0;
    private int countCars;


    public Racing(int countCars) {
        this.countCars = countCars;
    }


    public void addCar(Car car) {
        cars.add(car);
    }


    public ArrayList<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public void startRace(double durationRacing) throws InterruptedException {  //время в часах
        if (cars.size() != countCars) throw new IllegalArgumentException("Количество машин не равно заданному");
        System.out.println("Гонка началась!");
        winner = cars.get(0);
        double lengthPath = cars.get(0).getSpeed() * durationRacing;

        for (int i = 1; i < cars.size(); i++) {
            lengthPath = cars.get(i).getSpeed() * durationRacing;
            if (lengthPath >= lengthPathWinner) {
                winner = cars.get(i);
                lengthPathWinner = lengthPath;
            }
        }

        for (int i = 1; i < 24; i++) {
            Thread.sleep(200);
            System.out.print(". ");
        }

        System.out.println("\nГонка закончилась!");

    }


    public void startRace() throws InterruptedException {
        startRace(24);
    }


    public void printWinner() {
        if (winner == null) {
            System.out.println("Гонка не началась или в конке не было победителя");
        } else {
            System.out.println("Победитель в гонке автомобиль - " + winner.getName()
                    + "\n       со скоростью - " + winner.getSpeed() + " км/ч"
                    + "\n       пройденное расстояние  - " + lengthPathWinner + " км");
        }
    }
}
