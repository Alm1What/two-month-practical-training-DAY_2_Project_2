package org.example.day_2_practice_project_two.dto;

public class BookDTO {
    private Long id;
    private String title;
    private boolean borrowed;

    private Long authorId;
    private String authorName;
    public BookDTO() {

    }
    public BookDTO(Long id, String title, boolean borrowed, Long authorId, String authorName) {
        this.id = id;
        this.title = title;
        this.borrowed = borrowed;
        this.authorId = authorId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}

