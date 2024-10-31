import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *Calculator는 JAVA를 사용하여 간단한 사칙연산 및 백분율 계산을 하는 계산기 애플리케이션 입니다.
 *
 * @author 2021011957 김민성
 * @version 1.0
 * @since 2024-10-31
 */

public class calculator extends JFrame implements ActionListener {
    /** 결과 및 입력을 표시하는 JTextField */
    private  JTextField textField;
    /** 첫번째 숫자 지정 */
    private  double num1 = 0, num2 = 0;
    /** 두번째 숫자 지정 */
    private  String operator = "";
    /** 새 숫자 입력 시작 여부 */
    private boolean startNewNumber = true;


    /**
     * 기본 생성자, 계산기의 GUI 컴포넌트를 초기화 및 설정
     */
    public calculator() {
        this.setTitle("계산기");
        this.setSize(300, 450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(10, 10)); //여백 추가
        this.getContentPane().setBackground(Color.DARK_GRAY); //배경색

        // 텍스트 필드 설정
        textField = new JTextField();
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

    /**
     * 버튼 클릭 이벤트를 처리하여 연산 및 결과 계산
     * @param e Actionevent 객체로, 버튼 클릭 이벤트 정보 포함
     */
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
            // "= 연산자 수행 "
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
            // C 버튼 처리(초기화)
            /**
             * @see 챗GPT의 도움을 받음
             */
            else if (command.equals("C")) {
                textField.setText("");
                num1 = num2 = 0;
                operator = "";
                startNewNumber = true;
                
            }
        // +/- 버튼 처리
            /**
             * @see 챗GPT의 도움을 받음
             */
            else if (command.equals("+/-")) {
                if (!textField.getText().isEmpty()){
                    double currentvalue = Double.parseDouble(textField.getText());
                    currentvalue = -currentvalue;
                    textField.setText(String.valueOf(currentvalue));
                }
                
            }
        }

    /**
     * 애플리케이션 실행 메인 메서드
     * Nimbus Look and Feel을 설정하고 Calculator 인스턴스 생성
     * @see "Nimbus Look and Feel"을 챗gpt가 사용을 권장
     * @param args
     */
    public static void main (String[]args){

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }


            new calculator();
        }
    }


