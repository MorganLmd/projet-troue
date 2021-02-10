
# Projet pour le cours Cybersécurité du M1III

**Etudiant : Morgan Lombard**
<hr>  

## Consignes

**Réalisation d'une application sécurisée et analyse de moyens mis en place pour sa sécurité**

### Pour que le projet soit reçevable, ses pré-requis sont :
- Pour chaque fonctionnalité de sécurité que vous ajoutez (ORM par exemple) :
  - Vous décrivez de quoi la fonctionnalité protège votre code
  - Vous décrivez comment la fonctionnalité protège votre code
  - Vous définissez le(s) mécanisme(s) ET le(s) principe(s) de sécurité que votre code implique ;
  - Décrivez les tests que vous feriez pour vérifier que cet endpoint (cette page web) n'est pas vulnérable (Les tests vont vous permettre de renforcer l'implémentation des principes de dev sécurisés)
  - (En bonus) Quel impact aurait eu cette vulnérabilité sur votre métier (Injection SQL => Fuite de données => Incident diplomatique => vous fermez votre business)


## Jalons

- **15/12/2020** | Création et invitation sur le repo Github
  - [X] de **loris-intergalactique** en tant que collaborateur sur le projet
- **03/12/2020** | Je veux pouvoir lancer une image Docker et que tout fonctionne correctement.
  - [X] La commande Docker à faire doit apparaître dans le README.
  - [X] Expliquez dans le README ce que fait votre travail :)
  - [X] La surface d'attaque doit être faite dans un fichier mermaidjs qui apparait dans le repo.
  - [X] Vos objectifs de sécurité (C, I, D, T) doivent apparaitre : Une note/5 et une explication
- **10/02/2020** Rendu Final

<hr>  


## Sujet de l'application
Cette API est une petite application qui permet à des utilisateurs de lister les livres qu'ils possèdent. Les fonctions principales de l'API consisteront donc à permettre la création et la modification des utilisateurs (User) et des livres (Books).

### Architecture
Le projet est une simple API multi couche : endpoints => couche accès aux données => base de données. L'API est codée en java avec le framework Spring. L'ORM (Object Relationnal Mapping) JPA (Java Persistence API : ORM standard Java) gère les transactions objet/relationnel et les connexions avec la base de données.   
La programmation évite volontairement toutes les bonnes pratiques de développement et de sécurisation d'une véritable API multi-couche dans le but de facilement mettre en évidence les différentes failles possibles telles qu'on les trouve encore sur de nombreux sites amateurs.

### Base de données
Base de données H2 stockées en mémoire pour faciliter l'utilisation et les tests. C'est un système de gestion de base de données relationnelles basé sur le langage SQL.

<hr>  

## Installation de l'application

### Commande Docker

Pour télécharger et lancer l'image Docker exécuter cette commande dans un terminal

<code>docker run --name morganlombard-projettroue -p 8080:8080 morganlmd/projettroue</code>

l'application sera dès lors accessible à cette adresse : http://localhost:8080

Pour fermer l'application dans le terminal <code>ctrl + c</code>

Pour relancer le container si l'application est fermée <code>docker start morganlombard-projettroue</code>

Pour stoper le container <code>docker stop morganlombard-projettroue</code>

<hr>  

