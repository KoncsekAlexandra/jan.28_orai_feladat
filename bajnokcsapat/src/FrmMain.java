import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FrmMain extends javax.swing.JFrame {

    public ArrayList<bajnokok> bajnoklista = new ArrayList<>();
    public ArrayList<String> bajnokokcs = new ArrayList<>();
    public ArrayList<Integer> bajnokdb = new ArrayList<>();
    
    
    public FrmMain() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_bajnokok = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TA_lista = new javax.swing.JTextArea();
        btn_feltolt = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TA_bajnokok = new javax.swing.JTextArea();
        btn_adatbazis = new javax.swing.JButton();
        btn_mutat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_bajnokok.setText("Bajnokok");
        btn_bajnokok.setActionCommand("Bajnokok");
        btn_bajnokok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bajnokokActionPerformed(evt);
            }
        });

        TA_lista.setColumns(20);
        TA_lista.setRows(5);
        jScrollPane1.setViewportView(TA_lista);

        btn_feltolt.setText("Feltöltés");
        btn_feltolt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_feltoltActionPerformed(evt);
            }
        });

        TA_bajnokok.setColumns(20);
        TA_bajnokok.setRows(5);
        jScrollPane2.setViewportView(TA_bajnokok);

        btn_adatbazis.setText("Adatbázis feltöltése");
        btn_adatbazis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adatbazisActionPerformed(evt);
            }
        });

        btn_mutat.setText("Mutat");
        btn_mutat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mutatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(244, 244, 244)
                                .addComponent(btn_feltolt, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(240, 240, 240)
                                .addComponent(btn_bajnokok, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(btn_adatbazis, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                        .addComponent(btn_mutat, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_feltolt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_bajnokok, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_adatbazis, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(btn_mutat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_feltoltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_feltoltActionPerformed
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("bcsapatok.csv"));
            String sor = br.readLine();
            
            while((sor = br.readLine()) != null) {
                String[] db = sor.split(";");
                bajnokok bajnok = new bajnokok(db[0], db[1], db[2]);
                bajnoklista.add(bajnok);
            }
        }
        catch(Exception e) {
            System.out.println("Hiba! "+e);
        }
        
        for (bajnokok o : bajnoklista) {
            TA_lista.append(o.getEv()+";"+o.getBajnok()+";"+o.getKupagy()+"\n");
        }
    }//GEN-LAST:event_btn_feltoltActionPerformed

    private void btn_bajnokokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bajnokokActionPerformed
        
        
        for (bajnokok b : bajnoklista) {
            if (!bajnokokcs.contains(b.getBajnok())) {
                bajnokokcs.add(b.getBajnok());
            }
        }
        for (int i = 0; i < bajnokokcs.size(); i++) {
            int darab = 0;
            for (int j = 0; j < bajnoklista.size(); j++) {
                if (bajnokokcs.get(i).equals(bajnoklista.get(j).getBajnok())) {
                    darab++;
                }
            }
            bajnokdb.add(darab);
        }
        for (int i = 0; i < bajnokokcs.size(); i++) {
            TA_bajnokok.append(bajnokokcs.get(i)+": "+bajnokdb.get(i)+" győzelem\n");
        }
    }//GEN-LAST:event_btn_bajnokokActionPerformed

    private void btn_mutatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mutatActionPerformed
        FrmKiiras kiiras = new FrmKiiras();
        kiiras.setVisible(true);
    }//GEN-LAST:event_btn_mutatActionPerformed

    private void btn_adatbazisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adatbazisActionPerformed
        String host="jdbc:mysql://localhost:3306/steyer";
        String username = "root";
        String password = "";
        
        for (bajnokok b : bajnoklista) {
            try
            {
                Connection conn = DriverManager.getConnection(host,username,password);
                String sql = "INSERT INTO bajnokok(evszam,bajnok) VALUES('"+b.getEv()+"','"+b.getBajnok()+"')";
                Statement sta = conn.createStatement();
                sta.executeUpdate(sql);
                sta.close();
                conn.close();
            }
            catch (SQLException hiba)
            {
                    System.out.println("Hiba  a rögzítéskor: " + hiba);
            }
        }
        
    }//GEN-LAST:event_btn_adatbazisActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea TA_bajnokok;
    private javax.swing.JTextArea TA_lista;
    private javax.swing.JButton btn_adatbazis;
    private javax.swing.JButton btn_bajnokok;
    private javax.swing.JButton btn_feltolt;
    private javax.swing.JButton btn_mutat;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
