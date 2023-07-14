package org.example;

import model.Rebelde;
import service.ServiceRebeldes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ServiceRebeldes serviceRebeldes = new ServiceRebeldes();

        System.out.println("-----------------------------------------------------");
        System.out.println("                   BANCO DE DADOS                    ");
        System.out.println("-----------------------------------------------------");

        Scanner sc = new Scanner(System.in);
        Rebelde usuario = new Rebelde();
        boolean operarMenu = true;

        do {
            String escolhaUsuario = menuExibir();
            switch (escolhaUsuario) {
                case "1":
                    serviceRebeldes.consultarRegistros();
                    break;


                case "2":
                    System.out.println("Qual o nome do usuário?");
                    String nome = sc.next();
                    usuario.setNome_rebelde(nome);
                    System.out.println("Qual a idade do usuário?");
                    Integer idade = sc.nextInt();
                    usuario.setIdade(idade);
                    System.out.println("Qual o genero do usuário?");
                    String genero = sc.next();
                    usuario.setGenero(genero);
                    System.out.println("Qual a localização do usuário?");
                    String localizacao = sc.next();
                    usuario.setLocalizacao(localizacao);

                    serviceRebeldes.inserirRegistro(usuario.getNome_rebelde(), usuario.getIdade(),
                                                    usuario.getGenero(), usuario.getLocalizacao());
                    break;

                case "3":
                    System.out.println("Qual id do usuário que deseja alterar?:");
                    Integer id = sc.nextInt();
                    usuario.setId_rebelde(id);
                    System.out.println("Qual a nova localização? ");
                    String atualizarDados = sc.next();
                    usuario.setLocalizacao(atualizarDados);

                    serviceRebeldes.alterarRegistro(usuario.getId_rebelde(), usuario.getLocalizacao());
                    break;
            }
        }while (operarMenu);
    }

    public static String menuExibir(){
        Scanner sc = new Scanner(System.in);
        System.out.println("| 1 - Consultar todos os dados da tabela            |");
        System.out.println("| 2 - Inserir novos dados na tabela                 |");
        System.out.println("| 3 - Atualizar dados na tabela                     |");
        System.out.println("| 4 - Deletar dados da tabela                       |");
        System.out.println("| 5 - Consultar coluna nomes                        |");
        System.out.println("| 6 - Sair                                          |");
        System.out.println("-----------------------------------------------------");
        return sc.nextLine();
    }
}