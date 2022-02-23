package lab_tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab04_Songs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        List<Song> songs = new ArrayList<>();

        for (int i = 0; i < lines; i++) {
            String[] songInfo = scanner.nextLine().split("_");
            Song song = Song.parse(songInfo);
            songs.add(song);
        }
        String command = scanner.nextLine();
        if (command.equals("all")) {
            printAllSongs(songs);
        } else {
            printSongsBasedOn(songs, command);
        }
    }

    static void printSongsBasedOn(List<Song> songs, String typeList) {
        for (Song song : songs) {
            if (song.getTypeList().equals(typeList)) {
                System.out.println(song.getName());
            }
        }
    }

    static void printAllSongs(List<Song> songs) {
        for (Song song : songs) {
            System.out.println(song.getName());
        }
    }


    static class Song {
        private final String typeList;
        private final String name;
        private String time;

        public Song(String typeList, String name, String time) {
            this.typeList = typeList;
            this.name = name;
            this.time = time;
        }

        public String getTypeList() {
            return typeList;
        }

        public String getName() {
            return name;
        }

        public static Song parse(String[] songInfo) {
            String typeList = songInfo[0];
            String songName = songInfo[1];
            String songTime = songInfo[2];
            return new Song(typeList, songName, songTime);
        }
    }
}
