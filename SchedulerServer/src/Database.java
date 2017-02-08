import java.sql.*;

public class Database {
    
    private Connection con;
    private PreparedStatement st;
    private Statement stmt;
    private ResultSet rs;
    private ResultSetMetaData rsmd;
    private boolean error;
    
    public Database(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eventmanager","root","");
            error = false;
        }
        catch(ClassNotFoundException | SQLException e){
            error = true;
            System.out.println("Database: " + e);
        }
    }

    /*function to execute queries of array of parameters*/
    synchronized public void query(String query, String param[]){
        int i, length;
        try{
            st = con.prepareStatement(query);
            length = param.length;
            for(i = 0; i < length; ++i)
                st.setString(i + 1, param[i]);
            if(st.execute())
                rs = st.getResultSet();
            rsmd = rs.getMetaData();
            error = false;
        }
        catch(SQLException e){
            error = true;
            System.out.println("Database: " + e);
        }
    }
    
    /*function to execute simple queries*/
    synchronized public void query(String query){
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            rsmd = rs.getMetaData();
            error = false;
        }
        catch(SQLException e){
            error = true; 
            System.out.println("Database: " + e);
        }
    }
    
    /*returns resultset of query*/
    synchronized public ResultSet results(){
        return rs; 
    }
    
    /*returns metadata of resultset*/
    synchronized public ResultSetMetaData resultMeta(){
        return rsmd;
    }
    
    /*returns true if error in query execution otherwise false*/
    synchronized public boolean errors(){
        return error;
    }
    
    /*function to execute delete queries*/
    public boolean delete(String table, String id){
        if(!"".equals(id)){
            String query = "DELETE FROM " + table + " WHERE id = ? ";
            String param[] = new String[1];
            param[0] = id;
            query(query, param);
            return !errors();
        }    
        return false;
    }
    
    /*function to close all database connections*/
    public void closeAll(){
        try {
            rs.close();
            st.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Database: " + e);
        }
    }
    
}
