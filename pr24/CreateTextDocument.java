// task3_editor/CreateTextDocument.java
package task3_editor;

public class CreateTextDocument implements ICreateDocument {
    @Override
    public IDocument createNew()  { System.out.println("[New] создан текстовый документ");  return new TextDocument(); }

    @Override
    public IDocument createOpen() { System.out.println("[Open] открыт текстовый документ"); return new TextDocument(); }
}