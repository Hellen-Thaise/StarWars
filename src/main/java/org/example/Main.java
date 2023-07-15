package org.example;

import model.Rebelde;
import service.ServicePorcentagemRebelde;
import service.ServicePorcentagemTraidor;
import service.ServiceRebeldes;
import service.ServiceReportarTraidor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ServiceRebeldes serviceRebeldes = new ServiceRebeldes();

        System.out.println("-----------------------------------------------------");
        System.out.println("                     STAR WARS                       ");
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
                    System.out.println("Qual o nome do Rebelde?");
                    String nome = sc.next();
                    usuario.setNome_rebelde(nome);
                    System.out.println("Qual a idade do Rebelde?");
                    Integer idade = sc.nextInt();
                    usuario.setIdade(idade);
                    System.out.println("Qual o genero do Rebelde?");
                    String genero = sc.next();
                    usuario.setGenero(genero);
                    System.out.println("Qual a localização do Rebelde?");
                    String localizacao = sc.next();
                    usuario.setLocalizacao(localizacao);

                    serviceRebeldes.inserirRegistro(usuario.getNome_rebelde(), usuario.getIdade(),
                                                    usuario.getGenero(), usuario.getLocalizacao());
                    break;

                case "3":
                    System.out.println("Qual id do Rebelde que deseja alterar?:");
                    Integer id = sc.nextInt();
                    usuario.setId_rebelde(id);
                    System.out.println("Qual a nova localização do Rebelde? ");
                    String atualizarDados = sc.next();
                    usuario.setLocalizacao(atualizarDados);

                    serviceRebeldes.alterarRegistro(usuario.getId_rebelde(), usuario.getLocalizacao());
                    break;

                case "4":
                    ServiceReportarTraidor.serviceReportarTraidor();

                case "5":
                    ServicePorcentagemRebelde.exibirPorcentagemRebelde();
                    break;
                case "6":
                    ServicePorcentagemTraidor.exibirPorcentagemTraidor();
                    break;

                case "7":
                    operarMenu = false;
                    System.out.println("Obrigado(a) por utilizar nosso sistema, até logo!");
                    break;
            }
        }while (operarMenu);
    }

    public static String menuExibir(){
        Scanner sc = new Scanner(System.in);
        System.out.println("| 1 - Consultar todos os Rebeldes cadastrados            |");
        System.out.println("| 2 - Adicionar novo Rebelde                             |");
        System.out.println("| 3 - Atualizar localização do Rebelde                   |");
        System.out.println("| 4 - Reportar um Traidor                                |");
        System.out.println("| 5 - Consultar porcentagem de Rebeldes                  |");
        System.out.println("| 6 - Consultar porcentagem de Traidores                 |");
        System.out.println("| 7 - Sair                                               |");

        System.out.println("-----------------------------------------------------");
        return sc.nextLine();
    }
}