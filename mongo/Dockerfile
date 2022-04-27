FROM mongo:4.4.13
COPY mongo-scripts/* /docker-entrypoint-initdb.d/
RUN mkdir -p /home/mongodb && \
  touch /home/mongodb/.dbshell && \
	chown -R 999:999 /home/mongodb
CMD ["mongod"]