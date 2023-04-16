// package com.skillrisers.streetfighter.sprites;

// import javax.swing.*;
// // import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

// public class BackgroundImage extends JFrame {

//     private ImageIcon[] backgroundImages; // Array of background images
//     private JLabel backgroundLabel; // Label to display background image
//     private int currentBackgroundIndex; // Index of current background image

//     public BackgroundImage() {
//         // Initialize background images
//         backgroundImages = new ImageIcon[3]; // Example: 3 background images
//         backgroundImages[0] = new ImageIcon("bg.png"); // Load background image 1
//         backgroundImages[1] = new ImageIcon("bg.png"); // Load background image 2
//         backgroundImages[2] = new ImageIcon("bg.png"); // Load background image 3

//         // Initialize current background index
//         currentBackgroundIndex = 0;

//         // Create background label
//         backgroundLabel = new JLabel(backgroundImages[currentBackgroundIndex]);
//         add(backgroundLabel);

//         // Create a timer to change background image every 5 seconds
//         Timer timer = new Timer(5000, new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 // Update current background index
//                 currentBackgroundIndex = (currentBackgroundIndex + 1) % backgroundImages.length;
//                 // Update background image
//                 backgroundLabel.setIcon(backgroundImages[currentBackgroundIndex]);
//             }
//         });
//         timer.start();
//     }
// }
