package process;

import entity.*;

public class CarFactory {

    public static Car createCar(String engineType) {
        Engine engine = buildEngine(engineType);
        System.out.println("Factory → Created car with " + engine.getType());
        return new Car(engine);
    }

    public static void replaceEngine(Car car, String newEngineType) {
        Engine engine = buildEngine(newEngineType);
        car.replaceEngine(engine);
    }

    // ── Private builder ─────────────────────────────────────────

    private static Engine buildEngine(String type) {
        switch (type.trim().toLowerCase()) {
            case "gasoline":  return new GasolineEngine();
            case "electronic": return new ElectronicEngine();
            case "hybrid":    return new MixedHybridEngine();
            default:
                throw new IllegalArgumentException("Unknown engine type: " + type);
        }
    }
}