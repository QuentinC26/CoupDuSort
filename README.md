# Coup du Sort

Coup du sort est un projet personnel. Le but de ce projet est de créer une application de tirage au sort avec différents thèmes et la possibilité d’appliquer des règles spécifiques. J’y ai occupé le rôle de développeur web full stack.

## Table des matières

- [Technologies utilisées](#technologiesutiliséés)
- [Installation](#installation)
- [Fonctionnalités de l'application](#Fonctionnalitésdel'application)
- [License](#licence)
- [Contributeurs](#contributeurs)

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

## Fonctionnalités de l'application

Coup du Sort est une application de tirage au sort proposant plusieurs modes :

- **Tirage classique** : effectue un tirage au sort parmi une liste de participants définie par l'utilisateur.

- **Tirage avec interdictions** : permet de définir des contraintes afin qu'un participant ne puisse pas être tiré après un autre. Par exemple, pour éviter qu'un couple s'offre un cadeau lors d'un Secret Santa.

- **Tirage avec chapeaux** : permet de répartir les participants dans plusieurs chapeaux avant le tirage. Ce mode est pratique pour organiser des compétitions sportives, comme les tirages des Coupes du monde.

- **Tirage avec interdictions et chapeaux** : combine les deux fonctionnalités précédentes. Par exemple, il est possible de répartir les équipes par niveau dans différents chapeaux tout en empêchant que des pays d'un même continent se retrouvent dans le même groupe.

## Licence

Ce projet est licencié sous la licence MIT - voir le fichier LICENSE pour plus de détails.

## Contributeurs

Le projet a été créé par **Quentin Zuzlewski** (QuentinC26). Il est le développeur full stack principal de ce projet.  
Pour toute question sur le projet, vous pouvez le contacter à l'adresse email suivante : **qzuzlewski@gmail.com**
<br></br>
<a href="https://github.com/QuentinC26">
  <img src="https://github.com/QuentinC26.png" alt="QuentinC26" width="30" height="30"/>
</a>
<br></br>
Pour la liste complète des contributeurs et leurs rôles, consultez le fichier [CONTRIBUTORS.md](CONTRIBUTORS.md).
