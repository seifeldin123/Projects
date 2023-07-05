/*
* Student Name: Seifeldin Eid
* Student Number:041084185
* Course & Section #: 23SECST8288_021
* Declaration: The SimpleDemo class demonstrates the usage of the RecipientBusinessLogic and RecipientDTO classes.
* This is my own original work and is free from Plagiarism.
*/
import businesslayer.RecipientBusinessLogic;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import transferobjects.RecipientDTO;

/**
 * 
 * The SimpleDemo class demonstrates the usage of the RecipientBusinessLogic and RecipientDTO classes.
 * It performs various operations such as printing recipients, inserting a recipient, updating a recipient, deleting a recipient,
 * and displaying the metadata of the Recipients table.
 * @author Seifeldin Eid
 */
 
public class SimpleDemo {
  /**
     * Performs a demonstration of various operations using the RecipientBusinessLogic and RecipientDTO classes.
     */
    public void demo() {
        RecipientBusinessLogic logic = new RecipientBusinessLogic();
        List<RecipientDTO> list = null;
        RecipientDTO resi = null;

        //printing all the recipients
        
        System.out.println("Printing Recipients");
        list = logic.getAllRecipients();
        System.out.printf("%s %-35s %-35s %-35s %-35s","AwardID","Name","Year","City","Category");
        System.out.println();
        printRecipients(list);
        
        //printing one recipient with the prmary id
        
        System.out.println("Printing One recipient");
        resi = logic.getRecipient(40);
        System.out.printf("%s %-35s %-35s %-35s %-35s","AwardID","Name","Year","City","Category");
        System.out.println();
        printRecipient(resi);
        System.out.println();

        //inserting one recipient
        
        System.out.println("Inserting One recipient");
        resi = new RecipientDTO();
        resi.setName("UAE");
        resi.setYear(1978);
        resi.setCity("Dubai");
        resi.setCategory("GULF");
        logic.addRecipient(resi);
        list = logic.getAllRecipients();
        System.out.printf("%s %-35s %-35s %-35s %-35s","AwardID","Name","Year","City","Category");
        System.out.println();
        printRecipients(list);
        
        // updating the last recipient 
        
        System.out.println("Updating last recipient");
        Integer updatePrimaryKey = list.get(list.size() - 1).getAwardID();
        resi = new RecipientDTO();
        
        resi.setName("FirstTestUpdate");
        resi.setYear(2188);
        resi.setCity("CityTestUpdate");
        resi.setCategory("CategoryTestupdate");
        resi.setAwardID(updatePrimaryKey);
        logic.updateRecipient(resi);
        list = logic.getAllRecipients();
        System.out.printf("%s %-35s %-35s %-35s %-35s","AwardID","Name","Year","City","Category");
        System.out.println();
        printRecipients(list);

        // deleting the last recipient
        
        System.out.println("Deleting last recipient");
        list = logic.getAllRecipients();
        resi = list.get(list.size() - 1);
        logic.deleteRecipient(resi);
        list = logic.getAllRecipients();
        System.out.printf("%s %-35s %-35s %-35s %-35s","AwardID","Name","Year","City","Category");
        System.out.println();
        printRecipients(list);

        // displaying the metaData
        displayMetaData();

    }
  /**
     * Prints the details of a single recipient.
     *
     * @param recipient The recipient to be printed.
     */
    private static void printRecipient(RecipientDTO recipient) {
         
        String output = String.format("%s %-35s %-35s %-35s %-35s",
                recipient.getAwardID().toString(),
                recipient.getName(),
                recipient.getYear().toString(),
                recipient.getCity(),
                recipient.getCategory()
        );
        

        System.out.println(output);
    }
 /**
     * Prints the details of multiple recipients.
     *
     * @param recipients The list of recipients to be printed.
     */
    private static void printRecipients(List<RecipientDTO> recipients) {
        for (RecipientDTO recipient : recipients) {
            printRecipient(recipient);
        }
        System.out.println();
    }

    /**
     * Displays the metadata of the Recipients table, including column names,
     * types, and corresponding Java classes.
     */
    public void displayMetaData() {
        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipients", "root", "Amal1949!");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM Recipients");

            ResultSetMetaData metaData = resultSet.getMetaData();

            int columnCount = metaData.getColumnCount();

            System.out.println("Recipients Table - Column Attributes:");
            for (int i = 1; i <= columnCount; i++) {

                System.out.printf("%-8s\t", metaData.getColumnName(i));
                System.out.printf("%-8s\t", (metaData.getColumnTypeName(i)));
                System.out.printf("%-8s\t", metaData.getColumnClassName(i));
                System.out.printf("\n");
            }

            System.out.println();
        } // end try
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



