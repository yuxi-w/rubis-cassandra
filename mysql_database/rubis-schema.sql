--
-- Table structure for table `bids`
--

DROP TABLE IF EXISTS `bids`;
 
CREATE TABLE `bids` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `user` int unsigned NOT NULL,
  `item` int unsigned NOT NULL,
  `qty` int unsigned NOT NULL,
  `bid` float unsigned NOT NULL,
  `max_bid` float unsigned NOT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20002001 DEFAULT CHARSET=latin1;

--
-- Table structure for table `buynow`
--

DROP TABLE IF EXISTS `buynow`; 

CREATE TABLE `buynow` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `buyer` int unsigned NOT NULL,
  `item` int unsigned NOT NULL,
  `qty` int unsigned NOT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=latin1;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
 
CREATE TABLE `categories` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `dummy` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=151 DEFAULT CHARSET=latin1;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`; 

CREATE TABLE `comments` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `from_user` int unsigned NOT NULL,
  `to_user` int unsigned NOT NULL,
  `item` int unsigned NOT NULL,
  `rating` int DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `comment` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=latin1;

--
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;

CREATE TABLE `items` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `description` text,
  `initial_price` float unsigned NOT NULL,
  `quantity` int unsigned NOT NULL,
  `reserve_price` float unsigned DEFAULT '0',
  `buy_now` float unsigned DEFAULT '0',
  `nb_of_bids` int unsigned DEFAULT '0',
  `max_bid` float unsigned DEFAULT '0',
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `seller` int unsigned NOT NULL,
  `category` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=latin1;


--
-- Table structure for table `regions`
--

DROP TABLE IF EXISTS `regions`; 

CREATE TABLE `regions` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(25) DEFAULT NULL,
  `dummy` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1; 

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`; 

CREATE TABLE `users` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `firstname` varchar(20) DEFAULT NULL,
  `lastname` varchar(20) DEFAULT NULL,
  `nickname` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `rating` int DEFAULT NULL,
  `balance` float DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `region` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=latin1;


