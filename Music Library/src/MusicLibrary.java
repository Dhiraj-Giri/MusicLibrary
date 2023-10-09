
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Track {
    private String title;
    private String artist;
    private String album;


    public Track(String title, String artist, String album) {
        this.title = title;
        this.artist = artist;
        this.album = album;
      
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }


    @Override
    public String toString() {
        return "Title: " + title + ", Artist: " + artist + ", Album: " + album ;
    }
}

public class MusicLibrary {
    private Map<String, List<Track>> library;

    public MusicLibrary() {
        library = new HashMap<>();
    }

    public void addTrack(Track track) {
        String artist = track.getArtist().toLowerCase();
        library.putIfAbsent(artist, new ArrayList<>());
        library.get(artist).add(track);
    }

    public List<Track> searchByArtist(String artist) {
        return library.getOrDefault(artist.toLowerCase(), new ArrayList<>());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MusicLibrary musicLibrary = new MusicLibrary();

        while (true) {
            System.out.println("Music Library Menu:");
            System.out.println("1. Add a Track");
            System.out.println("2. Search by Artist");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Artist: ");
                    String artist = scanner.nextLine();
                    System.out.print("Enter Album: ");
                    String album = scanner.nextLine();
                    scanner.nextLine(); 

                    Track newTrack = new Track(title, artist, album);
                    musicLibrary.addTrack(newTrack);
                    System.out.println("Track added successfully!");
                    break;
                case 2:
                    System.out.print("Enter Artist: ");
                    String searchArtist = scanner.nextLine();
                    List<Track> tracks = musicLibrary.searchByArtist(searchArtist);
                    if (tracks.isEmpty()) {
                        System.out.println("No tracks found for the artist: " + searchArtist);
                    } else {
                        System.out.println("Tracks by " + searchArtist + ":");
                        for (Track track : tracks) {
                            System.out.println(track);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

