package com.omtlab.algorithmrecipe.design.using.map;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * 588. Design In-Memory File System
 * <p>
 * Design an in-memory file system to simulate the following functions:
 * <p>
 * ls: Given a path in string format. If it is a file path, return a list that only contains this file's name. If it is a directory path, return the list of file and directory names in this directory. Your output (file and directory names together) should in lexicographic order.
 * <p>
 * mkdir: Given a directory path that does not exist, you should make a new directory according to the path. If the middle directories in the path don't exist either, you should create them as well. This function has void return type.
 * <p>
 * addContentToFile: Given a file path and file content in string format. If the file doesn't exist, you need to create that file containing given content. If the file already exists, you need to append given content to original content. This function has void return type.
 * <p>
 * readContentFromFile: Given a file path, return its content in string format.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input:
 * ["FileSystem","ls","mkdir","addContentToFile","ls","readContentFromFile"]
 * [[],["/"],["/a/b/c"],["/a/b/c/d","hello"],["/"],["/a/b/c/d"]]
 * <p>
 * Output:
 * [null,[],null,null,["a"],"hello"]
 * <p>
 * Explanation:
 * filesystem
 * <p>
 * <p>
 * Note:
 * <p>
 * You can assume all file or directory paths are absolute paths which begin with / and do not end with / except that the path is just "/".
 * You can assume that all operations will be passed valid parameters and users will not attempt to retrieve file content or list a directory or file that does not exist.
 * You can assume that all directory names and file names only contain lower-case letters, and same names won't exist in the same directory.
 */
public class LC588 {

    public static class DirectoryOrFile implements Comparable<DirectoryOrFile> {
        boolean isFile;
        String name;
        StringBuilder fileContent = new StringBuilder();

        public DirectoryOrFile() {}
        public DirectoryOrFile(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DirectoryOrFile that = (DirectoryOrFile) o;
            return Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public int compareTo(DirectoryOrFile o) {
            return StringUtils.compare(this.name, o.name);
        }
    }

    public static class FileSystem {

        private Map<String, Set<DirectoryOrFile>> directories = new HashMap<>();
        private Map<String, DirectoryOrFile> files = new HashMap<>();


        public FileSystem() {
            directories.put("/", new TreeSet<>()); // Your output (file and directory names together) should in lexicographic order.
        }

        public List<String> ls(String path) {
            List<String> output = new ArrayList<>();
            if (files.containsKey(path)) { // If its file. Just return one file.
                output.add(files.get(path).name);
            } else if(directories.containsKey(path)) { // If its directory then return all children
                for(DirectoryOrFile directoryOrFile:directories.get(path)) {
                    output.add(directoryOrFile.name);
                }
            }
            return output;
        }

        public void mkdir(String path) {
            String child = "";
            while(!directories.containsKey(path)) {
                Set<DirectoryOrFile> set = new TreeSet<>();
                if(StringUtils.isNotEmpty(child)) {
                    DirectoryOrFile directoryOrFile = new DirectoryOrFile();
                    directoryOrFile.name = child;
                    set.add(directoryOrFile);
                }
                directories.put(path,set);
                int index = path.lastIndexOf("/");
                String parentDirectory = path.substring(0, index);

                child = path.substring(index+1);
                // Most IMP Step, Lets say for /a, parentDirectory 0 to lastIndex of "/" which means include 0 and exclude "/"
                // In this case parentDirectory would be blank string.
                path = parentDirectory.length() == 0? "/" :parentDirectory;
            }

            if(StringUtils.isNotEmpty(child) && !directories.get(path).contains(new DirectoryOrFile(child))) {
                DirectoryOrFile directoryOrFile = new DirectoryOrFile();
                directoryOrFile.name = child;
                directories.get(path).add(directoryOrFile);
            }

        }

        public void addContentToFile(String filePath, String content) {
            if (files.containsKey(filePath)) {
                files.get(filePath).fileContent.append(content);
            } else {
                int index = filePath.lastIndexOf("/");
                String directoryPath = filePath.substring(0, index);
                String fileName = filePath.substring(index + 1);
                mkdir(directoryPath); // Create Directory first.
                DirectoryOrFile directoryOrFile = new DirectoryOrFile();
                directoryOrFile.name = fileName;
                directoryOrFile.fileContent.append(content);
                directoryOrFile.isFile = true;

                files.put(filePath, directoryOrFile);
                directories.get(directoryPath).add(directoryOrFile);
            }

        }

        public String readContentFromFile(String filePath) {
            if(files.containsKey(filePath)) {
                return files.get(filePath).fileContent.toString();
            }
            return null; //Ideally we should throw  FileNotFoundException.
        }
    }
}
