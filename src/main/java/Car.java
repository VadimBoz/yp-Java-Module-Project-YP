public class Car {
    private int speed;
    private final String name;

    public Car(String name, int speed) {
        this.speed = speed;
        this.name = name;
    }

    public int getSpeed() {
        return speed; //скорость в км/ч
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }


    public String getName() {
        return name;
    }

}
