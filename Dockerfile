FROM nginx:stable-alpine
# upgrade and install node and pm2
RUN apk update; apk upgrade;
RUN apk add nodejs npm
RUN npm install --global pm2
# copy
COPY nginx/conf.d/default.conf /etc/nginx/conf.d/default.conf
COPY nginx/html /usr/share/nginx/html/
COPY opt/renderer/package.json /
#COPY docker-entrypoint.sh /
# nodejs
WORKDIR /
RUN npm install
# expose port
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]