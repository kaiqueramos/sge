import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        String login, password;
        String[] middleLogin, middlePassword;

        Scanner sc = new Scanner(System.in);

        System.out.println("Bem vindo/a ao sistema de gerenciamento de estoque!");
        System.out.println("Verificamos que é seu primeiro acesso. Vamos executar o processo de criação de usuário. ");

        //Processo de criação de usuário:
        System.out.print("Informe seu nome completo: ");
        login = sc.nextLine();
        middleLogin = login.split(" ");
        //Fim do processo

        //Processo de tratamento de login
        char firstLetter = middleLogin[0].charAt(0);
        int loginSize = middleLogin.length;
        String lastName = middleLogin[loginSize - 1];
        String finalLogin = firstLetter + "_" + lastName;
        finalLogin = finalLogin.toLowerCase();
        System.out.println("Seu usuário foi gerado! Anote, o login é " + finalLogin);
        login = finalLogin;
        //Fim do processo

        System.out.println(
                "Agora uma senha. Ela deve conter pelo menos: " +
                "\n 8 caracteres " +
                "\n 1 Letra MAIUSCULA " +
                "\n 1 letra minuscula " +
                "\n 1 número " +
                "\n um dos seguintes caracteres especiais: @ # !"
        );

        System.out.print("Digite aqui: ");
        password = sc.nextLine();

        //Tratamento de senha
        boolean hasMinDigits = false, hasUpperCase = false, hasLowerCase = false, hasNumber = false, hasMiscChar = false;

        //8 Dígitos
        if(password.length() >= 8){
            hasMinDigits = true;
        }

        for (int i = 0; i < password.length(); i++){
            //Letra maiúscula
            if (Character.isUpperCase(password.charAt(i))){
                hasUpperCase = true;
                continue;
            }
            //Letra minúscula
            if (Character.isLowerCase(password.charAt(i))){
                hasLowerCase = true;
                continue;
            }
            //Número
            if (Character.isDigit(password.charAt(i))){
                hasNumber = true;
                continue;
            }
            //Caractere especial
            if (String.valueOf(password.charAt(i)).equals("!") || String.valueOf(password.charAt(i)).equals("@") || String.valueOf(password.charAt(i)).equals("#")){
                hasMiscChar = true;
            }
        }

        //Validação senha & acesso
        if (hasMinDigits && hasLowerCase && hasUpperCase && hasMiscChar && hasNumber){
            System.out.println("Tudo ok com seu cadastro!");
            System.out.println("Você pode se logar agora! ");
            System.out.print("Digite seu login: ");
            String tryLogin = sc.nextLine();
            System.out.print("Digite sua senha: ");
            String tryPass = sc.nextLine();


            if (tryLogin.equals(login) && tryPass.equals(password)){
                System.out.println("Acessando o sistema..... (continua)");
            }else{
                for (int i = 1; true; ){
                    System.out.println("Login e/ou senha incorretos");
                    System.out.print("Digite novamente seu login: ");
                    String newTryLogin = sc.nextLine();

                    System.out.print("Digite novamente sua senha: ");
                    String newTryPass = sc.nextLine();

                    if (newTryLogin.equals(login) && newTryPass.equals(password)){
                        System.out.println("Acessando o sistema.... (continua)");
                        break;
                    }
                }
            }

        } else {
            System.out.println("Sua senha não segue o padrão! Tente novamente. ");

        }

    }

}
