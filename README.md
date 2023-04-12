# springboot-mongo

## Docker Setting

```shell
docker pull mongo #latest pull

#pull 받은 이미지 실행
docker run --name mongodb -d -p 27017:27017 -e MONGO_INITDB_ROOT_USERNAME={username} -e MONGO_INITDB_ROOT_PASSWORD={userpwd} mongo

#몽고 컨테이너 내 몽고DB 실행
mongosh -u {username} -p {userpwd}

#몽고DB 내 명령어
db.event.insertOne({id: "1", title: "title1", image: "image1"})
db.event.find({id: "1"})
```