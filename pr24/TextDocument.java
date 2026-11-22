// task3_editor/TextDocument.java
package task3_editor;

public class TextDocument implements IDocument {
    private String content = "";

    @Override public void open()  { System.out.println("Открыт текстовый документ"); }
    @Override public void save()  { System.out.println("Сохранён текст: \"" + content + "\""); }
    @Override public void close() { System.out.println("Закрыт текстовый документ"); }
    @Override public String getName() { return "TextDocument"; }

    public void setContent(String c) { this.content = c; }
}