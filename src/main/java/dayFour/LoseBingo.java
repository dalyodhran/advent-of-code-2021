package dayFour;

import java.util.ArrayList;
import java.util.List;

public class LoseBingo {

    int [] winnerList = new int[100];

    public int getLosingScore(String data) {
        String[] bingoResultsAndCards = data.split("\\r?\\n");

        String[] randomNumbers = getRandomNumber(bingoResultsAndCards[0]);
        List<BingoCard> bingoCards = getBingoCards(bingoResultsAndCards);
        int winningRandomNumber = 0;
        int winningSum = 0;

        for (int i = 0; i < randomNumbers.length; i++) {
            for (int j = 0; j < bingoCards.size(); j++) {
                BingoCard card = bingoCards.get(j);
                card.checkNumber(Integer.parseInt(randomNumbers[i]));
            }

            for (int j = 0; j < bingoCards.size(); j++) {
                if (winnerList[j] == 0) {
                    BingoCard card = bingoCards.get(j);
                    if (card.checkForBingo() && isLastWinner(j)) {
                        winningRandomNumber = Integer.parseInt(randomNumbers[i]);
                        winningSum = card.getWinningSum();
                        break;
                    }
                }
            }
            if (winningSum > 0) {
                break;
            }
        }

        return winningRandomNumber * winningSum;
    }

    private boolean isLastWinner(int j) {
        winnerList[j] = j + 1;
        int count = 0;
        for (int k : winnerList) {
            if (k != 0) {
                count++;
            }
        }
        return count == 100;
    }

    private List<BingoCard> getBingoCards(String[] bingoResultsAndCards) {
        List<BingoCard> bingoCards = new ArrayList<>();

        for (int i = 1; i < bingoResultsAndCards.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < i + 5; j++) {
                sb.append(bingoResultsAndCards[j] + "\n");
            }
            BingoCard card = new BingoCard();
            card.mapBingoCard(sb.toString());
            bingoCards.add(card);
            i += 5;
        }
        return bingoCards;
    }

    private String[] getRandomNumber(String bingoResultsAndCard) {
        return bingoResultsAndCard.split(",");
    }
}
