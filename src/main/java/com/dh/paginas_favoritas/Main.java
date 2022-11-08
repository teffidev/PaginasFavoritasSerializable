package com.dh.paginas_favoritas;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Proceso de escribir y guardar en un archivo:
        List<PaginaWeb> paginaWebList = new ArrayList<>();

        PaginaWeb pw1 = new PaginaWeb("www.youtube.com", "YouTube");
        PaginaWeb pw2 = new PaginaWeb("www.facebook.com", "Facebook");
        PaginaWeb pw3 = new PaginaWeb("www.instagram.com", "Instagram");
        PaginaWeb pw4 = new PaginaWeb("www.twitter.com", "Twitter");
        PaginaWeb pw5 = new PaginaWeb("www.linkedin.com", "LinkedIn");

        paginaWebList.add(pw1);
        paginaWebList.add(pw2);
        paginaWebList.add(pw3);
        paginaWebList.add(pw4);
        paginaWebList.add(pw5);

        FileOutputStream fileOutputStream;

        try {
            fileOutputStream = new FileOutputStream("coleccion_paginas.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(paginaWebList);

        } catch (Exception e){
            e.printStackTrace();
        }

        //Proceso de capturar y leer el archivo:
        List<PaginaWeb> paginaWebList1 = new ArrayList<>();

        FileInputStream fileInputStream;

        try {
            fileInputStream = new FileInputStream("coleccion_paginas.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            paginaWebList1 = (List<PaginaWeb>) objectInputStream.readObject();

            for (PaginaWeb paginaWeb : paginaWebList1) {
                System.out.println(paginaWeb.getUrl() + " - " + paginaWeb.getNombre());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}