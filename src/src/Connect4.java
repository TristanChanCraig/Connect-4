import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Connect4 {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JTextField textField11;
    private JTextField textField12;
    private JTextField textField13;
    private JTextField textField14;
    private JTextField textField15;
    private JTextField textField16;
    private JTextField textField17;
    private JTextField textField18;
    private JTextField textField19;
    private JTextField textField20;
    private JTextField textField21;
    private JTextField textField22;
    private JTextField textField23;
    private JTextField textField24;
    private JTextField textField25;
    private JTextField textField26;
    private JTextField textField27;
    private JTextField textField28;
    private JTextField textField29;
    private JTextField textField30;
    private JTextField textField31;
    private JTextField textField32;
    private JTextField textField33;
    private JTextField textField34;
    private JTextField textField35;
    private JTextField textField36;
    private JTextField textField37;
    private JTextField textField38;
    private JTextField textField39;
    private JTextField textField40;
    private JTextField textField41;
    private JTextField textField42;
    private JTextField textField43;
    private JButton dropButton;
    private JButton dropButton1;
    private JButton dropButton2;
    private JButton dropButton3;
    private JButton dropButton4;
    private JButton dropButton5;
    private JButton dropButton6;
    private JButton resetButton;
    private JPanel mainPanel;
    private final String[][] board = new String[6][7];;
    private int turn;
    private static final String chip = "⬤";

    private JPanel getMainPanel() { return mainPanel; }

    private int checkLowestSpot(int column) {
        for (int r = 5; r >= 0; r--) if (Objects.equals(board[r][column], "")) return r;
        return -1;
    }

    private void drop(int column) {
        // fix switching turn when additional button pressed
        int row = checkLowestSpot(column);
        if (!winCondition() && row != -1) {
            int cnt = 0;
            for (Component c : mainPanel.getComponents()) { // Generated by Google AI
                if (c instanceof JTextField) {
                    if (row * 7 + column == cnt) {
                        ((JTextField) c).setText(chip);
                        if (turn == 0) ((JTextField) c).setForeground(Color.RED); // Referenced from https://stackoverflow.com/questions/5929202/change-font-color-of-textfield-input-via-jcheckbox
                        else ((JTextField) c).setForeground(Color.YELLOW);
                    }
                    cnt++;
                }
            }
            changeBoard(row, column);
            changeTurns();
        }
        if (winCondition()) {
            if (turn == 1) textField1.setText("Red Wins! Start Over ->");
            if (turn == 0) textField1.setText("Yellow Wins! Start Over ->");
        } else if (drawCondition()) {
            textField1.setText("Draw! Start Over ->");
        }
    }

    private void changeBoard(int row, int col) { board[row][col] = String.valueOf(turn); }
    private void changeTurns() { turn = (turn == 0) ? 1 : 0; }
    private boolean winCondition() {
        // Row
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length - 3; c++) {
                if (!Objects.equals(board[r][c], "") && !Objects.equals(board[r][c+1], "")
                && !Objects.equals(board[r][c+2], "") && !Objects.equals(board[r][c+3], "")) {
                    if ((board[r][c].equals(board[r][c + 1]) && board[r][c + 1].equals(board[r][c + 2]))
                            && (board[r][c + 2].equals(board[r][c + 3]))) return true;
                }
            }
        }
        // Column
        for (int r = 0; r < board.length - 3; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (!Objects.equals(board[r][c], "") && !Objects.equals(board[r+1][c], "")
                        && !Objects.equals(board[r+2][c], "") && !Objects.equals(board[r+3][c], "")) {
                    if ((board[r][c].equals(board[r + 1][c]) && board[r + 1][c].equals(board[r + 2][c]))
                            && (board[r + 2][c].equals(board[r + 3][c]))) return true;
                }
            }
        }
        // Left-Right Diagonal
        for (int r = 0; r < board.length - 3; r++) {
            for (int c = 0; c < board[0].length - 3; c++) {
                if (!Objects.equals(board[r][c], "") && !Objects.equals(board[r+1][c+1], "")
                        && !Objects.equals(board[r+2][c+2], "") && !Objects.equals(board[r+3][c+3], "")) {
                    if ((board[r][c].equals(board[r + 1][c + 1]) && board[r + 1][c + 1].equals(board[r + 2][c + 2]))
                            && (board[r + 2][c + 2].equals(board[r + 3][c + 3]))) return true;
                }
            }
        }
        // Right-Left Diagonal
        for (int r = 0; r < board.length - 3; r++) {
            for (int c = 0; c < board[0].length - 3; c++) {
                if (!Objects.equals(board[r][c+3], "") && !Objects.equals(board[r+1][c+2], "")
                        && !Objects.equals(board[r+2][c+1], "") && !Objects.equals(board[r+3][c], "")) {
                    if ((board[r][c + 3].equals(board[r + 1][c + 2]) && board[r + 1][c + 2].equals(board[r + 2][c + 1]))
                            && (board[r + 2][c + 1].equals(board[r + 3][c]))) return true;
                }
            }
        }
        // Default Condition
        return false;
    }

    private boolean drawCondition() {
        for (String[] r : board)
            for (String c : r)
                if (Objects.equals(c, "")) return false;
        return true;
    }

    private void reset() {
        // TODO: Center text, make textfields resizable, increase font to size, make the drop button display a down arrow instead of "drop"
        for (int r = 0; r < board.length; r++)
            for (int c = 0; c < board[0].length; c++)
                board[r][c] = "";
        turn = 0;
        Dimension buttonDimension = new Dimension(100, 100);
        for (Component c : mainPanel.getComponents()) { // Generated by Google AI
            c.setPreferredSize(buttonDimension);
            c.setMinimumSize(buttonDimension);
            c.setMaximumSize(buttonDimension);
            if (c instanceof JTextField && c != textField1) {
                ((JTextField) c).setText("");
                c.setFont(new Font("MONOSPACED", Font.PLAIN, 100)); // Referenced from https://stackoverflow.com/questions/1043872/are-there-any-built-in-methods-in-java-to-increase-font-size
                ((JTextField) c).setHorizontalAlignment(JTextField.CENTER); // Referenced from https://stackoverflow.com/questions/15507639/how-do-i-center-a-jtextfield
            } else if (c == textField1) ((JTextField) c).setText("");
        }
    }

    public Connect4() {
        mainPanel.setBackground(Color.BLUE);
        reset();

        dropButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drop(0);
            }
        });
        dropButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drop(1);
            }
        });
        dropButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drop(2);
            }
        });
        dropButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drop(3);
            }
        });
        dropButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drop(4);
            }
        });
        dropButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drop(5);
            }
        });
        dropButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drop(6);
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        });
    }

    public static void main(String[] args) {
        var frame = new JFrame("Connect 4");
        frame.setContentPane(new Connect4().getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}