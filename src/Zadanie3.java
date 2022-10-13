
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
        System.out.println("Type \"next\" to get Kanye's quote");

        while(true) {
            if (sc.nextLine().equals("next")) {
                while (quotes.contains((quote = getQuote()))) {}
                quotes.add(quote);
                System.out.println(quote);
            }
        }
    }

}
