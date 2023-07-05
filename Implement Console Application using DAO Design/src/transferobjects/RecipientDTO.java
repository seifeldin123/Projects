/*
* Student Name: Seifeldin Eid
* Student Number:041084185
* Course & Section #: 23SECST8288_021
* Declaration: The RecipientDTO class represents a recipient object with its properties
* This is my own original work and is free from Plagiarism.
 */
package transferobjects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/**
 * The RecipientDTO class represents a recipient object with its properties.
 * This class is part of the transferobjects package and can be used for data
 * transfer between different layers of the application.
 *
 * @author Seifeldin Eid
 */
public class RecipientDTO {

    /**
     * It contains information about an award recipient, such as their name,
     * award ID, year, city, and category. The class provides getters and
     * setters for accessing and modifying the recipient's properties.
     */

    private Integer AwardID;
    private String name;
    private Integer year;
    private String city;
    private String category;

    /**
     * Retrieves the Award ID of the recipient.
     *
     * @return The Award ID.
     */
    public Integer getAwardID() {
        return AwardID;
    }

    /**
     * Sets the Award ID of the recipient.
     *
     * @param AwardID The Award ID to set.
     */
    public void setAwardID(Integer AwardID) {
        this.AwardID = AwardID;
    }

    /**
     * Retrieves the name of the recipient.
     *
     * @return The name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the recipient.
     *
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the year of the recipient.
     *
     * @return The year.
     */
    public Integer getYear() {
        return year;
    }

    /**
     * Sets the year of the recipient.
     *
     * @param year The year to set.
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * Retrieves the city of the recipient.
     *
     * @return The city.
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city of the recipient.
     *
     * @param city The city to set.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Retrieves the category of the recipient.
     *
     * @return The category.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category of the recipient.
     *
     * @param category The category to set.
     */
    public void setCategory(String category) {
        this.category = category;
    }
}