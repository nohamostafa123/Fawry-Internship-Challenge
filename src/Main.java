import dummy_data.CarScenarios;

public class Main {
    public static void main(String[] args) {
        CarScenarios.runGasolineCarTest();
        CarScenarios.runElectricCarTest();
        CarScenarios.runHybridCarTest();
        CarScenarios.runEngineReplacementTest();
    }
}