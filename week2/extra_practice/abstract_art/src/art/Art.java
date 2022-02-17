package week2.extra_practice.abstract_art.src.art;

public abstract class Art {

    protected String title;
    protected String author;
    protected String description;

    public abstract void viewArt();

    public Art(String title, String author, String description) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setDescription(description);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
