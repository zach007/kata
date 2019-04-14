package com.hsbc.kata.singasong;

import lombok.Getter;

import java.util.List;

public class Song {
    public String lyricsFor(List<String> animal) {
        if (animal.isEmpty()) {
            return "";
        } else if (animal.size() == 1) {
            String oneAnimal = animal.get(0);
            if (oneAnimal.equalsIgnoreCase(Animal.fly.name())) {
                return prefixString + Animal.fly.name() + middleString + Animal.fly.name() + suffixString;
            }
        } else {
            for (String a : animal) {

            }
            return null;
        }
        return null;
    }

    private static final String prefixString = "There was an old lady who swallowed a ";
    private static final String middleString = ".\nI don't know why she swallowed a ";
    private static final String suffixString = " - perhaps she'll die!\n" + "\n";

    public static void main(String[] args) {

        String song = "There was an old lady who swallowed a fly.\n" +
                "I don't know why she swallowed a fly - perhaps she'll die!\n" +
                "\n" +
                "There was an old lady who swallowed a spider;\n" +
                "That wriggled and wiggled and tickled inside her.\n" +
                "She swallowed the spider to catch the fly;\n" +
                "I don't know why she swallowed a fly - perhaps she'll die!\n" +
                "\n" +
                "There was an old lady who swallowed a bird;\n" +
                "How absurd to swallow a bird.\n" +
                "She swallowed the bird to catch the spider,\n" +
                "She swallowed the spider to catch the fly;\n" +
                "I don't know why she swallowed a fly - perhaps she'll die!\n" +
                "\n" +
                "There was an old lady who swallowed a cat;\n" +
                "Fancy that to swallow a cat!\n" +
                "She swallowed the cat to catch the bird,\n" +
                "She swallowed the bird to catch the spider,\n" +
                "She swallowed the spider to catch the fly;\n" +
                "I don't know why she swallowed a fly - perhaps she'll die!\n" +
                "\n" +
                "There was an old lady who swallowed a dog;\n" +
                "What a hog, to swallow a dog!\n" +
                "She swallowed the dog to catch the cat,\n" +
                "She swallowed the cat to catch the bird,\n" +
                "She swallowed the bird to catch the spider,\n" +
                "She swallowed the spider to catch the fly;\n" +
                "I don't know why she swallowed a fly - perhaps she'll die!\n" +
                "\n" +
                "There was an old lady who swallowed a cow;\n" +
                "I don't know how she swallowed a cow!\n" +
                "She swallowed the cow to catch the dog,\n" +
                "She swallowed the dog to catch the cat,\n" +
                "She swallowed the cat to catch the bird,\n" +
                "She swallowed the bird to catch the spider,\n" +
                "She swallowed the spider to catch the fly;\n" +
                "I don't know why she swallowed a fly - perhaps she'll die!\n" +
                "\n" +
                "There was an old lady who swallowed a horse...\n" +
                "...She's dead, of course!";

        System.out.println(song);
    }

    enum Animal {
        fly(""),
        spider("That wriggled and wiggled and tickled inside her.\n");

        @Getter
        private String verse;

        Animal(String verse) {
            this.verse = verse;
        }
    }
}
