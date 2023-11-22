package Sevice;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */


import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface NhanVienInterface<T> {

    public List<T> getAll();

    public void add(T entity);

    public void remove(T index);

    public void update(T index);

    public boolean isMaNVExists(int maNV);
}
