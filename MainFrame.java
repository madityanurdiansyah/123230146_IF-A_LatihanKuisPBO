/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latihankuispbo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    public MainFrame(String username) {
        setTitle("Halaman Utama");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(245, 245, 245)); 

        
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        titlePanel.setBackground(new Color(245, 245, 245)); 
        titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        
        JLabel welcomeLabel = new JLabel("Selamat Datang, " + username);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        welcomeLabel.setForeground(new Color(70, 130, 180)); 
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titlePanel.add(welcomeLabel);

        
        titlePanel.add(Box.createRigidArea(new Dimension(0, 10)));

        
        JLabel instructionLabel = new JLabel("Silakan pilih menu di bawah untuk membeli majalah");
        instructionLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        instructionLabel.setForeground(new Color(50, 50, 50)); 
        instructionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titlePanel.add(instructionLabel);

        panel.add(titlePanel, BorderLayout.NORTH);

        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        buttonPanel.setBackground(new Color(245, 245, 245)); 

        
        JButton anakButton = createStyledButton("Majalah Anak");
        anakButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PurchaseFrame("Majalah Anak", 10800).setVisible(true);
                dispose();
            }
        });
        buttonPanel.add(anakButton);

        
        JButton remajaButton = createStyledButton("Majalah Remaja");
        remajaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PurchaseFrame("Majalah Remaja", 15200).setVisible(true);
                dispose();
            }
        });
        buttonPanel.add(remajaButton);

        
        JButton dewasaButton = createStyledButton("Majalah Dewasa");
        dewasaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PurchaseFrame("Majalah Dewasa", 25500).setVisible(true);
                dispose();
            }
        });
        buttonPanel.add(dewasaButton);

        panel.add(buttonPanel, BorderLayout.CENTER);

        add(panel);
    }

    
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBackground(new Color(70, 130, 180)); 
        button.setForeground(Color.WHITE); 
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return button;
    }
}