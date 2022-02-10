package week1.extra_practice.map_of_the_hashmatique;

import java.util.HashMap;
import java.util.Set;

public class Hashmatique {
    
    public static void main(String[] args){

        //Song Title : Sample Lyrics
        HashMap<String, String> trackList = new HashMap<String, String>();

        trackList.put("Country", "I lost my dog...");
        trackList.put("Jazz", "*No lyrics");
        trackList.put("Pop", "Mmmm bop,...");
        trackList.put("Fresh Prince", "Causing trouble in my neighborhood...");

        System.out.println(trackList.get("Jazz"));

        Set<String> songs = trackList.keySet();

        System.out.println("Track Name:       Lyric Sample:");
        for (String song : songs){
            System.out.printf(" %-17s %s%n", song, trackList.get(song));
        }
    }
}
