import java.util.Scanner;

/**
 * Ponto de entrada do aplicativo de clima.
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        WeatherService servico = new WeatherService();
        WeatherDisplay display = new WeatherDisplay();

        System.out.println("=== Aplicativo de Clima ===");

        while (true) {

            System.out.print("Digite o nome da cidade (ex: Curitiba,BR) ou SAIR: ");
            String cidade = scanner.nextLine().trim();

            if (cidade.equalsIgnoreCase("SAIR")) {
                System.out.println("Encerrando aplicativo...");
                break;
            }

            if (cidade.isEmpty()) {
                System.out.println("Cidade invalida.");
                continue;
            }

            System.out.println("\nBuscando dados do clima...");

            WeatherData dados = servico.buscarClima(cidade);

            display.exibir(dados);
        }

        scanner.close();
    }
}