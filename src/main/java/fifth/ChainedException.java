package fifth;

import org.postgresql.util.PSQLException;

import java.sql.*;
import java.util.Arrays;

public class ChainedException {
    public static void main(String[] args) throws APILevelException, ClassNotFoundException {
      /*  long start1 = System.nanoTime();
        for(int i=0;i<1000;i++){
            getInfoAboutUser(1);
        }
        long time1 = System.nanoTime() - start1;
        long start2 = System.nanoTime();
        for(int i=0;i<1000;i++){
            getInfoAboutUserSupressed(1);
        }
        long time2 = System.nanoTime() - start2;
        System.out.println(time1);
        System.out.println(time2);//in average faster a little*/
        getInfoAboutUser(1);
        getInfoAboutUserSupressed(1);

    }
    private static void getUserFromDb(int id) throws ClassNotFoundException, SQLException {

        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "root";
        String password = "gddfgddc";

        Class.forName("org.postgresql.Driver");

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM persons WHERE id="+id)) {

            if (rs.next()) {
                System.out.println(rs.getString(1));
            }

        } catch (SQLException ex) {
            throw new SQLException("Database level exception",ex);
        }
    }
    private static void getUserById(int id) throws ServiceInternalErrorException, ClassNotFoundException {
        try{
            getUserFromDb(id);
        }catch (SQLException ex){
            throw new ServiceInternalErrorException("Service level error",ex);
        }

    }
    private static void getInfoAboutUser(int id) throws APILevelException, ClassNotFoundException {
        try{
            System.out.println("Getting user info by its id....");
            getUserById(id);
        }catch (ServiceInternalErrorException ex){
            APILevelException exception =  new APILevelException("API level error",ex);
            //throw exception;
           exception.printStackTrace();
        }
    }
    private static void getUserByIdSuppressed(int id) throws ServiceInternalErrorException, ClassNotFoundException {
        try{
            getUserFromDb(id);
        }catch (SQLException ex){
                ServiceInternalErrorException exception = new ServiceInternalErrorException("Service level error");
                exception.addSuppressed(ex);
                throw exception;
        }
    }
    private static void getInfoAboutUserSupressed(int id) throws APILevelException, ClassNotFoundException {
        try{
            System.out.println("Getting user info by its id....");
            getUserByIdSuppressed(id);
        }catch (ServiceInternalErrorException ex){
            APILevelException exception = new APILevelException("API level error");
            exception.addSuppressed(ex);
            //throw exception;
            exception.printStackTrace();
        }
    }
}
