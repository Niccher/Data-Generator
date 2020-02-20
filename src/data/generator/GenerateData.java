/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.generator;

import java.awt.Dimension;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author niccher
 */
public class GenerateData extends javax.swing.JFrame {
    
    int batchnumber=0;
    String path,iscategory,isformat,isoutput,isseparetor,isextension;

    /**
     * Creates new form Nuevo
     */
    public GenerateData() {
        initComponents();
        
        Dimension dim=getToolkit().getScreenSize();
        int jframWidth=this.getSize().width;
        int jframHeight=this.getSize().height;
        int locationX=(dim.width-jframWidth)/2;
        int locationY=(dim.height-jframHeight)/2;
        this.setLocation(locationX, locationY);
    }
    
    private int getRandomNumberInRange(int min, int max) {
	Random r = new Random();
        return r.ints(min, (max + 1)).limit(1).findFirst().getAsInt();
    }
    
    private float FahtoCelsius(float parsed){
        //T(°C) = (T(°F) - 32) / (1.8)
        float cel=(float) ((parsed - 32) / (1.8));
        return cel;
    }
    
    private float CelsiustoFah(float parsed){
        //F = C * 1.8 + 32  
        float fah=(float) ((parsed * 1.8) + 32);
        return fah;
    }
    
    private void InitVariables(){       
        if ( (!(Batch100.isSelected())) && (!(Batch250.isSelected())) && (!(Batch500.isSelected())) 
                && (!(Batch1000.isSelected())) && (!(Batch1250.isSelected())) && 
                (!(Batch1500.isSelected())) && (!(Batch2000.isSelected())) ) {
            System.out.println("Batch is not selected ");
        }else{
             if (Batch100.isSelected()) {
                batchnumber = 100;
                System.out.println("Batch Number -> "+batchnumber);
            }

            if (Batch250.isSelected()) {
                batchnumber = 250;
                System.out.println("Batch Number -> "+batchnumber);
            }

            if (Batch500.isSelected()) {
                batchnumber = 500;
                System.out.println("Batch Number -> "+batchnumber);
            }

            if (Batch1000.isSelected()) {
                batchnumber = 1000;
                System.out.println("Batch Number -> "+batchnumber);
            }

            if (Batch1250.isSelected()) {
                batchnumber = 1250;
                System.out.println("Batch Number -> "+batchnumber);
            }

            if (Batch1500.isSelected()) {
                batchnumber = 1500;
                System.out.println("Batch Number -> "+batchnumber);
            }

            if (Batch2000.isSelected()) {
                batchnumber = 2000;
                System.out.println("Batch Number -> "+batchnumber);
            }
        }
        
        
        if ( (!(CategoryCelsius.isSelected())) && (!(CategoryFahrenheit.isSelected())) ) {
            System.out.println("Category is not selected ");
        }else{
            if ( (CategoryCelsius.isSelected())) {
                iscategory="CategoryCelsius";
                System.out.println("Category "+iscategory);
            }
            if ( (CategoryFahrenheit.isSelected())) {
                iscategory="CategoryFahrenheit";
                System.out.println("Category "+iscategory);
            }
        }
        
        if ( (!(FormatFloat.isSelected())) && (!(FormatInteger.isSelected())) ) {
            System.out.println("Format is not selected ");
        }else{
            if ( (FormatFloat.isSelected())) {
                isformat="FormatFloat";
                System.out.println("Format "+isformat);
            }
            if ( (FormatInteger.isSelected())) {
                isformat="FormatInteger";
                System.out.println("Format "+isformat);
            }
        }
        
        if ( (!(OutPutComma.isSelected())) && (!(OutPutTab.isSelected())) ) {
            System.out.println("OutPutFormat is not selected ");
        }else{
            if ( (OutPutComma.isSelected())) {
                isoutput="OutPutComma";
                isseparetor=",";
                isextension=".csv";
                System.out.println("OutPutFormat "+isoutput);
            }
            if ( (OutPutTab.isSelected())) {
                isoutput="OutPutTab";
                isseparetor="   ";
                isextension=".tsv";
                System.out.println("OutPutFormat "+isoutput);
            }
        }
        
    }
    
