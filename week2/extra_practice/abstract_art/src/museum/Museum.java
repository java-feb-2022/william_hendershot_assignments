package week2.extra_practice.abstract_art.src.museum;

import java.util.ArrayList;
import java.util.Collections;

import week2.extra_practice.abstract_art.src.art.Art;

public class Museum {
    
    private ArrayList<Art> gallery;

    public Museum() {
        this.gallery = new ArrayList<Art>();
    }

    public void setGallery(ArrayList<Art> gallery) {
        this.gallery = gallery;
    }

    public ArrayList<Art> getGallery() {
        return this.gallery;
    }

    public void addArt(Art art) {
        this.gallery.add(art);
    }

    public void displayArtRandomly() {
        ArrayList<Art> temp = (ArrayList<Art>) this.getGallery().clone();
        Collections.shuffle(temp);
        System.out.println("\nAnd now for a random walk down the line.");
        for (Art art : temp) {
            art.viewArt();
        }
    }

    public void displayArt() {
        System.out.println("\nHere are some interesting objects!");
        for (Art art : this.getGallery()) {
            art.viewArt();
        }
    }
}
