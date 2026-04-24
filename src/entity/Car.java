package entity;

import custom.EngineNotStoppedException;

public class Car {

    private Engine engine;
    private int speed = 0;
    private boolean running = false;

    private static final int SPEED_STEP = 20;
    private static final int MAX_SPEED  = 200;

    public Car(Engine engine) {
        this.engine = engine;
    }

    // ── Operations ──────────────────────────────────────────────

    public void start() {
        running = true;
        speed   = 0;
        System.out.println("Car STARTED  |  Engine: " + engine.getType());
    }

    public void stop() throws EngineNotStoppedException {
        if (speed != 0) {
            throw new EngineNotStoppedException(
                "Cannot stop! Speed must be 0 before stopping. Current: " + speed + " km/h"
            );
        }
        running = false;
        System.out.println("Car STOPPED.");
    }

    public void accelerate() {
        if (!running) {
            System.out.println("Cannot accelerate — car is not running.");
            return;
        }
        if (speed >= MAX_SPEED) {
            System.out.println("Already at max speed: " + MAX_SPEED + " km/h");
            return;
        }

        int target = Math.min(speed + SPEED_STEP, MAX_SPEED);
        System.out.println("Accelerating from " + speed + " → " + target + " km/h ...");

        while (speed < target) {
            speed++;
            engine.increase();   
    }

    public void brake() {
        if (!running) {
            System.out.println("Car is not running.");
            return;
        }
        if (speed == 0) {
            System.out.println("Already at 0 km/h.");
            return;
        }

        int target = Math.max(speed - SPEED_STEP, 0);
        System.out.println("Braking from " + speed + " → " + target + " km/h ...");

        while (speed > target) {
            speed--;
            engine.decrease();  

    // ── Engine replacement (Strategy swap) ──────────────────────

    public void replaceEngine(Engine newEngine) {
        System.out.println("Engine replaced: " + engine.getType()
                         + "  →  " + newEngine.getType());
        this.engine = newEngine;
    }

    // ── Getters ─────────────────────────────────────────────────

    public int   getSpeed()  { return speed;   }
    public Engine getEngine() { return engine;  }
    public boolean isRunning(){ return running; }
}