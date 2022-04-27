docker-app-build:
	docker build application -t aapozd/imet-bot:latest

docker-mongo-build:
	docker build mongo -t aapozd/imet-mongo:latest 

docker-build: docker-app-build docker-mongo-build

docker-compose-up:
	docker-compose -f docker-compose.yml up -d

docker-push:
	docker push aapozd/imet-bot:latest
	docker push aapozd/imet-mongo:latest

