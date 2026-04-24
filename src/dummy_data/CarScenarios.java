package dummy_data;

import custom.EngineNotStoppedException;
import entity.Car;
import process.CarFactory;

public class CarScenarios {

    public static void runGasolineCarTest() {
        separator("Gasoline Car Test");
        Car car = CarFactory.createCar("gasoline");
        car.start();
        car.accelerate();   
        car.accelerate();   
        car.brake();        
        car.brake();       
        tryStop(car);
    }

    public static void runElectricCarTest() {
        separator("Electric Car Test");
        Car car = CarFactory.createCar("electronic");
        car.start();
        car.accelerate();  
        car.accelerate();  
        tryStop(car);       
        car.brake();       
        car.brake();       
        tryStop(car);      
    }

    public static void runHybridCarTest() {
        separator("Hybrid Car Test");
        Car car = CarFactory.createCar("hybrid");
        car.start();
        car.accelerate();   
        car.accelerate();   
        car.accelerate();   
        car.accelerate();   
        car.brake();        
        car.brake();        
        car.brake();        
        car.brake();        
        tryStop(car);
    }

    public static void runEngineReplacementTest() {
        separator("Engine Replacement Test");
        Car car = CarFactory.createCar("gasoline");
        car.start();
        car.accelerate();

        CarFactory.replaceEngine(car, "electronic");
        car.accelerate();
        car.brake();
        car.brake();
        tryStop(car);
    }

    // ── Helpers ─────────────────────────────────────────────────

    private static void tryStop(Car car) {
        try {
            car.stop();
        } catch (EngineNotStoppedException e) {
            System.out.println("EXCEPTION → " + e.getMessage());
        }
    }

    private static void separator(String title) {
        System.out.println("\n══════════════════════════════════════");
        System.out.println("  " + title);
        System.out.println("══════════════════════════════════════");
    }
}