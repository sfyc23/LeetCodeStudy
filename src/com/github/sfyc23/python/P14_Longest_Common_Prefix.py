class K14_Longest_Common_Prefix:
    # @return a String
    # if (strs == null || strs.length == 0) {
    # return "";
    # }
    # String prefixOne = strs[0];
    # String prefix = "";
    # for (int i = 0; i < prefixOne.length(); i++) {
    # for (int j = 1; j < strs.length; j++) {
    # prefix = prefixOne.substring(0, i + 1);
    # if (strs[j].indexOf(prefix) != 0) {
    # return prefixOne.substring(0, i);
    # }
    #
    # }
    # }
    def longestCommonPrefix01(self, strs):
        if not strs:
            return ""
        for i in range(len(strs[0])):
            for string in strs[1:]:
                if i >= len(string) or string[i] != strs[0][i]:
                    return strs[0][:i]
        return strs[0]

if __name__ == "__main__":
    strs = ["abc","ab","abbbb"]

    strsss = "abcdef"
    print("bc" in strsss)
    print(strsss.index("bc"))
    for i in range(len(strs)):
        print(strs[i].index("a"))

    print(K14_Longest_Common_Prefix().longestCommonPrefix01(strs))