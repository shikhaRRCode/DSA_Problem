class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        // Min-heap to store busy servers: stores int[] {freeTime, serverId}
        PriorityQueue<int[]> busyServers = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        // TreeSet to store available server IDs
        TreeSet<Integer> availableServers = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            availableServers.add(i);
        }
        
        int[] requestCount = new int[k];
        int maxRequests = 0;
        
        for (int i = 0; i < arrival.length; i++) {
            int currTime = arrival[i];
            
            // Free up servers whose tasks are finished by currTime
            while (!busyServers.isEmpty() && busyServers.peek()[0] <= currTime) {
                int[] server = busyServers.poll();
                availableServers.add(server[1]);
            }
            
            // If all servers are busy, drop the request
            if (availableServers.isEmpty()) {
                continue;
            }
            
            // Find the preferred server (i % k) or the next available one
            Integer targetServer = availableServers.ceiling(i % k);
            if (targetServer == null) {
                targetServer = availableServers.first(); // Wrap around to the beginning
            }
            
            // Assign request to the target server
            availableServers.remove(targetServer);
            busyServers.offer(new int[] { currTime + load[i], targetServer });
            
            requestCount[targetServer]++;
            maxRequests = Math.max(maxRequests, requestCount[targetServer]);
        }
        
        // Collect all servers that handled the maximum number of requests
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (requestCount[i] == maxRequests) {
                result.add(i);
            }
        }
        
        return result;
    }
}