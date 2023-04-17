# springboot-mongo

## Docker Setting

```shell
docker pull mongo #latest pull

#pull 받은 이미지 실행
docker run --name mongodb -d -p 27017:27017 -e MONGO_INITDB_ROOT_USERNAME={username} -e MONGO_INITDB_ROOT_PASSWORD={userpwd} mongo

#몽고 컨테이너 내 몽고DB 실행
mongosh -u {username} -p {userpwd}

#몽고DB 내 명령어
db.event.insertOne({title: "title1", image: "image1"})
db.event.find({title: "title1"})
```

## Mongo Indexing
단일 필드 인덱스
- 기본적으로 _id 라는 단일 필드 인덱스가 생성
- 인덱싱 시 1, -1 -> 오름차순, 내림차순을 선택
```shell
#단일 인덱스
db.event.createIndex({title: 1})

#복합 인덱스
db.event.createIndex({title: 1, image: -1})

#인덱스 통계
db.event.aggregate([{$indexStats:{}}])

db.event.find({title:"title1"}).explain("executionStats").executionStats.executionTimeMillis
```