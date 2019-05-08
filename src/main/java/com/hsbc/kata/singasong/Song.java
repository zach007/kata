package com.hsbc.kata.singasong;

import lombok.Getter;

import java.util.List;

public class Song {
    public static final String suffixString = "I don't know why she swallowed a fly - perhaps she'll die!\n" +
            "\n";

    public static void main(String[] args) {

        String song = Animal.fly.verse +
                suffixString +
                Animal.spider.verse +
                "She swallowed the spider to catch the fly;\n" +
                suffixString +
                Animal.bird.verse +
                "She swallowed the bird to catch the spider,\n" +
                "She swallowed the spider to catch the fly;\n" +
                suffixString +
                Animal.cat.verse +
                "She swallowed the cat to catch the bird,\n" +
                "She swallowed the bird to catch the spider,\n" +
                "She swallowed the spider to catch the fly;\n" +
                suffixString +
                Animal.dog.verse +
                "She swallowed the dog to catch the cat,\n" +
                "She swallowed the cat to catch the bird,\n" +
                "She swallowed the bird to catch the spider,\n" +
                "She swallowed the spider to catch the fly;\n" +
                suffixString +
                Animal.cow.verse +
                "She swallowed the cow to catch the dog,\n" +
                "She swallowed the dog to catch the cat,\n" +
                "She swallowed the cat to catch the bird,\n" +
                "She swallowed the bird to catch the spider,\n" +
                "She swallowed the spider to catch the fly;\n" +
                suffixString +
                Animal.horse.verse;

        System.out.println(song);
    }

    //todo write test first and then write the code
    public String lyricsFor(List<String> animal) {
        if (animal.isEmpty()) {
            return "";
        } else {
            StringBuilder sb = new StringBuilder();
            Animal[] values = Animal.values();
            for (int i = 0; i < animal.size(); i++) {
                String name = animal.get(i);
                for (int j = 0; j < values.length; j++) {
                    Animal value = values[j];
                    if (name.equals(value)) {
                        sb.append(value.verse + suffixString);
                    }
                }
            }
            return sb.toString();
        }
    }

    enum Animal {
        fly("There was an old lady who swallowed a fly.\n"),
        spider("There was an old lady who swallowed a spider;\n" +
                "That wriggled and wiggled and tickled inside her.\n"),
        bird("There was an old lady who swallowed a bird;\n" +
                "How absurd to swallow a bird.\n"),
        cat("There was an old lady who swallowed a cat;\n" +
                "Fancy that to swallow a cat!\n"),
        dog("There was an old lady who swallowed a dog;\n" +
                "What a hog, to swallow a dog!\n"),
        cow("There was an old lady who swallowed a cow;\n" +
                "I don't know how she swallowed a cow!\n"),
        horse("There was an old lady who swallowed a horse...\n" +
                "...She's dead, of course!");

        @Getter
        private String verse;

        Animal(String verse) {
            this.verse = verse;
        }
    }
}
