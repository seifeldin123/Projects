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
require_once('./dao/countryDAO.php');

// Process delete operation after confirmation
if(isset($_POST["id"]) && !empty($_POST["id"])){
        $countryDAO = new countryDAO();  
        $countryId = trim($_POST["id"]);        
        $result = $countryDAO->deleteCountry($countryId);
        if($result){
            header("location: index.php");
            exit();
            } else{
            echo "Oops! Something went wrong. Please try again later.";
            }
}

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Delete Record</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .wrapper{
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
                    <h2 class="mt-5 mb-3">Delete Record</h2>
                    <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>" method="post">
                        <div class="alert alert-danger">
                            <input type="hidden" name="id" value="<?php echo trim($_GET["id"]); ?>"/>
                            <p>Are you sure you want to delete this country record?</p>
                            <p>
                                <input type="submit" value="Yes" class="btn btn-danger">
                                <a href="index.php" class="btn btn-secondary ml-2">No</a>
                            </p>
                        </div>
                    </form>
                </div>
            </div>        
        </div>
    </div>
</body>
</html>