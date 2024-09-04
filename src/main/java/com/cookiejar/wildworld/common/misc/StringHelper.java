package com.cookiejar.wildworld.common.misc;

public class StringHelper {

    /**
     * Takes the given String and makes every separate word's
     * first letter capitalized, and returns the result.
     */
    public static String toTitleCase(String givenString) {
        String[] components = givenString.split(" ");
        StringBuilder builder = new StringBuilder();

        for (String s : components) {
            builder.append(Character.toUpperCase(s.charAt(0)))
                    .append(s.substring(1)).append(" ");
        }
        return builder.toString().trim();
    }
}
