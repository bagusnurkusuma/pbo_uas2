/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.asia.aplikasipencatatan;

/**
 *
 * @author Bagus Nur Kusuma(23201014)
 */
public class AplikasiPencatatan {

    public static void main(String[] args) {
        NoteAppMenu noteapp = new NoteAppMenu("notes.db");
        noteapp.start();
    }
}
