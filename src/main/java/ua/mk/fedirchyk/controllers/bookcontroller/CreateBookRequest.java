package ua.mk.fedirchyk.controllers.bookcontroller;

import java.util.List;

public class CreateBookRequest {
    private String bookName;
    private List<Long> authorIds;
    private List<Long> categoriesId;
    private List<Long> publishersId;

    public List<Long> getPublishersId() {
        return publishersId;
    }

    public void setPublishersId(List<Long> publishersId) {
        this.publishersId = publishersId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public List<Long> getCategoriesId() {
        return categoriesId;
    }

    public void setCategoriesId(List<Long> categoriesId) {
        this.categoriesId = categoriesId;
    }

    public List<Long> getAuthorIds() {
        return authorIds;
    }

    public void setAuthorIds(List<Long> authorIds) {
        this.authorIds = authorIds;
    }
}
