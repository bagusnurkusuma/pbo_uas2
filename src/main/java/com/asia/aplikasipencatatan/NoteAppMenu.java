/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asia.aplikasipencatatan;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Bagus Nur Kusuma(23201014)
 */
public class NoteAppMenu {

    private NoteService noteService;
    private Scanner scanner;

    public NoteAppMenu(String databasePath) {
        noteService = new NoteService(new DatabaseStorage(databasePath));
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            tampilkanMenu();
            int pilihan = readInt("Enter your choice (1 - 4): ");
            if (pilihan == 1) {
                tambahCatatan();
            } else if (pilihan == 2) {
                tampilCatatan();
            } else if (pilihan == 3) {
                hapusCatatan();
            } else {
                System.out.println("Exiting...");
                break;
            }
        }
    }

    private void tampilkanMenu() {
        System.out.println("");
        System.out.println("Note App Menu: Oleh Bagus Nur Kusuma NIM: 23201014");
        System.out.println("1. Add Note");
        System.out.println("2. Show Notes");
        System.out.println("3. Delete Note");
        System.out.println("4. Exit");
    }

    private int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Silakan masukkan angka.");
                scanner.nextLine();
            }
        }
    }

    private void tambahCatatan() {
        System.out.print("Enter note: ");
        if (scanner.hasNextInt() || scanner.hasNextLine()) {
            scanner.nextLine();
        }
        String input = scanner.nextLine();
        noteService.createNote(input);
        System.out.println("Note Saved : " + input);
    }

    private void tampilCatatan() {
        List<String> notes = noteService.readNotes();
        if (notes.isEmpty()) {
            System.out.println("Notes is empty");
        } else {
            System.out.println("Saved Notes :");
            int index = 1;
            for (String note : notes) {
                System.out.println(index + ". " + note);
                index += 1;
            }
        }
    }

    private void hapusCatatan() {
        List<String> notes = noteService.readNotes();
        if (notes.isEmpty()) {
            System.out.println("Notes is empty");
        } else {
            System.out.println("Saved Notes :");
            int index = 1;
            for (String note : notes) {
                System.out.println(index + ". " + note);
                index += 1;
            }

            int total_catatan = noteService.getNoteCount();
            System.out.print("Enter the note index to delete (1 - " + total_catatan + "): ");
            if (scanner.hasNextInt() || scanner.hasNextLine()) {
                scanner.nextLine();
            }

            int input = scanner.nextInt();
            if (total_catatan >= input) {
                String catatan_dipilih = noteService.getNoteByIndex(input - 1);
                noteService.deleteNote(catatan_dipilih);
                System.out.println("Notes Deleted: " + catatan_dipilih);
            } else {
                System.out.println("Notes with index : "+input+" ,not found");
            }
        }
    }
}
