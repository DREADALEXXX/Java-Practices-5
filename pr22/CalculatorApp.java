package task2_gui_mvc;

import javax.swing.*;

public class CalculatorApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorModel model = new CalculatorModel();
            CalculatorView view = new CalculatorView();
            new CalculatorController(model, view);
            view.setVisible(true);
        });
    }
}