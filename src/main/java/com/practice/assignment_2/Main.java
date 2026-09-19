package com.practice.assignment_2;

import com.practice.assignment_2.app.DeliveryApplication;
import com.practice.assignment_2.gui.GUIFactory;
import com.practice.assignment_2.gui.MacOSFactory;
import com.practice.assignment_2.gui.WindowsFactory;
import com.practice.assignment_2.logistics.Logistics;
import com.practice.assignment_2.logistics.RoadLogistics;
import com.practice.assignment_2.logistics.SeaLogistics;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String deliveryMode;
        String uiPlatform;

        if (args.length >= 2) {
            deliveryMode = args[0];
            uiPlatform = args[1];
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter delivery mode (ROAD or SEA): ");
            deliveryMode = scanner.hasNextLine() ? scanner.nextLine().trim() : "";

            System.out.print("Enter UI platform (WINDOWS or MACOS): ");
            uiPlatform = scanner.hasNextLine() ? scanner.nextLine().trim() : "";
        }

        if (deliveryMode.isEmpty()) {
            System.err.println("Validation Error: Missing delivery mode. Expected ROAD or SEA.");
            return;
        }

        Logistics logistics;
        switch (deliveryMode.toUpperCase()) {
            case "ROAD":
                logistics = new RoadLogistics();
                break;
            case "SEA":
                logistics = new SeaLogistics();
                break;
            default:
                System.err.println("Validation Error: Unsupported delivery mode '" + deliveryMode + "'. Supported: ROAD, SEA.");
                return;
        }

        if (uiPlatform.isEmpty()) {
            System.err.println("Validation Error: Missing UI platform. Expected WINDOWS or MACOS.");
            return;
        }

        GUIFactory factory;
        switch (uiPlatform.toUpperCase()) {
            case "WINDOWS":
                factory = new WindowsFactory();
                break;
            case "MACOS":
                factory = new MacOSFactory();
                break;
            default:
                System.err.println("Validation Error: Unsupported UI platform '" + uiPlatform + "'. Supported: WINDOWS, MACOS.");
                return;
        }

        System.out.println("Delivery mode: " + deliveryMode.toUpperCase());
        System.out.println("UI platform: " + uiPlatform.toUpperCase());

        DeliveryApplication app = new DeliveryApplication(factory, logistics);
        app.run("laboratory equipment", "Aktau");
    }
}