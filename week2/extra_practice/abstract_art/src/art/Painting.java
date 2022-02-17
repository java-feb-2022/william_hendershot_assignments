package week2.extra_practice.abstract_art.src.art;

public class Painting extends Art {
    
    private String paintType;
    
    public Painting(String title, String author, String description, String paintType){
        super(title, author, description);
        this.setPaintType(paintType);
    }

    public void setPaintType(String paintType) {
        this.paintType = paintType;
    }
    
    public String getPaintType() {
        return this.paintType;
    }

    public void viewArt() {
        String view = "";
        view += String.format("Title: %s%n", this.getTitle());
        view += String.format("Author: %s%n", this.getAuthor());
        view += String.format("Paint Type: %s%n", this.getPaintType());
        view += String.format("Description: %s%n", this.getDescription());

        System.out.println(view);
    }
}