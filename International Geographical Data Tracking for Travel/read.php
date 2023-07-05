<!--Name:Seifeldin Eid
    Date: Feb 19
    Section: CST 8285 section 303
    Lab: assignment 2
    File: CSS for web development
    assignment objective:This assignment is about creating, editing , viewing and deleting
    a entity that were created/presented in a mysql db table
    using CRUD Operations.
-->
<?php
// Include countryDAO file
require_once('./dao/countryDAO.php');
// require_once('./upload.php');
$countryDAO = new countryDAO();

// Check existence of id parameter before processing further
if (isset($_GET["id"]) && !empty(trim($_GET["id"]))) {
    // Get URL parameter
    $id = trim($_GET["id"]);
    $country = $countryDAO->getCountry($id);

    if ($country) {
        // Retrieve individual field value
        $name = $country->getName();
        $city = $country->getCity();
        $president = $country->getPresident();
        $population = $country->getPopulation();
        $image = $country->getImage();
    } else {
        // URL doesn't contain valid id. Redirect to error page
        header("location: error.php");
        exit();
    }
} else {
    // URL doesn't contain id parameter. Redirect to error page
    header("location: error.php");
    exit();
}

// Close connection
$countryDAO->getMysqli()->close();

?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>View Record</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
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
                    <h1 class="mt-5 mb-3">View Record</h1>
                    <div class="form-group">
                        <label>Name</label>
                        <p><b>
                                <?php echo $name; ?>
                            </b></p>
                    </div>
                    <div class="form-group">
                        <label>city</label>
                        <p><b>
                                <?php echo $city; ?>
                            </b></p>
                    </div>
                    <div class="form-group">
                        <label>president</label>
                        <p><b>
                                <?php echo $president; ?>
                            </b></p>
                    </div>
                    <div class="form-group">
                        <label>population</label>
                        <p><b>
                                <?php echo $population; ?>
                            </b></p>
                    </div>
                    <div class="form-group">
                        <label>image</label>
                        <?php
                        $image_path = $country->getImage(); 
                        // get the image path from the pet object
                        if (!empty($image_path)) { // check if the image path is not empty
                            echo "<img src='imgs/$image' style='width:300px;' />";
                        } else {
                            echo "No image available";
                        }
                        ?>
                    </div>
                    <p><a href="index.php" class="btn btn-primary">Back</a></p>
                </div>
            </div>
        </div>
    </div>
</body>

</html>