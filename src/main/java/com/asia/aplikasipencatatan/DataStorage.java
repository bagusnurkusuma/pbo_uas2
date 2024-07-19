/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asia.aplikasipencatatan;

import java.util.List;

/**
 *
 * @author Bagus Nur Kusuma(23201014)
 */
public interface DataStorage {

    void writeData(String note);

    List<String> readData();

    void deleteData(String note);
}