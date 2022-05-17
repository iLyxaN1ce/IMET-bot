mongo-init:
	node mongo/mongo-scripts/script.js

docker-app-build:
	rm -rf ./application/src
	mv -f ./src ./application/src
	mv -f pom.xml ./application/pom.xml
	docker build application -t aapozd/imet-bot:latest

docker-mongo-build:
	docker build mongo -t aapozd/imet-mongo:latest 

docker-initiator-build:
	docker build mongoinit -t aapozd/imet-init:latest

docker-build: docker-app-build docker-mongo-build docker-initiator-build

docker-compose-up:
	docker-compose -f docker-compose.yml up -d

docker-push:
	docker push aapozd/imet-bot:latest
	docker push aapozd/imet-mongo:latest
	docker push aapozd/imet-init:latest

