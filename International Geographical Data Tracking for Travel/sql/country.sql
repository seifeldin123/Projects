
--
-- Database: `demo` and php web application user
CREATE DATABASE demo;
GRANT USAGE ON *.* TO 'appuser'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON demo.* TO 'appuser'@'localhost';
FLUSH PRIVILEGES;

USE demo;
--
-- Table structure for table `Countries`
--

CREATE TABLE `Countries` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `city` varchar(20) NOT NULL,
  `president` varchar(20) NOT NULL,
  `population` int(10) NOT NULL,
  `image` varchar(256),

  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `countries``
--

INSERT INTO `countries` (id, name ,city, president ,population, image) VALUES
(1, 'United Arab Emirates', 'Abu Dhabi','Sheikh Zayed', 1480000, 'abudhabi.jpeg'),
(2, 'Canada', 'Ottawa','Justin Tredau', 934240, 'ottawa.jpeg'),
(3, 'Egypt', 'cairo', 'Mohamed Sisi', 10000000, 'cairo.jpeg');
