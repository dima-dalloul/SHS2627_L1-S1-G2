import java.util.Arrays;

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

        // Je teste le décodage de caractères
        System.out.println("Décodage de 'a' est " + decodeCar(rotor1, rotor2, reflec, 'a'));
        System.out.println("Décodage de 'h' est " + decodeCar(rotor1, rotor2, reflec, 'h'));
        System.out.println("Décodage de 'z' est " + decodeCar(rotor1, rotor2, reflec, 'z'));

        // Je teste le décodage de message
        System.out.println("Le message encodé est : " + decodeMsgQuestionB("ugdxl avtgvl ov bheh qhg lvkhxzv evgl sh ovtixvkv hzzvv zdtl vkkvzv", rotor1, rotor2, reflec));

        // Je teste le décalage de tableau
        char[] t = {'a','b','c','d'};
        System.out.println(Arrays.toString(t));
        decaler(t);
        System.out.println(Arrays.toString(t));

        // Je teste le décalage des rotors avec le décodage du message
        System.out.println("Le message encodé est : " + decodeMsgQuestionD("ypoyarhcmsejvud nfs zpl isw uvssacwvv", rotor1, rotor2, reflec));
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

    /**
     * Écrire la fonction decodeMsg pour décoder, caractère par caractère, une chaîne. Si un caractère est
     * un espace, ne le décodez pas, recopiez-le tel quel dans la chaîne résultat. Utilisez votre programme pour
     * décoder le message :
     * ugdxl avtgvl ov bheh qhg lvkhxzv evgl sh ovtixvkv hzzvv zdtl vkkvzv
     */
    public static String decodeMsgQuestionB(String chaineADecoder, char[] rotor1, char[] rotor2, char[] reflec){
        String resultatDecodage = "";   // chaîne de caractères à renvoyer, au début elle est vide

        // j'itère sur chaque caractère de la chaîne à décoder
        for(int i = 0; i < chaineADecoder.length(); i++){
            // si le caractère est un espace, je le recopie tel quel dans la chaîne résultat
            if(chaineADecoder.charAt(i) == ' ')
                resultatDecodage += ' ';
                // Équivalent à resultatDecodage = resultatDecodage + ' ';

            else{
                // si ce n'est pas un espace, on  le décode
                char lettreADecoder = decodeCar(rotor1, rotor2, reflec, chaineADecoder.charAt(i));
                resultatDecodage += lettreADecoder;
                // Équivalent à resultatDecodage = resultatDecodage + lettreADecoder;
            }
        }
        return resultatDecodage;
    }

    /**
     * Écrire l'action decaler qui, étant donné un tableau de caractères, décale ses éléments d'un cran vers le
     * début, le premier élément étant affecté à la dernière case du tableau. Attention à l'ordre dans lequel
     * vous faites ces opérations. Testez cette action. Pour cela, vous pouvez afficher le contenu d'un tableau
     * en écrivant votre propre action ou en utilisant la fonction Arrays.toString (en ayant ajouté import
     * java.util.Arrays; au début du programme). Voici une façon de tester votre action decaler :
     * char[] t = {'a','b','c','d'};
     * System.out.println(Arrays.toString(t));
     * decaler(t);
     * System.out.println(Arrays.toString(t));
     */
    public static void decaler(char[] tableau){
        // Je récupère le premier caractère et le met de côté
        char premierCaractere = tableau[0];

        // J'itère sur les autres caractères du tableau et je les décale vers indice - 1
        for(int i = 1; i < tableau.length; i++){
            tableau[i-1] = tableau[i];
        }

        // Je place le premier caractère au bout du tableau
        tableau[tableau.length-1] = premierCaractere;
    }


    /**
     * Lorsque le rotor 1 a fait un tour complet, il décale d'un cran le rotor 2, comme dans un compteur
     *     kilométrique de voiture. Modifier la fonction decodeMsg pour prendre en compte ces décalages.
     *     Vous devriez alors pouvoir décoder ce message :
     * ypoyarhcmsejvud nfs zpl isw uvssacwvv
     */
    public static String decodeMsgQuestionD(String messageADecoder, char[] rotor1, char[] rotor2, char[] reflec){
        String resultatDecodage = "";   // chaîne de caractères à renvoyer, au début elle est vide
        int compteurDecalages = 0;

        // j'itère sur chaque caractère de la chaîne à décoder
        for(int i = 0; i < messageADecoder.length(); i++){
            // si le caractère est un espace, je le recopie tel quel dans la chaîne résultat
            if(messageADecoder.charAt(i) == ' ')
                resultatDecodage += ' ';
                // Équivalent à resultatDecodage = resultatDecodage + ' ';

            else{
                // si ce n'est pas un espace, on  le décode
                char lettreADecoder = decodeCar(rotor1, rotor2, reflec, messageADecoder.charAt(i));
                resultatDecodage += lettreADecoder;
                // Équivalent à resultatDecodage = resultatDecodage + lettreADecoder;
            }

            // Peu importe le caractère décodé, je décale le rotor 1
            decaler(rotor1);
            compteurDecalages++;

            // Si le compteur de décalages est égal à 26, je décale le rotor 2
            if(compteurDecalages == 26){
                decaler(rotor2);
                compteurDecalages = 0;
            }
        }
        return resultatDecodage;
    }

}
