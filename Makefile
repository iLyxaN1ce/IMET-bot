docker-app-build:
	docker build application -t aapozd/imet-bot:latest

docker-compose-up:
	docker-compose -f docker-compose.yml up -d

docker-mongo-fix:
	mkdir -p ./home/mongodb
	touch ./home/mongodb/.dbshell
	chown -R 999:999 ./home/mongodb
