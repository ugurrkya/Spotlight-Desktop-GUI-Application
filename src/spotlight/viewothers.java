/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spotlight;

import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
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
public class viewothers extends javax.swing.JFrame {

    /**
     * Creates new form viewothers
     */
    private timeline getting;
    public viewothers(timeline getting1) {
        this.getting=getting1;
      initComponents();
     // username.setText(userr);
    }
    
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public viewothers(String gettingusername,String comingid) {		
        initComponents();
        
        username.setText(gettingusername);
        username.setVisible(false);
      otherid.setText(comingid);
      otherid.setVisible(false);
      postname.setVisible(false);
     
         Connection cnn;								
  Statement stt;									
  ResultSet rst;									

try
                        {
                            
                        foto.setText(gettingusername);		
                            cnn= DriverManager.getConnection("jdbc:mysql://localhost:3306/spotlight?useUnicode=true&characterEncoding=UTF-8", "ugur", "1905");
                            stt = cnn.createStatement();
            rst = stt.executeQuery("SELECT `userphoto`,`userid`,`nickname`,`sex`,`age`,`email` FROM `users` WHERE `userid` = '"+gettingusername+"'");			//retrieve all data from the database on the coming data
              
           
            while(rst.next()){
                
                byte[] imagee = rst.getBytes(1);			
				
			
            ImageIcon imageicon = new ImageIcon(new ImageIcon(imagee).getImage().getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_DEFAULT));
            foto.setIcon(imageicon);
            userid.setText(rst.getString(2));
            nicker.setText(rst.getString(3));
            sex.setText(rst.getString(4));
            agee.setText(rst.getString(5));
            maill.setText(rst.getString(6));
            
           
           
            }
           
           
            
             }
                          catch (SQLException ex) {
            Logger.getLogger(viewothers.class.getName()).log(Level.SEVERE, null, ex);
        }
      
  
    Followers();
      populateMyTable(); 
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
     

public void Followers(){
    Connection cnn;								
  Statement stt;									
  ResultSet rst;									

try
                        {
                           String usname=userid.getText(); 
                        
                            cnn= DriverManager.getConnection("jdbc:mysql://localhost:3306/spotlight?useUnicode=true&characterEncoding=UTF-8", "ugur", "1905");
                            stt = cnn.createStatement();
         rst = stt.executeQuery("SELECT COUNT(`transaction`) FROM `followers` WHERE `userid`= '"+usname+"'");				
              
           
            while (rst.next())
{

            String al=rst.getString(1);
            String follow=usname+" has "+al+" followers.";
            follows.setText(follow);
}  
            
        
           
           
            
             }
                          catch (SQLException ex) {
            Logger.getLogger(timeline.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
}
      public void populateMyTable(){
          try{
        ArrayList<ForCategories> listem = MyTable();
        String[] columnName = {"postid","postpic","posttag","category"};
        
        Object[][] rows = new Object[listem.size()][4];
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
          
            rows[i][2] = listem.get(i).getPostTag();
              rows[i][3] = listem.get(i).getCategory();
            
            
        }
        
        PostModel model = new PostModel(rows, columnName);
        
        categoriestable.setModel(model);
        categoriestable.setRowHeight(120);
        categoriestable.getColumnModel().getColumn(1).setPreferredWidth(150);
    }catch(ArrayIndexOutOfBoundsException ex) {
       
        
            }
      }
       public ArrayList<ForCategories> MyTable(){
   ArrayList<ForCategories> mylist = new ArrayList<ForCategories>();
   Connection con=getConnection();
   Statement st;
   ResultSet rs;
   String myid=userid.getText();
   
   
   try {
       
   st = con.createStatement();
   rs = st.executeQuery("SELECT `postpic`, `postid`, `userid`, `posttag`, `category`  FROM `posts` WHERE `userid`= '"+myid+"'");
   
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
    private viewothers() {
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
        username = new javax.swing.JLabel();
        foto = new javax.swing.JLabel();
        maill = new javax.swing.JLabel();
        agee = new javax.swing.JLabel();
        nicker = new javax.swing.JLabel();
        sex = new javax.swing.JLabel();
        userid = new javax.swing.JLabel();
        categoriespane = new javax.swing.JScrollPane();
        categoriestable = new javax.swing.JTable();
        follows = new javax.swing.JLabel();
        postname = new javax.swing.JLabel();
        likebutton = new javax.swing.JButton();
        otherid = new javax.swing.JLabel();
        followbutton = new javax.swing.JButton();
        showlikes = new javax.swing.JButton();
        back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1366, 768));
        getContentPane().setLayout(null);

        jPanel1.setOpaque(false);

        username.setForeground(new java.awt.Color(204, 255, 255));

        maill.setForeground(new java.awt.Color(204, 255, 255));

        agee.setForeground(new java.awt.Color(204, 255, 255));

        nicker.setForeground(new java.awt.Color(204, 255, 255));

        sex.setForeground(new java.awt.Color(204, 255, 255));

        userid.setForeground(new java.awt.Color(204, 255, 255));

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

        follows.setForeground(new java.awt.Color(204, 255, 255));

        likebutton.setForeground(new java.awt.Color(0, 102, 102));
        likebutton.setText("Like");
        likebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                likebuttonActionPerformed(evt);
            }
        });

        followbutton.setForeground(new java.awt.Color(0, 102, 102));
        followbutton.setText("Follow");
        followbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                followbuttonActionPerformed(evt);
            }
        });

        showlikes.setForeground(new java.awt.Color(0, 102, 102));
        showlikes.setText("Show Likes");
        showlikes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showlikesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(follows, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(823, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(940, 940, 940)
                            .addComponent(postname))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(foto, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(agee, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(userid, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(nicker, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(maill, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(sex, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(465, 465, 465)
                                    .addComponent(otherid))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(56, 56, 56)
                                    .addComponent(categoriespane, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(71, 71, 71)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(followbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(likebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(showlikes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(435, Short.MAX_VALUE)
                .addComponent(follows, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(postname)
                    .addGap(14, 14, 14)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(foto, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(6, 6, 6)
                                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(agee, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(55, 55, 55)
                                    .addComponent(followbutton)
                                    .addGap(6, 6, 6)
                                    .addComponent(likebutton)
                                    .addGap(6, 6, 6)
                                    .addComponent(showlikes)))
                            .addGap(18, 18, 18)
                            .addComponent(userid, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(nicker, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(maill, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(sex, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(otherid)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(categoriespane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(111, Short.MAX_VALUE)))))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 20, 1030, 560);

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spotlight/12.jpg"))); // NOI18N
        back.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                backComponentResized(evt);
            }
        });
        getContentPane().add(back);
        back.setBounds(0, 0, 1040, 580);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        postname.setVisible(false);
    }//GEN-LAST:event_categoriestableMousePressed

    private void likebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_likebuttonActionPerformed
         Connection conn;			
        PreparedStatement sorgu;
        
  
try
                        {
                            
              String getid= otherid.getText();
       
              String postnamee=postname.getText();
              
        String likerr=getid.concat(postnamee);
        
        
         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spotlight?useUnicode=true&characterEncoding=UTF-8", "ugur", "1905");
     
        String insert="INSERT INTO `likes` (`postid`, `userid`,`liker`) VALUES(?,?,?)";
         sorgu = conn.prepareStatement(insert);
         
               sorgu.setString(1,postnamee);
                sorgu.setString(2, getid);
              sorgu.setString(3,likerr);
         
       
           sorgu.executeUpdate();				
         
JOptionPane.showMessageDialog(null, "You liked it.");

        } catch (SQLException e) {
    if (e instanceof SQLIntegrityConstraintViolationException) {
        JOptionPane.showMessageDialog(null, "You already liked it");
    }
    else  {
        JOptionPane.showMessageDialog(null, "Please, fill in the required information areas");
    }
    
        }
    }//GEN-LAST:event_likebuttonActionPerformed

    private void followbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_followbuttonActionPerformed
        Connection conn;
        PreparedStatement sorgu;

        try
        {

            String getid= otherid.getText();

            String posternamee=userid.getText();

            String follower=getid.concat(posternamee);

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spotlight?useUnicode=true&characterEncoding=UTF-8", "ugur", "1905");

            String insert="INSERT INTO `followers` (`follower`, `userid`,`transaction`) VALUES(?,?,?)";
            sorgu = conn.prepareStatement(insert);

            sorgu.setString(1,getid);
            sorgu.setString(2, posternamee);
            sorgu.setString(3,follower);

            sorgu.executeUpdate();				

            JOptionPane.showMessageDialog(null, "You followed.");

        } catch (SQLException e) {
            if (e instanceof SQLIntegrityConstraintViolationException) {
                JOptionPane.showMessageDialog(null, "You already followed");
            }
            else  {
                JOptionPane.showMessageDialog(null, "Please, fill in the required information areas");
            }

        }

    }//GEN-LAST:event_followbuttonActionPerformed

    private void showlikesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showlikesActionPerformed
      Connection cnn;								
  Statement stt;									
  ResultSet rst;									

try
                        {
                           String postit=postname.getText(); 
                        
                            cnn= DriverManager.getConnection("jdbc:mysql://localhost:3306/spotlight?useUnicode=true&characterEncoding=UTF-8", "ugur", "1905");
                            stt = cnn.createStatement();
         rst = stt.executeQuery("SELECT COUNT(`liker`) FROM `likes` WHERE `postid`= '"+postit+"'");				
              
           
            while (rst.next())
{

            String al=rst.getString(1);
         	   JOptionPane.showMessageDialog(null,"The post "+al+" times liked.");
}  
            
        
           
           
            
             }
                          catch (SQLException ex) {
            Logger.getLogger(timeline.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_showlikesActionPerformed

    private void backComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_backComponentResized
back.setSize(this.getSize());        // TODO add your handling code here:
    }//GEN-LAST:event_backComponentResized

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
            java.util.logging.Logger.getLogger(viewothers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewothers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewothers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewothers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewothers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel agee;
    private javax.swing.JLabel back;
    private javax.swing.JScrollPane categoriespane;
    private javax.swing.JTable categoriestable;
    private javax.swing.JButton followbutton;
    private javax.swing.JLabel follows;
    private javax.swing.JLabel foto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton likebutton;
    private javax.swing.JLabel maill;
    private javax.swing.JLabel nicker;
    private javax.swing.JLabel otherid;
    private javax.swing.JLabel postname;
    private javax.swing.JLabel sex;
    private javax.swing.JButton showlikes;
    private javax.swing.JLabel userid;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
