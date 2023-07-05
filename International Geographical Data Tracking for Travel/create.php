<?php
//Name:Seifeldin Eid
// Date: Feb 19
// Section: CST 8285 section 303
// Lab: assignment 2
// File: CSS for web development
// assignment objective:This assignment is about creating, editing , viewing and deleting
// a entity that were created/presented in a mysql db table
// using CRUD Operations.

require_once('./dao/abstractDAO.php');
require_once('./dao/countryDAO.php');
$name = $city = $president = $population = $image = "";
$name_err = $city_err = $president_err = $population_err = $image_err = "";
if ($_SERVER["REQUEST_METHOD"] == "POST") {


    // include database connection
    $dao = new abstractDAO();
    $con = $dao->getMysqli();

    $target_dir = "imgs/";

    try {
        // Validate name
        $input_name = trim($_POST["name"]);
        if (empty($input_name)) {
            $name_err = "Please enter a name.";
        } elseif (!filter_var($input_name, FILTER_VALIDATE_REGEXP, array("options" => array("regexp" => "/^[a-zA-Z\s]+$/")))) {
            $name_err = "Please enter a valid name.";
        } else {
            $name = $input_name;
        }


        // Validate city
        $input_city = trim($_POST["city"]);
        if (empty($input_city)) {
            $city_err = "Please enter an city.";
        }elseif (!filter_var($input_city, FILTER_VALIDATE_REGEXP, array("options" => array("regexp" => "/^[a-zA-Z\s]+$/")))) {
            $city_err = "Please enter a valid city.";
        } else {
            $city = $input_city;
        }

        // Validate president
        $input_president = trim($_POST["president"]);
        if (empty($input_president)) {
            $president_err = "Please enter an president name.";
        }elseif (!filter_var($input_president, FILTER_VALIDATE_REGEXP, array("options" => array("regexp" => "/^[a-zA-Z\s]+$/")))) {
            $president_err = "Please enter a valid name.";
        } else {
            $president = $input_president;
        }

        // Validate population
        $input_population = trim($_POST["population"]);
        if (empty($input_population)) {
            $population_err = "Please enter the population amount.";
        } elseif (!ctype_digit($input_population)) {
            $population_err = "Please enter a positive integer value.";
        } else {
            $population = $input_population;
        }
        // Validate image
        if (empty($_FILES["fileToUpload"]["name"])) {
            $image_err = "Please upload an image.";
        } else {
            $target_file = $target_dir . basename($_FILES["fileToUpload"]["name"]);
            $imageFileType = strtolower(pathinfo($target_file, PATHINFO_EXTENSION));
            $check = getimagesize($_FILES["fileToUpload"]["tmp_name"]);
            if ($check === false) {
                $image_err = "File is not an image.";
            } elseif ($imageFileType != "jpg" && $imageFileType != "png" && $imageFileType != "jpeg" && $imageFileType != "gif") {
                $image_err = "Sorry, only JPG, JPEG, PNG & GIF files are allowed.";
            } elseif (!move_uploaded_file($_FILES["fileToUpload"]["tmp_name"], $target_file)) {
                $image_err = "Sorry, there was an error uploading your file.";
            } else {
                $image = basename($_FILES["fileToUpload"]["name"]);
            }
        }

        // Check input errors before inserting into database
        if (empty($name_err) && empty($city_err) && empty($president_err) && empty($population_err) && empty($image_err)) {
            $countryDAO = new countryDAO();
            $country = new Country(0, $name, $city, $president, $population, $image);
            $addResult = $countryDAO->addCountry($country);
            header("refresh:2; url=index.php");
            echo '<br><h6 style="text-align:center">' . $addResult . '</h6>';
            // Close connection
            $countryDAO->getMysqli()->close();
        }

    } catch (Exception $e) {
        echo "Error: " . $e->getMessage();
    }

}

?>



<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Create Recordsss</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="JS/newScript.js" defer></script>
    <style>
        .wrapper {
            width: 600px;
            margin: 0 auto;
        }
    </style>
</head>

<body>
    <div class="wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <h2 class="mt-5">Add a new country</h2>
                    <p>kindly fill this form and submit to add a new country record to the database.</p>

                    <!--the following form action, will send the submitted form data to the page itself ($_SERVER["PHP_SELF"]), instead of jumping to a different page.-->
                    <form id="newForm" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>" method="post"
                        enctype="multipart/form-data">
                        <div class="form-group">
                            <label for="Name">Name</label>
                            <input type="text" name="name" id="Name"
                                class="form-control <?php echo (!empty($name_err)) ? 'is-invalid' : ''; ?>"
                                value="<?php echo isset($name) ? htmlspecialchars($name) : ''; ?>">
                            <span class="invalid-feedback">
                                <?php echo $name_err; ?>
                            </span>
                        </div>
                        <div class="form-group">
                            <label for="Type">city</label>
                            <input type="text" name="city" id="city"
                                class="form-control <?php echo (!empty($city_err)) ? 'is-invalid' : ''; ?>"
                                value="<?php echo isset($city) ? htmlspecialchars($city) : ''; ?>">
                            <span class="invalid-feedback">
                                <?php echo $city_err; ?>
                            </span>
                        </div>
                        <div class="form-group">
                            <label for="president">President</label>
                            <input type="text" name="president" id="president"
                                class="form-control <?php echo (!empty($president_err)) ? 'is-invalid' : ''; ?>"
                                value="<?php echo isset($president) ? htmlspecialchars($president) : ''; ?>">
                            <span class="invalid-feedback">
                                <?php echo $president_err; ?>
                            </span>
                        </div>
                        <div class="form-group">
                            <label for="population">population</label>
                            <input type="text" name="population" id="population"
                                class="form-control <?php echo (!empty($population_err)) ? 'is-invalid' : ''; ?>"
                                value="<?php echo isset($population) ? htmlspecialchars($population) : ''; ?>">
                            <span class="invalid-feedback">
                                <?php echo $population_err; ?>
                            </span>
                        </div>

                        <div class="form-group">
                            <label for="fileToUpload">image</label>
                            <input type="file" name="fileToUpload" id="fileToUpload"
                                class="form-control <?php echo (!empty($image_err)) ? 'is-invalid' : ''; ?>"
                                value="<?php echo $image; ?>">
                            <span class="invalid-feedback">
                                <?php echo $image_err; ?>
                            </span>
                        </div>
                </div>
                <input type="submit" class="btn btn-primary" id="submitBtn" value="Submit">
                <a href="index.php" class="btn btn-secondary ml-2">Cancel</a>
                </form>
            </div>
        </div>

        <? include 'footer.php'; ?>

</body>

</html>