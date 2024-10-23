import java.awt.*;
import javax.swing.*;

public class calculator extends JFrame {
    public calculator() {
        this.setTitle("계산기");
        this.setSize(520, 250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        // 텍스트 필드 설정
        JTextField textField = new JTextField();
        textField.setEditable(false);
        this.add(textField, BorderLayout.NORTH);

        // 버튼 배열 생성
        String[] buttonLabels = {
                "Backspace", "", "", "CE", "C",
                "7", "8", "9", "/", "sqrt",
                "4", "5", "6", "x", "%",
                "1", "2", "3", "-", "1/x",
                "0", "+/-", ".", "+", "="
        };

        // 버튼 색상 배열 생성
        Color[] buttonTextColors = {
                Color.BLUE, Color.BLACK, Color.BLACK, Color.RED, Color.RED,
                Color.BLUE, Color.BLUE, Color.BLUE, Color.RED, Color.RED,
                Color.BLUE, Color.BLUE, Color.BLUE, Color.RED, Color.RED,
                Color.BLUE, Color.BLUE, Color.BLUE, Color.RED, Color.RED,
                Color.BLUE, Color.BLUE, Color.BLUE, Color.RED, Color.RED
        };

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 5, 5, 5));

        // 반복문을 사용하여 버튼 추가
        for (int i = 0; i < buttonLabels.length; i++) {
            JButton button = new JButton(buttonLabels[i]);
            button.setBackground(Color.YELLOW);
            button.setForeground(buttonTextColors[i]);
            buttonPanel.add(button);
        }

        // 버튼 패널을 프레임에 추가
        this.add(buttonPanel, BorderLayout.CENTER);

        // 프레임을 보이게 설정
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new calculator();
    }
}

