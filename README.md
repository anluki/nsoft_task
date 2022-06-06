# nsoft_task

Download project using command: git clone https://github.com/anluki/nsoft_task.git

Eclipse:	File>Import>Existing maven projects> then select cloned repository and find pom.xml
Wait until successfuly dependency download 

Download and setup Kafka localy: https://www.javainuse.com/spring/spring-boot-apache-kafka-hello-world
After success setup, go to kafka folder and run these comands:
  1) .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
  2) .\bin\windows\kafka-server-start.bat .\config\server.properties
  3) .\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic event
  4) .\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic event --from-beginning

Run application and Use Postman to test app. Import postamn collection (nSoft.postman_collection.json located in root of project) to Postman
