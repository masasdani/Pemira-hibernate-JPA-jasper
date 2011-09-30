/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.masasdani.pemira.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author badak
 */
@Entity
public class Mahasiswa {
    @Id
    String nim;
    String nama;
    String jurusan;
    int angkatan;

    public int getAngkatan() {
        return angkatan;
    }

    public void setAngkatan(int angkatan) {
        this.angkatan = angkatan;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }
}
