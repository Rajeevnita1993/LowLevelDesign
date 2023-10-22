package com.example.DesignFileSystem;

import java.util.HashMap;
import java.util.Map;

public class FileSystem {

    Map<String, Integer> paths;

    public FileSystem() {
        paths = new HashMap<>();
    }

    public boolean createPath(String path, int value) {

        // Step 1 : Basic path validations
        if (path.isEmpty() || path.equals("/") || this.paths.containsKey(path)) {
            return false;
        }

        int delimIndex = path.lastIndexOf("/");
        String parentPath = path.substring(0, delimIndex);

        // Step 2: If parent path does not exist. Note that "/" is a valid parent
        if (parentPath.length() > 1 && !this.paths.containsKey(parentPath)) {
            return false;
        }

        // Step 3: add this new path and return true
        this.paths.put(path, value);
        return true;

    }

    public int get(String path) {
        return this.paths.getOrDefault(path, -1);

    }
}
