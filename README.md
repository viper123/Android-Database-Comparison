# Android-Database-Comparison
Compare android database ORM solutions greenDao,  sugarORM with realm NoSql database solution.

In this project we compare the performance of some database solutions. The scenarios in which the database solutions are compared are not very complicated 
and does not cover all situations, however after taking a look at this project, you are a little bit closer to determine what is the best database solution for
your particular needs.

#Results summary:
After running this project on an Nexus 5 with Android 6.0 emulator we noticed the following results:
- Realm is the fastest database solution;
- greenDao is the second fastest however is the fastest ORM being faster then SugarRecord;
- Realm and greenDao both supports encryption with AES 256(greenDao is using SQLCipher with commercial and community edition);
- Realm has the best documentation. The documentation is up-to-date and easy to read and understand. On the other side greenDao's documentation
is a little bit more hard to follow and is very easy to miss use the library and get very bad performance.
![alt tag](https://raw.githubusercontent.com/viper/Android-Database-Comparison/master/Screenshot_1482420732.png)
