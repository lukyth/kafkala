Kafka Example
====
#Install
    brew install zookeeper
    brew install kafka
    
#Zookeeper
    zkServer start
    
#Kafka
    kafka-server-start.sh /usr/local/etc/kafka/server.properties

#Create Topic
    kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 10 --topic test

#List Topic
    kafka-topics.sh --list --zookeeper localhost:2181
    
#Reference
    http://kafka.apache.org/documentation.html#quickstart
    
#Monitor
    Download KafkaOffsetMonitor from Github (https://github.com/quantifind/KafkaOffsetMonitor)
    
    java -cp KafkaOffsetMonitor-assembly-0.2.1.jar \
         com.quantifind.kafka.offsetapp.OffsetGetterWeb \
         --zk localhost \
         --port 8080 \
         --refresh 10.seconds \
         --retain 2.days
    

<a rel="license" href="http://creativecommons.org/licenses/by/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by/4.0/88x31.png" /></a><br /><span xmlns:dct="http://purl.org/dc/terms/" property="dct:title">Kafkala</span> by <a xmlns:cc="http://creativecommons.org/ns#" href="http://www.thjug.cm" property="cc:attributionName" rel="cc:attributionURL">Peerapat Asoktummarungsri</a> is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by/4.0/">Creative Commons Attribution 4.0 International License</a>.<br />Based on a work at <a xmlns:dct="http://purl.org/dc/terms/" href="https://github.com/nuboat/kafkala" rel="dct:source">https://github.com/nuboat/kafkala</a>.
