package spotlight;

public class ForUsers {
    
    private byte[] userphoto;
    private String userid;
    private String userpass;
    private String nickname;
    private String sex;
    private int age;
    private String email;

    
    public ForUsers(){}
    
    public ForUsers(byte[] image,String usid, String pass, String nick, String sexx,int aged,String mail){
        
        this.userphoto= image;
       
        this.userid = usid;
        this.userpass= pass;
        this.nickname = nick;
        this.sex=sexx;
        
        this.age=aged;
        this.email = mail;
    }

   
    
    
    public byte[] getMyImage(){
        return userphoto;
    
    }
  public String getID(){
      return userid;
    }
    
    public void setID(String ID){
        this.userid = ID;
    }
    
    public String getPass(){
        return userpass;
    }
    public void setPass(String Pass){
        this.userpass=Pass;
    }
    public String getNick(){
        return nickname;
    }
    
    public void setNick(String Nick){
        this.nickname = Nick;
    }
    
    public int getAged(){
        return age;
    }
    
    public void setAged(int Aged){
        this.age= Aged;
    }
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String Email){
        this.email = Email;
    }
    public String getSexx(){
        return sex;
    }
    
    public void setSexx(String Sex){
        this.sex = Sex;
    }
     
    
}