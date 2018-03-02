CREATE TABLE `lectors` (
   `id` int(11) NOT NULL,
   `name` varchar(45) NOT NULL,
   `surname` varchar(45) NOT NULL,
   `department` varchar(45) DEFAULT NULL,
   `degree` varchar(45) NOT NULL,
   `salary` int(11) NOT NULL,
   `head` varchar(45) NOT NULL,
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8