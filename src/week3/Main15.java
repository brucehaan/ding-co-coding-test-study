package week3;

import java.util.*;

public class Main15 {

    public static Integer[] getMelonBestAlbum(String[] genreArray, int[] playArray) {
        int n = genreArray.length;
        Map<String, Integer> genreTotalPlayDict = new HashMap<>();
        Map<String, List<int[]>> genreIndexPlayArrayDict = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String genre = genreArray[i]; // classic
            int play = playArray[i]; // 500

            if (genreTotalPlayDict.containsKey(genre)) { // classic 이라는 키값이 있었으면
                genreTotalPlayDict.put(genre, genreTotalPlayDict.get(genre) + play); // 재생횟수를 더해줘야 할테니
                genreIndexPlayArrayDict.get(genre).add(new int[]{i, play});
            } else {
                genreTotalPlayDict.put(genre, play); // 500
                List<int[]> list = new ArrayList<>();
                list.add(new int[]{i, play});
                genreIndexPlayArrayDict.put(genre, list);
            }
        }

        // 장르별로 가장 재생횟수가 많은 장르들 중, 곡수가 많은 순서대로 2개씩 출력하기
        List<Map.Entry<String, Integer>> sortedGenrePlayList = new ArrayList<>(genreTotalPlayDict.entrySet());
        sortedGenrePlayList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        List<Integer> answer = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : sortedGenrePlayList) {
            String genre = entry.getKey();
            List<int[]> genreIndexPlayList = genreIndexPlayArrayDict.get(genre);

            // Sort by play count (descending), then by index (ascending) if play counts are equal
            genreIndexPlayList.sort((a, b) -> {
                if (b[1] != a[1]) {
                    return b[1] - a[1];
                } else {
                    return a[0] - b[0];
                }
            });

            int genreSongCount = 0;
            for (int[] indexPlay : genreIndexPlayList) {
                if (genreSongCount >= 2) break;
                answer.add(indexPlay[0]);
                genreSongCount++;
            }
        }
        return answer.toArray(Integer[]::new);
    }

    public static void main(String[] args) {
        System.out.println("정답 = [4, 1, 3, 0] / 현재 풀이 값 = " + java.util.Arrays.toString(getMelonBestAlbum(
                new String[]{"classic", "pop", "classic", "classic", "pop"},
                new int[]{500, 600, 150, 800, 2500}
        )));

        System.out.println("정답 = [0, 6, 5, 2, 4, 1] / 현재 풀이 값 = " + java.util.Arrays.toString(getMelonBestAlbum(
                new String[]{"hiphop", "classic", "pop", "classic", "classic", "pop", "hiphop"},
                new int[]{2000, 500, 600, 150, 800, 2500, 2000}
        )));
    }
}
