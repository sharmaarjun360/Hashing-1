// Time Complexity :  O(n)
// Space Complexity : O(1) // fixed 128
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope

class Solution {
    fun isIsomorphic(s: String, t: String): Boolean {
        val sMap = IntArray(128){0}
        val tMap = IntArray(128){0}

        for(i in s.indices){
            val sChar = s[i].code
            val tChar = t[i].code
            if(sMap[sChar] != 0 && sMap[sChar] != tChar) return false
            sMap[sChar] = tChar

            if(tMap[tChar] != 0 && tMap[tChar] != sChar) return false
            tMap[tChar] = sChar
        }
        return true
    }
}