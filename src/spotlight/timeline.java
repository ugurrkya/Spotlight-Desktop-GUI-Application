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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ugur
 */

public class timeline extends javax.swing.JFrame {

    /**
     * Creates new form timeline
     */
    private platformlogin giris;
    public timeline(platformlogin gir) {
        this.giris=gir;
        initComponents();
    }
     public timeline(String idal) {
             initComponents();
     gettingid.setText(idal); 
     populateFollowerPosts();
     postername.setVisible(false);
      Connection cnn;								
  Statement stt;									
  ResultSet rst;									

try
                        {
                            
                        myfoto.setText(idal);		
                            cnn= DriverManager.getConnection("jdbc:mysql://localhost:3306/spotlight?useUnicode=true&characterEncoding=UTF-8", "ugur", "1905");
                            stt = cnn.createStatement();
            rst = stt.executeQuery("SELECT `userphoto`,`userid`,`nickname`,`age`,`email`,`sex` FROM `users` WHERE `userid` = '"+idal+"'");			//retrieve all data from the database on the coming data
              
           
            while(rst.next()){
                
                byte[] imagee = rst.getBytes(1);			
				
				
            ImageIcon imageicon = new ImageIcon(new ImageIcon(imagee).getImage().getScaledInstance(myfoto.getWidth(), myfoto.getHeight(), Image.SCALE_DEFAULT));
            myfoto.setIcon(imageicon);			
            		
            mynick.setText(rst.getString(3));		
            mymail.setText(rst.getString(5));
            mysex.setText(rst.getString(6));
            
            myage.setText(rst.getString(4));
            gettingid.setText(rst.getString(2));
           
           
            }
           
           
            
             }
                          catch (SQLException ex) {
            Logger.getLogger(timeline.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     
     public ArrayList<ForCategories> DrawingsTable(){
   ArrayList<ForCategories> mylist = new ArrayList<ForCategories>();
   Connection con=getConnection();
   Statement st;
   ResultSet rs;
   String cat=drawings.getLabel();
   
   
   try {
       
   st = con.createStatement();
   rs = st.executeQuery("SELECT `postpic`, `postid`, `userid`, `posttag`, `category`  FROM `posts` WHERE `category`= '"+cat+"'");
   
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
   public ArrayList<ForCategories> AnimalsTable(){
   ArrayList<ForCategories> mylist = new ArrayList<ForCategories>();
   Connection con=getConnection();
   Statement st;
   ResultSet rs;
   String cat=animals.getLabel();
   
   
   try {
       
   st = con.createStatement();
   rs = st.executeQuery("SELECT `postpic`, `postid`, `userid`, `posttag`, `category`  FROM `posts` WHERE `category`= '"+cat+"'");
   
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
   public ArrayList<ForCategories> NatureTable(){
   ArrayList<ForCategories> mylist = new ArrayList<ForCategories>();
   Connection con=getConnection();
   Statement st;
   ResultSet rs;
   String cat=nature.getLabel();
   
   
   try {
       
   st = con.createStatement();
   rs = st.executeQuery("SELECT `postpic`, `postid`, `userid`, `posttag`, `category`  FROM `posts` WHERE `category`= '"+cat+"'");
   
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
    public ArrayList<ForCategories> StructuresTable(){
   ArrayList<ForCategories> mylist = new ArrayList<ForCategories>();
   Connection con=getConnection();
   Statement st;
   ResultSet rs;
   String cat=structures.getLabel();
   
   
   try {
       
   st = con.createStatement();
   rs = st.executeQuery("SELECT `postpic`, `postid`, `userid`, `posttag`, `category`  FROM `posts` WHERE `category`= '"+cat+"'");
   
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
  public void populateDrawings(){
          try{
        ArrayList<ForCategories> listem = DrawingsTable();
        String[] columnName = {"postid","postpic","userid","posttag"};
        
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
            rows[i][2] = listem.get(i).getUserID();
            rows[i][3] = listem.get(i).getPostTag();
            
            
        }
        
        PostModel model = new PostModel(rows, columnName);
        
        categoriestable.setModel(model);
        categoriestable.setRowHeight(120);
        categoriestable.getColumnModel().getColumn(1).setPreferredWidth(150);
    }catch(ArrayIndexOutOfBoundsException ex) {
       
        
            }
      }
  public void populateAnimals(){
          try{
        ArrayList<ForCategories> listem = AnimalsTable();
        String[] columnName = {"postid","postpic","userid","posttag"};
        
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
            rows[i][2] = listem.get(i).getUserID();
            rows[i][3] = listem.get(i).getPostTag();
            
            
        }
        
        PostModel model = new PostModel(rows, columnName);
        
        categoriestable.setModel(model);
        categoriestable.setRowHeight(120);
        categoriestable.getColumnModel().getColumn(1).setPreferredWidth(150);
    }catch(ArrayIndexOutOfBoundsException ex) {
       
        
            }
      }
  public void populateStructures(){
          try{
        ArrayList<ForCategories> listem = StructuresTable();
        String[] columnName = {"postid","postpic","userid","posttag"};
        
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
            rows[i][2] = listem.get(i).getUserID();
            rows[i][3] = listem.get(i).getPostTag();
            
            
        }
        
        PostModel model = new PostModel(rows, columnName);
        
        categoriestable.setModel(model);
        categoriestable.setRowHeight(120);
        categoriestable.getColumnModel().getColumn(1).setPreferredWidth(150);
    }catch(ArrayIndexOutOfBoundsException ex) {
       
        
            }
      }
  public void populateNature(){
          try{
        ArrayList<ForCategories> listem = NatureTable();
        String[] columnName = {"postid","postpic","userid","posttag"};
        
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
            rows[i][2] = listem.get(i).getUserID();
            rows[i][3] = listem.get(i).getPostTag();
            
            
        }
        
        PostModel model = new PostModel(rows, columnName);
        
        categoriestable.setModel(model);
        categoriestable.setRowHeight(120);
        categoriestable.getColumnModel().getColumn(1).setPreferredWidth(150);
    }catch(ArrayIndexOutOfBoundsException ex) {
       
        
            }
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
   public void populateUserTable(){
        ArrayList<ForUsers> list = UsersTable();
        String[] columnName = {"userphoto","userid","nickname","sex","age","email"};
        
        Object[][] rows = new Object[list.size()][6];
        for(int i = 0; i < list.size(); i++){
    if(list.get(i).getMyImage() != null){
                
             ImageIcon image = new ImageIcon(new ImageIcon(list.get(i).getMyImage()).getImage()
             .getScaledInstance(150, 120, Image.SCALE_SMOOTH) );   
                
            rows[i][0] = image;
            }
            else{ 
                rows[i][0] = null;
            }
            
            rows[i][1] = list.get(i).getID();
            //rows[i][2] = list.get(i).getPass();
            rows[i][2] = list.get(i).getNick();
            
             rows[i][3] = list.get(i).getSexx();
            rows[i][4] = list.get(i).getAged();
           
            rows[i][5] = list.get(i).getEmail();
            
        }
        
        PostModel model = new PostModel(rows, columnName);
        usertable.setModel(model);
        usertable.setRowHeight(120);
        usertable.getColumnModel().getColumn(0).setPreferredWidth(150);
    } 
   public ArrayList<ForUsers> UsersTable(){
        
   ArrayList<ForUsers> mylist = new ArrayList<ForUsers>();
   Connection con = getConnection();
   Statement st;
   ResultSet rs;
   String seeusers= profilesearch.getText();
   try {
   st = con.createStatement();
   rs = st.executeQuery("SELECT `userphoto`, `userid`, `userpass`, `nickname`, `sex`, `age`,`email` FROM `users` WHERE `userid`= '"+seeusers+"'");
   
   ForUsers fu;
   while(rs.next()){
   fu = new ForUsers(
   rs.getBytes("userphoto"),
   rs.getString("userid"),
   rs.getString("userpass"),
   rs.getString("nickname"),
   rs.getString("sex"),
   rs.getInt("age"),
   rs.getString("email")
   );
   mylist.add(fu);
   }
   
   } catch (SQLException ex) {
   Logger.getLogger(timeline.class.getName()).log(Level.SEVERE, null, ex);
   }
   return mylist;
   }
   
   
   public void searchusers(){
         String seeusers= profilesearch.getText();
        
        try {
            
              
        Connection conct = DriverManager.getConnection("jdbc:mysql://localhost:3306/spotlight?useUnicode=true&characterEncoding=UTF-8", "ugur", "1905");
        Statement st = (Statement) conct.createStatement();
			
	  try(ResultSet rs = st.executeQuery("SELECT `userid`,`nickname`,`age`,`email`,`sex` FROM `users` WHERE `userid`= '"+seeusers+"' ") ) { 
            int counter = rs.getMetaData().getColumnCount(); 	
            DefaultTableModel tm = new DefaultTableModel();		
            for(int i = 1;i<=counter;i++)
               
                tm.addColumn(rs.getMetaData().getColumnName(i));		
            while(rs.next())				
                {
					Object[] row = new Object[counter];			
                    for(int i=1;i<=counter;i++)					
                        row[i-1] = rs.getObject(i);			
         
                    tm.addRow(row);
                }
            usertable.setModel(tm);
            
            
          
        }
        conct.close();								
    } catch (SQLException ex) {
            Logger.getLogger(timeline.class.getName()).log(Level.SEVERE, null, ex);
    }
     }
   public ArrayList<ForCategories> tagsearchTable(){
   ArrayList<ForCategories> mylistm = new ArrayList<ForCategories>();
   Connection con=getConnection();
   Statement st;
   ResultSet rs;
   String cat=tagsearch.getText();
   
   
   try {
       
   st = con.createStatement();
   rs = st.executeQuery("SELECT `postpic`,`postid`, `userid`, `posttag`, `category`  FROM `posts` WHERE `posttag`= '"+cat+"'");
   
   ForCategories cdd;
   while(rs.next()){
   cdd = new ForCategories(
   rs.getBytes("postpic"),
   rs.getInt("postid"),
   rs.getString("userid"),
   rs.getString("posttag"),
   rs.getString("category")
  
   );
   mylistm.add(cdd);
   
   }
   
   } catch (SQLException ex) {
   Logger.getLogger(timeline.class.getName()).log(Level.SEVERE, null, ex);
   }
   return mylistm;
   }
   public void populatetag(){
          try{
        ArrayList<ForCategories> mylistm = tagsearchTable();
        String[] columnName = {"postid","postpic","userid","category"};
        
        Object[][] rows = new Object[mylistm.size()][4];
        for(int i = 0; i < mylistm.size(); i++){
    
            
            
            rows[i][0] = mylistm.get(i).getpostID();
            if(mylistm.get(i).getMyImage() != null){
                
             ImageIcon image = new ImageIcon(new ImageIcon(mylistm.get(i).getMyImage()).getImage()
             .getScaledInstance(150, 120, Image.SCALE_SMOOTH) );   
                
            rows[i][1] = image;
            }
            else{ 
                rows[i][1] = null;
            }
            rows[i][2] = mylistm.get(i).getUserID();
            rows[i][3] = mylistm.get(i).getCategory();
            
            
        }
        
        PostModel model = new PostModel(rows, columnName);
        
        categoriestable.setModel(model);
        categoriestable.setRowHeight(120);
        categoriestable.getColumnModel().getColumn(1).setPreferredWidth(150);
    }catch(ArrayIndexOutOfBoundsException ex) {
       
        
            }
      }
   
   
  public ArrayList<ForCategories> FollowerPostsTable(){
   ArrayList<ForCategories> mylist = new ArrayList<ForCategories>();
   Connection con=getConnection();
   Statement st;
   ResultSet rs;
   String pname=postername.getText();
   String uname=gettingid.getText();
   
   try {
       
   st = con.createStatement();
   rs = st.executeQuery("SELECT `postpic`, `postid`, `F`.`userid`, `posttag`, `category`  FROM `posts` P,`followers` F  WHERE '"+uname+"'= `F`.`follower` AND `P`.`userid`= `F`.`userid`");
   
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
  public void populateFollowerPosts(){
          try{
        ArrayList<ForCategories> listem = FollowerPostsTable();
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
   

   
    private timeline() {
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

        gettingid = new javax.swing.JLabel();
        drawings = new javax.swing.JButton();
        postname = new javax.swing.JLabel();
        postpicture = new javax.swing.JLabel();
        animals = new javax.swing.JButton();
        nature = new javax.swing.JButton();
        structures = new javax.swing.JButton();
        categoriespane = new javax.swing.JScrollPane();
        categoriestable = new javax.swing.JTable();
        myfoto = new javax.swing.JLabel();
        myage = new javax.swing.JLabel();
        mynick = new javax.swing.JLabel();
        mymail = new javax.swing.JLabel();
        mysex = new javax.swing.JLabel();
        profilesearch = new javax.swing.JTextField();
        usersearch = new javax.swing.JButton();
        userpane = new javax.swing.JScrollPane();
        usertable = new javax.swing.JTable();
        tagsearch = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        likebutton = new javax.swing.JButton();
        postername = new javax.swing.JLabel();
        showlikes = new javax.swing.JButton();
        othernick = new javax.swing.JLabel();
        followbutton = new javax.swing.JButton();
        followingposts = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        back = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        List = new javax.swing.JMenu();
        myposts = new javax.swing.JMenuItem();
        updateprofile = new javax.swing.JMenuItem();
        posts = new javax.swing.JMenu();
        addpost = new javax.swing.JMenuItem();
        updatepost = new javax.swing.JMenuItem();
        deletepost = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        platformnews = new javax.swing.JMenuItem();
        toplist = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1366, 768));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        getContentPane().setLayout(null);

        gettingid.setForeground(new java.awt.Color(0, 102, 102));
        getContentPane().add(gettingid);
        gettingid.setBounds(160, 10, 137, 20);

        drawings.setBackground(new java.awt.Color(0, 102, 102));
        drawings.setForeground(new java.awt.Color(255, 255, 255));
        drawings.setText("Drawings");
        drawings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drawingsActionPerformed(evt);
            }
        });
        getContentPane().add(drawings);
        drawings.setBounds(430, 180, 83, 23);
        getContentPane().add(postname);
        postname.setBounds(980, 40, 177, 29);
        getContentPane().add(postpicture);
        postpicture.setBounds(581, 660, 215, 168);

        animals.setBackground(new java.awt.Color(0, 102, 102));
        animals.setForeground(new java.awt.Color(255, 255, 255));
        animals.setText("Animals");
        animals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                animalsActionPerformed(evt);
            }
        });
        getContentPane().add(animals);
        animals.setBounds(430, 230, 83, 23);

        nature.setBackground(new java.awt.Color(0, 102, 102));
        nature.setForeground(new java.awt.Color(255, 255, 255));
        nature.setText("Nature");
        nature.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                natureActionPerformed(evt);
            }
        });
        getContentPane().add(nature);
        nature.setBounds(430, 270, 83, 23);

        structures.setBackground(new java.awt.Color(0, 102, 102));
        structures.setForeground(new java.awt.Color(255, 255, 255));
        structures.setText("Structures");
        structures.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                structuresActionPerformed(evt);
            }
        });
        getContentPane().add(structures);
        structures.setBounds(430, 320, 90, 23);

        categoriespane.setOpaque(false);

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
        categoriespane.setBounds(10, 165, 400, 402);
        getContentPane().add(myfoto);
        myfoto.setBounds(10, 10, 134, 106);

        myage.setForeground(new java.awt.Color(0, 102, 102));
        getContentPane().add(myage);
        myage.setBounds(160, 50, 110, 20);

        mynick.setForeground(new java.awt.Color(0, 102, 102));
        getContentPane().add(mynick);
        mynick.setBounds(160, 30, 130, 20);

        mymail.setForeground(new java.awt.Color(0, 102, 102));
        getContentPane().add(mymail);
        mymail.setBounds(160, 90, 140, 20);

        mysex.setForeground(new java.awt.Color(0, 102, 102));
        getContentPane().add(mysex);
        mysex.setBounds(160, 70, 110, 20);

        profilesearch.setText("Find Profile");
        getContentPane().add(profilesearch);
        profilesearch.setBounds(1080, 170, 130, 25);

        usersearch.setBackground(new java.awt.Color(0, 102, 102));
        usersearch.setForeground(new java.awt.Color(255, 255, 255));
        usersearch.setText("Search Profile");
        usersearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usersearchActionPerformed(evt);
            }
        });
        getContentPane().add(usersearch);
        usersearch.setBounds(930, 170, 130, 23);

        userpane.setOpaque(false);

        usertable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
            }
        ));
        usertable.setMaximumSize(new java.awt.Dimension(4124, 2313));
        usertable.setMinimumSize(new java.awt.Dimension(500, 500));
        usertable.setPreferredSize(new java.awt.Dimension(500, 500));
        usertable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usertableMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                usertableMousePressed(evt);
            }
        });
        userpane.setViewportView(usertable);

        getContentPane().add(userpane);
        userpane.setBounds(540, 168, 380, 402);

        tagsearch.setText("Find Tag");
        getContentPane().add(tagsearch);
        tagsearch.setBounds(1080, 210, 130, 25);

        search.setBackground(new java.awt.Color(0, 102, 102));
        search.setForeground(new java.awt.Color(255, 255, 255));
        search.setText("Search Tag");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        getContentPane().add(search);
        search.setBounds(930, 210, 130, 23);

        likebutton.setBackground(new java.awt.Color(0, 102, 102));
        likebutton.setForeground(new java.awt.Color(255, 255, 255));
        likebutton.setText("Like it");
        likebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                likebuttonActionPerformed(evt);
            }
        });
        getContentPane().add(likebutton);
        likebutton.setBounds(10, 585, 80, 23);
        getContentPane().add(postername);
        postername.setBounds(20, 749, 71, 30);

        showlikes.setBackground(new java.awt.Color(0, 102, 102));
        showlikes.setForeground(new java.awt.Color(255, 255, 255));
        showlikes.setText("Show Likes");
        showlikes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showlikesActionPerformed(evt);
            }
        });
        getContentPane().add(showlikes);
        showlikes.setBounds(310, 130, 100, 23);
        getContentPane().add(othernick);
        othernick.setBounds(1494, 55, 0, 0);

        followbutton.setBackground(new java.awt.Color(0, 102, 102));
        followbutton.setForeground(new java.awt.Color(255, 255, 255));
        followbutton.setText("Follow");
        followbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                followbuttonActionPerformed(evt);
            }
        });
        getContentPane().add(followbutton);
        followbutton.setBounds(820, 580, 100, 23);

        followingposts.setBackground(new java.awt.Color(0, 102, 102));
        followingposts.setForeground(new java.awt.Color(255, 255, 255));
        followingposts.setText("Your Following Posts");
        followingposts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                followingpostsActionPerformed(evt);
            }
        });
        getContentPane().add(followingposts);
        followingposts.setBounds(10, 136, 151, 23);

        logout.setBackground(new java.awt.Color(0, 153, 255));
        logout.setForeground(new java.awt.Color(255, 255, 255));
        logout.setText("LOGOUT");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        getContentPane().add(logout);
        logout.setBounds(1200, 10, 120, 30);

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spotlight/15.jpg"))); // NOI18N
        getContentPane().add(back);
        back.setBounds(0, 0, 1240, 768);

        jMenuBar1.setAlignmentX(0.55F);
        jMenuBar1.setAlignmentY(0.5F);
        jMenuBar1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        List.setText("Profile");
        List.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListActionPerformed(evt);
            }
        });

        myposts.setText("My Posts");
        myposts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mypostsMousePressed(evt);
            }
        });
        List.add(myposts);

        updateprofile.setText("Update Profile");
        updateprofile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                updateprofileMousePressed(evt);
            }
        });
        List.add(updateprofile);

        jMenuBar1.add(List);

        posts.setText("Posts");
        posts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                postsMouseClicked(evt);
            }
        });

        addpost.setText("Add Post");
        addpost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addpostMousePressed(evt);
            }
        });
        posts.add(addpost);

        updatepost.setText("Update Post");
        updatepost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                updatepostMousePressed(evt);
            }
        });
        posts.add(updatepost);

        deletepost.setText("Delete Post");
        deletepost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                deletepostMousePressed(evt);
            }
        });
        deletepost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletepostActionPerformed(evt);
            }
        });
        posts.add(deletepost);

        jMenuBar1.add(posts);

        jMenu1.setText("News/Lists");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu1MousePressed(evt);
            }
        });

        platformnews.setText("News");
        platformnews.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                platformnewsMousePressed(evt);
            }
        });
        jMenu1.add(platformnews);

        toplist.setText("TopList");
        toplist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toplistActionPerformed(evt);
            }
        });
        jMenu1.add(toplist);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void drawingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drawingsActionPerformed
    populateDrawings();
    }//GEN-LAST:event_drawingsActionPerformed

    private void animalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_animalsActionPerformed
      populateAnimals();
    }//GEN-LAST:event_animalsActionPerformed

    private void structuresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_structuresActionPerformed
    populateStructures();
    }//GEN-LAST:event_structuresActionPerformed

    private void natureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_natureActionPerformed
    populateNature();
    }//GEN-LAST:event_natureActionPerformed

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
        
         String poster= source.getModel().getValueAt(row,2)+"";
        postername.setText(poster);
        postername.setVisible(false);
    }//GEN-LAST:event_categoriestableMousePressed

    private void ListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ListActionPerformed

    private void postsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_postsMouseClicked

    }//GEN-LAST:event_postsMouseClicked

    private void addpostMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addpostMousePressed
      String n=gettingid.getText();
        
        new postadding(this).setVisible(false);
        new postadding(n).setVisible(true);
    }//GEN-LAST:event_addpostMousePressed

    private void deletepostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletepostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deletepostActionPerformed

    private void updateprofileMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateprofileMousePressed
      String n=gettingid.getText();
        
        new updateprofile(this).setVisible(false);
        new updateprofile(n).setVisible(true);
    }//GEN-LAST:event_updateprofileMousePressed

    private void deletepostMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletepostMousePressed
       String n=gettingid.getText();
        
        new deletepost(this).setVisible(false);
        new deletepost(n).setVisible(true);
    }//GEN-LAST:event_deletepostMousePressed

    private void updatepostMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatepostMousePressed
        String n=gettingid.getText();
        
        new updateposts(this).setVisible(false);
        new updateposts(n).setVisible(true);
    }//GEN-LAST:event_updatepostMousePressed

    private void usersearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usersearchActionPerformed

        String finduser=profilesearch.getText();
        profilesearch.setText(finduser);
        populateUserTable();
       
       
      
    }//GEN-LAST:event_usersearchActionPerformed

    private void usertableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usertableMouseClicked
     JTable source= (JTable)evt.getSource();
        int row= source.rowAtPoint(evt.getPoint());
        int column= source.columnAtPoint(evt.getPoint());

        String nicknamee= source.getModel().getValueAt(row,1)+"";
        othernick.setText(nicknamee);
        String nickname= othernick.getText();
        String idmy=gettingid.getText();
        
        new viewothers(nickname,idmy).setVisible(true);
        new viewothers(this).setVisible(false);
    }//GEN-LAST:event_usertableMouseClicked

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        String ara=tagsearch.getText();
        tagsearch.setText(ara);
        populatetag();
        

    }//GEN-LAST:event_searchActionPerformed

    private void mypostsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mypostsMousePressed
      String n=gettingid.getText();
        
        new myposts(this).setVisible(false);
        new myposts(n).setVisible(true);
    }//GEN-LAST:event_mypostsMousePressed

    private void likebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_likebuttonActionPerformed
        Connection conn;			
        PreparedStatement sorgu;
        
  
