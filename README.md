# socket-echo-service

## 실행법

server on
<img width="1051" alt="스크린샷 2023-09-24 오후 11 38 20" src="https://github.com/salgu1998/socket-echo-service/assets/76906458/3c814d40-e21a-4b45-97c6-9ff301d1897d">

client on
<img width="1043" alt="스크린샷 2023-09-24 오후 11 38 27" src="https://github.com/salgu1998/socket-echo-service/assets/76906458/2b441be0-3613-409a-a850-773c3d2cadfc">


client2 on
<img width="1042" alt="스크린샷 2023-09-24 오후 11 38 32" src="https://github.com/salgu1998/socket-echo-service/assets/76906458/7d43f2f8-40c0-43da-bc95-d22ed38a2da9">


<p>Application을 실행할때 arguments로 `server`, `client` 값을 받아 따로따로 실행해주었습니다.</p>
<p>client, client2와 server의 port도 따로 변경하여 각각 독립적으로 실행시켜줍니다.</p>

#### Port

- EchoServer Application Port : 8080
- EchoServer Socket Port : 8081
- EchoClient Application Port : 8082 ~ ...

## 결과

### EchoServer
<img width="639" alt="스크린샷 2023-09-21 오후 7 33 12" src="https://github.com/salgu1998/socket-echo-service/assets/76906458/05fcba2c-371a-406b-ace8-09ff4b0653e5">

### EchoClient
<img width="480" alt="스크린샷 2023-09-21 오후 7 33 34" src="https://github.com/salgu1998/socket-echo-service/assets/76906458/bac3c4d2-6d01-435e-851d-a9a5aef4ea4a">

### EchoClient2
<img width="483" alt="스크린샷 2023-09-21 오후 7 33 59" src="https://github.com/salgu1998/socket-echo-service/assets/76906458/bcf5515c-9e7f-4f09-ae22-b08b4c393303">


### Queue의 Size를 초과하였을때의 반환 값

<img width="597" alt="스크린샷 2023-09-21 오후 7 35 01" src="https://github.com/salgu1998/socket-echo-service/assets/76906458/2e7acfb9-8c2b-4b8e-ad83-7cbb118ffb48">
