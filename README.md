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
