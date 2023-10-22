package com.example.RankCandidateByVotes;

import java.util.*;

public class Solution {

    public String rankCandidates(String[] votes) {
        int numOfCandidates = votes[0].length();

        Map<Character, int[]> candidateVoteMap = new HashMap<>();

        for (String vote : votes) {
            for (int i = 0; i < numOfCandidates; i++) {
                Character candidate = vote.charAt(i);
                if (!candidateVoteMap.containsKey(candidate)) {
                    candidateVoteMap.put(candidate, new int[numOfCandidates]);
                }
                candidateVoteMap.get(candidate)[i]++;
            }
        }

        List<Character> candidates = new ArrayList<>(candidateVoteMap.keySet());

        Collections.sort(candidates, (a, b) -> {
            int[] countsA = candidateVoteMap.get(a);
            int[] countsB = candidateVoteMap.get(b);

            for (int i = 0; i < numOfCandidates; i++) {
                if (countsB[i] != countsA[i]) {
                    return countsB[i] - countsA[i];
                }
            }
            return a - b;
        });

        StringBuilder sb = new StringBuilder();
        for (Character candidate : candidates) {
            sb.append(candidate);
        }

        return sb.toString();
    }
}
