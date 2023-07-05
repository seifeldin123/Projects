<!--Name:Seifeldin Eid
    Date: Feb 19
    Section: CST 8285 section 303
    Lab: assignment 2
    File: CSS for web development
    assignment objective:This assignment is about creating, editing , viewing and deleting
    a entity that were created/presented in a mysql db table
    using CRUD Operations.
-->
<?php require_once('./dao/countryDAO.php'); ?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
        .wrapper {
            width: 900px;
            margin: 0 auto;
        }

        table tr td:last-child {
            width: 150px;
        }
    </style>
    <script>
        $(document).ready(function () {
            $('[data-toggle="tooltip"]').tooltip();
        });
    </script>
</head>

<body>
    <div class="wrapper">
        <div class="container-fluid">
            <div class="country">
                <div class="col-md-12">
                    <div class="mt-5 mb-3 clearfix">
                        <h2 class="pull-left">countrys Details</h2>
                        <a href="create.php" class="btn btn-success pull-right"><i class="fa fa-plus"></i> Add New
                            country</a>
                    </div>
                    <?php
                    $countryDAO = new countryDAO();
                    $countrys = $countryDAO->getCountrys();


                    if ($countrys) {
                        echo '<table class="table table-bordered table-striped">';
                        echo "<thead>";
                        echo "<tr>";
                        echo "<th>#</th>";
                        echo "<th>Name</th>";
                        echo "<th>city</th>";
                        echo "<th>President</th>";
                        echo "<th>population</th>";
                        echo "<th>image</th>";
                        echo "<th>Action</th>";
                        echo "</tr>";
                        echo "</thead>";
                        echo "<tbody>";
                        foreach ($countrys as $country) {
                            echo "<tr>";
                            echo "<td>" . $country->getId() . "</td>";
                            echo "<td>" . $country->getName() . "</td>";
                            echo "<td>" . $country->getCity() . "</td>";
                            echo "<td>" . $country->getPresident() . "</td>";
                            echo "<td>" . $country->getPopulation() . "</td>";
                            echo "<td>" . $country->getImage() . "</td>";
                            echo "<td>";
                            echo '<a href="read.php?id=' . $country->getId() . '" class="mr-3" title="View Record" data-toggle="tooltip"><span class="fa fa-eye"></span></a>';
                            echo '<a href="update.php?id=' . $country->getId() . '" class="mr-3" title="Update Record" data-toggle="tooltip"><span class="fa fa-pencil"></span></a>';
                            echo '<a href="delete.php?id=' . $country->getId() . '" title="Delete Record" data-toggle="tooltip"><span class="fa fa-trash"></span></a>';
                            echo "</td>";
                            echo "</tr>";
                        }
                        echo "</tbody>";
                        echo "</table>";
                        // Free result set
                        //$result->free();
                    } else {
                        echo '<div class="alert alert-danger"><em>No records were found.</em></div>';
                    }

                    // Close connection
                    $countryDAO->getMysqli()->close();
                    include 'footer.php';
                    ?>
                </div>
            </div>
        </div>
</body>

</html>