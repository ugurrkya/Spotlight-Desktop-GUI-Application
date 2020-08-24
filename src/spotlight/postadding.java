/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spotlight;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Ugur
 */
public class postadding extends javax.swing.JFrame {

    /**
     * Creates new form postadding
     */
    String ptt;
    private timeline al;
    public postadding(timeline gec) {
        this.al=gec;
        initComponents();
    }
    
    public postadding(String getidm) {
        initComponents();
        myname.setText(getidm);
        myname.setVisible(false);
        
        
    }
    
    public ImageIcon ResizeImagee(String imgPathh){			
        ImageIcon MyImagee = new ImageIcon(imgPathh);		
        Image imgg = MyImagee.getImage();					
        Image newwImage = imgg.getScaledInstance(picture.getWidth(), picture.getHeight(),Image.SCALE_SMOOTH);		
        ImageIcon imagee = new ImageIcon(newwImage);		
        return imagee;
    }

    private postadding() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        picture = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        tagtype = new javax.swing.JTextField();
        category = new javax.swing.JComboBox<>();
        adding = new javax.swing.JButton();
        myname = new javax.swing.JLabel();
        back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1366, 768));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel1.setOpaque(false);

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setForeground(new java.awt.Color(240, 240, 240));
        jButton1.setText("Choose a photo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tagtype.setText("type a tag...");

        category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "drawings", "nature", "animals", "structures" }));

        adding.setBackground(new java.awt.Color(0, 102, 102));
        adding.setForeground(new java.awt.Color(240, 240, 240));
        adding.setText("POST!");
        adding.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(picture, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(47, 47, 47)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tagtype, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(70, 70, 70)
                            .addComponent(myname, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(210, 210, 210)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(adding, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(11, 11, 11)
                            .addComponent(picture, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(45, 45, 45)
                            .addComponent(tagtype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(myname, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(32, 32, 32)
                    .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(28, 28, 28)
                    .addComponent(adding)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(570, 150, 630, 370);

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spotlight/7.jpg"))); // NOI18N
        getContentPane().add(back);
        back.setBounds(0, 0, 990, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         JFileChooser fileChooser = new JFileChooser();          
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));   
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png","jpeg");      
        fileChooser.addChoosableFileFilter(filter);          
        int result = fileChooser.showSaveDialog(null);         
        if(result == JFileChooser.APPROVE_OPTION){            
            File selectedFile = fileChooser.getSelectedFile();       
            String pathh = selectedFile.getAbsolutePath();          	
            picture.setIcon(ResizeImagee(pathh));                     	
            ptt=pathh;
            if(pathh==null){
                JOptionPane.showMessageDialog(null, "Please choose a photo");
            }else{
                JOptionPane.showMessageDialog(null, "Photo is added");
            }
        }
        else if(result == JFileChooser.CANCEL_OPTION){					
            JOptionPane.showMessageDialog(null, "No data");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void addingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addingActionPerformed
   Connection conn;			
        PreparedStatement sorgu;
  
try
                        {
                            
              String usname= myname.getText(); 
        String tagging= tagtype.getText();
        String ctg = (String)category.getSelectedItem();
    
        
         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spotlight?useUnicode=true&characterEncoding=UTF-8", "ugur", "1905");
     
        String insert="INSERT INTO `posts` (`postpic`,`userid`, `posttag`, `category`) VALUES(?,?,?,?)";
         sorgu = conn.prepareStatement(insert);
         
              InputStream is = new FileInputStream(new File(ptt));
           
         sorgu.setBlob(1, is);
       
         
     
         sorgu.setString(2,usname);
       sorgu.setString(3, tagging);
       sorgu.setString(4, ctg);
      
           sorgu.executeUpdate();				
         
         
        
         
JOptionPane.showMessageDialog(null, "The post is added");

    tagtype.setText("");
    category.setSelectedIndex(0);
   
    picture.setText("");
    
        } catch (SQLException e) {
    if (e instanceof SQLIntegrityConstraintViolationException) {
        JOptionPane.showMessageDialog(null, "Post is there already");
    }
    else  {
        JOptionPane.showMessageDialog(null, "Please, fill in the required information areas");
    }
    
	
        }
catch (NullPointerException ed) {
              JOptionPane.showMessageDialog(null, "Please choose a photo");
          } catch (FileNotFoundException ex) {   
            Logger.getLogger(postadding.class.getName()).log(Level.SEVERE, null, ex);
        } 

    }//GEN-LAST:event_addingActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
back.setSize(this.getSize());         // TODO add your handling code here:
    }//GEN-LAST:event_formComponentResized

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
            java.util.logging.Logger.getLogger(postadding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(postadding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(postadding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(postadding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new postadding().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adding;
    private javax.swing.JLabel back;
    private javax.swing.JComboBox<String> category;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel myname;
    private javax.swing.JLabel picture;
    private javax.swing.JTextField tagtype;
    // End of variables declaration//GEN-END:variables
}