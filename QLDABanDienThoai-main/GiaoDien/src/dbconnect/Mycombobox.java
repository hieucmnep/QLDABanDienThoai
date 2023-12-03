/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbconnect;

/**
 *
 * @author ADMIN
 */
public class Mycombobox {

    private Object value, text; // chứa mã thuuộc tính và tên thuộc tính
    // value : mã , text : tên
    private String thuonghieu;

    public Mycombobox(String thuonghieu) {
        this.thuonghieu = thuonghieu;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getText() {
        return text;
    }

    public void setText(Object text) {
        this.text = text;
    }

    public String getThuonghieu() {
        return thuonghieu;
    }

    public void setThuonghieu(String thuonghieu) {
        this.thuonghieu = thuonghieu;
    }

    public Mycombobox(Object value, Object text) {
        this.value = value;
        this.text = text;
    }

    public Mycombobox() {
    }

    @Override
    public String toString() {
        return text.toString();
    }

    //lấy dữ liệu kiểu string
    public String maString() {
        return value.toString();
    }

    // lấy dữ liệu kiểu int
    public int maint() {
        return Integer.parseInt(value.toString());
    }

}
