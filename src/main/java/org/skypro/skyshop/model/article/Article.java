package org.skypro.skyshop.model.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public class Article implements Searchable {
    private final UUID id;
    private final String title;
    private final String content;

    public Article(UUID id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }


    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public UUID getId() { return id; }


    @Override
    public String toString() {
        return title + '\n' + content;
    }

    @Override
    @JsonIgnore
    public String getSearchTerm() {
        return toString();
    }

    @Override
    @JsonIgnore
    public String getSearchContentType() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(title, article.title);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }
}
