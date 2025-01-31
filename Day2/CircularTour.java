public class CircularTour {

    public static int findStartPoint(int[] petrol, int[] distance) {
        int n = petrol.length;
        int totalPetrol = 0, currentPetrol = 0, startIndex = 0;

        // Traverse through all the petrol pumps
        for (int i = 0; i < n; i++) {
            // Add the petrol to the total petrol and subtract the distance to the next pump
            totalPetrol += petrol[i] - distance[i];
            currentPetrol += petrol[i] - distance[i];

            // If current petrol goes negative, then we cannot start from 'startIndex'
            // Reset the start point and the current petrol
            if (currentPetrol < 0) {
                startIndex = i + 1;
                currentPetrol = 0;
            }
        }

        // If total petrol is non-negative, we can complete the tour
        return totalPetrol >= 0 ? startIndex : -1;
    }

    public static void main(String[] args) {
        // Example: petrol array and distance array
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        int start = findStartPoint(petrol, distance);
        if (start == -1) {
            System.out.println("Tour not possible");
        } else {
            System.out.println("Start at petrol pump " + start);
        }
    }
}
