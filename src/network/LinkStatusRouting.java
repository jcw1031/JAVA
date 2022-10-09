package network;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 노드 클래스
 */
class Node{
    private String name;
    private ArrayList<Node> link = new ArrayList<>();
    private boolean visited;
    /*private int[] next;
    private int[] cost;*/
    private Map<Node, Integer> lsp = new HashMap<>();

    public Node(String name){
        this.name = name;
        /*next = new int[n+1];
        cost = new int[n+1];*/
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Node> getLink() {
        return link;
    }

    public void setLink(ArrayList<Node> link) {
        this.link = link;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Map<Node, Integer> getLsp() {
        return lsp;
    }

    public void setLsp(Node node, int cost) {
        lsp.put(node, cost);
    }
}

public class LinkStatusRouting {
    static final int N = 7; //노드의 개수
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        // 1~N 인덱스를 사용하기 위해서 (N+1) * (N+1) 크기의 2차원 배열을 생성한다.
        int[][] distance = new int[N + 1][N + 1]; //LSDB(Link Status Database)


    }

    public void flooding() {

    }
}
