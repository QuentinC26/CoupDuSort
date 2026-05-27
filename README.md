# Coup du Sort

Coup du sort est un projet personnel. Le but de ce projet est de créer une application de tirage au sort avec différents thèmes et la possibilité d’appliquer des règles spécifiques. J’y ai occupé le rôle de développeur web full stack.

## Table des matières


- [Technologies utilisées](#technologiesutiliséés)
- [Installation](#installation)


## Technologies utilisées

Le projet Coup du Sort repose sur les technologies suivantes :

- **Back-end** : utilisation de [Spring Boot](https://spring.io/projects/spring-boot) pour la création d’API RESTful permettant de gérer des règles spécifiques liées aux différents tirages au sort.
- **Front-end** : [Angular](https://angular.dev/) pour une interface utilisateur réactive et moderne.

## Installation

Pour installer Coup du Sort sur votre ordinateur, commencez par cloner le dépôt GitHub. Cliquez sur le bouton vert « Code » puis copiez l’URL HTTPS ou SSH. Ensuite, exécutez la commande suivante dans votre terminal :

git clone https://github.com/QuentinC26/CoupDuSort.git

Une fois le projet cloné, installez les dépendances du front-end. Pour cela, rendez-vous dans le dossier correspondant :

cd front-end

Puis installez les dépendances avec la commande :

npm install

Ensuite, revenez à la racine du projet :

cd ..

Le lancement de l’application se fait via Docker. Aucune installation n’est nécessaire pour le back-end, celui-ci étant conteneurisé.

docker compose up
