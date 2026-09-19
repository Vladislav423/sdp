# Assignment 2 — Factory Method and Abstract Factory

---

## 1. Project Purpose

This project is a console-based Java logistics application that demonstrates two creational design patterns:

* **Factory Method** — creates the appropriate transport for road or sea delivery.
* **Abstract Factory** — creates a matching family of UI components for Windows or macOS.

The application combines both patterns in one program.

At runtime, the user selects:

* delivery mode: `ROAD` or `SEA`;
* UI platform: `WINDOWS` or `MACOS`.

All four combinations work without changing the source code.

---

## 2. Package Structure

```text
src/main/java/com/practice/assignment_2/
├── app/
│   └── DeliveryApplication.java
│
├── gui/
│   ├── Button.java
│   ├── Checkbox.java
│   ├── GUIFactory.java
│   ├── MacOSButton.java
│   ├── MacOSCheckbox.java
│   ├── MacOSFactory.java
│   ├── WindowsButton.java
│   ├── WindowsCheckbox.java
│   └── WindowsFactory.java
│
├── logistics/
│   ├── Logistics.java
│   ├── RoadLogistics.java
│   ├── SeaLogistics.java
│   ├── Ship.java
│   ├── Transport.java
│   └── Truck.java
│
└── Main.java
```

### Factory Method

The `logistics` package contains:

* `Transport` — product interface defining delivery behavior.
* `Truck` — concrete product for road delivery.
* `Ship` — concrete product for sea delivery.
* `Logistics` — abstract creator with the shared `planDelivery()` workflow and `createTransport()` factory method.
* `RoadLogistics` — concrete creator that creates `Truck`.
* `SeaLogistics` — concrete creator that creates `Ship`.

### Abstract Factory

The `gui` package contains:

* `Button` — abstract product interface.
* `Checkbox` — abstract product interface.
* `GUIFactory` — abstract factory interface.
* `WindowsButton` and `WindowsCheckbox` — Windows concrete products.
* `MacOSButton` and `MacOSCheckbox` — macOS concrete products.
* `WindowsFactory` — concrete factory for the Windows component family.
* `MacOSFactory` — concrete factory for the macOS component family.

The `app` package contains `DeliveryApplication`, which works with the abstract `GUIFactory` and `Logistics` types.

---

## 3. Prerequisites

* **JDK 17**
* **IntelliJ IDEA** or another Java IDE

No external services, databases, or frameworks are required.

---

## 4. Supported Input

The application accepts the following values:

| Parameter     | Supported values   |
| ------------- | ------------------ |
| Delivery mode | `ROAD`, `SEA`      |
| UI platform   | `WINDOWS`, `MACOS` |

Input is case-insensitive.

Unsupported or missing input is validated and results in a clear error message. The application does not silently use a default value.

---

## 5. Build and Run

### Using IntelliJ IDEA

1. Open the project in IntelliJ IDEA.
2. Configure the project to use **JDK 17**.
3. Open:

```text
src/main/java/com/practice/assignment_2/Main.java
```

4. Run `Main.main()`.
5. Enter the delivery mode when prompted.
6. Enter the UI platform when prompted.

### Using the Terminal

From the project root, compile the project:

```bash
javac -d target/classes src/main/java/com/practice/assignment_2/logistics/*.java src/main/java/com/practice/assignment_2/gui/*.java src/main/java/com/practice/assignment_2/app/*.java src/main/java/com/practice/assignment_2/Main.java
```

Then run the application:

```bash
java -cp target/classes com.practice.assignment_2.Main
```

The application will ask for the delivery mode and UI platform interactively.

---

## 6. Sample Run

```text
Enter delivery mode (ROAD or SEA): ROAD
Enter UI platform (WINDOWS or MACOS): WINDOWS

Delivery mode: ROAD
UI platform: WINDOWS
Rendering Windows button
Rendering Windows checkbox
Truck delivers laboratory equipment to Aktau warehouse by road.
```

The application can also be run with other valid combinations, such as `SEA + WINDOWS`, `ROAD + MACOS`, and `SEA + MACOS`.
