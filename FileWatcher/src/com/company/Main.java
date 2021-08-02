package com.company;

import javafx.scene.shape.Path;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Paths;
import java.nio.file.WatchService;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        FileWatcher file = new FileWatcher("C://Users//natag//Desktop//Новая папка",5000);
        file.adress = "C://Users//natag//Desktop//Новая папка";
        file.watch();




    }
}
