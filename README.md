# demo4

# mysql table create

```mysql
CREATE TABLE `products` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_name` varchar(45) DEFAULT NULL,
  `price` int DEFAULT NULL,
  `imagesrc` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

```
# Insert products

```mysql
INSERT INTO `products` (`id`,`product_name`,`price`,`imagesrc`,`type`,`description`) VALUES (1,'Naruto',1040,'resources/images/naruto.jpg','manga','Naruto (Japanese: ナルト) is a Japanese manga series written and illustrated by Masashi Kishimoto. It tells the story of Naruto Uzumaki, a young ninja who seeks recognition from his peers and dreams of becoming the Hokage, the leader of his village.');
INSERT INTO `products` (`id`,`product_name`,`price`,`imagesrc`,`type`,`description`) VALUES (2,'One Piece',2000,'resources/images/onepiece.jpg','manga','One Piece (1999 - Current) One Piece is a steampunk manga and anime series created by artist Eiichiro Oda. It revolves around a crew of pirates led by captain Monkey D. Luffy, whose dream is to obtain the ultimate treasure One Piece that was left behind by the King of the Pirates, Gold Roger.');
INSERT INTO `products` (`id`,`product_name`,`price`,`imagesrc`,`type`,`description`) VALUES (3,'OreGairu',2500,'resources/images/oregairu.jpg','manga','My Youth Romantic Comedy Is Wrong, As I Expected (Japanese: やはり俺の青春ラブコメはまちがっている。, Hepburn: Yahari Ore no Seishun Rabukome wa Machigatteiru.), abbreviated as OreGairu (俺ガイル) and Hamachi (はまち),[3] and also known as My Teen Romantic Comedy SNAFU, is a Japanese light novel series written by Wataru Watari and illustrated by Ponkan8. The series follows Hachiman Hikigaya, a pessimistic, closeminded, and realistic teen, who is forced by his teacher to join the school\'s service club and work with two girls with issues of their own. They offer help and advice to others while dealing with their inner conflicts.');
INSERT INTO `products` (`id`,`product_name`,`price`,`imagesrc`,`type`,`description`) VALUES (4,'Tower of God',1500,'resources/images/towerofgod.jpg','manhua','Tower of God centers around a boy called Twenty-Fifth Bam, who has spent most of his life trapped beneath a vast and mysterious Tower, with only his close friend, Rachel, to keep him entertained.');
INSERT INTO `products` (`id`,`product_name`,`price`,`imagesrc`,`type`,`description`) VALUES (5,'WindBreaker',1760,'resources/images/windbreaker.jpg','manhua','Jay is the Student Body President of Sunny High. Not only is he a smart student, but he is also an extreme biker with extraordinary technique. Trail his bike to encounter his friends, loves, and adventures.');
INSERT INTO `products` (`id`,`product_name`,`price`,`imagesrc`,`type`,`description`) VALUES (6,'Owari no Seraph',1600,'resources/images/owarinoseraph.jpg','manga','The series is set in a world where a virus has wiped out most of humanity, allowing vampires to enslave the rest of the human race. It tells the story of an orphaned boy named Yūichirō Hyakuya trying to rid the world of the vampires by joining the Japanese Imperial Demon Army.');
INSERT INTO `products` (`id`,`product_name`,`price`,`imagesrc`,`type`,`description`) VALUES (7,'Seraph of the End',1100,'resources/images/owarinoseraph.jpg','manga','The series is set in a world where a virus has wiped out most of humanity, allowing vampires to enslave the rest of the human race. It tells the story of an orphaned boy named Yūichirō Hyakuya trying to rid the world of the vampires by joining the Japanese Imperial Demon Army.');
INSERT INTO `products` (`id`,`product_name`,`price`,`imagesrc`,`type`,`description`) VALUES (8,'Secret love',2100,'resources/images/secretlove.jpg','manhua','Manhua is about secret love of two students. They are trying to hide their feeling of each other.');
INSERT INTO `products` (`id`,`product_name`,`price`,`imagesrc`,`type`,`description`) VALUES (9,'Fairy Tail',2150,'resources/images/fairytail.jpg','manga','The series follows the adventures of the Celestial Spirit Mage Lucy Heartfilia after she joins the Fairy Tail Guild and teams up with Natsu Dragneel, who is searching for the Dragon Igneel.');
INSERT INTO `products` (`id`,`product_name`,`price`,`imagesrc`,`type`,`description`) VALUES (10,'Dragonball',3500,'resources/images/image.jpg','manga','It initially had a comedy focus but later became an action-packed fighting series. The story follows the adventures of Son Goku, from childhood to adulthood, as he trains in martial arts and explores the world in search of the Dragon Balls, seven magical orbs which summon a wish-granting dragon when gathered.');
INSERT INTO `products` (`id`,`product_name`,`price`,`imagesrc`,`type`,`description`) VALUES (11,'White blood',780,'resources/images/image.jpg','manhua','Park Ha-yan (name meaning white) just wants to live an ordinary life, despite being born a vampire');
INSERT INTO `products` (`id`,`product_name`,`price`,`imagesrc`,`type`,`description`) VALUES (12,'Nan Hao',970,'resources/images/nanhao.jpg','manhua','Manhua about best friends Nan and Hao. ');

