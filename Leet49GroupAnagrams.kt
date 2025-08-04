// Time Complexity :  O(n * k) Words * chars in words
// Space Complexity : O(n) // fixed 128
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope
class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = HashMap<String, MutableList<String>>()
        for(s in strs){
            val sMap = IntArray(128)
            for(c in s){
                sMap[c.code]++
            }
            val key = sMap.joinToString("#")
            map.getOrPut(key){ mutableListOf<String>()}.add(s)
        }
        return map.values.toList()
    }
}
//for only lowercase letters
class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = HashMap<String, MutableList<String>>()
        for(s in strs){
            val sMap = IntArray(26)
            for(c in s){
                sMap[c.code - 'a'.code]++
            }
            val key = sMap.joinToString("#")
            map.getOrPut(key){ mutableListOf<String>()}.add(s)
        }
        return map.values.toList()
    }
}