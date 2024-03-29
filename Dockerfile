FROM nginx:stable-alpine3.17
# copy
COPY nginx/conf.d/default.conf /etc/nginx/conf.d/default.conf
COPY nginx/html /usr/share/nginx/html/
# expose port
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]