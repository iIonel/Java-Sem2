package org.example;

public class AddCommand implements Command{
    Document doc;

    public AddCommand(Document doc) {
        this.doc = doc;
    }

    @Override
    public void execute(Catalog c) {
        c.add(doc);
    }
}
