/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latihankuispbo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PurchaseFrame extends JFrame {
    private JTextField quantityField;
    private JLabel totalPriceLabel;
    private JLabel unitPriceLabel;
    private JLabel quantityInfoLabel;

    public PurchaseFrame(String category, int price) {
        setTitle("Halaman Pembelian");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2, 10, 10)); 
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(new Color(245, 245, 245)); 

        
        JLabel categoryLabel = new JLabel("Kategori:");
        categoryLabel.setFont(new Font("Arial", Font.BOLD, 14));
        categoryLabel.setForeground(new Color(50, 50, 50)); 
        panel.add(categoryLabel);

        JLabel categoryValue = new JLabel(category);
        categoryValue.setFont(new Font("Arial", Font.PLAIN, 14));
        categoryValue.setForeground(new Color(70, 130, 180)); 
        panel.add(categoryValue);

        
        JLabel priceLabel = new JLabel("Harga Satuan:");
        priceLabel.setFont(new Font("Arial", Font.BOLD, 14));
        priceLabel.setForeground(new Color(50, 50, 50)); 
        panel.add(priceLabel);

        JLabel priceValue = new JLabel("Rp" + price + " /pcs");
        priceValue.setFont(new Font("Arial", Font.PLAIN, 14));
        priceValue.setForeground(new Color(70, 130, 180)); 
        panel.add(priceValue);

        
        JLabel quantityLabel = new JLabel("Jumlah:");
        quantityLabel.setFont(new Font("Arial", Font.BOLD, 14));
        quantityLabel.setForeground(new Color(50, 50, 50)); 
        panel.add(quantityLabel);

        quantityField = new JTextField();
        quantityField.setFont(new Font("Arial", Font.PLAIN, 14));
        quantityField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1)); 
        panel.add(quantityField);

        
        JButton backButton = createStyledButton("Kembali");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainFrame("123230146").setVisible(true);
                dispose();
            }
        });
        panel.add(backButton);

   
        JButton buyButton = createStyledButton("Beli");
        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int quantity = Integer.parseInt(quantityField.getText());
                    if (quantity <= 0) {
                        throw new IllegalArgumentException("Jumlah harus lebih dari 0");
                    }
                    int totalPrice = quantity * price;
                    totalPriceLabel.setText("Rp" + totalPrice);
                    quantityInfoLabel.setText(quantity + " pcs"); 
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(PurchaseFrame.this, "Jumlah harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(PurchaseFrame.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(buyButton);


        JLabel unitPriceInfoLabel = new JLabel("Harga Satuan Barang:");
        unitPriceInfoLabel.setFont(new Font("Arial", Font.BOLD, 14));
        unitPriceInfoLabel.setForeground(new Color(50, 50, 50)); 
        panel.add(unitPriceInfoLabel);

        unitPriceLabel = new JLabel("Rp" + price + " /pcs");
        unitPriceLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        unitPriceLabel.setForeground(new Color(70, 130, 180)); 
        panel.add(unitPriceLabel);

       
        JLabel quantityInfoTitleLabel = new JLabel("Jumlah Barang yang Dibeli:");
        quantityInfoTitleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        quantityInfoTitleLabel.setForeground(new Color(50, 50, 50)); 
        panel.add(quantityInfoTitleLabel);

        quantityInfoLabel = new JLabel("0 pcs");
        quantityInfoLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        quantityInfoLabel.setForeground(new Color(70, 130, 180));
        panel.add(quantityInfoLabel);


        JLabel totalLabel = new JLabel("Total Pembelian:");
        totalLabel.setFont(new Font("Arial", Font.BOLD, 14));
        totalLabel.setForeground(new Color(50, 50, 50)); 
        panel.add(totalLabel);

        totalPriceLabel = new JLabel("Rp0");
        totalPriceLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        totalPriceLabel.setForeground(new Color(70, 130, 180)); 
        panel.add(totalPriceLabel);
        
        add(panel);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(new Color(70, 130, 180)); 
        button.setForeground(Color.WHITE); 
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return button;
    }
}