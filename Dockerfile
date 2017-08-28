FROM kyma/docker-nginx
COPY resources/public/ /var/www
CMD 'nginx'
