package org.example;
import javax.print.Doc;
import java.util.*;
import java.util.stream.IntStream;
import com.fasterxml.jackson.core.*;
public class Main {
    public static void main(String[] args) {
        Catalog catalog = new Catalog();
        var documents = IntStream.rangeClosed(1,2).mapToObj(i->new Document("0"+i,"DOC" + i,"/path/to/DOC" + i,"https://example.com/DOC" + i)).toArray(Document[]::new);
        List<Document> documentsList = new ArrayList<>();
        for(Document doc: documents)
            documentsList.add(doc);
        documentsList.get(0).addTag(new Tag("Author:", "Dani Mocanu"));
        documentsList.get(0).addTag(new Tag("Years: ","3 sept 1992-"));
        documentsList.get(1).addTag(new Tag("Author:","Florin Salam "));
        documentsList.get(1).addTag(new Tag("Years: ","1 oct 1979-"));

        for(Document doc: documents)
            catalog.add(doc);

        System.out.println(catalog.toString());
        catalog.save("finalCatalog.json");

        Catalog loadedCatalog = Catalog.load("finalcatalog.json");
        System.out.println(loadedCatalog.toString());
    }
}