/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package read;

import java.awt.Color;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import rojeru_san.RSPanelsSlider;

/**
 *
 * @author Brandon
 */

public class numeros extends javax.swing.JFrame {

    /**
     * Creates new form numeros
     */
    String usuario;
    JLabel estrella1;
    JLabel estrella2;
    JLabel estrella3;
    public numeros(String nombre,JLabel n1,JLabel n2,JLabel n3) {
        usuario=nombre;
        estrella1 = n1;
        estrella2 = n2;
        estrella3 = n3;
        initComponents();
        apagados();
        this.setLocationRelativeTo(null);
    }
    
    int i=1;
    int x,y;
    public void apagados(){
        atras.setVisible(false);
        
    }
    
    public void pausa(JLabel n){
        Runnable miRunnable;
        miRunnable = new Runnable()
        {
            public void run()
            {
                try
                {
                    if(Integer.parseInt(n.getText())==i){
                        siguiente.setText(Integer.toString(i));
                        i++;
                        n.setBackground(new Color(0,173,86));
                        Thread.sleep(250);
                        n.setBackground(Color.WHITE);
                        
                    }else{
                        n.setBackground(new Color(255,0,0));
                        Thread.sleep(250);
                        n.setBackground(Color.WHITE);
                    }
            
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        };
      Thread hilo = new Thread (miRunnable);
      hilo.start();
      
    } 
    conectar dentro = new conectar();
    public int calificar(String puntaje[]){
        String []ejercicio= new String [6];
        int calificacion=0;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss:SS");
        try {
            try {
                ejercicio=dentro.buscarejercicio(nombreejercicio.getText());
            } catch (SQLException ex) {
                Logger.getLogger(numeros.class.getName()).log(Level.SEVERE, null, ex);
            }
            java.util.Date date = sdf.parse(puntaje[0]);
            java.util.Date date1;
            java.util.Date date2;
            for(int i=2;(i+1)<6;i++){
                date1=sdf.parse(ejercicio[i]);
                date2=sdf.parse(ejercicio[i+1]);
                
                if(date.compareTo(date1)>=0 && date.compareTo(date2)<=0){
                    switch (i){
                        case 2:
                            calificacion = 3;
                            break;
                        case 3:
                            calificacion = 2;
                            break;  
                        case 4:
                            calificacion = 1;
                            break;
                    }
                }
            }
                    
        } catch (ParseException ex) {
            Logger.getLogger(numeros.class.getName()).log(Level.SEVERE, null, ex);
        }
        return calificacion;
    }
    
    public void obtenerdatos(String n){
        try {
            String datos[]=dentro.buscarejercicio(n);
            nombreejercicio.setText(datos[0]);
            instruccionesejercicio.setText(datos[1]);
        } catch (SQLException ex) {
            Logger.getLogger(numeros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int [] mezclandoArray() { 
        int[] ar = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
        Random rnd = ThreadLocalRandom.current(); 
        for (int i = ar.length - 1; i > 0; i--) { 
            int temp = rnd.nextInt(i + 1); 
            // Simple swap 
            int a = ar[temp]; 
            ar[temp] = ar[i]; 
            ar[i] = a; 
        }
        return ar;
    } 
    public void juego(){
        JLabel [] tablero= {n1, n2, n3, n4, n5, n6, n7, n8, n9, n10,n11,n12,n13,n14,
            n15,n16,n17,n18,n19,n20,n21,n22,n23,n24,n25};
        int [] nuevojuego=mezclandoArray();
        for(int i=0;i<25;i++){
            tablero[i].setText(Integer.toString(nuevojuego[i]));
            tablero[i].setBackground(Color.WHITE);
        }
    }
    public void estrella(JLabel e1,JLabel e2,JLabel e3, int idusuario, int idejercicio){
        
        try {
            String[] puntaje=dentro.obtenerpuntaje(idusuario, idejercicio);
            switch (Integer.parseInt(puntaje[2])){
                case 1:
                    e1.setVisible(true);
                    break;
                case 2:
                    e1.setVisible(true);
                    e2.setVisible(true);
                    break;
                case 3:
                    e1.setVisible(true);
                    e2.setVisible(true);
                    e3.setVisible(true);
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        atras = new rojeru_san.RSButton();
        basenumeros = new rojeru_san.RSPanelsSlider();
        instrucciones = new javax.swing.JPanel();
        nombreejercicio = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        instruccionesejercicio = new javax.swing.JTextArea();
        numeros = new javax.swing.JPanel();
        n1 = new javax.swing.JLabel();
        n6 = new javax.swing.JLabel();
        n3 = new javax.swing.JLabel();
        n11 = new javax.swing.JLabel();
        n4 = new javax.swing.JLabel();
        n9 = new javax.swing.JLabel();
        n5 = new javax.swing.JLabel();
        n2 = new javax.swing.JLabel();
        n7 = new javax.swing.JLabel();
        n8 = new javax.swing.JLabel();
        n15 = new javax.swing.JLabel();
        n13 = new javax.swing.JLabel();
        n14 = new javax.swing.JLabel();
        n12 = new javax.swing.JLabel();
        n10 = new javax.swing.JLabel();
        n17 = new javax.swing.JLabel();
        n16 = new javax.swing.JLabel();
        n20 = new javax.swing.JLabel();
        n18 = new javax.swing.JLabel();
        n19 = new javax.swing.JLabel();
        n22 = new javax.swing.JLabel();
        n21 = new javax.swing.JLabel();
        n25 = new javax.swing.JLabel();
        n23 = new javax.swing.JLabel();
        n24 = new javax.swing.JLabel();
        siguiente = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        cronometro = new javax.swing.JLabel();
        continuar = new rojeru_san.RSButtonRiple();
        resultado = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        record = new javax.swing.JLabel();
        tutiempo = new javax.swing.JLabel();
        rSButtonRiple2 = new rojeru_san.RSButtonRiple();
        rSButtonRiple1 = new rojeru_san.RSButtonRiple();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(370, 529));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 183, 255), 1, true));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        atras.setBackground(new java.awt.Color(0, 183, 255));
        atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagnesLectura/regresando 1.png"))); // NOI18N
        atras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                atrasMouseClicked(evt);
            }
        });

        instrucciones.setBackground(new java.awt.Color(255, 255, 255));
        instrucciones.setName("instrucciones"); // NOI18N

        nombreejercicio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        instruccionesejercicio.setEditable(false);
        instruccionesejercicio.setColumns(5);
        instruccionesejercicio.setLineWrap(true);
        instruccionesejercicio.setRows(5);
        instruccionesejercicio.setWrapStyleWord(true);
        jScrollPane1.setViewportView(instruccionesejercicio);

        javax.swing.GroupLayout instruccionesLayout = new javax.swing.GroupLayout(instrucciones);
        instrucciones.setLayout(instruccionesLayout);
        instruccionesLayout.setHorizontalGroup(
            instruccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, instruccionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(instruccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nombreejercicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE))
                .addContainerGap())
        );
        instruccionesLayout.setVerticalGroup(
            instruccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(instruccionesLayout.createSequentialGroup()
                .addComponent(nombreejercicio, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        basenumeros.add(instrucciones, "card4");

        numeros.setBackground(new java.awt.Color(255, 255, 255));
        numeros.setName("numeros"); // NOI18N
        numeros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                numerosMouseEntered(evt);
            }
        });

        n1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        n1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        n1.setText("1");
        n1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 183, 255), 1, true));
        n1.setOpaque(true);
        n1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                n1MouseClicked(evt);
            }
        });

        n6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        n6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        n6.setText("1");
        n6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 183, 255), 1, true));
        n6.setOpaque(true);
        n6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                n6MouseClicked(evt);
            }
        });

        n3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        n3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        n3.setText("1");
        n3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 183, 255), 1, true));
        n3.setOpaque(true);
        n3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                n3MouseClicked(evt);
            }
        });

        n11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        n11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        n11.setText("1");
        n11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 183, 255), 1, true));
        n11.setOpaque(true);
        n11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                n11MouseClicked(evt);
            }
        });

        n4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        n4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        n4.setText("1");
        n4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 183, 255), 1, true));
        n4.setOpaque(true);
        n4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                n4MouseClicked(evt);
            }
        });

        n9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        n9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        n9.setText("1");
        n9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 183, 255), 1, true));
        n9.setOpaque(true);
        n9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                n9MouseClicked(evt);
            }
        });

        n5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        n5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        n5.setText("1");
        n5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 183, 255), 1, true));
        n5.setOpaque(true);
        n5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                n5MouseClicked(evt);
            }
        });

        n2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        n2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        n2.setText("1");
        n2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 183, 255), 1, true));
        n2.setOpaque(true);
        n2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                n2MouseClicked(evt);
            }
        });

        n7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        n7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        n7.setText("1");
        n7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 183, 255), 1, true));
        n7.setOpaque(true);
        n7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                n7MouseClicked(evt);
            }
        });

        n8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        n8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        n8.setText("1");
        n8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 183, 255), 1, true));
        n8.setOpaque(true);
        n8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                n8MouseClicked(evt);
            }
        });

        n15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        n15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        n15.setText("1");
        n15.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 183, 255), 1, true));
        n15.setOpaque(true);
        n15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                n15MouseClicked(evt);
            }
        });

        n13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        n13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        n13.setText("1");
        n13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 183, 255), 1, true));
        n13.setOpaque(true);
        n13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                n13MouseClicked(evt);
            }
        });

        n14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        n14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        n14.setText("1");
        n14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 183, 255), 1, true));
        n14.setOpaque(true);
        n14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                n14MouseClicked(evt);
            }
        });

        n12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        n12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        n12.setText("1");
        n12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 183, 255), 1, true));
        n12.setOpaque(true);
        n12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                n12MouseClicked(evt);
            }
        });

        n10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        n10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        n10.setText("1");
        n10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 183, 255), 1, true));
        n10.setOpaque(true);
        n10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                n10MouseClicked(evt);
            }
        });

        n17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        n17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        n17.setText("1");
        n17.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 183, 255), 1, true));
        n17.setOpaque(true);
        n17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                n17MouseClicked(evt);
            }
        });

        n16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        n16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        n16.setText("1");
        n16.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 183, 255), 1, true));
        n16.setOpaque(true);
        n16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                n16MouseClicked(evt);
            }
        });

        n20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        n20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        n20.setText("1");
        n20.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 183, 255), 1, true));
        n20.setOpaque(true);
        n20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                n20MouseClicked(evt);
            }
        });

        n18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        n18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        n18.setText("1");
        n18.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 183, 255), 1, true));
        n18.setOpaque(true);
        n18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                n18MouseClicked(evt);
            }
        });

        n19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        n19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        n19.setText("1");
        n19.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 183, 255), 1, true));
        n19.setOpaque(true);
        n19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                n19MouseClicked(evt);
            }
        });

        n22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        n22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        n22.setText("1");
        n22.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 183, 255), 1, true));
        n22.setOpaque(true);
        n22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                n22MouseClicked(evt);
            }
        });

        n21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        n21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        n21.setText("1");
        n21.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 183, 255), 1, true));
        n21.setOpaque(true);
        n21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                n21MouseClicked(evt);
            }
        });

        n25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        n25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        n25.setText("1");
        n25.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 183, 255), 1, true));
        n25.setOpaque(true);
        n25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                n25MouseClicked(evt);
            }
        });

        n23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        n23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        n23.setText("1");
        n23.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 183, 255), 1, true));
        n23.setOpaque(true);
        n23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                n23MouseClicked(evt);
            }
        });

        n24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        n24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        n24.setText("1");
        n24.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 183, 255), 1, true));
        n24.setOpaque(true);
        n24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                n24MouseClicked(evt);
            }
        });

        siguiente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        siguiente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        siguiente.setText("0");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel28.setText("/25");

        cronometro.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        cronometro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cronometro.setText("00:00:00:00");

        continuar.setBackground(new java.awt.Color(0, 183, 255));
        continuar.setText("Continuar");
        continuar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                continuarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout numerosLayout = new javax.swing.GroupLayout(numeros);
        numeros.setLayout(numerosLayout);
        numerosLayout.setHorizontalGroup(
            numerosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(numerosLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(numerosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cronometro)
                    .addGroup(numerosLayout.createSequentialGroup()
                        .addComponent(n16, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(n17, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(n18, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(n19, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(n20, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(numerosLayout.createSequentialGroup()
                        .addGroup(numerosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(n1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(n6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(n11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(numerosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(numerosLayout.createSequentialGroup()
                                .addGroup(numerosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(numerosLayout.createSequentialGroup()
                                        .addComponent(n7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(n8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(numerosLayout.createSequentialGroup()
                                        .addComponent(n2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(n3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(numerosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(numerosLayout.createSequentialGroup()
                                        .addComponent(n4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(n5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(numerosLayout.createSequentialGroup()
                                        .addComponent(n9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(n10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(numerosLayout.createSequentialGroup()
                                .addComponent(n12, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(n13, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(n14, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(n15, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(numerosLayout.createSequentialGroup()
                        .addComponent(n21, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(n22, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(n23, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(numerosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(continuar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(numerosLayout.createSequentialGroup()
                                .addComponent(n24, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(numerosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(numerosLayout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(siguiente)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel28))
                                    .addComponent(n25, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        numerosLayout.setVerticalGroup(
            numerosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(numerosLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(numerosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(n1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(n5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(n3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(n2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(n4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(numerosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(n6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(n7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(n8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(n9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(n10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(numerosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(n11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(n12, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(n13, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(n14, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(n15, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(numerosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(numerosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(n16, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(n17, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(n19, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(n20, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(n18, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(numerosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(n21, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(n22, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(n23, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(n24, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(n25, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(numerosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(siguiente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cronometro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(continuar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        basenumeros.add(numeros, "card3");

        resultado.setBackground(new java.awt.Color(255, 255, 255));
        resultado.setName("resultado"); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 183, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("¡Record!");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 183, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Tu tiempo");

        record.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        record.setText("00:00:00:00");

        tutiempo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tutiempo.setText("00:00:00:00");

        rSButtonRiple2.setBackground(new java.awt.Color(0, 183, 255));
        rSButtonRiple2.setText("Terminar");
        rSButtonRiple2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButtonRiple2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout resultadoLayout = new javax.swing.GroupLayout(resultado);
        resultado.setLayout(resultadoLayout);
        resultadoLayout.setHorizontalGroup(
            resultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resultadoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rSButtonRiple2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131))
            .addGroup(resultadoLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(resultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(resultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, resultadoLayout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(17, 17, 17))
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, resultadoLayout.createSequentialGroup()
                            .addComponent(tutiempo)
                            .addGap(39, 39, 39)))
                    .addGroup(resultadoLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(record)
                        .addGap(39, 39, 39)))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        resultadoLayout.setVerticalGroup(
            resultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resultadoLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(record)
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tutiempo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addComponent(rSButtonRiple2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        basenumeros.add(resultado, "card4");

        rSButtonRiple1.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonRiple1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagnesLectura/boton-de-reproduccion (1).png"))); // NOI18N
        rSButtonRiple1.setColorHover(new java.awt.Color(0, 183, 255));
        rSButtonRiple1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButtonRiple1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(basenumeros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(rSButtonRiple1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(atras, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(atras, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(basenumeros, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSButtonRiple1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rSButtonRiple1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonRiple1MouseClicked
        // TODO add your handling code here:
        i=1;
        basenumeros.setPanelSlider(1, numeros, RSPanelsSlider.DIRECT.RIGHT);
        juego();
        atras.setVisible(true);
        rSButtonRiple1.setVisible(false);
        
        new Thread(new Runnable(){
                            
                        @Override
                       
                        public void run() {
                                Cronometro nuevo=new Cronometro(cronometro,siguiente);
                                if(Integer.parseInt(siguiente.getText())==25 ){
                                    nuevo.parar();
                                }
                                
                           }
                                                
                        }).start(); 
    }//GEN-LAST:event_rSButtonRiple1MouseClicked

    private void n1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n1MouseClicked
        // TODO add your handling code here:
        pausa(n1);
    }//GEN-LAST:event_n1MouseClicked

    private void n2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n2MouseClicked
        // TODO add your handling code here:
        pausa(n2);
    
    }//GEN-LAST:event_n2MouseClicked

    private void n3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n3MouseClicked
        // TODO add your handling code here:
        pausa(n3);
     
    }//GEN-LAST:event_n3MouseClicked

    private void n4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n4MouseClicked
        // TODO add your handling code here:
        pausa(n4);
     
    }//GEN-LAST:event_n4MouseClicked

    private void n5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n5MouseClicked
        // TODO add your handling code here:
        pausa(n5);
    
    }//GEN-LAST:event_n5MouseClicked

    private void n6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n6MouseClicked
        // TODO add your handling code here:
        pausa(n6);
     
    }//GEN-LAST:event_n6MouseClicked

    private void n7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n7MouseClicked
        // TODO add your handling code here:
        pausa(n7);
      
    }//GEN-LAST:event_n7MouseClicked

    private void n8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n8MouseClicked
        // TODO add your handling code here:
        pausa(n8);
       
    }//GEN-LAST:event_n8MouseClicked

    private void n9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n9MouseClicked
        // TODO add your handling code here:
        pausa(n9);
       
    }//GEN-LAST:event_n9MouseClicked

    private void n10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n10MouseClicked
        // TODO add your handling code here:
        pausa(n10);
      
    }//GEN-LAST:event_n10MouseClicked

    private void n11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n11MouseClicked
        // TODO add your handling code here:
        pausa(n11);
       
    }//GEN-LAST:event_n11MouseClicked

    private void n12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n12MouseClicked
        // TODO add your handling code here:
        pausa(n12);
       
    }//GEN-LAST:event_n12MouseClicked

    private void n13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n13MouseClicked
        // TODO add your handling code here:
        pausa(n13);
       
    }//GEN-LAST:event_n13MouseClicked

    private void n14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n14MouseClicked
        // TODO add your handling code here:
        pausa(n14);
       
    }//GEN-LAST:event_n14MouseClicked

    private void n15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n15MouseClicked
        // TODO add your handling code here:
        pausa(n15);
    
    }//GEN-LAST:event_n15MouseClicked

    private void n16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n16MouseClicked
        // TODO add your handling code here:
        pausa(n16);
     
    }//GEN-LAST:event_n16MouseClicked

    private void n17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n17MouseClicked
        // TODO add your handling code here:
        pausa(n17);
    
    }//GEN-LAST:event_n17MouseClicked

    private void n18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n18MouseClicked
        // TODO add your handling code here:
        pausa(n18);
     
    }//GEN-LAST:event_n18MouseClicked

    private void n19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n19MouseClicked
        // TODO add your handling code here:
        pausa(n19);
       
    }//GEN-LAST:event_n19MouseClicked

    private void n20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n20MouseClicked
        // TODO add your handling code here:
        pausa(n20);
      
    }//GEN-LAST:event_n20MouseClicked

    private void n21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n21MouseClicked
        // TODO add your handling code here:
        pausa(n21);
        
    }//GEN-LAST:event_n21MouseClicked

    private void n22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n22MouseClicked
        // TODO add your handling code here:
        pausa(n22);
        
    }//GEN-LAST:event_n22MouseClicked

    private void n23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n23MouseClicked
        // TODO add your handling code here:
        pausa(n23);
        
    }//GEN-LAST:event_n23MouseClicked

    private void n24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n24MouseClicked
        // TODO add your handling code here:
        pausa(n24);
        
    }//GEN-LAST:event_n24MouseClicked

    private void n25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n25MouseClicked
        // TODO add your handling code here:
        pausa(n25);
       
    }//GEN-LAST:event_n25MouseClicked

    private void numerosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_numerosMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_numerosMouseEntered

    private void atrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atrasMouseClicked
        this.dispose();
    }//GEN-LAST:event_atrasMouseClicked

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        // TODO add your handling code here
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        // TODO add your handling code here:
       x=evt.getX();
       y=evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void rSButtonRiple2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonRiple2MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_rSButtonRiple2MouseClicked

    private void continuarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_continuarMouseClicked
        // TODO add your handling code here:
        String []puntaje= new String[3];
        try {
            // TODO add your handling code here
            puntaje= dentro.obtenerpuntaje(dentro.encontraridusuario(usuario), 1);
        } catch (SQLException ex) {
            Logger.getLogger(numeros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(Integer.parseInt(siguiente.getText())==25){
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss:SS");
            try {
                java.util.Date date = sdf.parse(cronometro.getText());
                java.util.Date date1 = sdf.parse(puntaje[1]);
                puntaje[0]= sdf.format(date);
                if(date.compareTo(date1)<=0)
                {
                    puntaje[1]=sdf.format(date);
                    puntaje[2]=Integer.toString(calificar(puntaje));
                    try {
                        estrella(estrella1,estrella2,estrella3,dentro.encontraridusuario(usuario),3);
                    } catch (SQLException ex) {
                        Logger.getLogger(placas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                try {
                    dentro.modificarjercicio(puntaje, 1, dentro.encontraridusuario(usuario));
                } catch (SQLException ex) {
                    Logger.getLogger(numeros.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } catch (ParseException ex) {
                Logger.getLogger(numeros.class.getName()).log(Level.SEVERE, null, ex);
            }
            record.setText(puntaje[1]);
            tutiempo.setText(puntaje[0]);
            basenumeros.setPanelSlider(1,resultado, RSPanelsSlider.DIRECT.RIGHT);
            dentro.desconectar();
            continuar.setVisible(false);
            atras.setVisible(true);
        }
    }//GEN-LAST:event_continuarMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(numeros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(numeros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(numeros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(numeros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new numeros().setVisible(true);
                
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButton atras;
    private rojeru_san.RSPanelsSlider basenumeros;
    private rojeru_san.RSButtonRiple continuar;
    private javax.swing.JLabel cronometro;
    private javax.swing.JPanel instrucciones;
    private javax.swing.JTextArea instruccionesejercicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel n1;
    private javax.swing.JLabel n10;
    private javax.swing.JLabel n11;
    private javax.swing.JLabel n12;
    private javax.swing.JLabel n13;
    private javax.swing.JLabel n14;
    private javax.swing.JLabel n15;
    private javax.swing.JLabel n16;
    private javax.swing.JLabel n17;
    private javax.swing.JLabel n18;
    private javax.swing.JLabel n19;
    private javax.swing.JLabel n2;
    private javax.swing.JLabel n20;
    private javax.swing.JLabel n21;
    private javax.swing.JLabel n22;
    private javax.swing.JLabel n23;
    private javax.swing.JLabel n24;
    private javax.swing.JLabel n25;
    private javax.swing.JLabel n3;
    private javax.swing.JLabel n4;
    private javax.swing.JLabel n5;
    private javax.swing.JLabel n6;
    private javax.swing.JLabel n7;
    private javax.swing.JLabel n8;
    private javax.swing.JLabel n9;
    private javax.swing.JLabel nombreejercicio;
    private javax.swing.JPanel numeros;
    private rojeru_san.RSButtonRiple rSButtonRiple1;
    private rojeru_san.RSButtonRiple rSButtonRiple2;
    private javax.swing.JLabel record;
    private javax.swing.JPanel resultado;
    private javax.swing.JLabel siguiente;
    private javax.swing.JLabel tutiempo;
    // End of variables declaration//GEN-END:variables
}
