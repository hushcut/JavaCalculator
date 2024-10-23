import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class calculator extends JFrame {
    public calculator() {
        this.setTitle("계산기");
        this.setSize(400, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(10, 10)); //여백 추가
        this.getContentPane().setBackground(new Color(40, 44, 52)); //배경색

        // 텍스트 필드 설정
        JTextField textField = new JTextField();
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setFont(new Font("Arial", Font.BOLD, 30)); //폰트
        textField.setBackground(Color.gray); // 배경색
        textField.setForeground(Color.white); // 글자 색
        textField.setBorder(new EmptyBorder(15, 15, 15, 15));
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
        for (int i = 0; i < buttonLabels.length; i++)
            if (!buttonLabels[i].isEmpty()) {
                JButton button = new JButton(buttonLabels[i]);
                button.setBackground(Color.YELLOW);
                button.setForeground(buttonTextColors[i]);
                buttonPanel.add(button);
            } else {
                //빈 버튼 생성x
                buttonPanel.add(new JLabel());
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


