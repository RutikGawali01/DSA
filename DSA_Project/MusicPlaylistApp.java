import java.util.*;

class Song {
    String name;
    String artist;
    double duration; // in minutes
    Song next, prev;

    Song(String name, String artist, double duration) {
        this.name = name;
        this.artist = artist;
        this.duration = duration;
    }
}

class MusicPlaylistManager {
    Song head, current;
    Stack<Song> history = new Stack<>();
    Queue<Song> upcoming = new LinkedList<>();

    // Add a new song to the playlist
    void addSong(String name, String artist, double duration) {
        Song newSong = new Song(name, artist, duration);
        if (head == null) {
            head = newSong;
            current = head;
        } else {
            Song temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newSong;
            newSong.prev = temp;
        }
        System.out.println("🎵 Song added: " + name + " by " + artist);
    }

    // Play next song
    void playNext() {
        if (upcoming.isEmpty() && (current == null || current.next == null)) {
            System.out.println("⚠️ No more songs to play!");
            return;
        }

        if (current != null)
            history.push(current);

        if (!upcoming.isEmpty()) {
            current = upcoming.poll();
        } else if (current.next != null) {
            current = current.next;
        }

        showCurrentSong();
    }

    // Play previous song
    void playPrevious() {
        if (history.isEmpty()) {
            System.out.println("⚠️ No previous songs!");
            return;
        }

        if (current != null)
            upcoming.offer(current);

        current = history.pop();
        showCurrentSong();
    }

    // Add song to upcoming queue
    void addToQueue(String name, String artist, double duration) {
        Song newSong = new Song(name, artist, duration);
        upcoming.offer(newSong);
        System.out.println("🎶 Added to upcoming songs: " + name + " by " + artist);
    }

    // Display all songs in playlist
    void displayPlaylist() {
        if (head == null) {
            System.out.println("⚠️ Playlist is empty!");
            return;
        }

        Song temp = head;
        System.out.println("\n🎼 Playlist Songs:");
        while (temp != null) {
            if (temp == current)
                System.out.println(" -> [Now Playing] " + temp.name + " by " + temp.artist);
            else
                System.out.println(" -> " + temp.name + " by " + temp.artist);
            temp = temp.next;
        }
    }

    // Search for a song in playlist
    void searchSong(String songName) {
        if (head == null) {
            System.out.println("⚠️ Playlist is empty!");
            return;
        }

        Song temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(songName)) {
                System.out.println("\n🔍 Song Found!");
                System.out.println("🎵 Title: " + temp.name);
                System.out.println("👤 Artist: " + temp.artist);
                System.out.println("⏱️ Duration: " + temp.duration + " mins");
                found = true;
                break;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("❌ Song not found in playlist!");
    }

    // Show currently playing song details
    void showCurrentSong() {
        if (current == null) {
            System.out.println("⚠️ No song is currently playing!");
            return;
        }

        System.out.println("\n▶️ Now Playing:");
        System.out.println("🎵 Title: " + current.name);
        System.out.println("👤 Artist: " + current.artist);
        System.out.println("⏱️ Duration: " + current.duration + " mins");
    }

    // Display upcoming songs
    void showUpcoming() {
        if (upcoming.isEmpty()) {
            System.out.println("📭 No upcoming songs!");
            return;
        }

        System.out.println("\n⏩ Upcoming Songs:");
        for (Song s : upcoming)
            System.out.println(" - " + s.name + " by " + s.artist);
    }

    // Display song history
    void showHistory() {
        if (history.isEmpty()) {
            System.out.println("📭 No song history!");
            return;
        }

        System.out.println("\n⏪ History (Recently Played):");
        ListIterator<Song> itr = history.listIterator(history.size());
        while (itr.hasPrevious()) {
            Song s = itr.previous();
            System.out.println(" - " + s.name + " by " + s.artist);
        }
    }
}

public class MusicPlaylistApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MusicPlaylistManager manager = new MusicPlaylistManager();
        int choice;

        System.out.println("🎧 Welcome to Music Playlist Manager 🎧");

        do {
            System.out.println("\n==============================");
            System.out.println("1. Add Song to Playlist");
            System.out.println("2. Play Next Song");
            System.out.println("3. Play Previous Song");
            System.out.println("4. Add Song to Upcoming");
            System.out.println("5. Show Playlist");
            System.out.println("6. Show Upcoming Songs");
            System.out.println("7. Show History");
            System.out.println("8. Search Song");
            System.out.println("9. Show Currently Playing Song");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter song title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter artist name: ");
                    String artist = sc.nextLine();
                    System.out.print("Enter duration (in minutes): ");
                    double duration = sc.nextDouble();
                    manager.addSong(title, artist, duration);
                }
                case 2 -> manager.playNext();
                case 3 -> manager.playPrevious();
                case 4 -> {
                    System.out.print("Enter song title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter artist name: ");
                    String artist = sc.nextLine();
                    System.out.print("Enter duration (in minutes): ");
                    double duration = sc.nextDouble();
                    manager.addToQueue(title, artist, duration);
                }
                case 5 -> manager.displayPlaylist();
                case 6 -> manager.showUpcoming();
                case 7 -> manager.showHistory();
                case 8 -> {
                    System.out.print("Enter song name to search: ");
                    String songName = sc.nextLine();
                    manager.searchSong(songName);
                }
                case 9 -> manager.showCurrentSong();
                case 10 -> System.out.println("👋 Exiting... Goodbye!");
                default -> System.out.println("⚠️ Invalid choice!");
            }
        } while (choice != 10);

        sc.close();
    }
}
