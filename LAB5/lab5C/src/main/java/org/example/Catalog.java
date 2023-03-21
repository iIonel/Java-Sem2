package org.example;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Catalog {
    private List<Document> documents;

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public Catalog(){
        this.documents = new ArrayList<>();
    }

    public void add(Document doc){
        documents.add(doc);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Catalog: ");
        for(Document doc: documents)
            s.append(doc.toString()).append("\n");
        return s.toString();
    }

    public void save(String file){
        ObjectMapper mapper = new ObjectMapper();
        try{
            mapper.writeValue(new File(file),this);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Catalog load(String file){
        ObjectMapper mapper = new ObjectMapper();
        Catalog cat = null;
        try{
            cat = mapper.readValue(new File(file),Catalog.class);
        }catch (IOException e){
            e.printStackTrace();
        }
        return cat;
    }
}