## Base de données
[![](https://mermaid.ink/img/eyJjb2RlIjoiZXJEaWFncmFtXG4gICAgICAgICAgVVNFUiB9fC4ufHsgQk9PSyA6IGhhc1xuXG4gICAgICAgICAgICAiLCJtZXJtYWlkIjp7fSwidXBkYXRlRWRpdG9yIjpmYWxzZX0)](https://mermaid-js.github.io/mermaid-live-editor/#/edit/eyJjb2RlIjoiZXJEaWFncmFtXG4gICAgICAgICAgVVNFUiB9fC4ufHsgQk9PSyA6IGhhc1xuXG4gICAgICAgICAgICAiLCJtZXJtYWlkIjp7fSwidXBkYXRlRWRpdG9yIjpmYWxzZX0)

### Tables
- **User** : contient les données utilisateur (nom, username, mot de passe, numéro de carte de crédit etc.)
- **Book** : contient toutes les métadonnées d'un livre
- **User_Book** : contient les liens entre user et book (les livres possédés par les users)

## Objectifs de sécurité
|---|Confidentialité|Intégrité|Disponibilité|Traçabilité|
|--|--|--|--|--|
|**User**| 5/5 --- Les données users sont fortement confidentielle, notamment les numéro de carte bancaire. Une fuite entrainement une perte de confiance des utilisateurs et donc une perte de business  | 2/5 --- Hormis les identifiants qui doivent rester inchanger, le reste des données users n'est pas très sensible à la perte d'intégrité. Il sera toujours possible de changer un mot de passe, une cb etc. | 3/5 --- Une perte de disponibilité entrainement une perte de l'accès des users clients à leur compte et donc à leur achats. Le risque n'est pas majeur mais pourrait induire une perte de business  | 5/5 ---  Toutes les opérations sur les users doivent être tracées. Il est important de pourrait retrouver quand un user a été compromis  |
|**Book**| 0/5 --- Il n'y a aucune information confidentielle dans la table livre donc aucun impact majeur si elle venait à fuiter. Le seul impact serait plutôt en terme de business puisque qu'un concurent pourrait se réapproprier le travail gratuitement | 3/5 --- Les données d'un livre doivent être le plus stable possible au niveau des id et isbn puisque qu'il n'y a aucune raison de les faire évoluer. Une perte d'intégrité induirer un déréférencement de certains ouvrages. Notammment au niveau de l'ISBN qui est l'identifiant international du livre. Une perte d'intégrité induirait une perte de business, les clients iraient voir ailleurs.  | 4/5 --- Une perte de disponibilité entrainement une perte de business, les livres référencés étant la raison pour laquelle cette application est utilisée |4/5 --- La traçabilité est importante pour cette table puisqu'elle permettrait de détecter si un livre a été modifié et quand cela a été fait |
| **User_Book**| 2/5 ---  La confidentialité de ce données n'est pas critique, il y aurait toutefois une perte de confiance de l'utilisateurs si la liste de ses achats venait à fuiter| 5/5 --- L'intégrité de ces données est essentielle, une perte d'intégrité de cette table revient à retirer des livres achetés à certains clients ou d'en ajouter à d'autre. Critique pour le business | 4/5 --- La disponibilité de ces données est essentielles puisque ces ce qui permettrait de donner des accès de téléchargement selon les livres achetés| 4/5 --- la traçabilité est donc essentielle puisque qu'en cas de corruption des données il faudra retrouver quand elle a eu lieu|

<hr>  

## Surface d'attaque

[![](https://mermaid.ink/img/eyJjb2RlIjoiZ3JhcGggVERcbiAgICBBW09TXSAtLT4gQltET0NLRVJdXG4gICAgQiAtLT4gQ1tTRVJWRVVSIEFQUF1cbiAgICBCIC0tPiBEW1NFUlZFVVIgQkREXVxuICAgIEQgLS0-IEhbQkREIEgyXVxuICAgIEMgLS0-IEVbQVBJIEpBVkEgU1BSSU5HQk9PVF1cbiAgICBIIC0uT1JNIEpQQS4tIEVcbiAgICBFIC0tPiBGW0VORFBPSU5UIC9tYW5hZ2VtZW50L3VzZXJzXVxuICAgIEUgLS0-IEdbRU5EUE9JTlQgL2FwaS9ib29rc11cbiAgICBcbiAgICAgICAgICAgICIsIm1lcm1haWQiOnt9LCJ1cGRhdGVFZGl0b3IiOmZhbHNlfQ)](https://mermaid-js.github.io/mermaid-live-editor/#/edit/eyJjb2RlIjoiZ3JhcGggVERcbiAgICBBW09TXSAtLT4gQltET0NLRVJdXG4gICAgQiAtLT4gQ1tTRVJWRVVSIEFQUF1cbiAgICBCIC0tPiBEW1NFUlZFVVIgQkREXVxuICAgIEQgLS0-IEhbQkREIEgyXVxuICAgIEMgLS0-IEVbQVBJIEpBVkEgU1BSSU5HQk9PVF1cbiAgICBIIC0uT1JNIEpQQS4tIEVcbiAgICBFIC0tPiBGW0VORFBPSU5UIC9tYW5hZ2VtZW50L3VzZXJzXVxuICAgIEUgLS0-IEdbRU5EUE9JTlQgL2FwaS9ib29rc11cbiAgICBcbiAgICAgICAgICAgICIsIm1lcm1haWQiOnt9LCJ1cGRhdGVFZGl0b3IiOmZhbHNlfQ)  
La liaison en pointillés montre l'ORM utilisé pour l'accès à la base de données.

<hr>  

## Analyse de sécurité

### Framework Spring Rest (contre XSS)
Le fait de gérer une API stateless qui ne revoit que des json délègue la responsabilité de la gestion des XSS aux autres applications qui vont faire appel à cette API. En lui même le json ne présente pas de risque, par que, l'application qui va traiter ce json devra s'assurer qu'il ne contient pas de code malicieux.
### ORM JPA (contre injection SQL)
L'implémentation de l'ORM JPA (standard Java) permet de déléguer la responsabilité de la génération des requêtes SQL et de leur traitement à une dépendance fortement maintenue et soutenue par l'industrie. Cela permet d'éviter les erreurs de développerment qui laisserait une requête malicieuse être insérée dans la base de données.
### Spring security (pour l'authenfication et l'autorisation)
Spring security est une librairie Spring pour gérer la sécurité de son application. Elle permet de choisir facilement le type de sécurité (basic auth, form auth etc.), l'agorithme de chiffrement des mots de passe (Bcrypt, MD5 etc.). C'est avec cette librairie que l'on peut peut sécuriser les endpoints selon les roles et les autorisations. Un système de filter chainé permet de faire passer chaque requête http au travers d'un système de contrôle (authentification, validation de token etc.)
### Depandabot (alerte sur les dépendances)
Dependabot a été mis en place sur le repository GitHub afin d'être alerté en temps réel sur les alerte de sécurité et de mise à jour des dépendances du projet. Cela permet une gestion facilité des dépendances, une mise à jour régulière de celle-ci permet de ne pas accumuler de dette technique (notamment sur les fonctions dépréciées) et donc de limiter les risques de faille de sécurité.
### JWT (token)
JWT permet de fournir des tokens au application un moye de communication sécurisé. En effet le token généré par le serveur est controlable par les deux parties en communication ce qui permet de vérifier son intégrité. Toutefois celui-ci contient la clé secrète qui si elle venait à fuiter, compromettrait sérieusement la sécurité du serveur.
### HTTPS
Pour éviter que cela n'arrive, il est indispensable de mettre en place un certificat de sécurité https afin de sécuriser les échanges avec l'API. Cela permet également de protéger les en-tête des requêtes http qui contient notamment les tokens d'accès.
### CSRF
Le contrôle CSRF de l'application qui est nativement pris en charge par Spring Security a été désactivé sur les recommandation de la documentation officielle. L’objet de cette attaque est de transmettre à un utilisateur authentifié une requête HTTP falsifiée qui pointe sur une action interne au site, afin qu'il l'exécute sans en avoir conscience et en utilisant ses propres droits (wikipedia). Comme cette API n'a vocation qu'à la communication entre applications, la protection contre les CSRF n'est pas indispensable.
