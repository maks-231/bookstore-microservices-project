#stage 1
#Start with a base image containing Java runtime
FROM node:20-alpine3.18 as build

# Add Maintainer Info
LABEL maintainer=""

WORKDIR /usr/src/app

COPY . /usr/src/app
#RUN npm config delete proxy
RUN npm config set proxy http://192.168.70.12:3128
RUN npm install -g @angular/cli -verbose
RUN ng generate environments

RUN npm install

EXPOSE 4200

CMD ["ng", "serve", "--host", "0.0.0.0"]
