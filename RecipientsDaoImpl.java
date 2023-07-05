/*
* Student Name: Seifeldin Eid
* Student Number:041084185
* Course & Section #: 23SECST8288_021
* Declaration: The RecipientsDaoImpl class implements the RecipientsDao interface and provides the implementation for 
*accessing and manipulating the recipient data in the database.
* This is my own original work and is free from Plagiarism.
*/
package dataaccesslayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import transferobjects.RecipientDTO;

/**
 * The RecipientsDaoImpl class implements the RecipientsDao interface and provides the implementation for
 * accessing and manipulating the recipient data in the database.
 * @author Seifeldin Eid
 */
public class RecipientsDaoImpl implements RecipientsDao {

    /**
     * Retrieves a list of all recipients from the database.
     *
     * @return The list of recipients.
     */
    @Override
    public List<RecipientDTO> getAllRecipients() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<RecipientDTO> recipients = null;

        try {

            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT AwardID,Name,Year,City,Category FROM Recipients ORDER BY AwardID");
            rs = pstmt.executeQuery();
            recipients = new ArrayList<RecipientDTO>();
            while (rs.next()) {
                RecipientDTO reci = new RecipientDTO();
                reci.setAwardID(rs.getInt("AwardID"));
                reci.setName(rs.getString("Name"));
                reci.setYear(rs.getInt("Year"));
                reci.setCity(rs.getString("City"));
                reci.setCategory(rs.getString("Category"));
                recipients.add(reci);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return recipients;
    }

    /**
     * Retrieves a recipient based on the recipient ID from the database.
     *
     * @param recipientID The ID of the recipient to retrieve.
     * @return The recipient with the specified ID, or null if not found.
     */
    @Override
    public RecipientDTO getRecipientsBYRecipientId(Integer recipientID) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        RecipientDTO resi = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT AwardID,Name,Year,City,Category FROM Recipients WHERE AwardID = ?");
            pstmt.setInt(1, recipientID.intValue());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                resi = new RecipientDTO();
                resi.setAwardID(rs.getInt("AwardID"));
                resi.setName(rs.getString("Name"));
                resi.setYear(rs.getInt("Year"));
                resi.setCity(rs.getString("City"));
                resi.setCategory(rs.getString("Category"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return resi;

    }
    /**
     * Adds a new recipient to the database.
     *
     * @param recipient The recipient to add.
     */
    @Override
    public void addRecipient(RecipientDTO recipient) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "INSERT INTO Recipients (Name, Year, City, Category) VALUES (?, ?, ?, ?)");
            pstmt.setString(1, recipient.getName());
            pstmt.setInt(2, recipient.getYear());
            pstmt.setString(3, recipient.getCity());
            pstmt.setString(4, recipient.getCategory());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
  /**
     * Updates an existing recipient in the database.
     *
     * @param recipient The recipient to update.
     */
    @Override
    public void updateRecipient(RecipientDTO recipient) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "UPDATE Recipients SET Name = ?, Year = ?, City = ?, Category = ? WHERE AwardID = ?");
            pstmt.setString(1, recipient.getName());
            pstmt.setInt(2, recipient.getYear());
            pstmt.setString(3, recipient.getCity());
            pstmt.setString(4, recipient.getCategory());
            pstmt.setInt(5, recipient.getAwardID());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    /**
     * Deletes a recipient from the database.
     *
     * @param recipient The recipient to delete.
     */
    @Override
    public void deleteRecipient(RecipientDTO recipient) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "DELETE FROM Recipients WHERE AwardID = ?");
            pstmt.setInt(1, recipient.getAwardID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
