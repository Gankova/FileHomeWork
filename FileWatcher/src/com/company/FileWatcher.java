package com.company;

import java.io.File;
import java.util.HashMap;

public class FileWatcher implements Runnable{
    public String adress;
    public long interval;
    public File file;


    public FileWatcher(String dir, long pollingInterval) {
        this.adress = dir;
        this.interval = pollingInterval;
    }

    HashMap<String, Long> filearray = new HashMap();
    HashMap<String,Long> filesarray2 = new HashMap();

    public void fileArray() {

        File n = new File(adress);
        for (File file : n.listFiles()) {
            if (file.isFile()) {
                filearray.put(file.getName(), file.length());
            }
        }

    }


    public void watch () {
        FileWatcher fileWatcher = new FileWatcher(this.adress,this.interval);

        for (int i = 0; i<10; i++){
            //filesarray2.clear();
            //filesarray2 = filearray;
            filearray.clear();
            fileWatcher.fileArray();

            /*File n = new File(adress);
            for (File file : n.listFiles()) {
                if (file.isFile()) {
                    filearray.put(file.getName(), file.length());
                }


            }*/
            Thread thread2 = new Thread(fileWatcher::faylArray2);
            Thread thread = new Thread(fileWatcher::run);

            thread.start();
            thread2.start();


            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }



            try {
            thread.sleep(this.interval);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            while (thread.isAlive()){
            try {
                thread2.sleep(this.interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            }
            }
            }



   @Override
    public void run() {


            if (filearray.hashCode() == filesarray2.hashCode()) {
                System.out.println("Изменений нет");
                System.out.println(filearray.keySet());
                System.out.println(filesarray2.keySet());


            } else {
                System.out.println("произошли изменения");
                System.out.println(filearray.keySet());
                System.out.println(filesarray2.keySet());

            }


    }
    public void faylArray2(){
        File n = new File(adress);
        for (File file : n.listFiles()) {
            if (file.isFile()) {
                filesarray2.put(file.getName(), file.length());
            }


        }
    }
}
















