FROM mongo:4.4.13
ENV MONGO_INITDB_DATABASE=imet-db
ENV MONGO_INITDB_ROOT_USERNAME=aapozd
ENV MONGO_INITDB_ROOT_PASSWORD=312125
COPY mongo-scripts/* /docker-entrypoint-initdb.d/
CMD ["mongod"]