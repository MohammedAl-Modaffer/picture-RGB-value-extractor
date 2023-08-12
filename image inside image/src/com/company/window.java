package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class window {
    String human;
    window() {
        JFrame frame = new JFrame("RGB converter");
        JPanel panel = new JPanel();
        JFileChooser fc = new JFileChooser();
        fc.setBounds(10,10,770,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setBackground(new Color(50,50,50));
        frame.setSize(800,500);
        frame.setLocationRelativeTo(null);

        fc.addActionListener(e -> {
            if (e.getSource() == fc)
                fc.getSelectedFile();

            BufferedImage image = null;

            try {
                image = ImageIO.read(new File(String.valueOf(fc.getSelectedFile())));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            int width = 100;
            int height = 100;
            for(int i=0; i<height; i++) {
                for(int j=0; j<width; j++) {

                    assert image != null;

                    Color c = new Color(image.getRGB(j, i));
                    ArrayList<Color> data = new ArrayList<>();

                    data.add(c);
                    for (int m = 0;m<data.size();m++) {
                        System.out.println(data.get(m));
                        String human = String.valueOf(data);
                        this.human=human;
                    }
                }
            }
            JFrame frame2 = new JFrame("result");
            JLabel label = new JLabel(human);

            frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame2.setBackground(new Color(56, 56, 56));
            frame2.setSize(750, 400);

            label.setSize(750, 400);
            frame2.add(label);
            frame2.setVisible(true);
        });

        frame.add(fc);
        frame.add(panel);
        frame.setVisible(true);

    }
}