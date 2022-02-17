package week2.extra_practice.abstract_art;

import week2.extra_practice.abstract_art.src.museum.Museum;
import week2.extra_practice.abstract_art.src.art.*;

public class TestMeuseum {
    public static void main(String[] args) {
        Museum myMuseum = new Museum();

        myMuseum.addArt(new Painting("The bird", "William", "A bird staring at the observer.", "Acrylic"));
        myMuseum.addArt(new Painting("The bee", "William", "A bee staring at the observer.", "Bees"));
        myMuseum.addArt(new Painting("The Abyss", "William", "The abyss staring at the observer.", "Dark"));

        myMuseum.addArt(new Sculpture("The people", "William", "A heroic depiction of the Village People mid-song", "Gold plated platinum"));
        myMuseum.addArt(new Sculpture("The computer", "William", "A not so heroic display of the 80's Kaypro II might", "Kaypro II with King's Quest 2"));

        myMuseum.displayArt();
        myMuseum.displayArtRandomly();
    }
}
