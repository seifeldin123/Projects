/*
* Student Name: Seifeldin Eid
* Student Number:041084185
* Course & Section #: 23SECST8288_021
* Declaration:The RecipientsDao interface provides methods to interact with the recipients data in the data source.
* This is my own original work and is free from Plagiarism.
*/
package dataaccesslayer;

import java.util.List;
import transferobjects.RecipientDTO;

/**
  * The RecipientsDao interface provides methods to interact with the recipients data in the data source.
 * @author Seifeldin Eid
 */
public interface RecipientsDao {
   /**
     * Retrieves all recipients from the data source.
     *
     * @return A list of RecipientDTO objects representing all recipients.
     */
    List<RecipientDTO> getAllRecipients();
    /**
     * Retrieves a recipient by their recipient ID from the data source.
     *
     * @param recipientID The ID of the recipient to retrieve.
     * @return The RecipientDTO object representing the recipient with the specified ID, or null if not found.
     */
    RecipientDTO getRecipientsBYRecipientId(Integer recipientID);
    /**
     * Adds a new recipient to the data source.
     *
     * @param recipient The RecipientDTO object representing the recipient to add.
     */
    void addRecipient(RecipientDTO recipient);
    /**
     * Updates an existing recipient in the data source.
     *
     * @param recipient The RecipientDTO object representing the recipient to update.
     */
    void updateRecipient(RecipientDTO recipient);
    /**
     * Deletes an existing recipient from the data source.
     *
     * @param recipient The RecipientDTO object representing the recipient to delete.
     */
    void deleteRecipient(RecipientDTO recipient);
}
