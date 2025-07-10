import java.util.Scanner;

class Balada{
//Acesso a balada pelo nome e  idade
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        
        
        System.out.println("Digite seu nome: ");
        String nome = obj.nextLine();
        
        System.out.println("Digite sua idade: ");
        int idade = obj.nextInt();

        


        if(idade > 18){

            System.out.println(nome + ", Bem vindo a Balada! " );
        }

        else if(idade >= 13){
             System.out.println(nome + ", Bem vindo a Balada Teens! " );
        }
    else{
        System.out.println(nome + ", você é muito novo");
    }

    obj.close();
    }
}
