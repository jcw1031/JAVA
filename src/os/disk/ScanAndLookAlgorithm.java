/*
package os.disk;

import java.util.*;

class Seek implements Runnable {
    Disk disk;

    public Seek(Disk disk) {
        this.disk = disk;
    }

    @Override
    public void run() {
        while (!disk.queueIsEmpty()) {
            disk.seeking();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("seek 종료");
    }
}

class Request implements Runnable {
    Disk disk;

    public Request(Disk disk) {
        this.disk = disk;
    }

    @Override
    public void run() {
        while (!disk.queueIsEmpty()) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            int track = (int) (Math.random() * disk.diskSize);
            int yesOrNo = (int) (Math.random() * 2);
            if (yesOrNo == 1) {
                disk.receiveRequest(track);
            }
        }
    }
}

class Disk {
    int[] arr;
    int diskSize;
    int head;
    int distance;
    int direction; //0 : 왼쪽, 1 : 오른쪽

    Queue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
    Queue<Integer> right = new PriorityQueue<>();
    List<Integer> seekSequence = new ArrayList<>();

    public Disk () {
        arr = new int[]{105, 180, 40, 120, 10, 125, 65, 70};
        diskSize = 200;
        head = 50;
        distance = 0;
        direction = 0;

        for (int i = 0; i < arr.length; i++) {
            System.out.print("초기 ");
            receiveRequest(arr[i]);
        }
    }

    public boolean queueIsEmpty() {
        return left.isEmpty() && right.isEmpty();
    }

    public void receiveRequest(int track) {
        if (queueIsEmpty() && distance != 0) {
            return;
        }

        if (track < head) {
            left.add(track);
        } else if (track > head) {
            right.add(track);
        } else {
            return;
        }
        System.out.println("요청 트랙 : "+track);
    }

    public void seeking() {
        if (direction == 0) {
            if (left.isEmpty()) {
//                moveHead(0);
                direction = 1;
                return;
            }
            int seekTrack = left.poll();
            System.out.println("seek track : " + seekTrack);
            seekSequence.add(seekTrack);
            moveHead(seekTrack);
        } else {
            if (right.isEmpty()) {
//                moveHead(diskSize-1);
                direction = 0;
                return;
            }
            int seekTrack = right.poll();
            System.out.println("seek track : " + seekTrack);
            seekSequence.add(seekTrack);
            moveHead(seekTrack);
        }
    }

    public void moveHead(int track) {
        distance += Math.abs((track - head));
        head = track;
    }
}

public class ScanAndLookAlgorithm {
    public static void main(String[] args) {
        Disk disk = new Disk();
        Seek seek = new Seek(disk);
        Request request = new Request(disk);

        Thread seekThread = new Thread(seek);
        Thread requestThread = new Thread(request);

        seekThread.start();
        requestThread.start();

        try {
            seekThread.join();
            requestThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\n\n[ Seek Sequence ]");
        for (int i = 0; i < disk.seekSequence.size(); i++) {
            System.out.print(disk.seekSequence.get(i)+"\t");
        }
        System.out.println("\nHead Move Distance : "+disk.distance);
    }
}*/
