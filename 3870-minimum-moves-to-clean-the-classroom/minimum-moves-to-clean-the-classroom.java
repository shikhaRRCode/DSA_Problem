class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        
        int startR = -1, startC = -1;
        List<int[]> litterList = new ArrayList<>();
        
        // Scan the grid to locate 'S' and all 'L' positions
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                char ch = classroom[r].charAt(c);
                if (ch == 'S') {
                    startR = r;
                    startC = c;
                } else if (ch == 'L') {
                    litterList.add(new int[]{r, c});
                }
            }
        }
        
        int totalLitter = litterList.size();
        // If there's no litter to collect, 0 moves are required.
        if (totalLitter == 0) return 0;
        
        int fullMask = (1 << totalLitter) - 1;
        
        // bestEnergy[r][c][mask] stores the max remaining energy reached at state (r, c, mask)
        int[][][] bestEnergy = new int[m][n][1 << totalLitter];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(bestEnergy[i][j], -1);
            }
        }
        
        // Queue stores state: {r, c, mask, current_energy, steps}
        Queue<int[]> queue = new LinkedList<>();
        
        // Check if starting cell is also a litter position (just in case)
        int startMask = 0;
        for (int i = 0; i < totalLitter; i++) {
            if (litterList.get(i)[0] == startR && litterList.get(i)[1] == startC) {
                startMask |= (1 << i);
            }
        }
        
        queue.offer(new int[]{startR, startC, startMask, energy, 0});
        bestEnergy[startR][startC][startMask] = energy;
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int mask = curr[2];
            int currEnergy = curr[3];
            int steps = curr[4];
            
            // If all litter items are collected, return step count (BFS guarantees shortest path)
            if (mask == fullMask) {
                return steps;
            }
            
            // If energy is 0, we cannot move further unless we are on a reset cell 'R'
            if (currEnergy == 0) continue;
            
            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];
                
                // Check grid bounds and obstacle 'X'
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                char nextCell = classroom[nr].charAt(nc);
                if (nextCell == 'X') continue;
                
                int nextEnergy = currEnergy - 1;
                int nextMask = mask;
                
                // If the adjacent cell is a reset area 'R', restore energy to maximum capacity
                if (nextCell == 'R') {
                    nextEnergy = energy;
                }
                
                // Check if the cell contains an uncollected litter 'L'
                if (nextCell == 'L') {
                    for (int i = 0; i < totalLitter; i++) {
                        if (litterList.get(i)[0] == nr && litterList.get(i)[1] == nc) {
                            nextMask |= (1 << i);
                            break;
                        }
                    }
                }
                
                // Prune state if we've reached (nr, nc, nextMask) with equal or higher energy before
                if (nextEnergy > bestEnergy[nr][nc][nextMask]) {
                    bestEnergy[nr][nc][nextMask] = nextEnergy;
                    queue.offer(new int[]{nr, nc, nextMask, nextEnergy, steps + 1});
                }
            }
        }
        
        return -1;
    }
}