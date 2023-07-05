<?php
// Name:Seifeldin Eid
// Date: Feb 19
// Section: CST 8285 section 303
// Lab: assignment 2
// File: CSS for web development
// assignment objective:This assignment is about creating, editing , viewing and deleting
// a entity that were created/presented in a mysql db table
// using CRUD Operations.

// Include countryDAO file
require_once('./dao/abstractDAO.php');
require_once('./dao/countryDAO.php');

// Define variables and initialize with empty values
$name = $city = $president = $population = $image = "";
$name_err = $city_err = $president_err = $population_err = $image_err = "";
$countryDAO = new countryDAO();
$target_dir = "imgs/";

// Processing form data when form is submitted
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $id = $_POST["id"];

    // Validate name
    $input_name = trim($_POST["name"]);
    if (empty($input_name)) {
        $name_err = "Please enter a country name.";
    } elseif (!filter_var($input_name, FILTER_VALIDATE_REGEXP, array("options" => array("regexp" => "/^[a-zA-Z\s]+$/")))) {
        $name_err = "Please enter a valid country name.";
    } else {
        $name = $input_name;
    }

    // Validate city
    $input_city = trim($_POST["city"]);
    if (empty($input_city)) {
        $city_err = "Please enter an city.";
    } elseif (!filter_var($input_city, FILTER_VALIDATE_REGEXP, array("options" => array("regexp" => "/^[a-zA-Z\s]+$/")))) {
        $city_err = "Please enter a valid city.";
    } else {
        $city = $input_city;
    }
    // Validate president

    $input_president = trim($_POST["president"]);
    if (empty($input_president)) {
        $president_err = "Please enter an president name.";
    } elseif (!filter_var($input_president, FILTER_VALIDATE_REGEXP, array("options" => array("regexp" => "/^[a-zA-Z\s]+$/")))) {
        $president_err = "Please enter a valid name.";
    } else {
        $president = $input_president;
    }
    // Validate population
    if (isset($_POST["population"]) && !empty($_POST["population"])) {
        $input_population = trim($_POST["population"]);
        if (!ctype_digit($input_population)) {
            $population_err = "Please enter a positive integer value.";
        } else {
            $population = $input_population;
        }
    } else {
        $population_err = "Please enter the population.";
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
    if (empty($name_err) && empty($city_err) && empty($president_err) && empty($population_err) && empty($image_err)) {
        $country = new Country($id, $name, $city, $president, $population, $image);
        $result = $countryDAO->updateCountry($country);
        if ($result == true) {
            echo '<br><h6 style="text-align:center">' . $result . '</h6>';
            header("refresh:2; url=index.php");
        } else {
            echo "Oops! Something went wrong. Please try again later.";
        }

    }
}

// Check existence of id parameter before processing further
if (isset($_GET["id"]) && !empty(trim($_GET["id"]))) {
    // Get URL parameter
    $id = trim($_GET["id"]);
    // Retrieve country data based on id
    $country = $countryDAO->getCountry($id);

    // Check if country exists
    if (!$country) {
        // Country doesn't exist, redirect to error page
        header("location: error.php");
        exit();
    } else {
        // Country exists, set input values to country properties
        $name = $country->getName();
        $city = $country->getCity();
        $president = $country->getPresident();
        $population = $country->getPopulation();
        $image = $country->getImage();

    }
}

?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Update Country</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css">
    <style>
        .wrapper {
            width: 500px;
            margin: 0 auto;
        }

        .form-group {
            margin-top: 20px;
        }
    </style>
</head>

<body>
    <div class="wrapper">
        <h2>Update Country</h2>
        <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>" method="post"
            enctype="multipart/form-data">
            <input type="hidden" name="id" value="<?php echo $id; ?>" />
            <div class="form-group <?php echo (!empty($name_err)) ? 'has-error' : ''; ?>">
                <label>Country Name</label>
                <input type="text" name="name" class="form-control" value="<?php echo $name; ?>">
                <span class="help-block">
                    <?php echo $name_err; ?>
                </span>
            </div>
            <div class="form-group <?php echo (!empty($city_err)) ? 'has-error' : ''; ?>">
                <label>City</label>
                <input type="text" name="city" class="form-control" value="<?php echo $city; ?>">
                <span class="help-block">
                    <?php echo $city_err; ?>
                </span>
            </div>
            <div class="form-group <?php echo (!empty($president_err)) ? 'has-error' : ''; ?>">
                <label>President</label>
                <input type="text" name="president" class="form-control" value="<?php echo $president; ?>">
                <span class="help-block">
                    <?php echo $president_err; ?>
                </span>
            </div>
            <div class="form-group <?php echo (!empty($population_err)) ? 'has-error' : ''; ?>">
                <label>Population</label>
                <input type="text" name="population" class="form-control" value="<?php echo $population; ?>">
                <span class="help-block">
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
            <input type="hidden" name="id" value="<?php echo $id; ?>" />
            <input type="submit" class="btn btn-primary" value="Submit">
            <a href="index.php" class="btn btn-secondary ml-2">Cancel</a>
        </form>
    </div>
    </div>
    </div>
    </div>
</body>

</html>