import java.sql.*;

import javax.swing.JOptionPane;


public class DBCONNECTION {
    String host="jdbc:mysql://localhost:3306/hostelmanagment";
    String user="root";
    String pass="";
    
   String conn;
   Connection con;
    
   
   public Connection getConnect(){
      
       try{
     con=DriverManager.getConnection(host,user,pass);  
     return con; 
       }
       catch(SQLException ex){
       JOptionPane.showMessageDialog(null, "ex.getMessage()");
       return null;
        } 

    /**
     *
     * @param fname
     * @param lname
     * @param id
     * @param gender
     */
   }
    public void insertStudent(String fname,String lname,String id,String gender)
    {
           
       
       String q = "INSERT INTO hostel(firstname,lastname,id,gender) VALUES(?,?,?)";
       
       try{
          int k=0;
          PreparedStatement st=getConnect().prepareStatement(q);
          st.setString(1,fname);
          st.setString(2, lname);
          st.setString(3, id);
          st.setString(4, gender);
          
          if (st.executeUpdate()>k){
            JOptionPane.showMessageDialog(null, "record inserted");
          }
       }
       catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
       }
   
   
       }
       public ResultSet getStudents()
       {
        String q= "SELECT * FROM hostelmanagement" ;  
        try{
            Statement st=getConnect().createStatement();
            
            ResultSet rs=st.executeQuery(q);
            return rs;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        
        return null;
        }
       }
       public void updateStudents(String fname,String lname,String id,String gender){
           String q="UPDATE hostelmanagement SET firstname=?,lastname=?,id=?,gender=?";
           
           try{
               int k=0;
                PreparedStatement st=getConnect().prepareStatement(q);
                st.setString(1,fname);
                st.setString(2, lname);
                st.setString(3, id);
                st.setString(4, gender);
                
                if (st.executeUpdate()>k){
            JOptionPane.showMessageDialog(null, "record update succesfull");
          }
               
           }
           catch(SQLException ex){
              JOptionPane.showMessageDialog(null, "ex.getMessage()");
        
           }
       }
       public void deleteStudent(String id){
           
           //string query
           String q="DELETE FROM hostelmanagement WHERE id=?";
           
           //create st to execute query
           try{
               int k=0;
                PreparedStatement st=getConnect().prepareStatement(q);
               st.setString(3, id);
               
                if (st.executeUpdate()>k){
            JOptionPane.showMessageDialog(null, "record deletion succesfull");
                }
           }
           catch(SQLException ex){
             JOptionPane.showMessageDialog(null, "ex.getMessage()");   
           }
           
       }
}       
      

   
  


