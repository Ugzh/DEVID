public class Main {
    public static void main(String[] args) {
        String[][] arr = new String[][]{{"A","B","C","D"},{"E","F","G","H"}};
        String letters = "";

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                letters += arr[i][j] + ",";
            }
            letters += '\n';
        }
        System.out.println(letters);
    }
}
