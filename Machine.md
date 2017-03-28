#Machine a état

Implémentation simple d'une machine à état contenant 3 états (1, 2 et 3) et 4 transitions (1 -> 2, 2 -> 3, 3 -> 1 et 3 -> 2).

```java
class MachineAEtat {

	boolean condition;

	enum Etat {
		Etat_1,
		Etat_2,
		Etat_3
	}

	Etat e = Etat.Etat_1;

	public void transition() {
		switch(e) {

			case Etat_1: 		// Etat_1 -> Etat_2

				//Actions ...

				e = Etat.Etat_2;
			break;

			case Etat_2: 		// Etat_2 -> Etat_3

				//Actions ...

				e = Etat.Etat_3;
			break;

			case Etat_3: 
				if(condition) {	// Etat_3 -> Etat_1

					//Actions ...

					e = Etat.Etat_1;
				} else {		// Etat_3 -> Etat_2

					//Actions ...

					e = Etat.Etat_2;
				}
			break;
			}
	}
}
```
