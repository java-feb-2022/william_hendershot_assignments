package week2.extra_practice.abstract_art.src.art;

public class Sculpture extends Art {

    private String material;
    
    public Sculpture(String title, String author, String description, String material) {
        super(title, author, description);
        this.setMaterial(material);
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getMaterial() {
        return this.material;
    }

    public void viewArt() {
        String view = "";
        view += String.format("Title: %s%n", this.getTitle());
        view += String.format("Author: %s%n", this.getAuthor());
        view += String.format("Material: %s%n", this.getMaterial());
        view += String.format("Description: %s%n", this.getDescription());

        System.out.println(view);
    }
}
