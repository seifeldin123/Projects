/*
* Student Name: Seifeldin Eid
* Student Number:041084185
* Course & Section #: 23SECST8288_021
* Declaration:The RecipientBusinessLogic class handles the business logic related to recipients.
* This is my own original work and is free from Plagiarism.
*/
package businesslayer;

import dataaccesslayer.RecipientsDao;
import dataaccesslayer.RecipientsDaoImpl;
import java.util.List;
import transferobjects.RecipientDTO;

/**
 * 
 * The RecipientBusinessLogic class handles the business logic related to recipients.
 * It interacts with the data access layer to perform CRUD operations on recipients.
 * @author Seifeldin Eid
 */
public class RecipientBusinessLogic {

    private RecipientsDao recipientsDao = null;

    /**
     * Constructs a RecipientBusinessLogic object and initializes the recipientsDao.
     */
    public RecipientBusinessLogic() {
        recipientsDao = new RecipientsDaoImpl();
    }
    /**
     * Retrieves a list of all recipients.
     *
     * @return The list of all recipients.
     */
    public List<RecipientDTO> getAllRecipients() {
        return recipientsDao.getAllRecipients();
    }
    /**
     * Retrieves a recipient by their award ID.
     *
     * @param awardID The award ID of the recipient to retrieve.
     * @return The recipient with the specified award ID, or null if not found.
     */
    public RecipientDTO getRecipient(Integer awardID) {
        return recipientsDao.getRecipientsBYRecipientId(awardID);
    }
    /**
     * Adds a new recipient.
     *
     * @param recipient The recipient to add.
     */
    public void addRecipient(RecipientDTO recipient) {

        recipientsDao.addRecipient(recipient);
    }
    /**
     * Updates an existing recipient.
     *
     * @param recipient The recipient to update.
     */
    public void updateRecipient(RecipientDTO recipient) {

        recipientsDao.updateRecipient(recipient);
    }
    /**
     * Deletes a recipient.
     *
     * @param recipient The recipient to delete.
     */
    public void deleteRecipient(RecipientDTO recipient) {
        recipientsDao.deleteRecipient(recipient);
    }
    

}
