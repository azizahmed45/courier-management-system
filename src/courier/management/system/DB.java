package courier.management.system;

import courier.management.system.models.Branch;
import courier.management.system.models.Parcel;
import courier.management.system.models.Transaction;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB {
    
    private static final String DB_NAME = "courier";
    private static final String TABLE_ADMINS = "admins";
    private static final String TABLE_BRANCHES = "branches";
    private static final String TABLE_BRANCH_MANAGERS = "branch_managers";
    private static final String TABLE_PARCELS = "parcels";
    private static final String TABLE_TRANSACTIONS = "transactions";
  
  private Connection getConnection(){
      Connection c = null;
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:" + DB_NAME + ".db");
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      }
      System.out.println("Opened database successfully");
      
      return c;
  }
  
  private void createTables(){
      Connection connection = getConnection();
        try {
            
        
        Statement statement = connection.createStatement();
        
        //foreign key enable
        String foreignKeyEnable = "PRAGMA foreign_keys = ON";
        
        statement.execute(foreignKeyEnable);
        
        String adminsTableSql = "CREATE TABLE IF NOT EXISTS " + TABLE_ADMINS + " (\n"
                + "    _id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "    username text NOT NULL,\n"
                + "    password text NOT NULL\n"
                + ");";
        
        statement.execute(adminsTableSql);
            
        String branchesTableSql = "CREATE TABLE IF NOT EXISTS " + TABLE_BRANCHES + " (\n"
                + "    _id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "    branch_name text,\n"
                + "    branch_location text\n"
                + ");";
        
        statement.execute(branchesTableSql);
        
        String branchManagerTableSql = "CREATE TABLE IF NOT EXISTS " + TABLE_BRANCH_MANAGERS + " (\n"
                + "    _id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "    username text,\n"
                + "    password text,\n"
                + "    branch_id integer NOT NULL,\n"
                + "    FOREIGN KEY (branch_id) REFERENCES branches(_id)\n"
                + ");";
        
        statement.execute(branchManagerTableSql);
        
        String parcelsTableSql = "CREATE TABLE IF NOT EXISTS " + TABLE_PARCELS + " (\n"
                + "    _id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "    name text,\n"
                + "    type text,\n"
                + "    delivered integer,\n"
                + "    description text,\n"
                + "    current_branch_id integer NOT NULL,\n"
                + "    FOREIGN KEY (current_branch_id) REFERENCES branches(_id)\n"
                + ");";
      
        statement.execute(parcelsTableSql);
        
        
        String transactionsTableSql = "CREATE TABLE IF NOT EXISTS " + TABLE_TRANSACTIONS + " (\n"
                + "    _id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "    from_branch integer,\n"
                + "    to_branch integer,\n"
                + "    type text,\n"
                + "    description text,\n"
                + "    parcel_id integer NOT NULL,\n"
                + "    FOREIGN KEY (parcel_id) REFERENCES parcels(_id)\n"
                + ");";
      
        statement.execute(transactionsTableSql);
            
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }  finally{
          try {
              connection.close();
          } catch (SQLException ex) {
              Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
  }
  
  public boolean adminLogin(String username, String password){
      Connection connection = getConnection();
        try {
            
            Statement statement = connection.createStatement();
        
            String sql = "SELECT * FROM " + TABLE_ADMINS 
                    + " WHERE username = '" + username + "' AND "
                    + " password = '" + password + "'";
            
            ResultSet resultSet = statement.executeQuery(sql);
            
           
            
            return resultSet.next();
            
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally{
          try {
              connection.close();
          } catch (SQLException ex) {
              Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
  }
  
    public boolean isParcelExist(int parcelId){
      Connection connection = getConnection();
        try {
            
            Statement statement = connection.createStatement();
        
            String sql = "SELECT * FROM " + TABLE_PARCELS 
                    + " WHERE _id = " + parcelId + ";";
            
            ResultSet resultSet = statement.executeQuery(sql);
            
           
            
            return resultSet.next();
            
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally{
          try {
              connection.close();
          } catch (SQLException ex) {
              Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
  }
  
  public boolean managerLogin(String username, String password){
      Connection connection = getConnection();
        try {
            
            Statement statement = connection.createStatement();
            
            String sql = "SELECT * FROM " + TABLE_BRANCH_MANAGERS 
                    + " WHERE username = '" + username + "' AND "
                    + " password = '" + password + "'";
            
            ResultSet resultSet = statement.executeQuery(sql);
            
         
            
            return resultSet.next();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally{
          try {
              connection.close();
          } catch (SQLException ex) {
              Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
  }
  
  public boolean createAdmin(String username, String password){
      Connection connection = getConnection();
        try {
            
            Statement statement = connection.createStatement();
            
            String sql = "INSERT INTO " + TABLE_ADMINS 
                    + "(username, password)\n"
                    + "VALUES( '" + username + "', '" + password + "' )";
            
            
            return statement.execute(sql);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }  finally{
          try {
              connection.close();
          } catch (SQLException ex) {
              Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
  }
  
  public void createBranch(String branchName, String branchLocation){
      Connection connection = getConnection();
        try {
            
            Statement statement = connection.createStatement();
            
            String sql = "INSERT INTO " + TABLE_BRANCHES 
                    + "(branch_name, branch_location)\n"
                    + "VALUES( '" + branchName + "', '" + branchLocation + "' )";
            
         
            statement.execute(sql);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
          try {
              connection.close();
          } catch (SQLException ex) {
              Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
  }
  
    public void createParcel(int branchId, String name, String type, String description){
      Connection connection = getConnection();
      int parcelId = 0;
        try {
            
            Statement statement = connection.createStatement();
            
            String sql = "INSERT INTO " + TABLE_PARCELS 
                    + "(name, type, description, current_branch_id)\n"
                    + "VALUES( '" + name + "', '" + type + "',  '" + description + "',  '" + branchId + "' )";
            
            statement.execute(sql);
            
            String sqlLastParcelId = "SELECT * FROM " + TABLE_PARCELS 
                    + " ORDER BY _id DESC LIMIT 1;";
            
            ResultSet resultSet = statement.executeQuery(sqlLastParcelId);
            
            resultSet.next();
            
            parcelId = resultSet.getInt("_id");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
          try {
              connection.close();
              makeTransaction(parcelId, "pickup", branchId, branchId, "Product picked up");
              
          } catch (SQLException ex) {
              Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
  }
  
  public boolean createManager(String username, String password, int branchId){
      Connection connection = getConnection();
        try {
            
            Statement statement = connection.createStatement();
            
            String sql = "INSERT INTO " + TABLE_BRANCH_MANAGERS 
                    + "(username, password, branch_id)\n"
                    + "VALUES( '" + username + "', '" + password + "', " + branchId + " );";
            
      
            
            return statement.execute(sql);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally{
          try {
              connection.close();
          } catch (SQLException ex) {
              Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
  }
  
    public boolean makeTransaction(int parcelId, String type, int fromBranch, int toBranch, String description){
      Connection connection = getConnection();
        try {
            
            Statement statement = connection.createStatement();
            
            String sql = "INSERT INTO " + TABLE_TRANSACTIONS 
                    + "(parcel_id, from_branch, to_branch, type, description)\n"
                    + "VALUES( " + parcelId + ", " + fromBranch + ", " + toBranch + ", '" + type + "', '" + description + "' );";
            
            String sqlUpdate = "UPDATE " + TABLE_PARCELS
                    + " SET current_branch_id = " + toBranch + " WHERE _id = " + parcelId + "; ";
            
            statement.execute(sqlUpdate);
            return statement.execute(sql);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally{
          try {
              connection.close();
          } catch (SQLException ex) {
              Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
  }
    
 public void deliverParcel(int parcelId){
      Connection connection = getConnection();
        try {
            
            Statement statement = connection.createStatement();
            
            String sql = "UPDATE " + TABLE_PARCELS 
                    + " SET delivered = 1, current_branch_id = 0 WHERE _id = " + parcelId + ";";
      
            
            statement.execute(sql);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            
        } finally{
          try {
              connection.close();
              makeTransaction(parcelId, "deliver", 0, 0, "item delivered.");
          } catch (SQLException ex) {
              Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
  }
 
     public List<Transaction> getTransactionByParcel(int parcelId){
      Connection connection = getConnection();
        try {
            
            Statement statement = connection.createStatement();
            
            String sql = "SELECT * FROM " + TABLE_TRANSACTIONS + " WHERE parcel_id = " + parcelId + " ORDER BY _id";
            
      
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            
            List<Transaction> transactions = new ArrayList<>();
            
            while(resultSet.next()){
                String type = resultSet.getString("type");
                String fromBranch = getBranchName(resultSet.getInt("from_branch"));
                String toBranch = getBranchName(resultSet.getInt("to_branch"));
                String description = resultSet.getString("description");
                transactions.add(new Transaction(parcelId, type, fromBranch, toBranch, description));
            }
            
            
            return transactions;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally{
          try {
              connection.close();
          } catch (SQLException ex) {
              Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
  }
     
  
  
    public List<Branch> getAllBranches(){
      Connection connection = getConnection();
        try {
            
            Statement statement = connection.createStatement();
            
            String sql = "SELECT * FROM " + TABLE_BRANCHES + " ORDER BY _id";
            
      
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            
            List<Branch> branches = new ArrayList<>();
            
            while(resultSet.next()){
                int id = resultSet.getInt("_id");
                String branchName = resultSet.getString("branch_name");
                String branchLocation = resultSet.getString("branch_location");
                branches.add(new Branch(id,branchName, branchLocation));
            }
            
            
            return branches;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally{
          try {
              connection.close();
          } catch (SQLException ex) {
              Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
  }
    
 public List<Parcel> getAllParcelByBranch(int branchId){
      Connection connection = getConnection();
        try {
            
            Statement statement = connection.createStatement();
            
            String sql = "SELECT * FROM " + TABLE_PARCELS + " WHERE current_branch_id = " + branchId + " ORDER BY _id";
            
      
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            
            List<Parcel> parcels = new ArrayList<>();
            
            while(resultSet.next()){
                int id = resultSet.getInt("_id");
                String parcelName = resultSet.getString("name");
                String parcelType = resultSet.getString("type");
                String parcelDescription = resultSet.getString("description");
                
                parcels.add(new Parcel(id,parcelName, parcelType, parcelDescription));
            }
            
            
            return parcels;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally{
          try {
              connection.close();
          } catch (SQLException ex) {
              Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
  }
    
    
    public int getBranchId(String username){
      Connection connection = getConnection();
        try {
            
            Statement statement = connection.createStatement();
            
            String sql = "SELECT * FROM " + TABLE_BRANCH_MANAGERS + " WHERE username = '" + username + "' ;";
            
      
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            
            resultSet.next();
            int branchId = resultSet.getInt("branch_id");
            
            
            return branchId;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } finally{
          try {
              connection.close();
          } catch (SQLException ex) {
              Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
  }
    
    
public Parcel getParcelById(int parcelId){
      Connection connection = getConnection();
        try {
            
            Statement statement = connection.createStatement();
            
            String sql = "SELECT * FROM " + TABLE_PARCELS + " WHERE _id = " + parcelId + ";";
            
      
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            
            List<Parcel> parcels = new ArrayList<>();
            
            resultSet.next();
            
            int id = resultSet.getInt("_id");
            String parcelName = resultSet.getString("name");
            String parcelType = resultSet.getString("type");
            String parcelDescription = resultSet.getString("description");
                
            return new Parcel(id,parcelName, parcelType, parcelDescription);
            
          
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally{
          try {
              connection.close();
          } catch (SQLException ex) {
              Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
  }
    

    
    
 public String getBranchName(int branchId){
      Connection connection = getConnection();
        try {
            
            Statement statement = connection.createStatement();
            
            String sql = "SELECT * FROM " + TABLE_BRANCHES + " WHERE _id = " + branchId + " ;";
            
      
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            
            resultSet.next();
            String branchName = resultSet.getString("branch_name");
            resultSet.close();
            
            return branchName;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            return "No name";
        } finally{
          try {
              connection.close();
          } catch (SQLException ex) {
              Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
  }
    
    public static void main(String[] args) {
        new DB().createTables();
        new DB().createAdmin("ritu", "ritu");
    }
    
    public static DB getInstance(){
        return new DB();
    }
  
}