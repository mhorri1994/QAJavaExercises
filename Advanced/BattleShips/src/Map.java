/**
 * Created by Matthew on 07/08/2017.
 */
public class Map {
    public static final int mapSize = 5;
    Square[][] map = new Square[mapSize][mapSize];

    public Map(){
        for(int x = 0;x < mapSize; x++){
            for(int y = 0;y < mapSize; y++){
                map[x][y] = new Square();
            }
        }
    }

    public void drawMap(){
//        for(int x = 0;x < mapSize; x++){
//            for(int i = 0;i<mapSize;i++){
//                System.out.print(" -");
//            }
//            System.out.println();
//            System.out.print("|");
//            for(int y = 0;y < mapSize; y++){
//                System.out.print(map[x][y]);
//            }
//            System.out.println();
//        }
//        for(int i = 0;i<mapSize;i++){
//            System.out.print(" -");
//        }

        for(int x = 0;x < mapSize; x++){
            for(int y = 0;y < mapSize; y++){
                System.out.print(map[x][y]);
            }
            System.out.println();
        }

    }
}


