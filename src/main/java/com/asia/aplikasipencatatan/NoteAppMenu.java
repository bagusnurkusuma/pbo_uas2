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
 * @author STATION20B
 */
public class NoteAppMenu {

    private NoteService noteService;
    private Scanner scanner;

    public NoteAppMenu(String databasePath) {
        noteService = new NoteService(new DatabaseStorage(databasePath));
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean isRunning = true;
        while (isRunning) {
            displayMainMenu();
            int choice = readInt("Enter your choice (1 - 4): ");
            switch (choice) {
                case 1:
                    addNote();
                    break;
                case 2:
                    showNotes();
                    break;
                case 3:
                    deleteNote();
                    break;
                case 4:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Choice is invalid. Please try again.");
                    break;
            }
        }
    }

    private void displayMainMenu() {
        System.out.println("Note App Menu: Oleh Septian Dwi Cahya NIM: 23201032");
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
                scanner.nextLine(); // Mengkonsumsi input yang salah
            }
        }
    }

    private void addNote() {
        System.out.print("Enter note: ");
        if (scanner.hasNextInt() || scanner.hasNextLine()) {
            scanner.nextLine();
        }
        String note = scanner.nextLine();
        noteService.createNote(note);
        System.out.println("Note Saved: " + note);
    }

    private void showNotes() {
        List<String> notes = noteService.readNotes();
        System.out.println("Saved Notes:");
        if (notes.isEmpty()) {
            System.out.println("No notes found.");
        } else {
            for (String note : notes) {
                System.out.println(note);
            }
        }
    }

    private void deleteNote() {
        List<String> notes = noteService.readNotes();
        System.out.println("Saved Notes:");
        if (notes.isEmpty()) {
            System.out.println("No notes found.");
        } else {
            for (String note : notes) {
                System.out.println(note);
            }
        }

        int noteSize = noteService.getNoteCount();
        System.out.print("Enter the note index to delete (1 - " + noteSize + "): ");
        if (scanner.hasNextInt() || scanner.hasNextLine()) {
            scanner.nextLine();
        }
        int note = scanner.nextInt();
        String noteDipilih = noteService.getNoteByIndex(note - 1);
        noteService.deleteNote(noteDipilih);
        System.out.println("Note deleted: " + noteDipilih);
    }
}
