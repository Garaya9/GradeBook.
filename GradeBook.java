/**
 * A GradeBook class that stores scores and calculates statistics.
 * 
 * @author Gebrella Araya
 * @version 1.0
 * @since 2024-02-02
 */
public class GradeBook {
    private double[] scores;
    private int scoresSize;

    /**
     * Constructs a gradebook with no scores and a given capacity.
     * @param capacity the maximum number of scores in this gradebook
     */
    public GradeBook(int capacity) {
        scores = new double[capacity];
        scoresSize = 0;
    }

    /**
     * Adds a score to this gradebook.
     * @param score the score to add
     * @return true if the score was added, false if the gradebook is full
     */
    public boolean addScore(double score) {
        if (scoresSize < scores.length) {
            scores[scoresSize] = score;
            scoresSize++;
            return true;
        }
        return false;
    }

    /**
     * Computes the sum of the scores in this gradebook.
     * @return the sum of the scores
     */
    public double sum() {
        double total = 0;
        for (int i = 0; i < scoresSize; i++) {
            total += scores[i];
        }
        return total;
    }

    /**
     * Gets the minimum score in this gradebook.
     * @return the minimum score, or 0 if there are no scores.
     */
    public double minimum() {
        if (scoresSize == 0) return 0;
        double smallest = scores[0];
        for (int i = 1; i < scoresSize; i++) {
            if (scores[i] < smallest) {
                smallest = scores[i];
            }
        }
        return smallest;
    }

    /**
     * Gets the final score for this gradebook.
     * @return the sum of the scores, with the lowest score dropped if 
     * there are at least two scores, or 0 if there are no scores.
     */
    public double finalScore() {
        if (scoresSize == 0) return 0;
        if (scoresSize == 1) return scores[0];
        return sum() - minimum();
    }

    /**
     * Returns the number of scores in the gradebook.
     * @return the number of scores stored
     */
    public int getScoreSize() {
        return scoresSize;
    }

    /**
     * Returns a string with each score in scores separated by a space.
     * @return a string representation of the scores
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < scoresSize; i++) {
            sb.append(scores[i]).append(" ");
        }
        return sb.toString();
    }
}
