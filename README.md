# Setup
## Install docker
````
sudo apt install docker.io
````
## Run server
````
docker build -f .\DockerfileServer -t banking-server .
````
````
docker run -p 8080:8080 banking-server 
````
## Run client
````
docker build -f .\DockerfileClient -t banking-client .
````
````
docker run  banking-client
````
## Run both for testing of the setup
````
docker compose up --build
````