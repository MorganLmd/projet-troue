# Projet pour le cours Cybersécurité du M1III

**Etudiant : Morgan Lombard**

## Consignes

**Ecrivez un projet sur lequel vous avez carte blanche (carte blanche sur le langage et les fonctionnalités du projet)
.**

### Pour que le projet soit reçevable, ses pré-requis sont :

- [ ] Le projet doit pouvoir être lancé avec une commande docker (et donc doit avoir un Dockerfile).
- [ ] Si la commande Docker ne fonctionne pas, la note sera sévère parce que je vais pas débugger le code de 30
  personnes.
- [ ] La commande doit apparaitre dans /README.md
- [ ] Le projet doit faire apparaitre un dossier /tests qui contiendra les tests unitaires qui permettraient de trouver
  les vulnérabilités dans votre code (vous avez carte blanche sur votre framework de test)
    - Par exemple : Un test d'injection SQL sur un paramètre GET
- [ ] Le projet doit faire un apparaitre un dossier /exploit qui contiendra les scripts qui permettront d'exploiter les
  vulnérabilités (vous avez carte blanche sur le langage du script, il faut que le script soit concis)
- [ ] Le projet doit être un dépôt github publique, pour que je puisse y jeter des coups d'oeil et pour les corrections
- [ ] Le code doit être lisible et donc correctement commenté pour quelqu'un qui n'est pas dev (genre moi) mais qui sait
  lire de code (pas de "i++; // on incrémente i"). Si le code n'est pas propre et me fait perdre du temps quand je le
  lis, il y aura des malus.
- [ ] Le fichier README.md doit faire apparaitre les objectifs de sécurité de l'application :
    - Ses objectif en Confidentialité, Intégrité et Disponibilité (note /5)
- [ ] Le fichier README.md doit faire apparaitre un graph mermaidjs avec la surface d'attaque
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

## Jalons

- **15/12/2020** | Création et invitation sur le repo Github
    - [ ] de **loris-intergalactique** en tant que collaborateur sur le projet
- **03/12/2020** | Je veux pouvoir lancer une image Docker et que tout fonctionne correctement.
    - [ ] La commande Docker à faire doit apparaître dans le README.
    - [ ] Expliquez dans le README ce que fait votre travail :)
    - [ ] La surface d'attaque doit être faite dans un fichier mermaidjs qui apparait dans le repo.
    - [ ] Vos objectifs de sécurité (C, I, D, T) doivent apparaitre : Une note/5 et une explication

## Sujet de l'application

## Architecture

### Base de données

### API

## Installation de l'application

### Commande Docker

<code>commande docker</code>

## Objectifs de sécurité

### Confidentialité

### Intégrité

### Disponibilité

## Surface d'attaque

## Analyse de sécurité

(Document Excel à créer)