```
# Users table create

```mysql
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `roles` varchar(45) DEFAULT 'ROLE_USER',
  `active` tinyint DEFAULT NULL,
  `companyname` varchar(45) DEFAULT NULL,
  `money` int DEFAULT '10000',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
```
```mysql
INSERT INTO `users` (`id`,`user_name`,`password`,`roles`,`active`,`companyname`,`money`) VALUES (1,'kek','$2a$12$uavs/zM.p87UmXsVV.eNR.1hvD6XHImUB98OStJYksrjTVzs/IhyG','ROLE_ADMIN',1,'gexabyte',10000);
INSERT INTO `users` (`id`,`user_name`,`password`,`roles`,`active`,`companyname`,`money`) VALUES (9,'we','$2a$08$9xOkCMKOQiIZGOEQXk7xrObcTyS5VkswpyImzf2p1SJeB7EcO2QZq','ROLE_USER',1,'agindata',10000);
```

# login - password - are same

## edit schema name at application properties file






# REST

to login make POST request /restlogin 
body: 
```json
{
"userName":"kek",
"password":"kek"
}
```
Copy bearer token and add key to header

Key: Authorization Value: Bearer_'token'

![GitHub Logo](https://sun9-40.userapi.com/c857424/v857424764/2206e8/W6dwwvKMb9g.jpg)


# Output all products
/admin/products method GET
# Output all users
/admin/users method GET

# Add new product 
/admin/products/new method POST
Body:
```json
 {
        "productName": "Naruto",
        "type": "manga",
        "price": 1040,
        "imagesrc": "images/image.jpg"
    }
```

# Load file to project ( image )
/admin/products/new/file
body section 
key: file
choose file 

![GitHub Logo](https://sun9-27.userapi.com/c853624/v853624884/2458c5/ImAMiDissak.jpg)

# Delete product by id
/admin/products/delete/{id} method DELETE

# Edit product by id
/admin/products/edit/{id} method PUT
   Body:
```json
 {
        "id": id,
        "productName": "Naruto",
        "type": "manga",
        "price": 1040,
        "imagesrc": "images/image.jpg"
    }
```
    
  # User controller
  # Output all users
  /admin/users method GET
  
 # Add new user
  /admin/users/new method POST
  Body:
```json
  {
        "userName": "test",
        "password": "test",
        "active": true,
        "roles": "ROLE_ADMIN",
        "companyname": "gexabyte",
        "money": 10000
    }
 ```
  
  # Delete user 
  /admin/users/delete/{id} method DELETE
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  # Preview
  
 ![GitHub Logo](https://sun9-69.userapi.com/c857424/v857424764/2206f2/A2l2lxsiBDU.jpg)
 
 ![GitHub Logo](https://sun9-45.userapi.com/c857424/v857424764/2206fc/YDlk-RE51kg.jpg)
 
 ![GitHub Logo](https://sun9-7.userapi.com/c857424/v857424764/220706/5He7l6pvCWU.jpg)
  
  
