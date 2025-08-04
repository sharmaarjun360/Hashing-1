// Time Complexity :  O(n) n is input String
// Space Complexity : O(n) // storing all words
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : added line 09, line27 to cover edge cases
class Solution {
    fun wordPattern(pattern: String, s: String): Boolean {
        var left = 0
        val map = HashMap<Char,String>()
        val map2 = HashMap<String, Char>()
        for(c in pattern){
            val sb = StringBuilder()
            while(left < s.length && s[left] != ' '){
                sb.append(s[left])
                left++
            }
            left++
            val str = sb.toString()
            if(map.containsKey(c) && map[c] != str){
                return false
            }
            if(map2.containsKey(str) && map2[str] != c){
                return false
            }
            map[c] = str
            map2[str] = c
        }
        if(left != s.length + 1 || map.keys.count() != map2.keys.count()) return false
        return true
    }
}

// I also tried the split but it was slower I believe  due to split
class Solution {
    fun wordPattern(pattern: String, s: String): Boolean {
        val map = HashMap<Char,String>()
        val map2 = HashMap<String, Char>()
        val words = s.split(" ")
        if(pattern.length != words.size) return false

        for(i in pattern.indices){
            val str = words[i]
            val c = pattern[i]

            if(map.containsKey(c) && map[c] != str){
                return false
            }
            if(map2.containsKey(str) && map2[str] != c){
                return false
            }

            map[c] = str
            map2[str] = c
        }
        return true
    }
}
