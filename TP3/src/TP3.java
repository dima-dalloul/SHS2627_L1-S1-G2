import java.util.Scanner;

public class TP3 {
    public static void main(String[] args){
        int score = 0, nbLettres = 7;
        Scanner s = new Scanner(System.in);
        String lettresATrouver = "" , lettresUtilisateur = "";

        // Générer les 7 lettres à trouver
        for(int i = 0; i < nbLettres; i++){
            // Je définis le type attendu "char" puis je spécifie les limites inférieures et supérieures de l'intervalle Random
            char c = (char)('A' + Math.random() * 26);

            // Je rajoute dans la chaîne à mémoriser
            // Version compacte
            lettresATrouver += c;
            // Version étendue
            //lettresATrouver = lettresATrouver + c;
        }
        // Afficher les lettres aléatoires
        System.out.println("Les lettres à mémoriser sont : " + lettresATrouver);

        // On fait patienter le programme pendant 3 secondes
        try{
            Thread.sleep(3000);
        } catch (Exception e){}

        // Je fais comme si je libère la console en imprimant 50 lignes vides
        for(int i = 0; i < 50; i++)
            System.out.println();

        // Demander à l'utilisateur d'entrer les lettres dont il.elle se rappelle
        System.out.println("Quelles lettres pouvez-vous vous rappeler?");
        lettresUtilisateur = s.nextLine();

        // On va tester la mémoire de l'utilisateur
        for(int j = 0; j < 7; j++){
            // Si le charactère à l'indice j est le même, alors on augmente le score
            if(lettresATrouver.charAt(j) == lettresUtilisateur.charAt(j))
                score++;
        }

        // On annonce le score
        System.out.println("Votre score est " + score + "/7.");
    }
}
