
package View;

import Model.Album;
import Model.Song;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 *
 * @author guexa
 */
public class Main {
    
    private static ArrayList<Album> albums = new ArrayList<>();
    
    public static void main(String[] args) {
        
        Album album = new Album("Giallo", "Jos\u00e9 Madero");
        
        album.addSong("Quita Esa Cara", 4.18);
        album.addSong("Soy el Diluvio", 3.04);
        album.addSong("Cantar de Gesta", 3.35);
        album.addSong("Quince Mil D\u00edas", 4.00);
        album.addSong("Cerraron Chipinque", 4.22);
        album.addSong("La Herida", 3.45);
        album.addSong("A Tu Merced", 4.20);
        album.addSong("Nadie M\u00e1s Vendr\u00e1", 3.44);
        album.addSong("En Vano", 4.21);
        album.addSong("Providencia A La Izquierda", 4.39);
        album.addSong("Documentales", 3.43);
        album.addSong("Siempre Vos", 3.27);
        album.addSong("Lo Dorado Desvanece", 3.22);
        
        albums.add(album);
        
        album = new Album("Noche", "Jos\u00e9 Madero");
        
        album.addSong("Noche De Lluvia", 2.26);
        album.addSong("Lo Sobrenatural", 2.57);
        album.addSong("MCMLXXX", 4.19);
        album.addSong("Grandes \u00c9xitos", 3.48);
        album.addSong("El Ser Supremo", 4.01);
        album.addSong("Noche De Brujas", 4.27);
        album.addSong("Una Nueva Identidad", 3.33);
        album.addSong("Fantasmas", 3.28);
        album.addSong("Noche De Baile", 3.34);
        album.addSong("Esta Noche Es La Reuni\u00f3n!", 4.25);
        album.addSong("Noche De Discoteque", 4.51);
        album.addSong("Son\u00e1mbulos", 3.46);
        album.addSong("Natt i Stockholm", 3.54);
        
        albums.add(album);
        
        LinkedList<Song> playList1 = new LinkedList<>();
        
        albums.get(0).addToPlayList("En Vano", playList1);
        albums.get(0).addToPlayList("Providencia A La Izquierda", playList1);
        albums.get(0).addToPlayList("Quita Esa Cara", playList1);
        albums.get(0).addToPlayList("Soy el Diluvio", playList1);
        albums.get(0).addToPlayList("Cantar de Gesta", playList1);
        albums.get(0).addToPlayList("Quince Mil D\u00edas", playList1);
        albums.get(0).addToPlayList("Cerraron Chipinque", playList1);
        albums.get(0).addToPlayList("La Herida", playList1);
        albums.get(0).addToPlayList("A Tu Merced", playList1);
        albums.get(0).addToPlayList("Nadie M\u00e1s Vendr\u00e1", playList1);
        albums.get(0).addToPlayList("Documentales", playList1);
        albums.get(0).addToPlayList("Lo Dorado Desvanece", playList1);
        albums.get(0).addToPlayList("Siempre Vos", playList1);
        
        albums.get(1).addToPlayList("Fantasmas", playList1);
        albums.get(1).addToPlayList("MCMLXXX", playList1);
        albums.get(1).addToPlayList("Noche De Lluvia", playList1);
        albums.get(1).addToPlayList("Lo Sobrenatural", playList1);
        albums.get(1).addToPlayList("Grandes \u00c9xitos", playList1);
        albums.get(1).addToPlayList("Son\u00e1mbulos", playList1);
        albums.get(1).addToPlayList("El Ser Supremo", playList1);
        albums.get(1).addToPlayList("Noche De Brujas", playList1);
        albums.get(1).addToPlayList("Una Nueva Identidad", playList1);
        albums.get(1).addToPlayList("Noche De Baile", playList1);
        albums.get(1).addToPlayList("Esta Noche Es La Reuni\u00f3n!", playList1);
        albums.get(1).addToPlayList("Noche De Discoteque", playList1);
        albums.get(1).addToPlayList("Natt i Stockholm", playList1);
        
        play(playList1);
        
    }
    
    private static void play(LinkedList<Song> playlist){
        
        Scanner scan = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playlist.listIterator();
        
        if(playlist.isEmpty()){
            System.out.println("This playlist have no song");
        } else {
            System.out.println("\nNow playing "+ listIterator.next().toString());
            printMenu();
        }
        
        while(!quit){
            int action = scan.nextInt();
            scan.nextLine();
            
            switch(action){
                
                case 0:
                    System.out.println("Playlist Complete");
                    quit = true;
                    break;
                
                case 1:
                    if(!forward && listIterator.hasNext()){
                        listIterator.next();
                    }
                    forward = true;
                    if(listIterator.hasNext()){
                        System.out.println("\nNow playing " + listIterator.next().toString());
                    } else {
                        System.out.println("No song available, reach to the end of the list");
                        forward = false;
                    }
                    break;
                
                case 2:
                    if(forward && listIterator.hasPrevious()){
                        listIterator.previous();
                    }
                    forward = false;
                    if(listIterator.hasPrevious()){
                        System.out.println("\nNow playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("We're at the first song");
                        forward = false;
                    }
                    break;
                    
                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("\nNow playing " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We're at the start of the list");
                        }
                    } else {
                        if(listIterator.hasNext()){
                            System.out.println("\nNow Playing " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We've reached to the end of the list");
                        }
                    }
                    break;
                    
                case 4:
                    printList(playlist);
                    break;
                    
                case 5:
                    printMenu();
                    break;
                    
                case 6:
                    if(playlist.size() > 0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("\nNow playing " + listIterator.next().toString());
                        } else {
                            if(listIterator.hasPrevious())
                            System.out.println("\nNow playing " + listIterator.previous().toString());
                        }
                    }
            }
        }
    }
    
    private static void printMenu(){
        
        System.out.println("\nWelcome to your favorite MusicApp");
        System.out.println("|-----------------------------------|");
        System.out.println("|         Available Options         |");
        System.out.println("|  1 - Play next song               |");
        System.out.println("|  2 - Play previous song           |");
        System.out.println("|  3 - Replay the current song      |");
        System.out.println("|  4 - List of all songs            |");
        System.out.println("|  5 - Print all available options  |");
        System.out.println("|  6 - Delete current song          |");
        System.out.println("|-----------------------------------|");
        
    }
    
    private static void printList(LinkedList<Song> playList){
    
        Iterator<Song> iterator = playList.iterator();
        
        System.out.println("-----------------------------------");
        
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        
        System.out.println("-----------------------------------");
    }
}
