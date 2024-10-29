import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class calculator extends JFrame implements ActionListener {
    private  JTextField textField;
    private  double num1 = 0, num2 = 0;
    private  String operator = "";
    private boolean startNewNumber = true;


    public calculator() {
        this.setTitle("계산기");
        this.setSize(300, 450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(10, 10)); //여백 추가
        this.getContentPane().setBackground(Color.DARK_GRAY); //배경색

        // 텍스트 필드 설정
        JTextField textField = new JTextField();
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setFont(new Font("PLAINFONT", Font.PLAIN, 30)); //폰트
        textField.setBackground(Color.gray); // 배경색
        textField.setForeground(Color.white); // 글자 색
        textField.setBorder(new EmptyBorder(15, 15, 15, 15));
        this.add(textField, BorderLayout.NORTH);


        // 버튼 레이블 생성
        String[] buttonLabels = {
                "C", " ", "%", "x",
                "7", "8", "9", "÷",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                "+/-", "0", ".", "="
        };


        // 버튼 패널
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 10, 10)); //간격
        buttonPanel.setBackground(Color.DARK_GRAY); //배경색

        // 반복문을 사용하여 버튼 추가
        // 버튼 스타일 설정
        for (String label : buttonLabels) {
            if (!label.isEmpty()) {
                JButton button = new JButton(label);
                button.setFont(new Font("PLAINFONT", Font.PLAIN, 20)); //폰트 및 크기
                button.setBackground(Color.LIGHT_GRAY); // 배경색
                button.setForeground(Color.darkGray); // 텍스트 색
                button.setFocusPainted(false); // 선택할때 테두리 제거
                button.setBorder(BorderFactory.createLineBorder(new Color(80, 80, 80))); // 테두리
                button.setPreferredSize(new Dimension(70, 50)); // 버튼 크기
                button.addActionListener(this);
                buttonPanel.add(button);
            } else {
                buttonPanel.add(new JLabel());
            }

        }

            // 버튼 패널을 프레임에 추가
            this.add(buttonPanel, BorderLayout.CENTER);

            // 프레임을 보이게 설정
            this.setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e){
            String command = e.getActionCommand();

            //숫자 입력
            if (command.matches("\\d")|| command.equals(".")){
                if (startNewNumber){
                    textField.setText("");
                    startNewNumber = false;
                }
                textField.setText(textField.getText()+command);
            }
            // 연산자
            else if (command.matches("[\\+\\-x/%]")) {
                num1 = Double.parseDouble(textField.getText());
                operator = command;
                startNewNumber = true;
                
            }
            // "= 연산자 수행"
            else if (command.equals("=")) {
                num2 = Double.parseDouble(textField.getText());
                double result = 0;

                switch (operator){
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "x":
                        result = num1 * num2;
                        break;
                    case "÷":
                        if (num2 !=0) {
                            result = num1 / num2;
                        }else {
                            textField.setText("Error");
                            return;
                        }
                        break;
                    case "%":
                        result = num1 * (num2/100); //백분율 계산
                        break;
                }

                textField.setText(String.valueOf(result));
                startNewNumber = true;
                
            }
            // c 버튼 처리(초기화)
            else if (command.equals("c")) {
                textField.setText("");
                num1 = num2 = 0;
                operator = "";
                startNewNumber = true;
                
            }
        // +/- 버튼 처리
            else if (command.equals("+/-")) {
                if (!textField.getText().isEmpty()){
                    double currentvalue = Double.parseDouble(textField.getText());
                }
                
            }
        }

        public static void main (String[]args){

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }


            new calculator();
        }
    }


