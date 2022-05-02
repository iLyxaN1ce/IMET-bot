FROM node:16-alpine3.14
WORKDIR /usr/app
COPY ./mongo-scripts /usr/app
RUN npm install mongoose 
CMD [ "node", "./script.js" ]