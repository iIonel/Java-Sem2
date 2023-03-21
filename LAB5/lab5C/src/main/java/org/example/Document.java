package org.example;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.*;
public class Document {
    private String id;
    private String name;
    private String path;
    private String url;
    private List<Tag> tags;

    public Document(String id, String name, String path, String url) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.url = url;
        this.tags = new ArrayList<>();

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    void addTag(Tag tag){
        this.tags.add(tag);
    }

    @Override
    public String toString() {
        StringBuilder s= new StringBuilder();
        s.append(name).append("\n");
        s.append("Tags: ");
        for(Tag tag: tags){
            s.append(tag.getName()).append("-").append(tag.getValue()).append(" ");
        }
        s.append("\n");
        s.append("Path: ").append(path).append("\n");
        s.append("URL: ").append(url);
        return s.toString();
    }
}
