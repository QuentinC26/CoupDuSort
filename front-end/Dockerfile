FROM node:22
WORKDIR /front-end
COPY package*.json ./
RUN npm install
COPY . . 
EXPOSE 4200
# npm start éxécute le script start du package.json.
# -- permet de dire que les arguments suivants doivent être transmis au script
# --host 0.0.0.0 permet d’accéder à l’application depuis ton navigateur.
CMD ["npm", "start", "--", "--host", "0.0.0.0"]
