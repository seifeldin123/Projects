<?php
//Name:Seifeldin Eid
// Date: Feb 19
// Section: CST 8285 section 303
// Lab: assignment 2
// File: CSS for web development
// assignment objective:This assignment is about creating, editing , viewing and deleting
// a entity that were created/presented in a mysql db table
// using CRUD Operations.
class Country
{
    private $id;
    private $name;
    private $city;
    private $president;
    private $population;
    private $image;

    public function __construct($id, $name, $city, $president, $population, $image)
    {
        $this->id = $id;
        $this->name = $name;
        $this->city = $city;
        $this->president = $president;
        $this->population = $population;
        $this->image = $image;
    }

    // getters and setters
    public function getId()
    {
        return $this->id;
    }
    public function setId()
    {
        $this->id = $id;
    }

    public function getName()
    {
        return $this->name;
    }
    public function setName()
    {
        $this->name = $name;
    }

    public function getCity()
    {
        return $this->city;
    }
    public function setCity()
    {
        $this->city = $city;
    }

    public function getPresident()
    {
        return $this->president;
    }
    public function setPresident()
    {
        $this->president = $president;
    }

    public function getPopulation()
    {
        return $this->population;
    }
    public function setPopulation($population)
    {
        $this->population = $population;
    }

    public function getImage()
    {
        return $this->image;
    }

    public function setImage($image)
    {
        // $this->image = htmlspecialchars(strip_tags($this->image));
        $this->image = $image;
    }
}
?>