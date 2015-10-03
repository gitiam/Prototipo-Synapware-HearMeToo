package clases;
 // CAMBIA EL PAQUETE

import javax.swing.*;

public class InterfaceHearMeToo extends javax.swing.JFrame { // Si quieres cambiale el nombre a la clase
    
    public InterfaceHearMeToo() {
        initComponents();
        this.setVisible(true);
    }
    
    public void letraInterpretada(String Letra, String Posibilidad1, String Posibilidad2){
        jLabel3.setText(Letra);
        jButton4.setText(Posibilidad1);
        jButton5.setText(Posibilidad2);
    }
    
    public void dialogo(String A, String B){
         dialogo = new NewJDialog(this, true, A, B);
         dialogo.setVisible(true);
    }

    private class NewJDialog extends javax.swing.JDialog {

        public NewJDialog(java.awt.Frame parent, boolean modal, String A, String B) {
            super(parent, modal);     
            initComponents();
            jButton1.setText(A);
            jButton2.setText(B);
        }
       
        @SuppressWarnings("unchecked")
        
        private void initComponents() {

            jButton1 = new javax.swing.JButton();
            jButton2 = new javax.swing.JButton();
            jLabel1 = new javax.swing.JLabel();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

            jButton1.setText("A");
            jButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
                }
            });

            jButton2.setText("B");
            jButton2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton2ActionPerformed(evt);
                }
            });

            jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); 
            jLabel1.setText("ﾂｿQue quiso decir?");

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(62, 62, 62)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(31, 31, 31)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(49, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(46, 46, 46)
                    .addComponent(jLabel1)
                    .addGap(40, 40, 40)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(93, Short.MAX_VALUE))
            );

            pack();
        }                      

        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
            this.dispose();
        }
        
        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
            this.dispose();
        } 
        
                           
        private javax.swing.JButton jButton1;
        private javax.swing.JButton jButton2;
        private javax.swing.JLabel jLabel1;
                           
    }


    
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HearMeToo");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setToolTipText("");
        jPanel1.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon("HearMeToo-Logo.PNG"));
        jLabel1.setText("Logo");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 10, 450, 270);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); 
        jLabel2.setText("Letra interpretada:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 280, 200, 50);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 80));
        jLabel3.setText("Selecionada");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(210, 340, 70, 100);

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 45));
        jButton4.setText("Opción 1");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(171, 440, 70, 50);

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 45));
        jButton5.setText("Opción 2");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(251, 440, 70, 50);

        jButton1.setText("SALIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(180, 540, 130, 60);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
        );

        pack();
    }                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        System.exit(0);
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        jLabel3.setText(jButton4.getText());
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        jLabel3.setText(jButton5.getText());
    }
                   
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JDialog dialogo;
    
                 
}






