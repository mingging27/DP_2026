package ch15.Q3;

public class Main {
    public static void main(String[] args) {
        // 큰따옴표 3개로 여러 줄 문자열을 표현할 수 있다 (문자열 리터럴)
        String html = """
        <!DOCTYPE html>
        <html>
            <head>
                <title>Welcome!</title>
            </head>
            <body>
                <h1 style="text-align: center">%s</h1>
            </body>
        </html>
        """;
        
        html = html.formatted("Welcome!");
        System.out.print(html);
    }
}
