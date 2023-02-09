import java.util.*

fun maxMatching(n: Int, graph: Array<MutableList<Int>>): Int {
    val matching = IntArray(n) { -1 }
    val seen = BooleanArray(n)
    fun dfs(i: Int): Boolean {
        seen[i].also { seen[i] = true }
        graph[i].forEach { j ->
            if (matching[j] == -1 || (!seen[matching[j]] && dfs(matching[j]))) {
                matching[j] = i
                return true
            }
        }
        return false
    }

    var matches = 0
    (0 until n).forEach { i ->
        if (dfs(i)) {
            matches++
        }
        seen.fill(false)
    }
    return matches
}

// The code above implements the Hopcroft-Karp algorithm for finding the maximum matching in a bipartite graph. The algorithm starts by initializing the matching array to -1, which represents the fact that no node has been matched yet. The function dfs(i) attempts to find an augmenting path starting from node i, and updates the matching array if it succeeds. The maxMatching function loops over all nodes in one side of the bipartite graph, calling dfs on each node and incrementing the matches counter if a match is found. This process continues until no more augmenting paths can be found. The final value of matches is the size of the maximum matching in the bipartite graph.


