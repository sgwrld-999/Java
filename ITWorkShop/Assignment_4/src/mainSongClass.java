import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.exit;

class creatingSongPlaylist {
    private ArrayList<Integer> playlist = new ArrayList<>() ;
    private int songId;
    private int timeDuration;
    private int count;
    private String soongName;
    private String artist;
    private String genre;
    private String album;

    creatingSongPlaylist(int songId, int timeDuration, int count, String soongName, String artist, String genre, String album) {
        this.songId = songId;
        this.timeDuration = timeDuration;
        this.count = count;
        this.soongName = soongName;
        this.artist = artist;
        this.genre = genre;
        this.album = album;
    }
    creatingSongPlaylist() {}

    public void addingInfoToSong(int songId, int timeDuration, int count, String soongName, String artist, String genre, String album) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Song ID: ");
        songId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Song Title: ");
        soongName = scanner.nextLine();
        System.out.print("Enter Artist Name: ");
        artist = scanner.nextLine();
        System.out.print("Enter Album Title: ");
        album = scanner.nextLine();
        System.out.print("Enter Genre: ");
        genre = scanner.nextLine();
        System.out.print("Enter Duration (in seconds): ");
        timeDuration  = scanner.nextInt();
    }
    public void printSongDetails(int tempId){
        if(songId == tempId){
            System.out.println("Song Title: " + soongName);
            System.out.println("Artist: " + artist);
            System.out.println("Album: " + album);
            System.out.println("Genre: " + genre);
            System.out.println("Duration: " + timeDuration + " seconds");
            System.out.println("Play Count: " + count);
        } else {
            System.out.println("Song not found.");
        }
    }
    public void printSpecificAttribute(int tempId, int attribute) {
        if (songId == tempId) {
            switch (attribute) {
                case 1:
                    System.out.println("Song Title: " + soongName);
                    break;
                case 2:
                    System.out.println("Artist: " + artist);
                    break;
                case 3:
                    System.out.println("Album: " + album);
                    break;
                case 4:
                    System.out.println("Genre: " + genre);
                    break;
                case 5:
                    System.out.println("Duration: " + timeDuration + " seconds");
                    break;
                case 6:
                    System.out.println("Play Count: " + count);
                    break;
                default:
                    System.out.println("Invalid attribute.");
            }
        } else {
            System.out.println("Song not found.");
        }
    }
    public void play(int tempId){
        if (songId == tempId) {
            System.out.println("Playing: " + soongName);
            count++;
        } else {
            System.out.println("Song not found.");
        }
    }
    public void add(int id) {
        if (songId == id) {
            if (!playlist.contains(id)) {
                playlist.add(id);
                System.out.println("Song added to playlist.");
            } else {
                System.out.println("Song is already in the playlist.");
            }
        } else {
            System.out.println("Song not found.");
        }
    }

    public void remove(int id) {
        if (songId == id) {
            if (playlist.contains(id)) {
                playlist.remove(Integer.valueOf(id));
                System.out.println("Song removed from playlist.");
            } else {
                System.out.println("Song is not in the playlist.");
            }
        } else {
            System.out.println("Song not found.");
        }
    }
}
public class mainSongClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        creatingSongPlaylist song = new creatingSongPlaylist();

        System.out.println("Song Management System");
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add Song");
            System.out.println("2. Play Song");
            System.out.println("3. Add to Playlist");
            System.out.println("4. Remove from Playlist");
            System.out.println("5. Print Song Details");
            System.out.println("6. Play Specific Attribute");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Adding a New Song:");
                    System.out.print("Enter Song ID: ");
                    int newSongId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Song Title: ");
                    String newSongTitle = scanner.nextLine();
                    System.out.print("Enter Artist Name: ");
                    String newArtist = scanner.nextLine();
                    System.out.print("Enter Album Title: ");
                    String newAlbum = scanner.nextLine();
                    System.out.print("Enter Genre: ");
                    String newGenre = scanner.nextLine();
                    System.out.print("Enter Duration (in seconds): ");
                    int newDuration = scanner.nextInt();
                    song = new creatingSongPlaylist(newSongId, newDuration, 0, newSongTitle, newArtist, newGenre, newAlbum);
                    System.out.println("Song added.");
                    break;
                case 2:
                    System.out.print("Enter Song ID to play: ");
                    int playId = scanner.nextInt();
                    song.play(playId);
                    break;
                case 3:
                    System.out.print("Enter Song ID to add to playlist: ");
                    int addToPlaylistId = scanner.nextInt();
                    song.add(addToPlaylistId);
                    break;
                case 4:
                    System.out.print("Enter Song ID to remove from playlist: ");
                    int removeFromPlaylistId = scanner.nextInt();
                    song.remove(removeFromPlaylistId);
                    break;
                case 5:
                    System.out.print("Enter Song ID to print details: ");
                    int printDetailsId = scanner.nextInt();
                    song.printSongDetails(printDetailsId);
                    break;
                case 6:
                    System.out.print("Enter Song ID to play specific attribute: ");
                    int playAttributeId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Attributes:");
                    System.out.println("1. Song Title");
                    System.out.println("2. Artist");
                    System.out.println("3. Album");
                    System.out.println("4. Genre");
                    System.out.println("5. Duration");
                    System.out.println("6. Play Count");
                    System.out.print("Choose the attribute to play: ");
                    int attributeChoice = scanner.nextInt();
                    song.printSpecificAttribute(playAttributeId, attributeChoice);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    exit(0);
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        } while (choice != 7);
        scanner.close();
    }
}