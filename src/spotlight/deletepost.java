/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spotlight;

import java.awt.Image;
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

/**
 *
 * @author Ugur
 */
public class deletepost extends javax.swing.JFrame {

    /**
     * Creates new form deletepost
     */
    private timeline userr;
    public deletepost(timeline getuser) {
        this.userr=getuser;
        initComponents();
    }
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public deletepost(String getIduser) {
        initComponents();
        myidd.setText(getIduser);
        myidd.setVisible(false);
        populateTable();
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
   ArrayList<ForCategories> mylist = new ArrayList<ForCategories>();
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
   mylist.add(da);
   
   }
   
   } catch (SQLException ex) {
   Logger.getLogger(timeline.class.getName()).log(Level.SEVERE, null, ex);
   }
   return mylist;
   }
     public void populateTable(){
          try{
        ArrayList<ForCategories> listem = PostTable();
        String[] columnName = {"postid","postpic","userid","posttag","category"};
        
        Object[][] rows = new Object[listem.size()][5];
        for(int i = 0; i < listem.size(); i++){
    
            
            
            rows[i][0] = listem.get(i).getpostID();
            if(listem.get(i).getMyImage() != null){
                
             ImageIcon image = new ImageIcon(new ImageIcon(listem.get(i).getMyImage()).getImage()
             .getScaledInstance(150, 120, Image.SCALE_SMOOTH) );   
                
            rows[i][1] = image;
            }
            else{ 
                rows[i][1] = null;
            }
            rows[i][2] = listem.get(i).getUserID();
            rows[i][3] = listem.get(i).getPostTag();
            rows[i][4] = listem.get(i).getCategory();
           
            
        }
        
        PostModel model = new PostModel(rows, columnName);
        
        categoriestable.setModel(model);
        categoriestable.setRowHeight(120);
        categoriestable.getColumnModel().getColumn(1).setPreferredWidth(150);
    }catch(ArrayIndexOutOfBoundsException ex) {
       
        
            }
      }
    public Boolean delete(String id)
    {
        //SQL STMT
        String sql="DELETE FROM posts WHERE postid ='"+id+"'";
        
        
        try
        {
            //GET COONECTION
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/spotlight?useUnicode=true&characterEncoding=UTF-8", "ugur", "1905");
            
            //STATEMENT
            Statement s=con.prepareStatement(sql);
            
            //EXECUTE
            s.execute(sql);
            
            return true;
            
        }catch(SQLException ex)
        {
            Logger.getLogger(deletepost.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    private deletepost() {
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

        myidd = new javax.swing.JLabel();
        postname = new javax.swing.JLabel();
        deletebutton = new javax.swing.JButton();
        categoriespane = new javax.swing.JScrollPane();
        categoriestable = new javax.swing.JTable();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1366, 768));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        getContentPane().setLayout(null);
        getContentPane().add(myidd);
        myidd.setBounds(627, 11, 83, 28);
        getContentPane().add(postname);
        postname.setBounds(10, 137, 81, 28);

        deletebutton.setText("Delete the Post");
        deletebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebuttonActionPerformed(evt);
            }
        });
        getContentPane().add(deletebutton);
        deletebutton.setBounds(627, 164, 114, 38);

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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                categoriestableMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                categoriestableMousePressed(evt);
            }
        });
        categoriespane.setViewportView(categoriestable);

        getContentPane().add(categoriespane);
        categoriespane.setBounds(141, 59, 469, 402);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spotlight/1.jpg"))); // NOI18N
        getContentPane().add(background);
        background.setBounds(0, 0, 750, 520);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deletebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebuttonActionPerformed

        String[] options = {"Yes", "No"};				
        int answ = JOptionPane.showOptionDialog(null, "Sure To Delete??", "Delete Confirm", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        if (answ == 0) {
            int index = categoriestable.getSelectedRow();
            String id = categoriestable.getValueAt(index, 0).toString();					
            if (delete(id)) {
                JOptionPane.showMessageDialog(null, "THE USER IS DELETED SUCCESSFULLY.");
               populateTable();
            } else
            {
                JOptionPane.showMessageDialog(null, "THE USER IS NOT DELETED UNFORTUNATELY.");
            }
        }
    }//GEN-LAST:event_deletebuttonActionPerformed

    private void categoriestableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_categoriestableMouseClicked
        boolean b=categoriestable.isEditing();
        if(b==false){

            JOptionPane.showMessageDialog(null,"You can't edit the post.");

        }
    }//GEN-LAST:event_categoriestableMouseClicked

    private void categoriestableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_categoriestableMousePressed
        JTable source= (JTable)evt.getSource();
        int row= source.rowAtPoint(evt.getPoint());
        int column= source.columnAtPoint(evt.getPoint());

        String postismi= source.getModel().getValueAt(row,0)+"";
        postname.setText(postismi);
        postname.setVisible(true);
    }//GEN-LAST:event_categoriestableMousePressed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
background.setSize(this.getSize());      // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(deletepost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(deletepost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(deletepost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(deletepost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new deletepost().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JScrollPane categoriespane;
    private javax.swing.JTable categoriestable;
    private javax.swing.JButton deletebutton;
    private javax.swing.JLabel myidd;
    private javax.swing.JLabel postname;
    // End of variables declaration//GEN-END:variables
}
