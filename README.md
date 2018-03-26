# CorrectionWebServiceJPA

Télécharger et décompresser HSQLBD : https://sourceforge.net/projects/hsqldb/files/hsqldb/hsqldb_1_8_1/

Démarrer la base de données (dans dossier lib d'hsqldb) : java -cp hsqldb.jar org.hsqldb.Server

Démarrer l'outil d'inspaction de la base de données (dans dossier lib d'hsqldb) : java -cp hsqldb.jar org.hsqldb.util.DatabaseManagerSwing
Se connecter au type server.

Build de l'application : ./gradlew build    sous Linux ou   gradlew build   sous Windows

Convertion en un projet Eclipse : ./gradlew eclise    sous Linux ou   gradlew eclipse   sous Windows

Importation sous Eclipse : File ->  Import -> General -> Existing project into werokspace...

Lancer le main de création de la base : https://github.com/charroux/CorrectionWebServiceJPA/blob/master/src/main/java/com/univ/model/Main.java

Lancer le Web Service : https://github.com/charroux/CorrectionWebServiceJPA/blob/master/src/main/java/com/univ/CorrectionWebServiceJpaApplication.java

Tester le get : http://localhost:8080/cars

Tester le put sur l'URL (avec RestCleitn par exemple) : http://localhost:8080/cars/11AA22?louer=true