try
                        {
                            
              String getid= gettingid.getText();
       
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

    private void followbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_followbuttonActionPerformed
         Connection conn;			
        PreparedStatement sorgu;
        
  
try
                        {
                            
              String getid= gettingid.getText();
       
              String posternamee=postername.getText();
              
        String follower=getid.concat(posternamee);
        
        
         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spotlight?useUnicode=true&characterEncoding=UTF-8", "ugur", "1905");
     
        String insert="INSERT INTO `followers` (`follower`, `userid`,`transaction`) VALUES(?,?,?)";
         sorgu = conn.prepareStatement(insert);
         
               sorgu.setString(1,getid);
                sorgu.setString(2, posternamee);
              sorgu.setString(3,follower);
         
       
           sorgu.executeUpdate();				
         
JOptionPane.showMessageDialog(null, "You followed.");
populateFollowerPosts();
        } catch (SQLException e) {
    if (e instanceof SQLIntegrityConstraintViolationException) {
        JOptionPane.showMessageDialog(null, "You already followed");
    }
    else  {
        JOptionPane.showMessageDialog(null, "Please, fill in the required information areas");
    }
    
        }
        
    }//GEN-LAST:event_followbuttonActionPerformed

    private void usertableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usertableMousePressed
        JTable source= (JTable)evt.getSource();
        int row= source.rowAtPoint(evt.getPoint());
        int column= source.columnAtPoint(evt.getPoint());

                
        String poster= source.getModel().getValueAt(row,1)+"";
        postername.setText(poster);
        postername.setVisible(false);
    }//GEN-LAST:event_usertableMousePressed

    private void platformnewsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_platformnewsMousePressed
   
        
        new viewplnews(this).setVisible(true);
               
    }//GEN-LAST:event_platformnewsMousePressed

    private void toplistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toplistActionPerformed
        new toplist(this).setVisible(true);
    }//GEN-LAST:event_toplistActionPerformed

    private void jMenu1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MousePressed
       
    }//GEN-LAST:event_jMenu1MousePressed

    private void followingpostsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_followingpostsActionPerformed
