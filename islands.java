import java.util.Scanner;
class islands {
    public int numIslands(char[][] grid) {
        int islands=0;
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] vis=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && !vis[i][j] ){
                    islands++;
                    dfs(grid,vis,i,j);
                }
            }
        }
        return islands;  
    }
    private void dfs(char[][] grid, boolean[][] vis,int i,int j){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length){
            return;
        }
        if(grid[i][j]=='0')
        return;
        if(vis[i][j])
        return;
        vis[i][j]= true ;
        dfs(grid, vis, i-1,j);
        dfs(grid, vis, i+1,j);
        dfs(grid, vis, i,j-1);
        dfs(grid, vis, i,j+1);
    }
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = s.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = s.nextInt();

        char[][] grid = new char[rows][cols];

        System.out.println("Enter the grid (only 0 and 1):");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = s.next().charAt(0);
            }
        }

        islands obj = new islands();

        int ans = obj.numIslands(grid);

        System.out.println("Number of Islands = " + ans);

        s.close();
    }
}