# Quarto

## Introduction

Le but de ce projet sera l'implémentation pour Android du jeu Quarto.

### Les règles du Quarto

Le jeu est composé

 * d'un plateau du jeu de 4x4 cases
 * de 16 pièces: noire ou blanche, ronde ou carrée, a bordure doulbe ou non, contenant une croix ou non.

A chaque tour:

 * Le premier joueur choisit une pièce de sa couleur et la donne à son adversaire qui la place sur le plateau.

Un joueur gagne si:

 * Il place la dernière pièce d'une ligne, colonne ou diagonale dont les 4 pièces possèdent une caractéristique commune. (Toutes de la même couleur, toutes de la même forme, etc...) 

### Objectifs

L'application finale sera composé d'au moins:

 * Un **Menu** qui servira d'écran d'accueil et qui permettra de lancer une partie.

![Menu](img/doc/Menu.png)

 * Une fois dans la partie le **Plateau** de jeu ainsi que la main du joueur dont c'est le tour apparaîtront.

![Menu](img/doc_mini/Debut.png)
![Menu](img/doc_mini/Pick.png)
![Menu](img/doc_mini/Place.png)
![Menu](img/doc_mini/Coup.png)
![Menu](img/doc_mini/Fin.png)



## Installation d'Android studio

### Objectifs

 * Installer Android studio

### Détails

 * Activez dans le bios les options de virtualisation
 * Ouvrez un terminal est installer les packets nécéssaires pour l'émulateur Android (AVD)
```
sudo apt-get install qemu-kvm libvirt-bin ubuntu-vm-builder bridge-utils
```
La commande

```
sudo kvm-ok
```
devrait maintenant retourner:
```
INFO: /dev/kvm exists
KVM acceleration can be used
```
 * Installer Android studio

[Télécharger l'archive](https://developer.android.com/studio/index.html)

Décompressez la, ouvrez un terminal dans le dossier extrait, et lancez
```
./bin/studio.sh
```


## Hello World!

### Objectifs

 * Créer un première application contenant le message "Hellow World!" et la lancer sur un appareil virtuel.

### Détails

 * Voir sur [OpenClassroom](https://openclassrooms.com/courses/developpez-une-application-pour-android/)

## Menu

### Objectifs

 * Créer une application contenant deux activité. Un bouton présent sur la première permet, une fois activé de passer à la seconde.
 * Utiliser le Moniteur Android pour logger le comportement de l'application.

![Menu](img/doc_mini/Menu.png)

### Détails

 * Voir sur [OpenClassroom](https://openclassrooms.com/courses/developpez-une-application-pour-android/)


## Plateau

### Objectifs

 * Afficher plateau, boutons et images

![Menu](img/doc_mini/Debut.png)

### Détails

 * Les images des pièces se trouvent dans `img/pieces`
 * Un layout de type TableLayout et des Widgets de type ImageButton peuvent être utilisés.

## Premier coup

### Objectifs
![Menu](img/doc_mini/Pick.png)


## Logique du jeu

### Objectifs

![Menu](img/doc_mini/Coup.png)

 * Les classes Piece, Joueur, Partie
 * Les event listener
 * Les machines à état ([Aide ici](Machine.md))

![Menu](img/doc/FSM.png)

## Améliorations

### Objectifs

 * Ajouter un ecran de victoire

![Menu](img/doc_mini/Coup.png)

 * Ajouter un son et/ou une vibration lorsqu'une pièce est posée.

![Menu](img/doc_mini/Fin.png)

 * Changer la couleur du fond en fonction du joueur don c'est le tour.

 * Remplacer la vue de la main du joueur qui a choisi la pièce, lorsque son adversaire doit la pauser, par la pièce en question seule.

## En ligne

### Objectifs

A venir


