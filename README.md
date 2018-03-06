TP1

6)Quelle est la visibilité optimale pour isAlive dans cette configuration ? Pourquoi ?

La visibilité optimale pour isAlive dans cette configuration est 'default/friendly'. Elle nous permet d'avoir une sécurité maximum tout en limitant un maximum les accès à la méthode comme isAlive et le main sont dans le même paquet.


7)Quelle est la visibilité optimale pour isAlive dans cette configuration ? Pourquoi ?

Comme isAlive et le main ne sont pas dans le même paquet, le niveau de sécurité maximum disponible est fourni par 'public'.




TP2

1.2)Il faudra certainement passer des membres de private à protected. Pourquoi ?

Le fait de devoir passer des membres de private à protected est dû au fait que l'on change de classe.