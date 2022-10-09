package network;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 노드 클래스
 */
class Node{
    private String name; //문자 이름
//    private ArrayList<Node> link = new ArrayList<>();
    private boolean visited; //방문 여부
    /*private int[] next;
    private int[] cost;*/
    private Map<Node, Integer> lsp = new HashMap<>(); //링크 상태 패킷
    private ArrayList<Map<Node, IntegerAndNode>> routingTable = new ArrayList<>(); //라우팅 테이블

    public Node(String name){
        this.name = name;
        /*next = new int[n+1];
        cost = new int[n+1];*/
        for(int i = 0; i<= LinkStatusRouting.N; i++){
            routingTable.add(new HashMap<>());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    /**
     * 라우팅 테이블에 비용과 다음 노드를 함께 저장하기 위한 클래스
     */
    class IntegerAndNode{
        int cost;
        Node nextNode;

        public IntegerAndNode(int cost, Node nextNode){
            this.cost = cost;
            this.nextNode = nextNode;
        }

        public int getCost() {
            return cost;
        }

        public Node getNextNode() {
            return nextNode;
        }
    }
}

public class LinkStatusRouting {
    static final int N = 7; //노드의 개수
    static final int INF = Integer.MAX_VALUE; //무한
    static int[][] distance; //LSDB
    static Node[] nodes; //노드 배열
    public static void main(String[] args) {
        // 1~N 인덱스를 사용하기 위해서 (N+1) * (N+1) 크기의 2차원 배열을 생성한다.
        distance = new int[N + 1][N + 1]; //LSDB(Link Status Database)

        makeNode(); //노드 생성
        setLsp(); //링크 상태 패킷 생성
        setDistance();
        printLsdb();
    }

    /**
     * 플러딩 알고리즘
     */
    public void flooding() {

    }

    /**
     * 노드 생성
     */
    public static void makeNode() {
        nodes = new Node[N + 1];

        for (int i = 0; i <= N; i++) {
            nodes[i] = new Node(Character.toString((char) (i + 64)));
        }
    }

    /**
     * 링크 상태 패킷 생성
     */
    public static void setLsp() {
        for (int i = 1; i <= N; i++) {
            nodes[i].setLsp(nodes[i], 0);
        }
        nodes[findByName("A")].setLsp(nodes[findByName("B")], 5);
        nodes[findByName("A")].setLsp(nodes[findByName("C")], 6);
        nodes[findByName("B")].setLsp(nodes[findByName("A")], 5);
        nodes[findByName("B")].setLsp(nodes[findByName("D")], 5);
        nodes[findByName("B")].setLsp(nodes[findByName("F")], 4);
        nodes[findByName("C")].setLsp(nodes[findByName("A")], 6);
        nodes[findByName("C")].setLsp(nodes[findByName("E")], 3);
        nodes[findByName("C")].setLsp(nodes[findByName("G")], 7);
        nodes[findByName("D")].setLsp(nodes[findByName("A")], 4);
        nodes[findByName("D")].setLsp(nodes[findByName("B")], 5);
        nodes[findByName("D")].setLsp(nodes[findByName("E")], 5);
        nodes[findByName("D")].setLsp(nodes[findByName("G")], 5);
        nodes[findByName("E")].setLsp(nodes[findByName("C")], 3);
        nodes[findByName("E")].setLsp(nodes[findByName("D")], 5);
        nodes[findByName("E")].setLsp(nodes[findByName("G")], 4);
        nodes[findByName("F")].setLsp(nodes[findByName("B")], 4);
        nodes[findByName("F")].setLsp(nodes[findByName("G")], 2);
        nodes[findByName("G")].setLsp(nodes[findByName("D")], 5);
        nodes[findByName("G")].setLsp(nodes[findByName("E")], 4);
        nodes[findByName("G")].setLsp(nodes[findByName("F")], 2);
    }

    /**
     * 이름으로 노드 인덱스 검색
     * @param name
     * @return int
     */
    public static int findByName(String name) {
        for(int i=1;i<=N;i++){
            if(nodes[i].getName().equals(name)){
                return i;
            }
        }
        return 0;
    }

    /**
     * 초기 LSDB 구축
     */
    public static void setDistance(){
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                distance[i][j] = INF;
            }
        }

        for(int i=1;i<=N;i++){
            for(Node key : nodes[i].getLsp().keySet()){
                distance[i][findByName(key.getName())] = nodes[i].getLsp().get(key);
            }
        }
    }

    public static void printLsdb(){
        for(int i=0;i<=N;i++){
            for(int j=0;j<=N;j++){
                if(i==0 && j==0){
                    System.out.print(" \t");
                }
                else if(i==0){
                    System.out.print((char)(j+64)+"\t");
                }
                else if(j==0){
                    System.out.print((char)(i+64)+"\t");
                }
                else{
                    if(distance[i][j] != INF) {
                        System.out.print(distance[i][j] + "\t");
                    }
                    else{
                        System.out.print(-1+"\t"); //무한대인 경우 -1로 표기
                    }
                }
            }
            System.out.println();
        }
    }
}

