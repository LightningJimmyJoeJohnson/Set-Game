import java.util.Scanner;

/**
 * Created by meyerhallot on 10/10/16.
 * Warning nested for loop and if statements
 * TODO someday fix bug where program prints all permutations of the equivilant cards
 * TODO find more efficient method of doing this
 */
public class ableSet {
    Card[][] field = new Card[4][3];
    void setvals() {
        Scanner scanner = new Scanner(System.in);
        for(int row= 0; row < field.length; row++){
            for(int col = 0; col < field[row].length; col++) {
                String input = scanner.nextLine();
                field[row][col] = new Card();
                field[row][col].makeCard(input);

            }
        }
    }

    void calcField(){//compares all cards on the field, checking for a set of 3 cards with three attributes in common
        for(int row= 0; row < field.length; row++){
            for(int col = 0; col < field[row].length; col++){
                for(int rowOp= 0; rowOp < field.length; rowOp++){
                    for(int colOp = 0; colOp < field[rowOp].length; colOp++){
                            boolean twoEquiv = cardCompare(field[row][col],field[rowOp][colOp]);
                        if(twoEquiv==true) {
                            for (int rowT = 0; rowT < field.length; rowT++) {
                                for (int colT = 0; colT < field[rowT].length; colT++) {
                                    boolean threeEquivOne = cardCompare(field[row][col],field[rowT][colT]);
                                    boolean threeEquivTwo = cardCompare(field[rowOp][colOp],field[rowT][colT]);
                                    if(threeEquivOne == true && threeEquivTwo == true){
                                        System.out.println("First coordinates: " + row + "," + col);
                                        System.out.println("Second coordinates: " + rowOp + "," + colOp);
                                        System.out.println("Third coordinates: " + rowT + "," + colT);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    boolean cardCompare(Card firstCard, Card secondCard) { //compares two cards
        byte commonCount = 0; //it only needs to go up to three, it can be an byte
        boolean haveThreeCommon = false;
        boolean[] commonArray = new boolean[]{firstCard.getColor().equals(secondCard.getColor()),
                firstCard.getShape().equals(secondCard.getShape()),
                firstCard.getShading().equals(secondCard.getShading()),
                firstCard.getQuantity().equals(secondCard.getQuantity())
        };
        for (int i=0; i < commonArray.length; i++){
            if(commonArray[i]==true){
                commonCount++;
            }
        }
        if (commonCount == 3){
            haveThreeCommon = true;
        }
        return haveThreeCommon;
    }

}
