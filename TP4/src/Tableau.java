public class Tableau {
    public static void main(String[] args) {
        int[] t = {6,8,5,4,8,1,2,7,4,9,8,4,2,2,6,0,5,8,5,7,5,2,1,9};
        // Ecrire ci-dessous du code pour afficher la moyenne des éléments de t
        int somme = 0;
        double moyenne;

        for(int i = 0; i < t.length; i++){
            somme = somme + t[i];
        }

        moyenne = (double) somme / t.length;
        System.out.println("Moyenne = " + moyenne);

        // Ecrire ci-dessous du code pour afficher la plus petite valeur du tableau
        int min = t[0];     // Je prends le premier élément du tableau

        for(int i = 0; i < t.length; i++){
            if(min > t[i])
                min = t[i];
        }

        System.out.println("La plus petite valeur du tableau est : " + min);
    }
}
