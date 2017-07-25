class P3_Longest_Substring :
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        if not s:
            return 0
        maxLong = 1
        lookup = {}
        pw_index = 0
        for i in range(len(s)):
            if s[i] in lookup:
                pw_index = max(lookup[s[i]] + 1, pw_index)
            lookup[s[i]] = i

            maxLong = max(i-pw_index+1, maxLong)
        return maxLong