# Time:  O(n)
# Space: O(1)
#
# Given an integer, convert it to a roman numeral.
#
# Input is guaranteed to be within the range from 1 to 3999.
#
# print("helloworld")


class P12_Integer_to_Roman:
    # @return a string
    def intToRoman(self, num):

        M = ("", "M", "MM", "MMM")
        C = ("", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM")
        X = ("", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC")
        I = ("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX")

        result = M[num // 1000] + C[num % 1000 // 100] + X[num % 100 // 10] + I[num % 10]

        return result

if __name__ == "__main__":
    print(P12_Integer_to_Roman().intToRoman(999))
    print(P12_Integer_to_Roman().intToRoman(1999))