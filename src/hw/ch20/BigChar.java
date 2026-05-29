package hw.ch20;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BigChar {
    // 문자의 이름 
    private char charname;
    // 큰 문자를 표현하는 문자열('#' '.' '\n'의 열)
    private String fontdata;

    // 생성자 
    public BigChar(char charname) {
        this.charname = charname;
        try {
            String filename = "big" + charname + ".txt";
            StringBuilder sb = new StringBuilder();
            // 확장 for문
            for (String line: Files.readAllLines(Path.of(filename))) {
                sb.append(line);    // 한줄씩 내용 + '\n' 추가
                sb.append("\n");
            }
            this.fontdata = sb.toString();  // StringBuilder의 내용을 String으로 변환 -> fontdata에 저장
        } catch (IOException e) {
            this.fontdata = charname + "?";
        }
    }

    // 큰 문자를 표시한다
    public void print() {
        System.out.print(fontdata);
    }

    public void print(String colorCode) {
        System.out.print(colorCode + fontdata + "\u001B[0m");
    }
}
