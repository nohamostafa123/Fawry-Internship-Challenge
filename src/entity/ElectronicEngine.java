package entity;

public class ElectronicEngine implements Engine {

    private int speed = 0;

    @Override
    public void increase() {
        speed++;
        System.out.println("  [ElectricEngine] speed → " + speed + " km/h");
    }

    @Override
    public void decrease() {
        if (speed > 0) speed--;
        System.out.println("  [ElectricEngine] speed → " + speed + " km/h");
    }

    @Override
    public int getSpeed() { return speed; }

    @Override
    public String getType() { return "Electronic Engine"; }
}