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
    private  String[][] board;
    private int turn;

    public JPanel getMainPanel() { return mainPanel; }

    public int checkLowestSpot(int column) {
        for (int r = 5; r >= 0; r--) if (Objects.equals(board[r][column], "")) return r;
        return -1;
    }

    public void drop(int column) {
        if (!winCondition()) {
            String chip = (turn == 0) ? "○" : "⬤";
            int row = checkLowestSpot(column);
            if (row == 0 && column == 0) textField2.setText(chip);
            if (row == 0 && column == 1) textField3.setText(chip);
            if (row == 0 && column == 2) textField4.setText(chip);
            if (row == 0 && column == 3) textField5.setText(chip);
            if (row == 0 && column == 4) textField6.setText(chip);
            if (row == 0 && column == 5) textField7.setText(chip);
            if (row == 0 && column == 6) textField8.setText(chip);
            if (row == 1 && column == 0) textField9.setText(chip);
            if (row == 1 && column == 1) textField10.setText(chip);
            if (row == 1 && column == 2) textField11.setText(chip);
            if (row == 1 && column == 3) textField12.setText(chip);
            if (row == 1 && column == 4) textField13.setText(chip);
            if (row == 1 && column == 5) textField14.setText(chip);
            if (row == 1 && column == 6) textField15.setText(chip);
            if (row == 2 && column == 0) textField16.setText(chip);
            if (row == 2 && column == 1) textField17.setText(chip);
            if (row == 2 && column == 2) textField18.setText(chip);
            if (row == 2 && column == 3) textField19.setText(chip);
            if (row == 2 && column == 4) textField20.setText(chip);
            if (row == 2 && column == 5) textField21.setText(chip);
            if (row == 2 && column == 6) textField22.setText(chip);
            if (row == 3 && column == 0) textField23.setText(chip);
            if (row == 3 && column == 1) textField24.setText(chip);
            if (row == 3 && column == 2) textField25.setText(chip);
            if (row == 3 && column == 3) textField26.setText(chip);
            if (row == 3 && column == 4) textField27.setText(chip);
            if (row == 3 && column == 5) textField28.setText(chip);
            if (row == 3 && column == 6) textField29.setText(chip);
            if (row == 4 && column == 0) textField30.setText(chip);
            if (row == 4 && column == 1) textField31.setText(chip);
            if (row == 4 && column == 2) textField32.setText(chip);
            if (row == 4 && column == 3) textField33.setText(chip);
            if (row == 4 && column == 4) textField34.setText(chip);
            if (row == 4 && column == 5) textField35.setText(chip);
            if (row == 4 && column == 6) textField36.setText(chip);
            if (row == 5 && column == 0) textField37.setText(chip);
            if (row == 5 && column == 1) textField38.setText(chip);
            if (row == 5 && column == 2) textField39.setText(chip);
            if (row == 5 && column == 3) textField40.setText(chip);
            if (row == 5 && column == 4) textField41.setText(chip);
            if (row == 5 && column == 5) textField42.setText(chip);
            if (row == 5 && column == 6) textField43.setText(chip);
            if (row != -1) changeBoard(row, column, chip);
            changeTurns();
        }
        if (winCondition()) {
            if (turn == 1) textField1.setText("White Wins! Start Over ->");
            if (turn == 0) textField1.setText("Black Wins! Start Over ->");
        } else if (drawCondition()) {
            textField1.setText("Draw! Start Over ->");
        }
    }

    private void changeBoard(int row, int col, String chip) { board[row][col] = chip; }
    private void changeTurns() { turn = (turn == 0) ? 1 : 0; }
    public boolean winCondition() {
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

    public boolean drawCondition() {
        for (String[] r : board)
            for (String c : r)
                if (Objects.equals(c, "")) return false;
        return true;
    }

    public void reset() {
        // TODO: Center text, make textfields resizable, increase font to size, make the drop button display a down arrow instead of "drop"
        for (int r = 0; r < board.length; r++)
            for (int c = 0; c < board[0].length; c++)
                board[r][c] = "";
        turn = 0;
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        textField5.setText("");
        textField6.setText("");
        textField7.setText("");
        textField8.setText("");
        textField9.setText("");
        textField10.setText("");
        textField11.setText("");
        textField12.setText("");
        textField13.setText("");
        textField14.setText("");
        textField15.setText("");
        textField16.setText("");
        textField17.setText("");
        textField18.setText("");
        textField19.setText("");
        textField20.setText("");
        textField21.setText("");
        textField22.setText("");
        textField23.setText("");
        textField24.setText("");
        textField25.setText("");
        textField26.setText("");
        textField27.setText("");
        textField28.setText("");
        textField29.setText("");
        textField30.setText("");
        textField31.setText("");
        textField32.setText("");
        textField33.setText("");
        textField34.setText("");
        textField35.setText("");
        textField36.setText("");
        textField37.setText("");
        textField38.setText("");
        textField39.setText("");
        textField40.setText("");
        textField41.setText("");
        textField42.setText("");
        textField43.setText("");
    }

    public Connect4() {
        board = new String[6][7];
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
