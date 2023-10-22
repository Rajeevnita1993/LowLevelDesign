package com.example.FileTaggingSystem;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileTagging {

    public static class File {
        String fileName;
        List<String> tags;
        int size;

        public File(String fileName, List<String> tags, int size) {
            this.fileName = fileName;
            this.tags = tags;
            this.size = size;
        }
    }

    public static List<String> groupFilesByTags(List<File> files, int limit) {

        Map<String, Integer> tagSizeMap = new HashMap<>();

        for (File file : files) {
            for (String tag : file.tags) {
                tagSizeMap.put(tag, tagSizeMap.getOrDefault(tag, 0) + file.size);
            }
        }

        List<Map.Entry<String, Integer>> sortedTags = new ArrayList<>(tagSizeMap.entrySet());
        sortedTags.sort((a, b) -> b.getValue() - a.getValue());

        List<String> topTags = new ArrayList<>();

        for (int i = 0; i < Math.min(sortedTags.size(), limit); i++) {
            topTags.add(sortedTags.get(i).getKey());
        }

        return topTags;
    }
}
