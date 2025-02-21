package tech.ada.web.programcao.aula01;

import java.util.Scanner;

public class CepController {

    private final CepService cepService;

    public CepController() {
        this.cepService = new CepService();
    }

    public static void main(String[] args) {
        var cepController = new CepController();
        var cepData = cepController.getCepData();

        System.out.println(cepData);
    }

    public String getCepData() {
        System.out.println("Digite o CEP(ex.:60842025): ");
        var cep = new Scanner(System.in).nextLine();

        return cepService.getCepData(cep);
    }
}
