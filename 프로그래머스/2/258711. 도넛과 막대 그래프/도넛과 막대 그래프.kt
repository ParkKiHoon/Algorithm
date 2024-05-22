data class Node(
    var inDegree: Int=0,
    var outDegree: Int=0
)

class Solution {
    fun solution(edges: Array<IntArray>): IntArray{
        var answer=IntArray(4)
        var graph=Array(1000001){Node()}
        edges.forEach{
            (a,b)->
            graph[a].outDegree++
            graph[b].inDegree++
        }
        for ((i,node) in graph.withIndex()){
            if (2<=node.outDegree && 0==node.inDegree){
                answer[0]=i
            }
            else if (node.outDegree == 0 && 0 < node.inDegree) {
                answer[2]++
            } 
            else if (2 <= node.outDegree && 2 <= node.inDegree) {
                answer[3]++
            }
        }
        answer[1] = graph[answer[0]].outDegree - answer[2] - answer[3]
        return answer
    }
}