    private void SaveFile(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify output Destination");   

        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            System.out.println("Save as file: " + fileToSave.getAbsolutePath());
            path=String.valueOf(fileChooser.getSelectedFile());
            SaveFilePath.setText(String.valueOf(fileChooser.getSelectedFile()));
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        OutPutComma = new javax.swing.JRadioButton();
        OutPutTab = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        CategoryCelsius = new javax.swing.JRadioButton();
        CategoryFahrenheit = new javax.swing.JRadioButton();
        SaveFilePath = new javax.swing.JTextField();
        SaveFile = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        FormatInteger = new javax.swing.JRadioButton();
        FormatFloat = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        Batch250 = new javax.swing.JRadioButton();
        Batch100 = new javax.swing.JRadioButton();
        Batch500 = new javax.swing.JRadioButton();
        Batch1000 = new javax.swing.JRadioButton();
        Batch1250 = new javax.swing.JRadioButton();
        Batch1500 = new javax.swing.JRadioButton();
        Batch2000 = new javax.swing.JRadioButton();
        StartGenerating = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        AppClose = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Output Format"));

        buttonGroup3.add(OutPutComma);
        OutPutComma.setText("Comma Separated");

        buttonGroup3.add(OutPutTab);
        OutPutTab.setText("Tab Separated");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(OutPutComma)
                    .addComponent(OutPutTab))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(OutPutTab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(OutPutComma)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Category"));

        buttonGroup1.add(CategoryCelsius);
        CategoryCelsius.setText("Celsius");

        buttonGroup1.add(CategoryFahrenheit);
        CategoryFahrenheit.setText("Fahrenheit");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CategoryCelsius)
                    .addComponent(CategoryFahrenheit))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(CategoryFahrenheit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CategoryCelsius)
                .addContainerGap())
        );

        SaveFile.setText("Browse");
        SaveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveFileActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Format"));

        buttonGroup2.add(FormatInteger);
        FormatInteger.setText("Integer only");

        buttonGroup2.add(FormatFloat);
        FormatFloat.setText("Float only");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FormatFloat)
                    .addComponent(FormatInteger))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(FormatFloat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FormatInteger)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Batch Size"));

        buttonGroup4.add(Batch250);
        Batch250.setText("250");

        buttonGroup4.add(Batch100);
        Batch100.setText("100");

        buttonGroup4.add(Batch500);
        Batch500.setText("500");

        buttonGroup4.add(Batch1000);
        Batch1000.setText("1000");

        buttonGroup4.add(Batch1250);
        Batch1250.setText("1250");

        buttonGroup4.add(Batch1500);
        Batch1500.setText("1500");

        buttonGroup4.add(Batch2000);
        Batch2000.setText("2000");

        StartGenerating.setText("Start Generating");
        StartGenerating.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartGeneratingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Batch100)
                .addGap(18, 18, 18)
                .addComponent(Batch250)
                .addGap(18, 18, 18)
                .addComponent(Batch500)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(StartGenerating)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(Batch1000)
                        .addGap(18, 18, 18)
                        .addComponent(Batch1250)
                        .addGap(18, 18, 18)
                        .addComponent(Batch1500)
                        .addGap(18, 18, 18)
                        .addComponent(Batch2000)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 8, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Batch1000)
                        .addComponent(Batch1250)
                        .addComponent(Batch1500)
                        .addComponent(Batch2000))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Batch100)
                        .addComponent(Batch250)
                        .addComponent(Batch500)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(StartGenerating)
                .addContainerGap())
        );

        jLabel2.setText("Output");

        AppClose.setText("Exit");
        AppClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AppCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SaveFilePath, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SaveFile)
                        .addGap(53, 53, 53)
                        .addComponent(AppClose))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveFilePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SaveFile)
                    .addComponent(jLabel2)
                    .addComponent(AppClose))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Linux Biolinum Keyboard O", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Temparature Generator");

        jLabel3.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Dataset generator (Celsius to Fahrenheit and vice versa) for DataScience");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void SaveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveFileActionPerformed
        // TODO add your handling code here:
        SaveFile();
    }//GEN-LAST:event_SaveFileActionPerformed


    private void StartGeneratingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartGeneratingActionPerformed
        // TODO add your handling code here:      
        InitVariables();
        if ( (batchnumber<100) || (iscategory=="")  || (isformat=="") || (isoutput=="") ) {
            JOptionPane.showMessageDialog(this,"Pick an element per category","Blank elements"
                    ,JOptionPane.ERROR_MESSAGE);
        }else{       
            if (path==null) {
                System.out.println("Path Is Empty");
                SaveFile();
            } else {
                BufferedWriter writer = null;
                try {
                    writer = new BufferedWriter(new FileWriter(path+isextension, true));
                    
                    if (iscategory=="CategoryCelsius") {
                        writer.write("Celsius"+isseparetor+"Fahrenheit\n");
                            
                        for (int i = 0; i < batchnumber; i++) {
                            int valgenerated = getRandomNumberInRange(0, 1000);
                            float pass=Float.parseFloat(String.valueOf(valgenerated));
                            float newd;

                            newd = CelsiustoFah(pass);
                            writer.append(String.valueOf(valgenerated) +isseparetor+ String.valueOf(newd) +"\n");
                        }

                    } else if (iscategory=="CategoryFahrenheit") {
                        writer.write("Fahrenheit"+isseparetor+"Celsius\n");
                            
                        for (int i = 0; i < batchnumber; i++) {
                            int valgenerated = getRandomNumberInRange(0, 1000);
                            float pass=Float.parseFloat(String.valueOf(valgenerated));
                            float newd;

                            newd = FahtoCelsius(pass);
                            writer.append(String.valueOf(valgenerated) +isseparetor+ String.valueOf(newd) +"\n");
                        } 
                    }
                    
                         
                    JOptionPane.showMessageDialog(this,"Successfully wrote Output to "+path+isextension,"Generator"
                            ,JOptionPane.ERROR_MESSAGE);
                    
                } catch (IOException ex) {
                    System.out.println("An ********** ."+ex.getMessage());
                } finally {
                    try {
                        writer.close();
                    } catch (IOException ex) {
                        Logger.getLogger(GenerateData.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_StartGeneratingActionPerformed

    private void AppCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AppCloseActionPerformed
        // TODO add your handling code here:
        System.gc();
        System.exit(0);
    }//GEN-LAST:event_AppCloseActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GenerateData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GenerateData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GenerateData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GenerateData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GenerateData().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AppClose;
    private javax.swing.JRadioButton Batch100;
    private javax.swing.JRadioButton Batch1000;
    private javax.swing.JRadioButton Batch1250;
    private javax.swing.JRadioButton Batch1500;
    private javax.swing.JRadioButton Batch2000;
    private javax.swing.JRadioButton Batch250;
    private javax.swing.JRadioButton Batch500;
    private javax.swing.JRadioButton CategoryCelsius;
    private javax.swing.JRadioButton CategoryFahrenheit;
    private javax.swing.JRadioButton FormatFloat;
    private javax.swing.JRadioButton FormatInteger;
    private javax.swing.JRadioButton OutPutComma;
    private javax.swing.JRadioButton OutPutTab;
    private javax.swing.JButton SaveFile;
    private javax.swing.JTextField SaveFilePath;
    private javax.swing.JButton StartGenerating;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables
}
