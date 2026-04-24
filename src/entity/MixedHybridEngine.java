package entity;

public class MixedHybridEngine implements Engine {

    private final GasolineEngine gasolineEngine = new GasolineEngine();
    private final ElectronicEngine electronicEngine = new ElectronicEngine();
    private int speed = 0;

    @Override
    public void increase() {
        speed++;
        if (speed < 50) {
            electronicEngine.increase();
        } else {
            gasolineEngine.increase();
        }
    }

    @Override
    public void decrease() {
        if (speed > 0) speed--;
        if (speed < 50) {
            electronicEngine.decrease();
        } else {
            gasolineEngine.decrease();
        }
    }

    @Override
    public int getSpeed() { return speed; }

    @Override
    public String getType() { return "Mixed Hybrid Engine"; }

    public String getActiveEngine() {
        return speed < 50 ? "Electric" : "Gasoline";
    }
}