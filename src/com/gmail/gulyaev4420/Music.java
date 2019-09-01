package com.gmail.gulyaev4420;

public class Music {

        @Save private int Album;
        @Save private long SongNumber;
        @Save private String SongName;
        @Save private boolean Good;

        public Music() {}

        public Music(int Album, long SongNumber, String SongName, boolean Good){
            this.Album = Album;
            this.SongNumber = SongNumber;
            this.SongName = SongName;
            this.Good = Good;
        }

        public int getAlbum() {
            return Album;
        }
        public void setAlbum() {
            this.Album = Album;
        }

        public long getSongNumber() {
            return SongNumber;
        }
        public void setSongNumber() {
            this.SongNumber = SongNumber;
        }

        public String getSongName() {
            return SongName;
        }
        public void setSongName() {
            this.SongName = SongName;
        }

        public boolean getGood() {
            return Good;
        }
        public void setGood() {
            this.Good = Good;
        }

        @Override
        public String toString() {
        return "Music{" + "SongName" + SongName + "Album - " + Album +
                "Song number in album - " + SongNumber +
                "Are the a good song?" + Good + '}';
    }
}
