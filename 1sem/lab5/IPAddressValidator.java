import java.util.regex.*;

public class IPAddressValidator {
    public static void main(String[] args) {
        String[] ips = {
            "192.168.1.1",
            "255.255.255.255",
            "256.100.50.25",
            "123.045.067.089"
        };
        String ipPattern = "^((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}" + "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$";
        
        try {
            Pattern pattern = Pattern.compile(ipPattern);

            for (String ip : ips) {
                Matcher matcher = pattern.matcher(ip);

                if (matcher.matches()) {
                    System.out.println(ip + " ok");
                } else {
                    System.out.println(ip + " not ok");
                }
            }

        } catch (PatternSyntaxException e) {
            System.out.println("Regex error: " + e.getMessage());
        }
    }
}
