# Car Factory
 
A Java implementation of a Car Factory system using the **Strategy** and **Factory** design patterns, built as part of the Fawry Software Engineering Internship challenge.
 
---

## 📌 Challenge Overview
 
Design a **Car Factory** with swappable engine types:
 
- 3 engine types: **Gasoline**, **Electric**, and **Hybrid**
- A car can **start**, **stop**, **accelerate**, and **brake**
- The engine tracks its own internal speed (increase/decrease by 1 km/h)
- The car advises the engine on every speed change
- The **Hybrid** engine is cost-optimized: uses Electric below 50 km/h, Gas at 50+ km/h — never both simultaneously
- The factory can **create** a car by engine type or **replace** the engine of an existing car
---
 
## 📁 Project Structure
 
```
CarFactory/
├── src/
│   ├── Main.java                          # Entry point — runs all test scenarios
│   ├── entity/
│   │   ├── Engine.java                    # Engine interface (Strategy)
│   │   ├── GasolineEngine.java            # Gas engine implementation
│   │   ├── ElectronicEngine.java          # Electric engine implementation
│   │   ├── MixedHybridEngine.java         # Hybrid engine (Gas + Electric)
│   │   └── Car.java                       # Car class — uses Engine strategy
│   ├── process/
│   │   └── CarFactory.java                # Factory — creates & replaces engines
│   ├── custom/
│   │   └── EngineNotStoppedException.java # Custom exception for safe stopping
│   └── dummy_data/
│       └── CarScenarios.java              # Test scenarios for all car types
└── README.md
```
 
---
 
## 🚘 Car Operations
 
| Operation | Description |
|-----------|-------------|
| `start()` | Starts the engine at 0 km/h |
| `stop()` | Stops the car — **throws exception** if speed ≠ 0 |
| `accelerate()` | Increases speed by **20 km/h** (max: 200 km/h) |
| `brake()` | Decreases speed by **20 km/h** (min: 0 km/h) |
 
> Every 1 km/h change in car speed calls `engine.increase()` or `engine.decrease()` to keep the engine in sync.
 
---
 
## ▶️ How to Run
 
### Prerequisites
- Java JDK 17+ installed
- VS Code with **Extension Pack for Java** (by Microsoft)
### Compile & Run (Terminal)
 
```bash
# Clone the repository
git clone https://github.com/YOUR_USERNAME/CarFactory.git
cd CarFactory
 
# Compile all source files
javac -d out -sourcepath src src/Main.java
 
# Run the program
java -cp out Main
```
 
### Run in VS Code
1. Open the `CarFactory` folder in VS Code
2. Open `src/Main.java`
3. Press **F5** or click **Run** above the `main` method
---
 
## 📟 Sample Output
 
```
══════════════════════════════════════
  Gasoline Car Test
══════════════════════════════════════
Factory → Created car with Gasoline Engine
Car STARTED  |  Engine: Gasoline Engine
Accelerating from 0 → 20 km/h ...
  [GasolineEngine] speed → 1 km/h
  ...
  [GasolineEngine] speed → 20 km/h
Braking from 20 → 0 km/h ...
  [GasolineEngine] speed → 0 km/h
Car STOPPED.
 
══════════════════════════════════════
  Hybrid Car Test
══════════════════════════════════════
Accelerating from 40 → 60 km/h ...
  [ElectricEngine] speed → 41 km/h   ← Electric zone
  ...
  [GasolineEngine] speed → 51 km/h   ← Gas zone (>=50)
```
 
---
 
## 🛠️ Technologies
 
- **Language:** Java 17
- **IDE:** VS Code
- **Build:** Manual `javac` compilation
