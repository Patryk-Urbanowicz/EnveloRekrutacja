
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zadanie3 {

    private static String getQuote() throws Exception {
        URL url = new URL("https://api.kanye.rest/");
        HttpURLConnection quoteConnection = (HttpURLConnection) url.openConnection();
        quoteConnection.setRequestMethod("GET");

        BufferedReader br = new BufferedReader(new InputStreamReader(quoteConnection.getInputStream()));
        String quote = br.readLine();
        br.close();
        quoteConnection.disconnect();

        quote = quote.substring(9, quote.length() - 1);
        return quote;
    }

    public static void main(String[] args) throws Exception {
        List<String> quotes = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String quote;
        String input;
        System.out.println("Type \"next\" to get Kanye's quote.");
        System.out.println("Type \"exit\" to exit.");

        while(true) {
            input = sc.nextLine();
            if (input.equals("next")) {
                do {
                    quote = getQuote();
                } while (quotes.contains(quote));
                quotes.add(quote);
                System.out.println(quote);
            }
            else if (input.equals("exit")) {
                break;
            }
        }
    }

}
