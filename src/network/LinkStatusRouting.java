package network;

import java.lang.annotation.Documented;
import java.util.*;

/**
 * 노드 클래스
 */
class Node{
    private String name; //문자 이름
    private boolean visited; //방문 여부
    private Map<Node, Integer> lsp = new HashMap<>(); //링크 상태 패킷
    private Map<Node, IntegerAndNode> routingTable = new HashMap<>(); //라우팅 테이블

    public Node(String name){
        this.name = name;
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
        this.lsp.put(node, cost);
    }

    public Map<Node, IntegerAndNode> getRoutingTable() {
        return routingTable;
    }

    /**
     * 라우팅 테이블 수정
     * @param node
     * @param cost
     * @param nextNode
     */
    public void setRoutingTable(Node node, int cost, Node nextNode){
        this.routingTable.put(node, new IntegerAndNode(cost, nextNode));
    }

    /**
     * 라우팅 테이블에 비용과 다음 노드를 함께 저장하기 위한 Node 클래스의 내부 클래스
     */
    static class IntegerAndNode{
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
        printRoutingTable();
        flooding();
        printRoutingTable();
    }

    /**
     * 플러딩 알고리즘
     */
    private static void flooding() {
        PriorityQueue<Node.IntegerAndNode> pq = new PriorityQueue<>(new Comparator<Node.IntegerAndNode>() {
            @Override
            public int compare(Node.IntegerAndNode i1, Node.IntegerAndNode i2){
                if(i1.getCost() < i2.getCost()){
                    return -1;
                }
                else if(i1.getCost() > i2.getCost()){
                    return 1;
                }
                else{
                    return 0;
                }
            }
        });

        Queue<Node> queue = new LinkedList<>();
        for(int i=1;i<=N;i++){
            clearVisited();
            nodes[i].setVisited(true);
            for(Node key : nodes[i].getLsp().keySet()){
                pq.add(new Node.IntegerAndNode(nodes[i].getLsp().get(key), key));
                queue.add(key);
            }

            while(!pq.isEmpty()){
                Node tmp = pq.poll().getNextNode();
            }




            while(!queue.isEmpty()){
                Node tmp = queue.poll();
                for(Node key : tmp.getLsp().keySet()){
                    if(!key.isVisited()){
                        key.setVisited(true);
                        queue.add(key);
                    }
                    int newCost = nodes[i].getRoutingTable().get(tmp).getCost() + tmp.getLsp().get(key);
                    if(nodes[i].getRoutingTable().get(key).getCost() > newCost){
                        nodes[i].setRoutingTable(key, newCost, tmp);
                    }
                }
            }
        }
    }

    /**
     * 노드 생성
     */
    private static void makeNode() {
        nodes = new Node[N + 1];

        for (int i = 0; i <= N; i++) {
            nodes[i] = new Node(Character.toString((char) (i + 64)));
        }

        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                nodes[i].setRoutingTable(nodes[j], INF, null);
            }
        }
    }

    /**
     * 링크 상태 패킷 생성
     */
    private static void setLsp() {
        for (int i = 1; i <= N; i++) {
            nodes[i].setLsp(nodes[i], 0);
        }
        nodes[findByName("A")].setLsp(nodes[findByName("B")], 5);
        nodes[findByName("A")].setLsp(nodes[findByName("C")], 6);
        nodes[findByName("A")].setLsp(nodes[findByName("D")], 4);
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
        nodes[findByName("G")].setLsp(nodes[findByName("C")], 7);
        nodes[findByName("G")].setLsp(nodes[findByName("D")], 5);
        nodes[findByName("G")].setLsp(nodes[findByName("E")], 4);
        nodes[findByName("G")].setLsp(nodes[findByName("F")], 2);

        for(int i=1;i<=N;i++){
            for(Node key : nodes[i].getLsp().keySet()){
                nodes[i].setRoutingTable(key, nodes[i].getLsp().get(key), null);
            }
        }
    }

    /**
     * 이름으로 노드 인덱스 검색
     * @param name
     * @return int
     */
    private static int findByName(String name) {
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
    private static void setDistance(){
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

    private static void printLsdb(){
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
                        System.out.print("∞\t"); //무한대인 경우 -1로 표기
                    }
                }
            }
            System.out.println();
        }
    }

    private static void printRoutingTable(){
        for(int i=1;i<=N;i++){
            System.out.println("----------"+nodes[i].getName()+" 노드 라우팅 테이블----------");

            for(int j=1;j<=N;j++){
                System.out.print(nodes[j].getName()+"\t");
                if(nodes[i].getRoutingTable().get(nodes[j]).getCost() == INF){
                    System.out.print("∞\t");
                }
                else{
                    System.out.print(nodes[i].getRoutingTable().get(nodes[j]).getCost()+"\t");
                }
                if(!(nodes[i].getRoutingTable().get(nodes[j]).getNextNode() == null)){
                    System.out.println(nodes[i].getRoutingTable().get(nodes[j]).getNextNode().getName());
                }
                else{
                    System.out.println("-");
                }
            }
        }
    }

    private static void clearVisited(){
        for(int i=1;i<=N;i++){
            nodes[i].setVisited(false);
        }
    }
}

