package me.slq.greendao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "NOTE".
 */
public class Note {

    private Long id;
    /** Not-null value. */
    private String text;
    private String content;
    private java.util.Date date;

    public Note() {
    }

    public Note(Long id) {
        this.id = id;
    }

    public Note(Long id, String text, String content, java.util.Date date) {
        this.id = id;
        this.text = text;
        this.content = content;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** Not-null value. */
    public String getText() {
        return text;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setText(String text) {
        this.text = text;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public java.util.Date getDate() {
        return date;
    }

    public void setDate(java.util.Date date) {
        this.date = date;
    }

}
