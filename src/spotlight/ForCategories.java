package spotlight;

public class ForCategories {
    
    private byte[] postpic;
    private int postid;
    private String userid;
    private String posttag;
    private String category;

    public ForCategories(){}
    
    public ForCategories(byte[] photo,int postingid, String username, String postname, String postcat){
        
        this.postpic=photo;
        this.postid = postingid;
        this.userid = username;
        this.posttag= postname;
        this.category = postcat;
            
    }
    
    public byte[] getMyImage(){
        return postpic;
    }
    public int getpostID(){
      return postid;
    }
    
    public void setpostID(int postingID){
        this.postid = postingID;
    }
    
    public String getUserID(){
        return userid;
    }
    
    public void setUserID(String usID){
        this.userid = usID;
    }
    public String getPostTag(){
        return posttag;
    }
    
    public void setPostTag(String PTag){
        this.posttag = PTag;
    }
   
    public String getCategory(){
        return category;
    }
    
    public void setCategory(String Category){
        this.category= Category;
    }
    
    
  
    
   
}