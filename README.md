**Chat App Backend.**

**Description**
---
A backend application where
- A user can register themself.
- Can login to create a jwt authentication token.
- Then using the jwt authentication token can get authenticated while calling the APIs.
- An authenticated user can create rooms.
- An authenticated user can broadcast messages in created rooms.
- An authenticated user can receive the message broadcasted in a room at real time.

**Prerequisites**
---
- Docker installed (no need for Java or Maven)

**How to test**
---
- Download just the docker-compose.yml file.
- In terminal navigate to path where docker-compose.yml is placed and run the command: docker-compose up
- The application will start running.
- Import the postman (collection and environment) in the postman app.
- Hit and test all the APIs present in collection.
- To publish any message, open the URL http://localhost:8080/index.html.
- Paste the token generated from the end point “Generate Jwt access token” and connect the websocket.
- Provide the message payload and click on send to broadcast the message.
- To terminate the application, open a new terminal window and give command: docker-compose down
