docker-build:
	docker build . -t aapozd/imet-bot:latest

docker-push:
	docker push aapozd/imet-bot:latest