
package codes;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class DbConnect {
    
    
    public static Connection connect(){
        Connection conn = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/petshop" , "root" , "mellow");
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return conn;        
    }
}
