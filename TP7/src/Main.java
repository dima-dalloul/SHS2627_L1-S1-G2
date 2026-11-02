public class Main {
    public static void main(String[] args) {
        char[] rotor1 = {'e','l','w','m','h','a','s','n','o','i','x','y','b','r','z','q','d','c','v','g','t','f','k','p','u','j'};
        char[] rotor2 = {'d','k','s','c','l','p','b','x','w','o','t','g','u','j','f','z','e','v','r','q','m','i','a','y','n','h'};
        char[] reflec = {'m','q','e','t','c','z','w','u','n','l','y','j','a','i','v','x','b','s','r','d','h','o','g','p','k','f'};

        // Je teste le rotor Aller
        System.out.println("Rotor Aller pour 'a' est " + passeUnRotorAller(rotor1, 'a'));
        System.out.println("Rotor Aller pour 'c' est " + passeUnRotorAller(rotor1, 'c'));
        System.out.println("Rotor Aller pour 'z' est " + passeUnRotorAller(rotor1, 'z'));

        // Je teste le rotor Retour
        System.out.println("Rotor Retour pour 'e' est " + passeUnRotorRetour(rotor1, 'e'));
        System.out.println("Rotor Retour pour 'a' est " + passeUnRotorRetour(rotor1, 'a'));
        System.out.println("Rotor Retour pour 'u' est " + passeUnRotorRetour(rotor1, 'u'));

        // Je teste le décodage
        System.out.println("Décodage de 'a' est " + decodeCar(rotor1, rotor2, reflec, 'a'));
        System.out.println("Décodage de 'h' est " + decodeCar(rotor1, rotor2, reflec, 'h'));
        System.out.println("Décodage de 'z' est " + decodeCar(rotor1, rotor2, reflec, 'z'));
    }

    /*
    passeUnRotorAller qui étant donné un tableau et un caractère renvoie le caractère
    correspondant dans le sens aller. Par exemple passeUnRotorAller(rotor1,'c') doit renvoyer
    'w'. Il faut juste utiliser le rang de la lettre dans l'alphabet pour trouver la lettre en sortie.
    Pour cela, rappelez-vous que les caractères peuvent être considérés comme des entiers et que
    donc 'c'-'a' vaut 2 ! Testez votre programme en affichant le résultat de cet exemple dans le
    main.
    */
    public static char passeUnRotorAller(char[] rotor, char charATrouver){
        // Pour rappel, 'c'-'a' vaut 2, car il compare les codes ASCII et renvoie l'indice de la lettre
        int indice = charATrouver - 'a';

        // Je récupère le caractère à l'indice trouvé
        char lettreATrouver = rotor[indice];

        // Je renvoie la lettre trouvée
        return lettreATrouver;
    }

    /*
    passeUnRotorRetour qui étant donné un tableau et un caractère renvoie le caractère
    correspondant au retour. Par exemple, passeUnRotorRetour(rotor1,'w') doit renvoyer 'c.
    Cette fois-ci, il faut chercher dans le tableau la position du caractère (par exemple, 2 pour 'w'
    et renvoyer le 3e caractère de l'alphabet). Tester votre programme comme précédemment.
    */
    public static char passeUnRotorRetour(char[] rotor, char caractereATrouver){
        int indiceLettreATrouver = -1;

        for(int i = 0; i < rotor.length; i++){
            if(caractereATrouver == rotor[i]){
               indiceLettreATrouver = i;
               break;
            }
        }

        char lettreTrouvee = (char) ('a' + indiceLettreATrouver);
        return lettreTrouvee;
    }

    /*
    • decodeCar qui étant donné les 3 tableaux et un caractère, renvoie le caractère associé. Utilisez
    les fonctions précédentes. Par exemple, avec 'a', la fonction doit renvoyer 'h' (
    Étape 1 : de 'a' à 'e' par le rotor 1
    Étape 2 :  de 'e' à 'l' par le rotor 2
    Étape 3 : de 'l' à 'j' par le déflecteur
    Étape 4 : de 'j' à 'n' par le rotor 2 inversé
    Étape 5 : de 'n' à 'h' par le rotor 1 inversé
    ). Testez votre programme et vérifiez que
    decodeCar('a') renvoie bien 'h' et que decodeCar('h') renvoie bien 'a'. Si ce n'est pas le cas,
    faites des affichages intermédiaires pour isoler le dysfonctionnement
     */
    public static char decodeCar(char[] rotor1, char[] rotor2, char[] reflec, char caractere){
        char etape1, etape2, etape3, etape4, etape5;

        // Étape 1 : de 'a' à 'e' par le rotor 1
        etape1 = passeUnRotorAller(rotor1, caractere);

        // Étape 2 :  de 'e' à 'l' par le rotor 2
        etape2 = passeUnRotorAller(rotor2, etape1);

        // Étape 3 : de 'l' à 'j' par le déflecteur
        etape3 = passeUnRotorAller(reflec, etape2);

        // Étape 4 : de 'j' à 'n' par le rotor 2 inversé
        etape4 = passeUnRotorRetour(rotor2, etape3);

        // Étape 5 : de 'n' à 'h' par le rotor 1 inversé
        etape5 = passeUnRotorRetour(rotor1, etape4);

        return etape5;
    }
}
