CREATE DATABASE  IF NOT EXISTS thymeleaf_demo;
USE thymeleaf_demo;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS employee;
CREATE TABLE employee (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO employee VALUES
	(1,'David','Adams','david@mail.com'),
	(2,'John','Doe','john@gmail.com'),
	(3,'Ajay','Rao','ajay@gmail.com'),
	(4,'Mary','Public','mary@yandex.com'),
	(5,'Maxwell','Dixon','max@yandex.com');

