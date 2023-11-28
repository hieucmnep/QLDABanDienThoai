/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbconnect;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author ADMIN
 */
public class XImage {

    public static Image getAppIcon() {
        URL url = XImage.class.getResource("/com/edusys/icon/fpt.png");
        if (url != null) {
            return new ImageIcon(url).getImage();
        } else {
            // Handle the case where url is null
            System.out.println("Unable to load application icon");
            return null;
        }
    }

    public static boolean save(File src) {
        File dst = new File("src/main/resources/com/edusys/logos", src.getName());
        if (!dst.getParentFile().exists()) {
            dst.getParentFile().mkdirs();
        }
        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(dst.getAbsolutePath());
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (Exception e) {
            System.out.println("Error saving logo: " + e.getMessage());
            return false;
        }
    }

    public static ImageIcon read(String fileName) {
        File path = new File("src/main/resources/com/edusys/logos", fileName);
        if (path.exists()) {
            return new ImageIcon(path.getAbsolutePath());
        } else {
            System.out.println("Logo file not found: " + fileName);
            return null;
        }
    }
}
