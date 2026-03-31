import java.util.*;

class SongAlreadyExistsException extends Exception{
    public SongAlreadyExistsException(String msg){
        super(msg);
    }
}

class Song{
    String name;

    Song(String name){
        this.name=name;
    }
}

class PlaylistManager{

    LinkedList<Song> playlist=new LinkedList<>();
    Stack<Song> history=new Stack<>();
    Set<String> songSet=new HashSet<>();

    void addSong(String name) throws SongAlreadyExistsException{
        if(songSet.contains(name)){
            throw new SongAlreadyExistsException("Song already exists");
        }

        Song s=new Song(name);
        playlist.add(s);
        songSet.add(name);
    }

    void playSong(){
        Song s=playlist.poll();
        if(s!=null){
            history.push(s);
            System.out.println("Playing: "+s.name);
        }
    }
}

public class SongPlaylistManager{
    public static void main(String args[]){
        PlaylistManager pm=new PlaylistManager();

        try{
            pm.addSong("Believer");
            pm.addSong("Shape of You");
            pm.addSong("Believer");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        pm.playSong();
        pm.playSong();
    }
}
