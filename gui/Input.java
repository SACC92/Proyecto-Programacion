/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import game.*;
/**
 *
 * @author Sebastian
 */
public class Input extends JFrame implements ActionListener{
    
    protected JButton genRandomInv;
    protected JPanel luchadores;
    
    public Input(){
        FlowLayout layout = new FlowLayout();
        this.setLayout(layout);
        
        this.genRandomInv = new JButton("Generar Inventario Luchadores");
        this.genRandomInv.addActionListener(this);
        
        this.luchadores = new JPanel();
        
        this.luchadores.add(genRandomInv);
        
        this.add(luchadores);
        
        this.setSize(600, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == genRandomInv) {
            InventarioLuchadores inventario = new InventarioLuchadores();
            inventario.randomInventario();
            this.remove(luchadores);
            this.repaint();
        }
    }
}
