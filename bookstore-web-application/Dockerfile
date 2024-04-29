#stage 1
#Start with a base image containing Java runtime
FROM node:alpine as build

# Add Maintainer Info
LABEL maintainer=""

WORKDIR /usr/src/app

COPY . /usr/src/app

RUN npm install -g @angular/cli

RUN npm install

EXPOSE 4200

CMD ["ng", "serve", "--host", "0.0.0.0"]
