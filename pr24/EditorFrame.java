// task3_editor/EditorFrame.java
package task3_editor;

import javax.swing.*;
import java.awt.*;

public class EditorFrame extends JFrame {
    private final ICreateDocument factory;   // ← фабрика (не привязан к типу)
    private IDocument currentDocument;

    public EditorFrame(ICreateDocument factory) {
        super("Редактор");
        this.factory = factory;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setJMenuBar(createMenuBar());
        setSize(600, 400);
        setLocationRelativeTo(null);
    }

    private JMenuBar createMenuBar() {
        JMenuBar bar = new JMenuBar();
        JMenu file = new JMenu("File");

        JMenuItem newItem  = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");

        newItem.addActionListener(e -> {
            currentDocument = factory.createNew();
            currentDocument.open();
        });

        openItem.addActionListener(e -> {
            currentDocument = factory.createOpen();
            currentDocument.open();
        });

        saveItem.addActionListener(e -> {
            if (currentDocument != null) currentDocument.save();
            else System.out.println("Нет открытого документа");
        });

        exitItem.addActionListener(e -> System.exit(0));

        file.add(newItem);
        file.add(openItem);
        file.add(saveItem);
        file.addSeparator();
        file.add(exitItem);

        bar.add(file);
        return bar;
    }

    public static void main(String[] args) {
        // Каркас не привязан к конкретному типу — передаём фабрику
        ICreateDocument factory = new CreateTextDocument();
        SwingUtilities.invokeLater(() -> new EditorFrame(factory).setVisible(true));
    }
}