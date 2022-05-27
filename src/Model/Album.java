
package Model;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author guexa
 */
public class Album {
    
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }
    
    public Album() {}

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }
    
    public Song findSong(String title){
        for(Song checkedSong : songs){
            if(checkedSong.getTitle().equals(title))
                return checkedSong;
        }
        return null;
    }
    
    public boolean addSong(String title, double duration){
        if(findSong(title) == null){
            songs.add(new Song(title, duration));
            //System.out.println(title + "\n Succesfully added to the list");
            return true;
        } else {
            System.out.println("\nTitle with name " + title + " already exist in the list");
            return false;
        }
    }
    
    public boolean addToPlaylist(int trackNumber, LinkedList<Song> Playlist){
        int index = trackNumber - 1;
        if(index > 0 && index <= this.songs.size()){
            Playlist.add(this.songs.get(index));
            return true;
        }
        System.out.println("\nThis album doesn't have song with tracknumber" + trackNumber);
        return false;
    }
    
    public boolean addToPlayList(String title, LinkedList<Song> Playlist){
        for(Song checkedSong : this.songs){
            if(checkedSong.getTitle().equals(title)){
                Playlist.add(checkedSong);
                return true;
            }
        }
        System.out.println("\n" + title + " there is no such song in album");
        return false;
    }
}
