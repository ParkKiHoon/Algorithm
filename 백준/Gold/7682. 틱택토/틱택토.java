import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String a = in.readLine();
            if (a.equals("end")) {
                break;
            }
            String[] split = a.split("");

            int O = 0;
            int X = 0;
            for (String str : split) {
                if (str.equals("O")) {
                    O++;
                } else if (str.equals("X")) {
                    X++;
                }
            }

            // X는 O보다 같거나 하나 더 많아야 한다.
            if (O > X || X > O + 1) {
                System.out.println("invalid");
                continue;
            }

            // X와 O가 이기는 상태를 확인
            boolean xWins = checkWin(split, 'X');
            boolean oWins = checkWin(split, 'O');

            // 둘 다 이기면 invalid
            if (xWins && oWins) {
                System.out.println("invalid");
                continue;
            }

            // O가 이겼을 때는 X와 O의 개수가 같아야 한다.
            if (oWins && X != O) {
                System.out.println("invalid");
                continue;
            }

            // X가 이겼을 때는 X가 O보다 하나 많아야 한다.
            if (xWins && X != O + 1) {
                System.out.println("invalid");
                continue;
            }

            // 게임이 유효한 경우
            if (xWins || oWins || X + O == 9) {
                System.out.println("valid");
            } else {
                System.out.println("invalid");
            }
        }
    }

    // 주어진 플레이어가 승리했는지 확인하는 함수
    private static boolean checkWin(String[] board, char player) {
        String p = String.valueOf(player);
        return (board[0].equals(p) && board[1].equals(p) && board[2].equals(p)) ||  // 첫 번째 행
               (board[3].equals(p) && board[4].equals(p) && board[5].equals(p)) ||  // 두 번째 행
               (board[6].equals(p) && board[7].equals(p) && board[8].equals(p)) ||  // 세 번째 행
               (board[0].equals(p) && board[3].equals(p) && board[6].equals(p)) ||  // 첫 번째 열
               (board[1].equals(p) && board[4].equals(p) && board[7].equals(p)) ||  // 두 번째 열
               (board[2].equals(p) && board[5].equals(p) && board[8].equals(p)) ||  // 세 번째 열
               (board[0].equals(p) && board[4].equals(p) && board[8].equals(p)) ||  // 대각선 (\)
               (board[2].equals(p) && board[4].equals(p) && board[6].equals(p));    // 대각선 (/)
    }
}