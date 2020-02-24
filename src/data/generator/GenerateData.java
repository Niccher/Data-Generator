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
    
    int batchtrainnumber=0, batchtestnumber=0;
    String path,iscategory,isformat,isoutput,isseparetor,isextension;
    String pathtest,iscategorytest,isseparetortest,isextensiontest;

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
    
    private void InitTrainingVariables(){       
        if ( (!(Batch100.isSelected())) && (!(Batch500.isSelected())) && (!(Batch1000.isSelected())) 
                && (!(Batch1500.isSelected())) && (!(Batch2000.isSelected())) && 
                (!(Batch3000.isSelected())) && (!(Batch4000.isSelected())) ) {
            System.out.println("Batch is not selected ");
        }else{
             if (Batch100.isSelected()) {
                batchtrainnumber = 100;
                System.out.println("Batch Number -> "+batchtrainnumber);
            }

            if (Batch500.isSelected()) {
                batchtrainnumber = 500;
                System.out.println("Batch Number -> "+batchtrainnumber);
            }

            if (Batch1000.isSelected()) {
                batchtrainnumber = 1000;
                System.out.println("Batch Number -> "+batchtrainnumber);
            }

            if (Batch1500.isSelected()) {
                batchtrainnumber = 1500;
                System.out.println("Batch Number -> "+batchtrainnumber);
            }

            if (Batch2000.isSelected()) {
                batchtrainnumber = 2000;
                System.out.println("Batch Number -> "+batchtrainnumber);
            }

            if (Batch3000.isSelected()) {
                batchtrainnumber = 3000;
                System.out.println("Batch Number -> "+batchtrainnumber);
            }

            if (Batch4000.isSelected()) {
                batchtrainnumber = 4000;
                System.out.println("Batch Number -> "+batchtrainnumber);
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
    
    private void InitTestVariables(){       
        if ( (!(BatchTest100.isSelected())) && (!(BatchTest500.isSelected())) && (!(BatchTest1000.isSelected())) 
                && (!(BatchTest1500.isSelected())) && (!(BatchTest2000.isSelected())) && 
                (!(BatchTest3000.isSelected())) && (!(BatchTest4000.isSelected())) ) {
            System.out.println("Batch is not selected ");
        }else{
             if (BatchTest100.isSelected()) {
                batchtestnumber = 100;
                System.out.println("Batch Number -> "+batchtestnumber);
            }

            if (BatchTest500.isSelected()) {
                batchtestnumber = 500;
                System.out.println("Batch Number -> "+batchtestnumber);
            }

            if (BatchTest1000.isSelected()) {
                batchtestnumber = 1000;
                System.out.println("Batch Number -> "+batchtestnumber);
            }

            if (BatchTest1500.isSelected()) {
                batchtestnumber = 1500;
                System.out.println("Batch Number -> "+batchtestnumber);
            }

            if (BatchTest2000.isSelected()) {
                batchtestnumber = 2000;
                System.out.println("Batch Number -> "+batchtestnumber);
            }

            if (BatchTest3000.isSelected()) {
                batchtestnumber = 3000;
                System.out.println("Batch Number -> "+batchtestnumber);
            }

            if (BatchTest4000.isSelected()) {
                batchtestnumber = 4000;
                System.out.println("Batch Number -> "+batchtestnumber);
            }
        }
        
        
        if ( (!(CategoryTestFahrenheit.isSelected())) && (!(CategoryTestCelsius.isSelected())) ) {
            System.out.println("Category is not selected ");
        }else{
            if ( (CategoryTestCelsius.isSelected())) {
                iscategorytest="CategoryCelsius";
                System.out.println("Category "+iscategorytest+" to Fahrenheit");
            }
            if ( (CategoryTestFahrenheit.isSelected())) {
                iscategorytest="CategoryFahrenheit";
                System.out.println("Category "+iscategorytest+" to Celsius");
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
    
    private void SaveTestFile(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify output Destination");   

        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            System.out.println("Save as file: " + fileToSave.getAbsolutePath());
            pathtest=String.valueOf(fileChooser.getSelectedFile());
            SaveTestFilePath.setText(String.valueOf(fileChooser.getSelectedFile()));
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
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        Tabs_Major = new javax.swing.JTabbedPane();
        Tab_Training_Data = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        Batch500 = new javax.swing.JRadioButton();
        Batch100 = new javax.swing.JRadioButton();
        Batch1000 = new javax.swing.JRadioButton();
        Batch1500 = new javax.swing.JRadioButton();
        Batch2000 = new javax.swing.JRadioButton();
        Batch3000 = new javax.swing.JRadioButton();
        Batch4000 = new javax.swing.JRadioButton();
        StartGenerating = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        CategoryCelsius = new javax.swing.JRadioButton();
        CategoryFahrenheit = new javax.swing.JRadioButton();
        SaveFile = new javax.swing.JButton();
        AppClose = new javax.swing.JButton();
        SaveFilePath = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        OutPutComma = new javax.swing.JRadioButton();
        OutPutTab = new javax.swing.JRadioButton();
        Tab_Testing_Data = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        BatchTest500 = new javax.swing.JRadioButton();
        BatchTest100 = new javax.swing.JRadioButton();
        BatchTest1000 = new javax.swing.JRadioButton();
        BatchTest1500 = new javax.swing.JRadioButton();
        BatchTest2000 = new javax.swing.JRadioButton();
        BatchTest3000 = new javax.swing.JRadioButton();
        BatchTest4000 = new javax.swing.JRadioButton();
        StartTestGenerating = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        CategoryTestCelsius = new javax.swing.JRadioButton();
        CategoryTestFahrenheit = new javax.swing.JRadioButton();
        SaveTestFile = new javax.swing.JButton();
        AppClose1 = new javax.swing.JButton();
        SaveTestFilePath = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 420));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Batch Size"));

        buttonGroup3.add(Batch500);
        Batch500.setText("500");

        buttonGroup3.add(Batch100);
        Batch100.setText("100");

        buttonGroup3.add(Batch1000);
        Batch1000.setText("1000");

        buttonGroup3.add(Batch1500);
        Batch1500.setText("1500");

        buttonGroup3.add(Batch2000);
        Batch2000.setText("2000");

        buttonGroup3.add(Batch3000);
        Batch3000.setText("3000");

        buttonGroup3.add(Batch4000);
        Batch4000.setText("4000");

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
                .addComponent(Batch500)
                .addGap(18, 18, 18)
                .addComponent(Batch1000)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(StartGenerating)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(Batch1500)
                        .addGap(18, 18, 18)
                        .addComponent(Batch2000)
                        .addGap(18, 18, 18)
                        .addComponent(Batch3000)
                        .addGap(18, 18, 18)
                        .addComponent(Batch4000)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 8, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Batch1500)
                        .addComponent(Batch2000)
                        .addComponent(Batch3000)
                        .addComponent(Batch4000))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Batch100)
                        .addComponent(Batch500)
                        .addComponent(Batch1000)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(StartGenerating)
                .addContainerGap())
        );

        jLabel2.setText("Output");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Category"));

        buttonGroup1.add(CategoryCelsius);
        CategoryCelsius.setText("Celsius to Fahrenheit");

        buttonGroup1.add(CategoryFahrenheit);
        CategoryFahrenheit.setText("Fahrenheit to Celsius");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CategoryCelsius)
                    .addComponent(CategoryFahrenheit))
                .addContainerGap(43, Short.MAX_VALUE))
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

        AppClose.setText("Exit");
        AppClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AppCloseActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Output Format"));

        buttonGroup2.add(OutPutComma);
        OutPutComma.setText("Comma Separated");

        buttonGroup2.add(OutPutTab);
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

        javax.swing.GroupLayout Tab_Training_DataLayout = new javax.swing.GroupLayout(Tab_Training_Data);
        Tab_Training_Data.setLayout(Tab_Training_DataLayout);
        Tab_Training_DataLayout.setHorizontalGroup(
            Tab_Training_DataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tab_Training_DataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Tab_Training_DataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Tab_Training_DataLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SaveFilePath, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SaveFile)
                        .addGap(53, 53, 53)
                        .addComponent(AppClose))
                    .addGroup(Tab_Training_DataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(Tab_Training_DataLayout.createSequentialGroup()
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        Tab_Training_DataLayout.setVerticalGroup(
            Tab_Training_DataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tab_Training_DataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Tab_Training_DataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(Tab_Training_DataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveFilePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SaveFile)
                    .addComponent(jLabel2)
                    .addComponent(AppClose))
                .addContainerGap())
        );

        Tabs_Major.addTab("Training Data", Tab_Training_Data);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Batch Size"));

        buttonGroup6.add(BatchTest500);
        BatchTest500.setText("500");
        BatchTest500.setToolTipText("");

        buttonGroup6.add(BatchTest100);
        BatchTest100.setText("100");
        BatchTest100.setToolTipText("");

        buttonGroup6.add(BatchTest1000);
        BatchTest1000.setText("1000");
        BatchTest1000.setToolTipText("");

        buttonGroup6.add(BatchTest1500);
        BatchTest1500.setText("1500");
        BatchTest1500.setToolTipText("");

        buttonGroup6.add(BatchTest2000);
        BatchTest2000.setText("2000");
        BatchTest2000.setToolTipText("");

        buttonGroup6.add(BatchTest3000);
        BatchTest3000.setText("3000");
        BatchTest3000.setToolTipText("");

        buttonGroup6.add(BatchTest4000);
        BatchTest4000.setText("4000");
        BatchTest4000.setToolTipText("");

        StartTestGenerating.setText("Start Generating");
        StartTestGenerating.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartTestGeneratingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BatchTest100)
                .addGap(18, 18, 18)
                .addComponent(BatchTest500)
                .addGap(18, 18, 18)
                .addComponent(BatchTest1000)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(StartTestGenerating)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(BatchTest1500)
                        .addGap(18, 18, 18)
                        .addComponent(BatchTest2000)
                        .addGap(18, 18, 18)
                        .addComponent(BatchTest3000)
                        .addGap(18, 18, 18)
                        .addComponent(BatchTest4000)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 8, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BatchTest1500)
                        .addComponent(BatchTest2000)
                        .addComponent(BatchTest3000)
                        .addComponent(BatchTest4000))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BatchTest100)
                        .addComponent(BatchTest500)
                        .addComponent(BatchTest1000)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(StartTestGenerating)
                .addContainerGap())
        );

        jLabel4.setText("Output");

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Category"));

        buttonGroup5.add(CategoryTestCelsius);
        CategoryTestCelsius.setText("Celsius to Fahrenheit");

        buttonGroup5.add(CategoryTestFahrenheit);
        CategoryTestFahrenheit.setText("Fahrenheit to Celsius");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CategoryTestCelsius)
                    .addComponent(CategoryTestFahrenheit))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(CategoryTestFahrenheit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CategoryTestCelsius)
                .addContainerGap())
        );

        SaveTestFile.setText("Browse");
        SaveTestFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveTestFileActionPerformed(evt);
            }
        });

        AppClose1.setText("Exit");
        AppClose1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AppClose1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Tab_Testing_DataLayout = new javax.swing.GroupLayout(Tab_Testing_Data);
        Tab_Testing_Data.setLayout(Tab_Testing_DataLayout);
        Tab_Testing_DataLayout.setHorizontalGroup(
            Tab_Testing_DataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tab_Testing_DataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Tab_Testing_DataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Tab_Testing_DataLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SaveTestFilePath, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SaveTestFile)
                        .addGap(53, 53, 53)
                        .addComponent(AppClose1))
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        Tab_Testing_DataLayout.setVerticalGroup(
            Tab_Testing_DataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tab_Testing_DataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(Tab_Testing_DataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveTestFilePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SaveTestFile)
                    .addComponent(jLabel4)
                    .addComponent(AppClose1))
                .addContainerGap())
        );

        Tabs_Major.addTab("Tesing Data", Tab_Testing_Data);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tabs_Major, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tabs_Major, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setPreferredSize(new java.awt.Dimension(596, 80));

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
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StartGeneratingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartGeneratingActionPerformed
        // TODO add your handling code here:
        InitTrainingVariables();
        if ( (batchtrainnumber<100) || (iscategory=="")  /*|| (isformat=="")*/ || (isoutput=="") ) {
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

                        for (int i = 0; i < batchtrainnumber; i++) {
                            int valgenerated = getRandomNumberInRange(0, 2500);
                            float pass=Float.parseFloat(String.valueOf(valgenerated));
                            float newd;

                            newd = CelsiustoFah(pass);
                            writer.append(String.valueOf(valgenerated) +isseparetor+ String.valueOf(newd) +"\n");
                        }

                    } else if (iscategory=="CategoryFahrenheit") {
                        writer.write("Fahrenheit"+isseparetor+"Celsius\n");

                        for (int i = 0; i < batchtrainnumber; i++) {
                            int valgenerated = getRandomNumberInRange(0, 2500);
                            float pass=Float.parseFloat(String.valueOf(valgenerated));
                            float newd;

                            newd = FahtoCelsius(pass);
                            writer.append(String.valueOf(valgenerated) +isseparetor+ String.valueOf(newd) +"\n");
                        }
                    }
                    
                    writer.flush();

                    JOptionPane.showMessageDialog(this,"Successfully wrote Output to "+path+isextension,"Generator"
                        ,JOptionPane.ERROR_MESSAGE);
                    
                    path=null;

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

    private void SaveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveFileActionPerformed
        // TODO add your handling code here:
        SaveFile();
    }//GEN-LAST:event_SaveFileActionPerformed

    private void AppCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AppCloseActionPerformed
        // TODO add your handling code here:
        System.gc();
        System.exit(0);
    }//GEN-LAST:event_AppCloseActionPerformed

    private void StartTestGeneratingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartTestGeneratingActionPerformed
        // TODO add your handling code here:
        InitTestVariables();
        if ( (batchtestnumber<100) || (iscategorytest=="") ) {
            JOptionPane.showMessageDialog(this,"Pick an element per category","Blank elements"
                ,JOptionPane.ERROR_MESSAGE);
        }else{
            if (pathtest==null) {
                System.out.println("Path Is Empty");
                SaveTestFile();
            } else {
                BufferedWriter writer = null;
                try {
                    writer = new BufferedWriter(new FileWriter(pathtest, true));

                    if (iscategorytest=="CategoryCelsius") {
                        writer.write("Celsius,Fahrenheit\n");

                        for (int i = 0; i < batchtestnumber; i++) {
                            int valgenerated = getRandomNumberInRange(0, 2500);
                            float pass=Float.parseFloat(String.valueOf(valgenerated));
                            float newd;

                            newd = CelsiustoFah(pass);
                            writer.append(String.valueOf(valgenerated) +"\n");
                        }
                        
                        writer.flush();

                    } else if (iscategorytest=="CategoryFahrenheit") {
                        writer.write("Fahrenheit,Celsius\n");

                        for (int i = 0; i < batchtestnumber; i++) {
                            int valgenerated = getRandomNumberInRange(0, 2500);
                            float pass=Float.parseFloat(String.valueOf(valgenerated));
                            float newd;

                            newd = FahtoCelsius(pass);
                            writer.append(String.valueOf(valgenerated) +"\n");
                        }
                        
                        writer.flush();
                    }

                    JOptionPane.showMessageDialog(this,"Successfully wrote Output to "+pathtest,"Generator"
                        ,JOptionPane.ERROR_MESSAGE);
                    
                    pathtest=null;

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
    }//GEN-LAST:event_StartTestGeneratingActionPerformed

    private void SaveTestFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveTestFileActionPerformed
        // TODO add your handling code here:
        SaveTestFile();
    }//GEN-LAST:event_SaveTestFileActionPerformed

    private void AppClose1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AppClose1ActionPerformed
        // TODO add your handling code here:
        System.gc();
        System.exit(0);
    }//GEN-LAST:event_AppClose1ActionPerformed



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
    private javax.swing.JButton AppClose1;
    private javax.swing.JRadioButton Batch100;
    private javax.swing.JRadioButton Batch1000;
    private javax.swing.JRadioButton Batch1500;
    private javax.swing.JRadioButton Batch2000;
    private javax.swing.JRadioButton Batch3000;
    private javax.swing.JRadioButton Batch4000;
    private javax.swing.JRadioButton Batch500;
    private javax.swing.JRadioButton BatchTest100;
    private javax.swing.JRadioButton BatchTest1000;
    private javax.swing.JRadioButton BatchTest1500;
    private javax.swing.JRadioButton BatchTest2000;
    private javax.swing.JRadioButton BatchTest3000;
    private javax.swing.JRadioButton BatchTest4000;
    private javax.swing.JRadioButton BatchTest500;
    private javax.swing.JRadioButton CategoryCelsius;
    private javax.swing.JRadioButton CategoryFahrenheit;
    private javax.swing.JRadioButton CategoryTestCelsius;
    private javax.swing.JRadioButton CategoryTestFahrenheit;
    private javax.swing.JRadioButton OutPutComma;
    private javax.swing.JRadioButton OutPutTab;
    private javax.swing.JButton SaveFile;
    private javax.swing.JTextField SaveFilePath;
    private javax.swing.JButton SaveTestFile;
    private javax.swing.JTextField SaveTestFilePath;
    private javax.swing.JButton StartGenerating;
    private javax.swing.JButton StartTestGenerating;
    private javax.swing.JPanel Tab_Testing_Data;
    private javax.swing.JPanel Tab_Training_Data;
    private javax.swing.JTabbedPane Tabs_Major;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration//GEN-END:variables
}
