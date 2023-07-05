
<?php
// Name:Seifeldin Eid
// Date: Feb 19
// Section: CST 8285 section 303
// Lab: assignment 2
// File: CSS for web development
// assignment objective:This assignment is about creating, editing , viewing and deleting
// a entity that were created/presented in a mysql db table
// using CRUD Operations.
// 
require_once('abstractDAO.php');
require_once('./model/country.php');

class countryDAO extends abstractDAO
{

    function __construct()
    {
        try {
            parent::__construct();
        } catch (mysqli_sql_exception $e) {
            throw $e;
        }
    }
    public function getCountry($countryId)
    {
        $query = 'SELECT * FROM countries WHERE id = ?';
        $stmt = $this->mysqli->prepare($query);
        $stmt->bind_param('i', $countryId);
        $stmt->execute();
        $result = $stmt->get_result();
        if ($result->num_rows == 1) {
            $temp = $result->fetch_assoc();
            $country = new country($temp['id'], $temp['name'], $temp['city'], $temp['president'], $temp['population'], $temp['image']);
            $result->free();
            return $country;
        }
        $result->free();
        return false;
    }

    public function getCountrys()
    {
        //The query method returns a mysqli_result object
        $result = $this->mysqli->query('SELECT * FROM countries');
        $countrys = array();

        if ($result->num_rows >= 1) {
            while ($row = $result->fetch_assoc()) {
                //Create a new country object, and add it to the array.
                $country = new Country($row['id'], $row['name'], $row['city'], $row['president'], $row['population'], $row['image']);
                $countrys[] = $country;
            }
            $result->free();
            return $countrys;
        }
        $result->free();
        return false;
    }
    public function addCountry($country)
    {

        if (!$this->mysqli->connect_errno) {
            //The query uses the question mark (?) as a
            //placeholder for the parameters to be used
            //in the query.
            //The prepare method of the mysqli object returns
            //a mysqli_stmt object. It takes a parameterized 
            //query as a parameter.
            $query = 'INSERT INTO countries (name, city, president, population ,image) VALUES (?,?,?,?,?)';
            $stmt = $this->mysqli->prepare($query);
            if ($stmt) {
                $name = $country->getName();
                $city = $country->getcity();
                $president = $country->getPresident();
                $population = $country->getpopulation();
                $image = $country->getImage();

                $stmt->bind_param(
                    'sssis',
                    $name,
                    $city,
                    $president,
                    $population,
                    $image
                );
                //Execute the statement
                $stmt->execute();

                if ($stmt->error) {
                    return $stmt->error;
                } else {
                    return $country->getName() . ' added successfully!';
                }
            } else {
                $error = $this->mysqli->errno . ' ' . $this->mysqli->error;
                echo $error;
                return $error;
            }

        } else {
            return 'Could not connect to Database.';
        }
    }
    public function updateCountry($country)
    {
        if ($_POST){

        
        $mysqli = $this->getMysqli();
        $sql = "UPDATE countries SET name=?, city=?, president=?, population=?, image=? WHERE id=?";
        $stmt = $mysqli->prepare($sql);
        $name = htmlspecialchars(strip_tags($_POST['name']));
        $city = htmlspecialchars(strip_tags($_POST['city']));
        $president = htmlspecialchars(strip_tags($_POST['president']));
        $population = htmlspecialchars(strip_tags($_POST['population']));
        $image = basename($_FILES["fileToUpload"]["name"]);
        if ($stmt) {
            $name = $country->getName();
            $city = $country->getCity();
            $president = $country->getPresident();
            $population = $country->getPopulation();
            $image = $country->getImage();
            $id = $country->getId();
            $stmt->bind_param("sssisi", $name, $city, $president, $population, $image, $id);
            $stmt->execute();
            if ($stmt->error) {
                return $stmt->error;
            } else{
                return "Record updated successfully.";
            }
                // echo $country->uploadPhoto();
            } else {
                echo "Error: " . $mysqli->error;
            }
            $stmt->close();
        }
        }


    public function deleteCountry($countryId)
    {
        if (!$this->mysqli->connect_errno) {
            $query = 'DELETE FROM countries WHERE id = ?';
            $stmt = $this->mysqli->prepare($query);
            $stmt->bind_param('i', $countryId);
            $stmt->execute();
            if ($stmt->error) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
}
?>