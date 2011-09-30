/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.masasdani.pemira.dao;

import com.masasdani.pemira.entity.Mahasiswa;
import java.util.List;

/**
 *
 * @author badak
 */
public interface MahasiswaDao {
    public void save(Mahasiswa m);
    public void delete(Mahasiswa m);
    public List<Mahasiswa> getAll();
    public Mahasiswa getMahasiswa(String nim);
    public List<Mahasiswa> getByJurusan(String j);
    public List<Mahasiswa> getbyAngkatan(int a);
    public List<Mahasiswa> getByNim(String nim);
}
