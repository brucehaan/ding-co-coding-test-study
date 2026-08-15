package week4;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main9 {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    private static int currnetR = 7;
    private static int currnetC = 4;
    private static int currnetD = 0;

    public static int getCountOfDepartmentsCleanedByRobotVacuum(int r, int c, int d, int[][] roomMap) {
        int n = roomMap.length;
        int m = roomMap[0].length;

        int countOfDepartmentsCleaned = 1;
        /**
         * 1. 루트 노드를 큐에 넣는다.
         * 2. 현재 큐의 노드를 빼서 visited에 추가한다.
         * 3. 현재 방문한 노드와 인접한 노드 중 방문하지 않은 노드를 큐에 추가한다.
         * 4. 2부터 반복한다.
         * 5. 큐가 비면 탐색을 종료한다.
         */
        roomMap[r][c] = 2;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c, d});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            r = current[0];
            c = current[1];
            d = current[2];

            int tempD = d;

            for (int i = 0; i < 4; i++) {
                tempD = getDIndexWhenRotateToLeft(tempD); // 북 -> 서
                int newR = r + dr[tempD];
                int newC = c + dc[tempD];

                // 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
                if ((0 <= newR && newR < n) && (0 <= newC && newC < m) && roomMap[newR][newC] == 0) {
                    countOfDepartmentsCleaned++;
                    roomMap[newR][newC] = 2;
                    queue.offer(new int[]{newR, newC, tempD});
                    break;
                } else if (i == 3) { // 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진하고 2번으로 돌아간다.
                    tempD = getDIndexWhenGoBack(d);
                    newR = r + dr[tempD];
                    newC = c + dc[tempD];

                    // 네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
                    if ((0 <= newR && newR < n) && (0 <= newC && newC < m) && roomMap[newR][newC] != 1) {
                        queue.offer(new int[]{newR, newC, d});
                    } else {
                        return countOfDepartmentsCleaned;
                    }
                }
            }
        }
        return countOfDepartmentsCleaned;
    }

    private static int getDIndexWhenRotateToLeft(int d) {
        return (d + 3) % 4;
    }
    private static int getDIndexWhenGoBack(int d) {
        return (d + 2) % 4;
    }

    public static void main(String[] args) {
        int currentR = 7, currentC = 4, currentD = 0;
        int[][] currentRoomMap = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
                {1, 0, 0, 1, 1, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };

        // 57 가 출력되어야 합니다!
        System.out.println(getCountOfDepartmentsCleanedByRobotVacuum(currentR, currentC, currentD, currentRoomMap));

        int[][] currentRoomMap2 = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
                {1, 0, 0, 1, 1, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };
        System.out.println("정답 = 29 / 현재 풀이 값 = " + getCountOfDepartmentsCleanedByRobotVacuum(6, 3, 1, currentRoomMap2));

        int[][] currentRoomMap3 = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
                {1, 0, 0, 1, 1, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 1, 0, 1},
                {1, 0, 0, 1, 0, 0, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };
        System.out.println("정답 = 33 / 현재 풀이 값 = " + getCountOfDepartmentsCleanedByRobotVacuum(7, 4, 1, currentRoomMap3));

        int[][] currentRoomMap4 = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 0, 1, 1, 1, 1, 0, 1},
                {1, 0, 0, 1, 1, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 1, 0, 1},
                {1, 0, 0, 1, 0, 0, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };
        System.out.println("정답 = 25 / 현재 풀이 값 = " + getCountOfDepartmentsCleanedByRobotVacuum(6, 2, 0, currentRoomMap4));
    }
}