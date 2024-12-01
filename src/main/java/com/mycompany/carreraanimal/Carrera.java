/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carreraanimal;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrea
 */


public class Carrera extends Thread {
    private JLabel eti;       
    private Interfaz a;      

    // Constructor
    public Carrera(JLabel eti, Interfaz a) {
        this.eti = eti;
        this.a = a;
    }

    @Override
    public void run() {
        int a1 = 0, a2 = 0, a3 = 0, a4 = 0; // Para almacenar las posiciones de los animales
        boolean carreraTerminada = false;
        // Variables para almacenar si algún animal ya ha llegado
        boolean pollitoGanador = false;
        boolean llamaGanadora = false;
        boolean cerditoGanador = false;
        boolean hipopotamoGanador = false;

        
        // Bucle para mover los animales
        while (true) {
            try {
                sleep((int) (Math.random() * 1000)); 

                // Obtener posiciones de los animales
                a1 = a.getPollito().getLocation().x;
                a2 = a.getLlama().getLocation().x;
                a3 = a.getCerdito().getLocation().x;
                a4 = a.getHipopotamo().getLocation().x;

                // Verificar si algún animal ha cruzado la meta
                if (!pollitoGanador && a1 >= a.getMeta().getLocation().x) {
                    pollitoGanador = true;
                    JOptionPane.showMessageDialog(null, "¡Ganó el Pollito!");
                } 
                if (!llamaGanadora && a2 >= a.getMeta().getLocation().x) {
                    llamaGanadora = true;
                    JOptionPane.showMessageDialog(null, "¡Ganó la Llama!");
                }
                if (!cerditoGanador && a3 >= a.getMeta().getLocation().x) {
                    cerditoGanador = true;
                    JOptionPane.showMessageDialog(null, "¡Ganó el Cerdito!");
                }
                if (!hipopotamoGanador && a4 >= a.getMeta().getLocation().x) {
                    hipopotamoGanador = true;
                    JOptionPane.showMessageDialog(null, "¡Ganó el Hipopotamo!");
                }

                // Si al menos un animal ha llegado a la meta, terminamos el juego
                if (pollitoGanador || llamaGanadora || cerditoGanador || hipopotamoGanador) {
                    break;
                }

               
                eti.setLocation(eti.getLocation().x + 10, eti.getLocation().y);
                a.repaint(); 

            } catch (InterruptedException e) {
                e.printStackTrace(); 
            }
        }
    }
}