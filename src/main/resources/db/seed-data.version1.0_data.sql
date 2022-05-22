INSERT INTO `grade` VALUES (1,5,'Silver'),(2,1,'Bronze'),(3,11,'Gold'),(4,3,'Bronze'),(5,22,'Platinum'),(6,7,'Silver'),(7,35,'Platinum'),(8,2,'Bronze'),(9,16,'Gold'),(10,17,'Gold');

INSERT INTO `menu` VALUES (1,'baguette',5000,'','','2021-02-01 10:00:00','2021-02-02 10:10:00',1,1),(2,'salmon',20000,NULL,NULL,'2021-02-02 11:00:00','2021-02-02 11:10:00',2,2),
                          (3,'pasta',25000,NULL,NULL,'2021-02-03 13:00:00','2021-02-03 13:10:00',3,3),(4,'pizza',20000,NULL,NULL,'2021-02-05 14:00:00','2021-02-05 14:10:00',4,4),
                          (5,'noodles',10000,NULL,NULL,'2021-02-06 15:00:00','2021-02-06 15:10:00',5,5),(6,'sweetcorn',8000,NULL,NULL,'2021-02-07 16:00:00','2021-02-07 16:10:00',6,6),
                          (7,'sweetpotato',7000,NULL,NULL,'2021-02-08 17:00:00','2021-02-08 17:10:00',7,7),(8,'ice cream',5000,NULL,NULL,'2021-02-09 11:00:00','2021-02-09 11:10:00',8,8),
                          (9,'bacon',10000,NULL,NULL,'2021-02-10 13:15:00','2021-02-10 13:30:00',9,9),(10,'beef',30000,NULL,NULL,'2021-02-11 15:00:00','2021-02-11 15:10:00',10,10);

INSERT INTO `order_menu` VALUES (1,1,1),(2,2,2),(3,3,3),(4,4,4),(5,5,5),(6,6,6),(7,7,7),(8,8,8),(9,9,9),(10,10,10);

INSERT INTO `order_status` VALUES (1,'waitpayment','2020-02-01 11:01:00',1),(2,'completepayment','2020-02-01 12:01:00',2),(3,'indelivery','2020-02-01 13:01:00',3),
                                  (4,'completepayment','2020-02-01 14:01:00',4),(5,'completepayment','2020-02-01 15:01:00',5),(6,'completedelivery','2020-02-01 16:01:00',6),
                                  (7,'completedelivery','2020-02-01 17:01:00',7),(8,'indelivery','2020-02-01 18:01:00',8),(9,'waitpayment','2020-02-01 19:01:00',9),
                                  (10,'completepayment','2020-02-01 20:01:00',10);

INSERT INTO `order` VALUES (1,'card','5000','20 Marquette Terrace','2020-02-01 11:00:00',1,1,1,1),(2,'card','20000','29027 Elka Trail','2020-02-01 13:00:00',2,2,2,2),
                           (3,'card','25000','3122 Ludington Point','2020-02-01 14:00:00',3,3,3,3),(4,'card','20000','156 Melrose Alley','2020-02-01 15:00:00',4,4,4,4),
                           (5,'card','10000','Crest Line Drive','2020-02-01 16:00:00',5,5,5,5),(6,'card','8000','349 Spaight Alley','2020-02-01 17:00:00',6,6,6,6),
                           (7,'card','7000','77 Oriole Avenue','2020-02-01 18:00:00',7,7,7,7),(8,'card','5000','266 Elka Pass','2020-02-01 19:00:00',8,8,8,8),
                           (9,'card','10000','4 Haas Parkway','2020-02-01 20:00:00',9,9,9,9),(10,'card','30000','7957 Straubel Park','2020-02-01 21:00:00',10,10,10,10);

INSERT INTO `seller` VALUES (1,'jshergill0@rediff.com','itbyj9Vz9rf','2019-11-19 00:00:00','2019-11-19 00:10:00'),(2,'wbavidge1@ebay.co.uk','eEEUGqMFR','2019-11-20 00:00:00','2019-11-20 00:10:00'),
                            (3,'akearsley2@globo.com','I8PSxwLz','2019-11-21 00:00:00','2019-11-21 00:10:00'),(4,'imcmillan3@usgs.gov','WeK6Px','2019-11-22 00:00:00','2019-11-22 00:10:00'),
                            (5,'tmorley4@latimes.com','kyR2Yw0yYZxk','2019-11-23 00:00:00','2019-11-23 00:10:00'),(6,'zhamley5@biglobe.ne.jp','F3NXMaRzY1FD','2019-11-24 00:00:00','2019-11-24 00:10:00'),
                            (7,'lguirau6@bbc.co.uk','sHskSrGtUI','2019-11-25 00:00:00','2019-11-25 00:10:00'),(8,'gpampling7@flavors.me','ZYZdZ3no9','2019-11-26 00:00:00','2019-11-26 00:10:00'),
                            (9,'kbavidge8@cnbc.com','2jjYumY3','2019-11-27 00:00:00','2019-11-27 00:10:00'),(10,'cwinger9@answers.com','nDIhdtG4G6h','2019-11-28 00:00:00','2019-11-28 00:10:00');

