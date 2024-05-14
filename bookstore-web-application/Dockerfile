#stage 1
#Start with a base image containing Java runtime
FROM node:22-alpine3.18 as build

# Add Maintainer Info
LABEL maintainer=""

WORKDIR /usr/src/app

COPY . /usr/src/app

RUN npm install @angular/cli -verbose

RUN npm install

EXPOSE 4200

CMD ["ng", "serve", "--host", "0.0.0.0"]
