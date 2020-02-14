package com.omtlab.algorithmrecipe.design.using.map;

import org.junit.Test;

import static org.junit.Assert.*;

public class LC588Test {

    LC588.FileSystem fileSystem = new LC588.FileSystem();

    @Test
    public void testFileSystem() {
        System.out.println(fileSystem.ls("/"));
        fileSystem.mkdir("/a/b/c");
        System.out.println(fileSystem.ls("/a"));
        System.out.println(fileSystem.ls("/b"));
        System.out.println(fileSystem.ls("/a/b"));
        System.out.println(fileSystem.ls("/"));
        fileSystem.mkdir("/a/b/d");
        fileSystem.mkdir("/a/b/a");
        System.out.println(fileSystem.ls("/a/b"));
        fileSystem.addContentToFile("/a/b/f/omt", "om sai ram");
        System.out.println(fileSystem.ls("/a/b/f/omt"));
        System.out.println(fileSystem.readContentFromFile("/a/b/f/omt"));
        fileSystem.addContentToFile("/a/b/f/omt", "<Airbnb>");
        System.out.println(fileSystem.readContentFromFile("/a/b/f/omt"));
        fileSystem.mkdir("/a/b/f/d");
        System.out.println(fileSystem.ls("/a/b/f/omt"));
        System.out.println(fileSystem.ls("/a/b/f"));
        fileSystem.mkdir("/a/b");
        System.out.println(fileSystem.ls("/a"));

    }


}