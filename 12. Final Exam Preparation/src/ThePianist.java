import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ThePianist {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPieces = Integer.parseInt(scanner.nextLine());
        Map<String, Piece> pieces = new LinkedHashMap<>();

        for (int i = 0; i < numberOfPieces; i++) {
            String[] pieceInfo = scanner.nextLine().split("\\|");
            String piece = pieceInfo[0];
            String composer = pieceInfo[1];
            String key = pieceInfo[2];

            if (pieces.get(piece) == null){
                pieces.put(piece, new Piece(piece,composer, key));
            }
        }

        String input = scanner.nextLine();
        while (!input.equals("Stop")) {
            String[] arguments = input.split("\\|");
            String command = arguments[0];
            String currentPiece = arguments[1];
            Piece piece = pieces.get(currentPiece);

            switch (command) {
                case "Add":
                    if (piece == null) {
                        String composer = arguments[2];
                        String key = arguments[3];
                        pieces.put(currentPiece, new Piece(currentPiece, composer, key));
                        System.out.printf("%s by %s in %s added to the collection!%n", currentPiece, composer, key);
                    } else {
                        System.out.printf("%s is already in the collection!%n", currentPiece);
                    }
                    break;
                case "Remove":
                    if (piece == null) {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", currentPiece);
                    } else {
                        pieces.remove(currentPiece);
                        System.out.printf("Successfully removed %s!%n", currentPiece);
                    }
                    break;
                case "ChangeKey":
                    if (piece == null) {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", currentPiece);
                    } else {
                        String newKey = arguments[2];
                        piece.setKey(newKey);
                        System.out.printf("Changed the key of %s to %s!%n", currentPiece, newKey);
                    }
                    break;
            }
            input = scanner.nextLine();
        }

        pieces.forEach((key, value) ->
                System.out.printf("%s -> Composer: %s, Key: %s%n", key, value.getComposer(), value.getKey()));
    }

    static class Piece {
        private String name;
        private String composer;
        private String key;

        public Piece(String name, String composer, String key) {
            this.name = name;
            this.composer = composer;
            this.key = key;
        }

        public String getName() {
            return name;
        }

        public String getComposer() {
            return composer;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }

}
