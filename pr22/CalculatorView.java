package task2_gui_mvc;

import javax.swing.*;
import java.awt.*;

public class CalculatorView extends JFrame {
    private final JTextField expressionField = new JTextField();
    private final JTextField resultField = new JTextField();
    private final JPanel buttonsPanel = new JPanel(new GridLayout(5, 4, 5, 5));

    public CalculatorView() {
        super("MyCalculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));

        JPanel top = new JPanel(new GridLayout(2, 1, 5, 5));
        expressionField.setHorizontalAlignment(JTextField.RIGHT);
        expressionField.setFont(new Font("Arial", Font.BOLD, 20));
        expressionField.setEditable(false);

        resultField.setHorizontalAlignment(JTextField.RIGHT);
        resultField.setFont(new Font("Arial", Font.BOLD, 24));
        resultField.setEditable(false);

        top.add(expressionField);
        top.add(resultField);
        add(top, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.CENTER);

        setSize(350, 450);
        setLocationRelativeTo(null);
    }

    public JButton addButton(String label) {
        JButton btn = new JButton(label);
        btn.setFont(new Font("Arial", Font.BOLD, 18));
        buttonsPanel.add(btn);
        return btn;
    }

    public void setExpression(String text)    { expressionField.setText(text); }
    public void appendToExpression(String t)  { expressionField.setText(expressionField.getText() + " " + t); }
    public String getExpression()             { return expressionField.getText().trim(); }
    public void setResult(String text)        { resultField.setText(text); }
    public void clearAll() {
        expressionField.setText("");
        resultField.setText("");
    }
}