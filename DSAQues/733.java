import java.util.*;
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int originalColor = image[sr][sc];
        if(originalColor == color) return image;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        image[sr][sc] = color;
        int[][] directions = {{0,1},{0,-1},{-1,0},{1,0}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int dir[] : directions){
                
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];

                if(nr>=0 && nc>=0 && nr<n && nc<m && image[nr][nc] == originalColor){
                    image[nr][nc] = color;
                    q.add(new int[]{nr, nc});
                }
            }
        }
         return image;
    }
}