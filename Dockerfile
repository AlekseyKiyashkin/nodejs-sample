FROM node:alpine

LABEL maintainer="akiyashkin@gmail.com"

WORKDIR /app

COPY /package.json .
RUN npm install
COPY . .

CMD ["node", "index.js"]