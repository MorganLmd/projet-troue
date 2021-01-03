# Projet pour le cours Cybersécurité du M1III

**Etudiant : Morgan Lombard**

<hr>

## Consignes

**Ecrivez un projet sur lequel vous avez carte blanche (carte blanche sur le langage et les fonctionnalités du projet)
.**

### Pour que le projet soit reçevable, ses pré-requis sont :

- [X] Le projet doit pouvoir être lancé avec une commande docker (et donc doit avoir un Dockerfile).
- [X] La commande doit apparaitre dans /README.md
- [ ] Le projet doit faire apparaitre un dossier /tests qui contiendra les tests unitaires qui permettraient de trouver
  les vulnérabilités dans votre code (vous avez carte blanche sur votre framework de test)
    - Par exemple : Un test d'injection SQL sur un paramètre GET
- [ ] Le projet doit faire un apparaitre un dossier /exploit qui contiendra les scripts qui permettront d'exploiter les
  vulnérabilités (vous avez carte blanche sur le langage du script, il faut que le script soit concis)
- [X] Le projet doit être un dépôt github publique, pour que je puisse y jeter des coups d'oeil et pour les corrections
- [] Le code doit être lisible et donc correctement commenté pour quelqu'un qui n'est pas dev (genre moi) mais qui sait lire de code (pas de "i++; // on incrémente i").
- [X] Le fichier README.md doit faire apparaitre les objectifs de sécurité de l'application :
    - Ses objectif en Confidentialité, Intégrité et Disponibilité (note /5)
- [X] Le fichier README.md doit faire apparaitre un graph mermaidjs avec la surface d'attaque
- [ ] Un fichier Excel avec la même analyse de sécurité que le premier TP doit aussi apparaitre.

### Exemple de vulnérabilités à inclure

- [ ] Injection de commande (bash)
- [ ] Injection SQL
- [ ] Injection XSS
- [ ] Injection NoSQL
- [ ] Injection de template
- [ ] SSRF
- [ ] CSRF
- [ ] IDOR

<hr>

## Jalons

- **15/12/2020** | Création et invitation sur le repo Github
    - [X] de **loris-intergalactique** en tant que collaborateur sur le projet
- **03/12/2020** | Je veux pouvoir lancer une image Docker et que tout fonctionne correctement.
    - [X] La commande Docker à faire doit apparaître dans le README.
    - [X] Expliquez dans le README ce que fait votre travail :)
    - [X] La surface d'attaque doit être faite dans un fichier mermaidjs qui apparait dans le repo.
    - [X] Vos objectifs de sécurité (C, I, D, T) doivent apparaitre : Une note/5 et une explication

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

## Objectifs de sécurité
### Confidentialité
#### Entité User
**Objectif :** Sécuriser l'accès aux données personnelles d'un utilisateur (adresse, mot de passe etc.)
**Niveau actuel :** 0/5

**Objectif :** filtrer l'accès aux méthodes du endpoint /users
**Niveau actuel :** 0/5

#### Entité Book
**Objectif :** filtrer l'accès aux méthodes du endpoint /books
**Niveau actuel :** 0/5

======================================

### Intégrité
#### Entité User
**Objectif :** Empêcher la corruption des données d'un utilisateur
**Niveau actuel :** 0/5

**Objectif :** Empêcher la suppression des données d'un utilisateur
**Niveau actuel :** 0/5

#### Entité Book
**Objectif :** Empêcher la corruption des données d'un livre
**Niveau actuel :** 0/5

**Objectif :** Empêcher la suppression des données d'un livre
**Niveau actuel :** 0/5

======================================

### Disponibilité
**Objectif :** Adapter la disponibilité des données d'un utilisateur en fonction des besoins
**Niveau actuel :** Sur-disponibilité -> 0/5

======================================

### Traçabilité
**Objectif :** Système de log de toutes les opérations sur la base de données et d'activités du serveur.
**Niveau actuel :** 0/5

<hr>

## Surface d'attaque

[![](https://mermaid.ink/img/eyJjb2RlIjoiZ3JhcGggVERcbiAgICBBW09TXSAtLT4gQltET0NLRVJdXG4gICAgQiAtLT4gQ1tTRVJWRVVSIEFQUF1cbiAgICBCIC0tPiBEW1NFUlZFVVIgQkREXVxuICAgIEQgLS0-IEhbQkREIEgyXVxuICAgIEMgLS0-IEVbQVBJIEpBVkEgU1BSSU5HQk9PVF1cbiAgICBIIC0uT1JNIEpQQS4tIEVcbiAgICBFIC0tPiBGW0VORFBPSU5UIC9hcGkvdXNlcnNdXG4gICAgRSAtLT4gR1tFTkRQT0lOVCAvYXBpL2Jvb2tzXVxuICAgIEUgLS0-IElbRU5EUE9JTlQgL2FwaS9hZG1pbl1cbiAgICBcbiAgICAgICAgICAgICIsIm1lcm1haWQiOnt9LCJ1cGRhdGVFZGl0b3IiOmZhbHNlfQ)](https://mermaid-js.github.io/mermaid-live-editor/#/edit/eyJjb2RlIjoiZ3JhcGggVERcbiAgICBBW09TXSAtLT4gQltET0NLRVJdXG4gICAgQiAtLT4gQ1tTRVJWRVVSIEFQUF1cbiAgICBCIC0tPiBEW1NFUlZFVVIgQkREXVxuICAgIEQgLS0-IEhbQkREIEgyXVxuICAgIEMgLS0-IEVbQVBJIEpBVkEgU1BSSU5HQk9PVF1cbiAgICBIIC0uT1JNIEpQQS4tIEVcbiAgICBFIC0tPiBGW0VORFBPSU5UIC9hcGkvdXNlcnNdXG4gICAgRSAtLT4gR1tFTkRQT0lOVCAvYXBpL2Jvb2tzXVxuICAgIEUgLS0-IElbRU5EUE9JTlQgL2FwaS9hZG1pbl1cbiAgICBcbiAgICAgICAgICAgICIsIm1lcm1haWQiOnt9LCJ1cGRhdGVFZGl0b3IiOmZhbHNlfQ)

La liaison en pointillés montre l'ORM utilisé pour l'accès à la base de données.

<hr>

## Analyse de sécurité

(Document Excel à créer)
