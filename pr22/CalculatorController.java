package task2_gui_mvc;

public class CalculatorController {
    private final CalculatorModel model;
    private final CalculatorView view;
    private final StringBuilder currentInput = new StringBuilder();

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;

        String[][] layout = {
                {"C", "⌫", "(", ")"},
                {"7", "8", "9", "/"},
                {"4", "5", "6", "*"},
                {"1", "2", "3", "-"},
                {"0", ".", "=", "+"}
        };

        for (String[] row : layout) {
            for (String label : row) {
                String cmd = label;
                view.addButton(cmd).addActionListener(e -> handle(cmd));
            }
        }
    }

    private void handle(String cmd) {
        switch (cmd) {
            case "C" -> {
                currentInput.setLength(0);
                view.clearAll();
                model.clear();
            }
            case "⌫" -> {
                String expr = view.getExpression();
                if (!expr.isEmpty()) {
                    int lastSpace = expr.lastIndexOf(' ');
                    view.setExpression(lastSpace > 0 ? expr.substring(0, lastSpace) : "");
                }
            }
            case "=" -> calculate();
            default -> {
                currentInput.append(cmd);
                view.appendToExpression(cmd);
            }
        }
    }

    private void calculate() {
        try {
            double result = model.evaluate(view.getExpression());
            view.setResult(String.valueOf(result));
        } catch (RuntimeException ex) {
            view.setResult("Ошибка: " + ex.getMessage());
        }
    }
}