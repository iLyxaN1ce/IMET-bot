docker-app-build:
	docker build application -t aapozd/imet-bot:latest

docker-mongo-build:
	docker build mongo -t aapozd/imet-mongo:latest

docker-compose-up:
	docker-compose -f docker-compose.yml up -d

docker-mongo-fix:
	mkdir -p mongo/home/mongodb
	touch mongo/home/mongodb/.dbshell
	chown -R 999:999 mongo/home/mongodb
