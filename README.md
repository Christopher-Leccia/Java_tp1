# TPS JAVA - LEARNINGSOULSGAME - LOMER Ewen / LECCIA Christopher - Ingésup B3

### Réponses aux questions

#### TP1

6) Quelle est la visibilité optimale pour isAlive dans cette configuration ? Pourquoi ?

La visibilité optimale pour isAlive dans cette configuration est 'default/friendly'. Elle nous permet d'avoir une sécurité maximum tout en limitant un maximum les accès à la méthode comme isAlive et le main sont dans le même paquet.


7) Quelle est la visibilité optimale pour isAlive dans cette configuration ? Pourquoi ?

Comme isAlive et le main ne sont pas dans le même paquet, le niveau de sécurité maximum disponible est fourni par 'public'.

#### TP2

1.2) Pour afficherdynamiquementle nom de la classe (le « [ Hero ] » et « [ Monster ] »), vous utiliserez un appel à getClass().getSimpleName(). Cherchez ces méthodes dans la documentation officielle Java. Comment cela fonctionne-t-il ?

Cette méthode récupère le nom de la classe pour laquelle la méthode est utilisée.


1.2) Il faudra certainement passer des membres de private à protected. Pourquoi ?

Le fait de devoir passer des membres de private à protected est dû au fait que l'on change de classe.


6) Que remarquez-vous au niveau de la durabilité de l'épée? Pourquoi?

La durabilité de l'épée descend aussi bien lorsque le héros attaque ou le monstre attaque. Du fait que l'on instancie la même épée aux 2 personnages (héro et monstre), la durabilité de l'épée est commune aux deux personnages.

#### TP3

4.2)
L'erreur présentée sur les classes Hero et Monster est du au fait qu'il faut implementer la méthode abstraite computeProtection dans les sous-classes de la classe abstraite Character

#### TP4

3.3)
Il est précisé dans la documentation qu'il n'est pas garanti, que dans l'itération, l'ordre des entrées reste le même que lors de la déclaration.

3.4)
Dans la documenation officiel il est précisé que grâce a une liste 'liée' il est possible de connaitre l'ordre d'itération des élément présent dans le HashSet, c'est dans l'ordre d'insertion des données.

#### TP6

2.2)
Puisque nous avons set l'arme de notre héro à 'null' le programme ne peux pas continuer de fonctionner.