populateFollowerPosts();
    }//GEN-LAST:event_followingpostsActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
back.setSize(this.getSize());        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentResized

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        dispose();
        new platformlogin().setVisible(true);
    }//GEN-LAST:event_logoutActionPerformed

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
            java.util.logging.Logger.getLogger(timeline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(timeline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(timeline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(timeline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new timeline().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu List;
    private javax.swing.JMenuItem addpost;
    private javax.swing.JButton animals;
    private javax.swing.JLabel back;
    private javax.swing.JScrollPane categoriespane;
    private javax.swing.JTable categoriestable;
    private javax.swing.JMenuItem deletepost;
    private javax.swing.JButton drawings;
    private javax.swing.JButton followbutton;
    private javax.swing.JButton followingposts;
    private javax.swing.JLabel gettingid;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton likebutton;
    private javax.swing.JButton logout;
    private javax.swing.JLabel myage;
    private javax.swing.JLabel myfoto;
    private javax.swing.JLabel mymail;
    private javax.swing.JLabel mynick;
    private javax.swing.JMenuItem myposts;
    private javax.swing.JLabel mysex;
    private javax.swing.JButton nature;
    private javax.swing.JLabel othernick;
    private javax.swing.JMenuItem platformnews;
    private javax.swing.JLabel postername;
    private javax.swing.JLabel postname;
    private javax.swing.JLabel postpicture;
    private javax.swing.JMenu posts;
    private javax.swing.JTextField profilesearch;
    private javax.swing.JButton search;
    private javax.swing.JButton showlikes;
    private javax.swing.JButton structures;
    private javax.swing.JTextField tagsearch;
    private javax.swing.JMenuItem toplist;
    private javax.swing.JMenuItem updatepost;
    private javax.swing.JMenuItem updateprofile;
    private javax.swing.JScrollPane userpane;
    private javax.swing.JButton usersearch;
    private javax.swing.JTable usertable;
    // End of variables declaration//GEN-END:variables
}
