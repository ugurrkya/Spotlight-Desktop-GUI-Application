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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Ugur
 */
public class updateposts extends javax.swing.JFrame {

    /**
     * Creates new form updateposts
     */
    String ptt;
    private timeline get;
    public updateposts(timeline gett) {
        this.get=gett;
        initComponents();
    }
    
    @SuppressWarnings("OverridableMethodCallInConstructor")
     public updateposts(String getID) {
        initComponents();
        myidd.setText(getID);
        myidd.setVisible(false);
        populateTable();
    }

    private updateposts() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Connection getConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spotlight?useUnicode=true&characterEncoding=UTF-8", "ugur","1905");
        } catch (SQLException ex) {
            Logger.getLogger(timeline.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    
    
    public ArrayList<ForCategories> PostTable(){
   ArrayList<ForCategories> listem = new ArrayList<ForCategories>();
   Connection con=getConnection();
   Statement st;
   ResultSet rs;
   String usname=myidd.getText();
   
   
   try {
       
   st = con.createStatement();
   rs = st.executeQuery("SELECT `postpic`, `postid`, `userid`, `posttag`, `category`  FROM `posts` WHERE `userid`= '"+usname+"'");
   
   ForCategories da;
   while(rs.next()){
   da = new ForCategories(
   rs.getBytes("postpic"),
   rs.getInt("postid"),
   rs.getString("userid"),
   rs.getString("posttag"),
   rs.getString("category")
  
   );
   listem.add(da);
   
   }
   
   } catch (SQLException ex) {
   Logger.getLogger(updateposts.class.getName()).log(Level.SEVERE, null, ex);
   }
   return listem;
   }
     public void populateTable(){
          try{
        ArrayList<ForCategories> listem = PostTable();
        String[] columnName = {"postpic","postid","userid","posttag","category"};
        
        Object[][] rows = new Object[listem.size()][5];
        for(int i = 0; i < listem.size(); i++){
    
            if(listem.get(i).getMyImage() != null){
                
             ImageIcon image = new ImageIcon(new ImageIcon(listem.get(i).getMyImage()).getImage()
             .getScaledInstance(150, 120, Image.SCALE_SMOOTH) );   
                
            rows[i][0] = image;
            }
            else{ 
                rows[i][0] = null;
            }
            
            rows[i][1] = listem.get(i).getpostID(); 
            rows[i][2] = listem.get(i).getUserID();
            rows[i][3] = listem.get(i).getPostTag();
            rows[i][4] = listem.get(i).getCategory();
           
            
        }
        
        PostModel model = new PostModel(rows, columnName);
        
        categoriestable.setModel(model);
        categoriestable.setRowHeight(120);
        categoriestable.getColumnModel().getColumn(0).setPreferredWidth(150);
        
    }catch(ArrayIndexOutOfBoundsException ex) {
       
        
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
        postname = new javax.swing.JLabel();
        myidd = new javax.swing.JLabel();
        tag = new javax.swing.JTextField();
        category = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        updatebutton = new javax.swing.JButton();
        categoriespane = new javax.swing.JScrollPane();
        categoriestable = new javax.swing.JTable();
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

        myidd.setForeground(new java.awt.Color(0, 102, 102));

        tag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tagActionPerformed(evt);
            }
        });

        category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "drawings", "nature", "animals", "structures" }));
        category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Tag:");

        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setText("Category:");

        updatebutton.setForeground(new java.awt.Color(0, 102, 102));
        updatebutton.setText("Update the Post");
        updatebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebuttonActionPerformed(evt);
            }
        });

        categoriestable.setAutoCreateRowSorter(true);
        categoriestable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
            }
        ));
        categoriestable.setMaximumSize(new java.awt.Dimension(2312320, 22320));
        categoriestable.setMinimumSize(new java.awt.Dimension(1366, 768));
        categoriestable.setPreferredSize(new java.awt.Dimension(5000, 2500));
        categoriestable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                categoriestableMousePressed(evt);
            }
        });
        categoriespane.setViewportView(categoriestable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(categoriespane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(postname)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(myidd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(updatebutton)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGap(27, 27, 27)
                                                .addComponent(jLabel2)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tag, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(9, 9, 9))))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 267, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(15, 15, 15)
                                    .addComponent(myidd, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(updatebutton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(postname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(categoriespane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(75, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(300, 150, 916, 267);

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spotlight/10.jpg"))); // NOI18N
        getContentPane().add(back);
        back.setBounds(0, 0, 960, 390);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tagActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tagActionPerformed

    private void categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryActionPerformed

    private void updatebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebuttonActionPerformed
   String tagging=tag.getText();
        String postidd=postname.getText();
        String mycat=(String)category.getSelectedItem();
        
       
        try {
         
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spotlight?useUnicode=true&characterEncoding=UTF-8", "ugur", "1905");
            
             String sql = "UPDATE posts SET posttag='" + tagging + "',category='" + mycat + "'  WHERE postid='" + postidd + "'";
            Statement s = con.prepareStatement(sql);
           
            s.execute(sql);
            JOptionPane.showMessageDialog(null,"Post is updated.");
            populateTable();
        } catch (SQLException ex) {
           Logger.getLogger(updateposts.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Post is not updated.");
        } 
    }//GEN-LAST:event_updatebuttonActionPerformed

    private void categoriestableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_categoriestableMousePressed
             JTable source= (JTable)evt.getSource();
        int row= source.rowAtPoint(evt.getPoint());
        int column= source.columnAtPoint(evt.getPoint());

        String postismi= source.getModel().getValueAt(row,1)+"";
        postname.setText(postismi);
        postname.setVisible(true);
    }//GEN-LAST:event_categoriestableMousePressed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
back.setSize(this.getSize());
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
            java.util.logging.Logger.getLogger(updateposts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updateposts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updateposts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updateposts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updateposts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JScrollPane categoriespane;
    private javax.swing.JTable categoriestable;
    private javax.swing.JComboBox<String> category;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel myidd;
    private javax.swing.JLabel postname;
    private javax.swing.JTextField tag;
    private javax.swing.JButton updatebutton;
    // End of variables declaration//GEN-END:variables
}
