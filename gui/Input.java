/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.ArrayList;
import java.util.Random;
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
    
    protected JButton genRandomInv, genRandomParty, battle;
    protected DefaultListModel invLuchadores, party;
    protected JList listLuchadores, listParty;
    protected JScrollPane paneLuchadores, paneParty;
    protected JPanel luchadores;
    
    private InventarioLuchadores inventario;
    private ArrayList<Luchador> team;
    private Batalla arena;
    
    public Input(){
        FlowLayout layout = new FlowLayout();
        this.setLayout(layout);
        
        this.genRandomInv = new JButton("Generar Inventario Luchadores");
        this.genRandomInv.addActionListener(this);
        this.genRandomParty = new JButton("Generar Equipo");
        this.genRandomParty.addActionListener(this);
        this.battle = new JButton("Iniciar batalla");
        this.battle.addActionListener(this);
        
        this.invLuchadores = new DefaultListModel();
        this.listLuchadores = new JList(invLuchadores);
        this.paneLuchadores = new JScrollPane(listLuchadores);
        this.paneLuchadores.setPreferredSize(new Dimension(150, 300));
        this.party = new DefaultListModel();
        this.listParty = new JList(party);
        this.paneParty = new JScrollPane(listParty);
        this.paneParty.setPreferredSize(new Dimension(150, 150));
        //this.listLuchadores = new JList(invLuchadores);
        //this.paneLuchadores = new JScrollPane(listLuchadores);
        
        this.luchadores = new JPanel();
        
        this.luchadores.add(genRandomInv);
        //this.luchadores.add(paneLuchadores);
        //this.luchadores.add(genRandomParty);
        
        
        this.add(luchadores);
        
        this.setSize(600, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == genRandomInv){
            this.inventario = new InventarioLuchadores();
            this.inventario.randomInventario();
            for (int i=0; i<25; i++){
                invLuchadores.addElement(inventario.get(i).getName());
            }
            this.luchadores.remove(genRandomInv);
            this.luchadores.add(paneLuchadores);
            this.luchadores.add(genRandomParty);
            this.revalidate();
        }
        if (e.getSource() == genRandomParty){
            this.luchadores.remove(genRandomParty);
            this.luchadores.add(paneParty);
            this.team = new ArrayList<>();
            Random rnd = new Random();
            ArrayList<Integer> nonRepeat = new ArrayList<>();
            for (int i=0; i < 6; i++){
                int index = rnd.nextInt(inventario.size());
                if (nonRepeat.contains(index)){
                    i--;
                } else{
                    team.add(inventario.get(index));
                    party.addElement(invLuchadores.get(index));
                    inventario.remove(index);
                    invLuchadores.remove(index);
                    nonRepeat.add(index);
                    this.revalidate();
                }
            }
            this.luchadores.add(battle);
            this.revalidate();
        }
        if (e.getSource() == battle){
            arena = new Batalla(team);
        }
    }
}
