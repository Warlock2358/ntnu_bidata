import java.io.*;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader nodeReader = new BufferedReader(new FileReader("noder.txt"));
        BufferedReader edgeReader = new BufferedReader(new FileReader("kanter.txt"));
        BufferedReader interestReader = new BufferedReader(new FileReader("interessepkt.txt"));

        Reader reader = new Reader();
        reader.readNodes(nodeReader);
        reader.readEdges(edgeReader);
        reader.readInterestPoints(interestReader);
        Map<Integer, Map<Integer, Double>> distancesFromLandmarks = reader.readLandmarkData("DistancesFromLandmarks");
        Map<Integer, Map<Integer, Double>> distancesToLandmarks = reader.readLandmarkData("DistancesToLandmarks");
        System.out.println("Data read");

        nodeReader.close();
        edgeReader.close();
        interestReader.close();

        Graph graph = new Graph();
        graph.constructGraph(reader.nodesList, reader.edgesList);
        Node startNode = graph.nodes.get(2266026);
        Node endNode = graph.nodes.get(7826348);


        //Dijkstra
        RouteFinder routeFinder = new RouteFinder();
        long startTime = System.nanoTime();
        routeFinder.DijkstraV2FastestRoute(startNode, endNode);
        long endTime = System.nanoTime();
        long totalTime = (endTime -startTime);
        System.out.println("Time for dijkstra navigation : " + (double) totalTime / 1000000000 + "sek");
        double timeToDrive = endNode.driveTimeFromStart;
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("path.txt"));
            while(endNode != null){
                writer.write(endNode.latitude + "," + endNode.longitude + "\n");
                endNode = endNode.previous;
            }
            writer.close();
        } catch(IOException e){
            e.printStackTrace();
        }
        //System.out.println(endNode.distanceFromStart);
        System.out.println("Number of nodes checked : " + routeFinder.numberOfNodesChecked);
        int timer = (int) (timeToDrive / 100 / 3600);
        int minuter = (int) (((timeToDrive / 100) % 3600) / 60);
        int sekunder = (int) ((timeToDrive / 100) % 60);
        System.out.println("Time to drive route : " + timer + ":" + minuter + ":" + sekunder);

        graph.resetGraph();

        // A*
        /*startNode = graph.nodes.get(5009309);
        endNode = graph.nodes.get(999080);
        long startTimeA = System.nanoTime();
        routeFinder.AStar(startNode, endNode);
        long endTimeA = System.nanoTime();
        long totalTimeA = endTimeA - startTimeA;
        System.out.println("Time for A* navigation : " + (double) totalTimeA / 1000000000 + "sek");
        double timeToDriveA = endNode.driveTimeFromStart;
        int numberOfNodesInPathA = 0;

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter( "pathA.txt"));
            while (endNode != null){
                numberOfNodesInPathA++;
                writer.write(endNode.latitude + "," + endNode.longitude + "\n");
                endNode = endNode.previous;
            }
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("Number of nodes checked : " + routeFinder.numberOfNodesChecked);
        System.out.println("Number of nodes in the path: " + numberOfNodesInPathA);
        int timerA = (int) (timeToDriveA / 100 / 3600);
        int minuterA = (int) (((timeToDriveA / 100) % 3600) / 60);
        int sekunderA = (int) ((timeToDriveA / 100) % 60);
        System.out.println("Time to drive route : " + timerA + ":" + minuterA + ":" + sekunderA);

        graph.resetGraph();*/

        // ALT
        startNode = graph.nodes.get(2266026);
        endNode = graph.nodes.get(7826348);
        long startTimeALT = System.nanoTime();
        routeFinder.ALT(startNode, endNode, distancesFromLandmarks, distancesToLandmarks);
        long endTimeAlT = System.nanoTime();
        long totalTimeALT = endTimeAlT - startTimeALT;
        System.out.println("Time for ALT navigation : " + (double) totalTimeALT / 1000000000 + "sek");
        double timeToDriveALT = endNode.driveTimeFromStart;

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("pathALT.txt"));
            while(endNode != null){
                writer.write(endNode.latitude + "," + endNode.longitude + "\n");
                endNode = endNode.previous;
            }
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("Number of nodes checked : " + routeFinder.numberOfNodesChecked);
        int timerALT = (int) (timeToDriveALT / 100 / 3600);
        int minuterALT = (int) (((timeToDriveALT / 100) % 3600) / 60);
        int sekunderALT = (int) ((timeToDriveALT / 100) % 60);
        System.out.println("Time to drive route : " + timerALT + ":" + minuterALT + ":" + sekunderALT);

        graph.resetGraph();

        //routeFinder.findInterestPoints(graph, reader.getNodes()[2266026], 4, 5, List.of(reader.interestPointsList));



    }
}
