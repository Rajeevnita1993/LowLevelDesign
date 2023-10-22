package com.example.OnlineElection;

public class TopVotedCandidate {

    private int[] persons;
    private int[] times;
    private int[] leads;

    // O(n) time to complete leads array
    // O(n) to store leads and votes array
    public TopVotedCandidate(int[] persons, int[] times) {
        int n = persons.length;
        this.persons = persons;
        this.times = times;
        leads = new int[n];

        int[] votes = new int[n];
        int maxVotes = 0, leader = -1;

        for (int i = 0; i < n; i++) {
            int p = persons[i];
            int t = times[i];

            votes[p]++;
            if (votes[p] >= maxVotes) {
                maxVotes = votes[p];
                leader = p;
            }
            leads[i] = leader;
        }
    }

    // O(log(n)) time for binary search
    // O(1) space
    public int q(int time) {
        int low = 0, high = times.length - 1;

        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low)/2;

            if (times[mid] == time) {
                return leads[mid];
            } else if (times[mid] < time) {
                // your code should find the nearest time point that's less than or equal to time,
                // but not an exact match
                ans = leads[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return ans;

    }
}
