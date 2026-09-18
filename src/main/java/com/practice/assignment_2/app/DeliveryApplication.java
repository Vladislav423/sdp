package com.practice.assignment_2.app;

import com.practice.assignment_2.gui.Button;
import com.practice.assignment_2.gui.Checkbox;
import com.practice.assignment_2.gui.GUIFactory;
import com.practice.assignment_2.logistics.Logistics;

public class DeliveryApplication {
    private final Button button;
    private final Checkbox checkbox;
    private final Logistics logistics;

    public DeliveryApplication(GUIFactory factory, Logistics logistics) {
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
        this.logistics = logistics;
    }

    public void run(String cargo, String destination) {
        button.paint();
        checkbox.paint();
        logistics.planDelivery(cargo, destination);
    }
}