
<?php
//Name:Seifeldin Eid
// Date: Feb 19
// Section: CST 8285 section 303
// Lab: assignment 2
// File: CSS for web development
// assignment objective:This assignment is about creating, editing , viewing and deleting
// a entity that were created/presented in a mysql db table
// using CRUD Operations.
$target_dir = "imgs/";
$uploadOk = 1;

$name = $city = $president = $population = $image = "";
// Check if image file is a actual image or fake image
if (isset($_POST["submit"])) {
  $check = getimagesize($_FILES["fileToUpload"]["tmp_name"]);
  if ($check !== false) {
    echo "File is an image - " . $check["mime"] . ".";
    $uploadOk = 1;
  } else {
    echo "File is not an image.";
    $uploadOk = 0;
  }
}
if(isset($_FILES["fileToUpload"])) {
  $target_file = $target_dir . basename($_FILES["fileToUpload"]["name"]);
  $imageFileType = strtolower(pathinfo($target_file, PATHINFO_EXTENSION));
  // rest of your code goes here
} else {
  echo "File upload failed!";
}

// Check if file already exists
if (file_exists($target_file)) {
  echo "Sorry, file already exists.";
  $uploadOk = 0;
}


// Allow certain file formats
if (
  $imageFileType != "jpg" && $imageFileType != "png" && $imageFileType != "jpeg"
  && $imageFileType != "gif"
) {
  echo "Sorry, only JPG, JPEG, PNG & GIF files are allowed.";
  $uploadOk = 0;
}

// Check if $uploadOk is set to 0 by an error
if ($uploadOk == 0) {
  echo "Sorry, your file was not uploaded.";
  // if everything is ok, try to upload file
} else {
  if (move_uploaded_file($_FILES["fileToUpload"]["tmp_name"], $target_file)) {
    echo "The file " . htmlspecialchars(basename($_FILES["fileToUpload"]["name"])) . " has been uploaded.";

    //create connection to the database with the following credentials
    $servername = "localhost";
    $username = "appuser";
    $password = "password";
    $dbname = "demo";

    $conn = new mysqli($servername, $username, $password, $dbname);
    if ($conn->connect_error) {
      die("Connection failed: " . $conn->connect_error);
    }
    $image_file_name = basename($_FILES["fileToUpload"]["name"]) . "." . $imageFileType;
    $sql = "INSERT INTO countries (name, city, president, population, image)
    VALUES ('$name', '$city', '$president', '$population', '$image_file_name')";
    if ($conn->query($sql) === TRUE) {
      echo "New record inserted successfully.";
    } else {
      echo "Error: " . $sql . "<br>" . $conn->error;
    }

    $conn->close();

  } else {
    echo "Sorry, there was an error uploading your file.";
  }
}
?>

