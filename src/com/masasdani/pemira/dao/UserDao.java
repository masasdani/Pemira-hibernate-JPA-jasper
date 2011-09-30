/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.masasdani.pemira.dao;

import com.masasdani.pemira.entity.User;
import java.util.List;

/**
 *
 * @author badak
 */
public interface UserDao {
    public void save(User u);
    public void update(User u);
    public boolean isValid(User u);
    public List<User> getAll();
}
