import java.util.Scanner;

class Main {
  static double saldo = 100;
  static Scanner scanner = new Scanner(System.in);
  static int senha = 3589;
  static String usuario;

  public static void login() {
    System.out.println("Nome:");
    usuario = scanner.nextLine();
  }

  public static void verificar_senha() {
    System.out.println("Senha:");
    int checaSenha = scanner.nextInt();
    while (checaSenha != senha) {
      System.out.println("Senha incorreta");
      checaSenha = scanner.nextInt();
    }
  }

  public static void opcoes() {
    System.out.println(
        "Selecione uma opção:\n 1. Saldo\n 2. Extrato\n 3. Saque\n 4. Depósito\n 5. Transferência\n 6. Sair. ");

    int opcao = scanner.nextInt();

    switch (opcao) {
      case 1:
        verificar_senha();
        ver_saldo();
        break;
      case 2:
        ver_extrato();
        break;
      case 3:
        fazer_saque();
        break;
      case 4:
        fazer_deposito();
        break;
      case 5:
        fazer_transferencia();
        break;
      case 6:
        sair();
      default:
        erro();

    }
  }

  public static void ver_saldo() {

    System.out.println("Seu saldo atual é: " + saldo);

    opcoes();
  }

  private static void ver_extrato() {
    verificar_senha();
    System.out.println("Seu extrato:\n Tranferência: -100\n Pix para Vladimilson: -150\n Pix recebido: +100");
    opcoes();
  }

  public static void fazer_saque() {
    verificar_senha();
    System.out.println("Qual o valor para saque?");
    Double saque = scanner.nextDouble();

    boolean checaNumero = saque.isNaN();

    if (checaNumero || saque < 0 || saldo < saque) {
      System.out.println("Operação não realizada.");
      fazer_saque();
    } else {
      saldo -= saque;
      ver_saldo();
    }
  }

  public static void fazer_deposito() {
    verificar_senha();

    System.out.println("Qual o valor a ser depositado?");
    Double deposito = scanner.nextDouble();

    boolean checaNumero = deposito.isNaN();
    if (checaNumero || deposito <= 0) {
      System.out.println("Operação não realizada.");
      fazer_deposito();
    } else {
      saldo += deposito;
      ver_saldo();
    }
  }

  private static void fazer_transferencia() {
    verificar_senha();

    System.out.println("Informe a conta de destino");
    Double conta = scanner.nextDouble();
    boolean checaConta = conta.isNaN();
    if (checaConta) {
      System.out.println("Operação não realizada.");
      fazer_transferencia();
    }

    System.out.println("Qual o valor da transferência?");
    Double saque = scanner.nextDouble();
    boolean checaNumero = saque.isNaN();

    if (checaNumero || saque < 0 || saldo < saque) {
      System.out.println("Operação não realizada");
      fazer_transferencia();
    } else {
      saldo -= saque;
      ver_saldo();
    }
  }

  public static void erro() {
    System.out.println("Por favor, informe um número entre 1 e 6");
    opcoes();
  }

  public static void sair() {
    System.out.println("Você deseja sair? S/N");
    String escolha = scanner.nextLine();

    if (escolha.equals("S")) {
      System.out.println(usuario + ", foi um prazer ter você por aqui!");
      System.exit(0);
    } else if (escolha.equals("N")) {
      opcoes();
    } else {
      System.out.println("Desculpe, mas não compreendi.");
      sair();
    }

  }

  public static void main(String[] args) {
    login();
    System.out.println("Olá " + usuario + " é um prazer ter você por aqui!");
    opcoes();
  }

}