package entity;

public class GasolineEngine implements Engine {

    private int speed = 0;

    @Override
    public void increase() {
        speed++;
        System.out.println("  [GasolineEngine] speed → " + speed + " km/h");
    }

    @Override
    public void decrease() {
        if (speed > 0) speed--;
        System.out.println("  [GasolineEngine] speed → " + speed + " km/h");
    }

    @Override
    public int getSpeed() { return speed; }

    @Override
    public String getType() { return "Gasoline Engine"; }
}