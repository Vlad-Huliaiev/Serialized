package com.gmail.gulyaev4420;

public class Main {

    public static void main(String[] args) throws Exception {

        Music rock = new Music(4,4,"Stairway To Heaven",true);
        Serializer.serializer(rock, "RockMusic.txt");

        Music song = new Music();
        deSerializer.deserializer(song, "RockMusic.txt");
        System.out.println(song);
    }
}
