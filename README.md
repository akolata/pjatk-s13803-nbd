# NBD
Exercises from NBD subject  
Aleksander Kołata s13803

## Mongo DB (self note)
Running MongoDB (ZSH shell)   
```shell script  
docker run \
    --name nbd-mongo \
    -v ~/docker-volumes/mongo:/data/db \
    -v $(pwd)/nbd/src/pl/akolata/s13803/nbd:/opt/nbd \
    -d mongo:4.4.4
```  

```shell script  
 docker exec -it nbd-mongo bash
```

## Neo4j  
Running Neo4j (ZSH shell)  
```shell script
docker run \
  --name nbd-neo4j \
  -v ~/docker-volumes/neo4j/nbd-neo4j:/data \
  -v $(pwd)/nbd/src/pl/akolata/s13803/nbd:/opt/nbd \
  -p 7474:7474 \
  -p 7687:7687 \
  -e NEO4J_AUTH=none \
  -d \
  neo4j:4.2.5
```

## Riak  
Running Riak  
```shell script
docker run \
  --name=nbd-riak \
  -p 8087:8087 \
  -p 8098:8098 \
  -d \
  basho/riak-kv:ubuntu-2.2.3
```   
