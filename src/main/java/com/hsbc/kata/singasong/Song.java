package com.hsbc.kata.singasong;

import com.google.common.base.Strings;
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
            StringBuilder sb = new StringBuilder();
            Animal[] values = Animal.values();
            for (int i = 0; i < values.length; i++) {
                Animal value = values[i];

                String bar = "";

                if (i - 1 >= 0) {
                    Animal beforeValue = values[i - 1];
                    bar = beforeValue.name();
                }
                if (value.name().equals(animal.get(i))) {
                    sb.append(prefixString)
                            .append(value.name())
                            .append(value.verse)
                            //todo
                            .append(foo(value.name(), bar))
                            .append(middleString)
                            .append(value.name())
                            .append(suffixString);
                }
            }
            return sb.toString();
        }
        return null;
    }

    private String foo(String animal, String beforeValue) {
        if (!Strings.isNullOrEmpty(beforeValue)) {
            return String.format("She swallowed the %s to catch the %s", animal, beforeValue);
        }
        {
            return "";
        }
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
        spider("\nThat wriggled and wiggled and tickled inside her.\n");

        @Getter
        private String verse;

        Animal(String verse) {
            this.verse = verse;
        }
    }
}