INSERT INTO `store` VALUES (1,'Zieme Inc','010-222-1363','5976 Vermont Street','한식','2019-12-19 00:00:00','2019-12-19 00:10:00',1),
                           (2,'Gleichner-Schiller','010-259-1334','0 Carpenter Lane','일식','2019-12-20 00:00:00','2019-12-20 00:10:00',2),
                           (3,'Donnelly','010-406-7307','92 Mallory Place','중식','2019-12-21 00:00:00','2019-12-21 00:10:00',3),
                           (4,'Wyman LLC','010-753-9228','398 Everett Park','양식','2019-12-22 00:00:00','2019-12-22 00:10:00',4),
                           (5,'Kertzmann','010-540-8614','5650 Maywood Pass','패스트푸드','2019-12-23 00:00:00','2019-12-23 00:10:00',5),
                           (6,'Feil Inc','010-666-0298','4989 Butterfield Drive','한식','2019-12-24 00:00:00','2019-12-24 00:10:00',6),
                           (7,'Hamill-Nicolas','010-460-8437','93 Morningstar Parkway','중식','2019-12-25 00:00:00','2019-12-25 00:10:00',7),
                           (8,'Larson-Balistreri','010-877-2500','42327 Banding Crossing','패스트푸드','2019-12-26 00:00:00','2019-12-26 00:10:00',8),
                           (9,'Baumbach-Denesik','010-683-6065','0550 Jenifer Circle','한식','2019-12-27 00:00:00','2019-12-27 00:10:00',9),
                           (10,'Lebsack and Sons','010-433-6130','100 Golden Leaf Parkway','양식','2019-12-28 00:00:00','2019-12-28 00:10:00',10);

INSERT INTO `user` VALUES (1,'ehawson0@jimdo.com','kl1pGOS5tIxE','lsavin','010-137-1580','20 Marquette Terrace','2020-01-01 00:00:00','2020-01-01 00:10:00',1),
                          (2,'matton1@shinystat.com','HRrG6cd','epeck','010-254-2500','29027 Elka Trail','2020-01-04 00:00:00','2020-01-04 00:10:00',2),
                          (3,'lpashbee2@amazon.de','2bWe3j2u','dbrooking','010-739-0549','3122 Ludington Point','2020-01-05 00:00:00','2020-01-05 00:10:00',3),
                          (4,'gstroban3@shinystat.com','50IpI7wozC','grodolf','010-214-3736','156 Melrose Alley','2020-01-02 00:00:00','2020-01-02 00:10:00',4),
                          (5,'dcorking4@yelp.com','GSCCIczc7','dtimbs','010-499-3279','Crest Line Drive','2020-01-10 00:00:00','2020-01-10 00:10:00',5),
                          (6,'gjohansson5@ebay.com','Zzz4Mw9Wza','yhutchins','010-143-6646','349 Spaight Alley','2020-01-06 00:00:00','2020-01-06 00:10:00',6),
                          (7,'mbaudts6@dagondesign.com','nYMj8p','ffox','010-850-6586','77 Oriole Avenue','2020-01-08 00:00:00','2020-01-08 00:10:00',7),
                          (8,'dchelley7@theguardian.com','oqKhI2','vyannoni','010-217-7368','266 Elka Pass','2020-01-03 00:00:00','2020-01-03 00:10:00',8),
                          (9,'phealings8@myspace.com','ADYqPmRLJokc','gcutmere','010-617-1652','4 Haas Parkway','2020-01-07 00:00:00','2020-01-07 00:10:00',9),
                          (10,'dborrett9@pagesperso-orange.fr','oVK8DJ7HZXJB','aordidge','010-310-4587','7957 Straubel Park','2020-01-09 00:00:00','2020-01-09 00:10:00',10);






